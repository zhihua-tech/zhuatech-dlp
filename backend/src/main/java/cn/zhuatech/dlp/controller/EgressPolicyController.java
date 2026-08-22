/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dlp.controller;

import cn.zhuatech.dlp.common.ApiResponse;
import cn.zhuatech.dlp.service.EgressPolicyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class EgressPolicyController {
    private final EgressPolicyService service;
    public EgressPolicyController(EgressPolicyService service) { this.service = service; }
    @PostMapping("/egress-policy")
    public ApiResponse<EgressPolicyService.Result> evaluate(@Valid @RequestBody EgressPolicyService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
