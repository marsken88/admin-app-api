package org.marsken.plantform.controller;

import org.marsken.arch.core.clientobject.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：MarsKen
 * @date ：Created in 2020/9/15 12:18 上午
 * @description：权限认证接口
 * @modified By：
 * @version: 1.0.0$
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/token")
    public Response<String> findTokenByUserName(){
        return Response.builderSuccess("123");
    }
}
