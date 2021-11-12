package com.grtidsp.node;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Cacheable 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
 * @CacheEvict 清空缓存
 * @CachePut 保证方法被调用，又希望结果被缓存
 * @EnableCaching 开启基于注解的缓存
 */

@SpringBootApplication
@EnableCaching //开启注解
@EnableTransactionManagement
public class NodeApplication {


    public static void main(String[] args) {
        SpringApplication.run(NodeApplication.class, args);
    }
}