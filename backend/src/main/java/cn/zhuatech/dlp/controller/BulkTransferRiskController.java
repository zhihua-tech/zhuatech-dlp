/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dlp.controller;

import cn.zhuatech.dlp.common.ApiResponse;
import cn.zhuatech.dlp.service.BulkTransferRiskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dlp/insights")
public class BulkTransferRiskController {
    private final BulkTransferRiskService service;
    public BulkTransferRiskController(BulkTransferRiskService service) { this.service = service; }
    @PostMapping("/bulk-transfer-risk")
    public ApiResponse<BulkTransferRiskService.Result> evaluate(
        @Valid @RequestBody BulkTransferRiskService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
