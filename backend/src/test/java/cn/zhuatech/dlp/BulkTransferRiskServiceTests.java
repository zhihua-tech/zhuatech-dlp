/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dlp;

import cn.zhuatech.dlp.service.BulkTransferRiskService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class BulkTransferRiskServiceTests {
    private final BulkTransferRiskService service = new BulkTransferRiskService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksUntrustedLargeRestrictedTransfer() {
        var result = service.evaluate(new BulkTransferRiskService.Request(
            "TX-01", "RESTRICTED", 50000, false, false, false, .8, true, true));
        assertEquals("BLOCK", result.decision());
        assertEquals(100, result.riskScore());
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void allowsProtectedInternalTransfer() {
        var result = service.evaluate(new BulkTransferRiskService.Request(
            "TX-02", "INTERNAL", 500, true, true, true, 0, false, false));
        assertEquals("ALLOW", result.decision());
    }
}
