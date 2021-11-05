package com.grtidsp.node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.grtidsp.node.constants.GrtidspErrorCode;
import com.grtidsp.node.utils.JsonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author daiqingsong
 * @Date 2021/10
 **/
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    private boolean swagger_is_enable = true;

    @Bean
    public Docket buildDocket() {
        List<ResponseMessage> responseMessageList = new ArrayList<ResponseMessage>();
        Arrays.stream(GrtidspErrorCode.values()).forEach(x -> {
            Map<String, String> map = new HashMap<String, String>();
            map.put("code", x.getCode());
            map.put("message", x.getMessage());
            responseMessageList.add(new ResponseMessageBuilder().code(Integer.parseInt(x.getCode()))
                    .message(JsonUtil.map2json(map)).build());
        });

        List<Parameter> parameters = new ArrayList<Parameter>();
        parameters.add(new ParameterBuilder().name("token").description("用户登录凭证").modelRef(new ModelRef("string"))
                .parameterType("header").required(true).build());
        return new Docket(DocumentationType.SWAGGER_2).enable(swagger_is_enable).useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList).apiInfo(buildApiInf())
                .ignoredParameterTypes(RequestAttribute.class).select()
                .apis(RequestHandlerSelectors.basePackage("com.grtidsp.node.controller")).paths(PathSelectors.any()).build()
                .globalOperationParameters(parameters);
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder().title("统一登录接口-swagger").version("2.x").build();
    }
}
