package com.deer.wms.api;

import com.deer.wms.file.configurer.FileSetting;
import org.flowable.ui.common.rest.idm.remote.RemoteAccountResource;
import org.flowable.ui.modeler.conf.ApplicationConfiguration;
import org.flowable.ui.modeler.servlet.AppDispatcherServletConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 共享托盘项目后台API入口
 * <p>
 * Created by Floki on 2017/9/30.
 * sss
 */

@Import({
        ApplicationConfiguration.class,
        AppDispatcherServletConfiguration.class
})
@SpringBootApplication(exclude = {RabbitAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.flowable.spring.boot.FlowableSecurityAutoConfiguration.class
})//排除MQ消息队列
@EnableScheduling   //支持定时任务
@EnableConfigurationProperties({FileSetting.class})
@ComponentScan(value = {
        "com.deer.wms.api"
        , "com.deer.wms.project.seed"
        , "com.deer.wms.intercept.common.data"
        , "com.deer.wms.file"
        , "com.deer.wms.system.manage"
        , "com.deer.wms.message"
        , "com.deer.wms.base.system"
        , "com.deer.wms.bill.manage"
        , "com.deer.wms.report"
        , "com.deer.wms.finance"
        , "com.deer.wms.operation"
        , "com.deer.wms.device.manage"
        , "com.deer.wms.detect"
        , "com.deer.wms.ware.task"
        , "com.deer.wms.workflow"
})

public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
