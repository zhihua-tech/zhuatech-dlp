/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dlp.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class EgressPolicyService {
    private static final Map<String, Integer> CLASSIFICATION_RISK = Map.of(
        "PUBLIC", 0, "INTERNAL", 20, "CONFIDENTIAL", 50, "RESTRICTED", 75);

    public Result evaluate(Request request) {
        String classification = request.classification().toUpperCase(Locale.ROOT);
        int score = CLASSIFICATION_RISK.getOrDefault(classification, 40)
            + (request.recipientExternal() ? 15 : 0) + (request.encrypted() ? 0 : 15)
            + (request.recordCount() > 1000 ? 10 : 0) - (request.approvedException() ? 30 : 0);
        score = Math.max(0, Math.min(100, score));
        String decision = score >= 75 ? "BLOCK" : score >= 45 ? "REVIEW" : "ALLOW";
        List<String> controls = new ArrayList<>();
        if (request.recipientExternal()) controls.add("验证外部收件人及业务必要性");
        if (!request.encrypted()) controls.add("启用加密传输和到期失效");
        if (request.recordCount() > 1000) controls.add("对批量数据导出执行二次审批");
        if ("BLOCK".equals(decision)) controls.add("阻断外发并通知数据安全负责人");
        return new Result(classification, request.channel(), score, decision, controls);
    }

    public record Request(@NotBlank String classification, @NotBlank String channel,
                          boolean recipientExternal, boolean encrypted,
                          @Min(0) int recordCount, boolean approvedException) {}
    public record Result(String classification, String channel, int riskScore,
                         String decision, List<String> controls) {}
}
