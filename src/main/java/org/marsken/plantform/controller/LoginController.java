package org.marsken.plantform.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.marsken.arch.core.clientobject.ResponseDTO;
import org.marsken.plantform.controller.dto.LoginDetailDTO;
import org.marsken.plantform.controller.dto.LoginFormDTO;
import org.marsken.plantform.domain.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author ：MarsKen
 * @date ：Created in 2020/10/9 5:26 下午
 * @description：登陆接口
 * @modified By：
 * @version: 1.0.0$
 */
@Slf4j
@RestController
public class LoginController {

    @PostMapping(value = "/session/login")
    public ResponseDTO<LoginDetailDTO> login(@RequestBody LoginFormDTO loginFormDTO) {
        String loginName = loginFormDTO.getLoginName();
        String loginPwd = loginFormDTO.getLoginPwd();
        LoginDetailDTO loginDetailDTO = loginService.login(loginName, loginPwd);
        return ResponseDTO.builderSuccess(loginDetailDTO);
    }


    @GetMapping(value = "/session/get")
    public ResponseDTO<LoginDetailDTO> get(HttpServletRequest request) {
        String requestToken = request.getHeader("x-access-token");
        LoginDetailDTO loginDetailDTO = loginService.findByToken(requestToken);
        return ResponseDTO.builderSuccess(loginDetailDTO);
    }

    @GetMapping(value = "/session/logOut")
    public ResponseDTO<Boolean> logout(@RequestParam(name = "x-access-token") String token) {
        return ResponseDTO.builderSuccess(loginService.logout(token));
    }


    @GetMapping(value = "/session/verificationCode")
    public ResponseDTO captcha() {
        String kaptchaText = defaultKaptcha.createText();

        String base64Code = "";

        BufferedImage image = defaultKaptcha.createImage(kaptchaText);
        ByteArrayOutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", outputStream);
            base64Code = Base64.encodeBase64String(outputStream.toByteArray());
        } catch (Exception e) {
            log.error("verificationCode exception .{}", e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    log.error("verificationCode outputStream close exception .{}", e);
                }
            }
        }
        HashMap data = new HashMap();
        data.put("uuid", UUID.randomUUID().toString());
        data.put("code", base64Code);
        return ResponseDTO.builderSuccess(data);
    }


    @Autowired
    private LoginService loginService;

    @Autowired
    private DefaultKaptcha defaultKaptcha;

}
