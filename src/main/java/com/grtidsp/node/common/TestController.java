package com.grtidsp.node.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
/**
 * @Author daiqingsong
 * @Date 2021/10
 **/
@RestController
@ResponseBody
public class TestController {

    //@Autowired
    //private HttpServletResponse response;
    //远程调用的IP +端口
//    private String inputDate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

    @GetMapping(value = "/service")
    public String service(){
        //远程调用
        RestTemplate restTemplate =new RestTemplate();
        //服务id即注册中心的中的服务名
        String serverId ="node-center";
        //获取服务的实例
        ServiceInstance serviceInstance = loadBalancerClient.choose(serverId);
        //获取带Http的uri
        URI uri = serviceInstance.getUri();
        //远程调用
        String result = restTemplate.getForObject(uri + "/test", String.class);
        return "consumer invoke1" + result;
    }
}
