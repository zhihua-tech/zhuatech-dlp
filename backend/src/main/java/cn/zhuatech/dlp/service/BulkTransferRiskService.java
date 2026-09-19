/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dlp.service;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class BulkTransferRiskService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Result evaluate(Request request) {
        int score = switch (request.classification()) {
            case "RESTRICTED" -> 45;
            case "CONFIDENTIAL" -> 30;
            case "INTERNAL" -> 10;
            default -> 0;
        };
        if (request.recordCount() >= 10000) score += 20;
        if (!request.destinationTrusted()) score += 25;
        if (!request.encrypted()) score += 20;
        if (!request.businessApproved()) score += 20;
        if (request.removableMedia()) score += 20;
        if (request.personalData()) score += 15;
        score += (int) Math.round(request.anomalyScore() * 20);
        score = Math.min(100, score);
        String decision = score >= 70 ? "BLOCK" : score >= 35 ? "REVIEW" : "ALLOW";
        List<String> actions = new ArrayList<>();
        if (!request.destinationTrusted()) actions.add("仅允许传输至受管控目标或企业交换区");
        if (!request.encrypted()) actions.add("启用传输加密和文件级加密");
        if (!request.businessApproved()) actions.add("补充业务用途、数据范围和审批人");
        if (request.personalData()) actions.add("执行个人信息最小化与脱敏");
        if (actions.isEmpty()) actions.add("允许传输并保留审计与哈希证据");
        return new Result(request.transferId(), score, decision, actions);
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String transferId,
                          @Pattern(regexp = "PUBLIC|INTERNAL|CONFIDENTIAL|RESTRICTED") String classification,
                          @Min(0) long recordCount, boolean destinationTrusted,
                          boolean encrypted, boolean businessApproved,
                          @DecimalMin("0") @DecimalMax("1") double anomalyScore,
                          boolean removableMedia, boolean personalData) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Result(String transferId, int riskScore, String decision, List<String> actions) {}
}
