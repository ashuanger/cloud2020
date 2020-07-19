package com.xsz.springcloud;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8010 {

    public static void main(String[] args){

//        DocsConfig config = new DocsConfig();
//        config.setProjectPath("D:\\code\\cloud2020-\\cloud2020"); // 项目根目录
//        config.setProjectName("cloud-payment"); // 项目名称
//        config.setApiVersion("V1.0");       // 声明该API的版本
//        config.setDocsPath("API"); // 生成API 文档所在目录
//        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
//        Docs.buildHtmlDocs(config); // 执行生成文档
        SpringApplication.run(PaymentMain8010.class,args);
    }
}
