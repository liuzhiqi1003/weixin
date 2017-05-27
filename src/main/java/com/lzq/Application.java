package com.lzq;

import com.lzq.utils.SignUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by zhiqi.liu@yoho.cn on 2017/5/26.
 */
@Controller
@SpringBootApplication
public class Application {

//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/wx")
    @ResponseBody
    public String handle(String signature, String timestamp, String nonce, String echostr){
// 通过检验 signature 对请求进行校验，若校验成功则原样返回 echostr，表示接入成功，否则接入失败
        if(SignUtil.checkSignature(signature, timestamp, nonce)){
           return echostr;
        }

        return "hello, this is a test";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
