package org.marsken.plantform.controller;

import org.marsken.arch.core.clientobject.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：MarsKen
 * @date ：Created in 2020/9/14 9:50 下午
 * @description：用户接口
 * @modified By：
 * @version: 1.0.0$
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/1")
    public Response<String> findUserByToken(){
        return Response.builderSuccess("123");
    }
}
