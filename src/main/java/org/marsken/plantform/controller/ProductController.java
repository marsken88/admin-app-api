package org.marsken.plantform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：MarsKen
 * @date ：Created in 2020/12/21 2:08 下午
 * @description：商品接口
 * @modified By：
 * @version: 1.0.0$
 */
@RestController
public class ProductController {

    @GetMapping("/api/products")
    public void findProductList(){

    }
}
