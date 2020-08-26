package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther zzyy
 * @create 2020-02-21 18:07
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3003
{
    public static void main(String[] args) {
            SpringApplication.run(ConfigClientMain3003.class, args);
    }
}
