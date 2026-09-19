/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dlp.controller;

import cn.zhuatech.dlp.common.ApiResponse;
import cn.zhuatech.dlp.service.BulkTransferRiskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/dlp/insights")
public class BulkTransferRiskController {
    private final BulkTransferRiskService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public BulkTransferRiskController(BulkTransferRiskService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/bulk-transfer-risk")
    public ApiResponse<BulkTransferRiskService.Result> evaluate(
        @Valid @RequestBody BulkTransferRiskService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
