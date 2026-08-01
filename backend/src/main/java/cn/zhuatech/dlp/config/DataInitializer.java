/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.dlp.config;

import cn.zhuatech.dlp.model.*;
import cn.zhuatech.dlp.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seed(OperatingUnitRepository operatingUnits, WorkRecordRepository orders,
                           ResourceRegisterRepository resources, ReviewRecordRepository reviewRecords,
                           UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (operatingUnits.count() > 0) return;
            OperatingUnit primaryUnit = operatingUnits.save(new OperatingUnit("DLP-RD", "研发中心", "敏感数据运营组", 180));
            OperatingUnit secondaryUnit = operatingUnits.save(new OperatingUnit("DLP-SALES", "销售运营部", "客户数据域", 120));
            OperatingUnit tertiaryUnit = operatingUnits.save(new OperatingUnit("DLP-FIN", "集团财务", "数据安全部", 96));

            WorkRecord t1 = orders.save(new WorkRecord("DLP-260801-018", "DATA-SOURCE-CODE", "研发源代码外发行为核验", primaryUnit, 24, 16, 1, LocalDate.now().plusDays(1), WorkRecord.Status.RUNNING, "POLICY-L3"));
            WorkRecord t2 = orders.save(new WorkRecord("DLP-260801-021", "DATA-CUSTOMER", "客户清单邮件外发确认", secondaryUnit, 18, 8, 0, LocalDate.now().plusDays(1), WorkRecord.Status.RUNNING, "POLICY-L2"));
            WorkRecord t3 = orders.save(new WorkRecord("DLP-260802-006", "DATA-SUP-BANK", "供应商银行信息云盘共享", secondaryUnit, 12, 0, 0, LocalDate.now().plusDays(3), WorkRecord.Status.RELEASED, "POLICY-L3"));
            WorkRecord t4 = orders.save(new WorkRecord("DLP-260728-015", "DATA-EMPLOYEE", "员工信息打印行为复核", tertiaryUnit, 20, 20, 1, LocalDate.now(), WorkRecord.Status.COMPLETED, "POLICY-L2"));

            resources.saveAll(List.of(
                new ResourceRegister("CAT-HPLC-03", "终端数据防护", primaryUnit, ResourceRegister.Status.RUNNING, 88),
                new ResourceRegister("CAT-ICP-02", "邮件外发防护", primaryUnit, ResourceRegister.Status.IDLE, 76),
                new ResourceRegister("CAT-UTM-05", "云盘共享防护", tertiaryUnit, ResourceRegister.Status.RUNNING, 91),
                new ResourceRegister("CAT-INC-08", "内容识别引擎", secondaryUnit, ResourceRegister.Status.ALARM, 62)
            ));
            reviewRecords.saveAll(List.of(
                new ReviewRecord("ISS-260801-032", t1, "业务用途复核", 6, 0, ReviewRecord.Result.PASSED, "周序"),
                new ReviewRecord("ISS-260801-011", t2, "内容识别校验", 3, 0, ReviewRecord.Result.PASSED, "林岚"),
                new ReviewRecord("ISS-260801-018", t4, "证据归档复核", 5, 1, ReviewRecord.Result.FAILED, "周序"),
                new ReviewRecord("ISS-260802-003", t3, "敏感等级确认", 4, 0, ReviewRecord.Result.PENDING, "林岚")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "林岚", UserAccount.Role.DOMAIN_USER, "DLP-RD"),
                new UserAccount("planner", demo, "周序", UserAccount.Role.DOMAIN_OPERATOR, null),
                new UserAccount("quality", demo, "顾清", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
