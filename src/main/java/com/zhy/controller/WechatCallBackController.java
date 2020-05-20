package com.zhy.controller;

import com.zhy.utils.MessageResponse;
import lombok.extern.log4j.Log4j2;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: myblog
 * @description: 微信相关回调接口
 * @author: hejun
 * @date: 2020-05-20
 **/
@Log4j2
public class WechatCallBackController {

    @RequestMapping(value = "callback")
    public void callback(HttpServletRequest request,
                         HttpServletResponse response,
                         String signature,
                         String timestamp,
                         String nonce,
                         String echostr) {

        log.info("公众号回调 signature={},timestamp={},nonce={},echostr={}", signature, timestamp, nonce, echostr);

        String result = "";
        //判断是否是微信验证请求
        if (echostr != null && echostr.length() > 1) {
            result = echostr;
        } else {
            //正常的微信处理流程
            try {
                // 将解析结果存储在HashMap中
                Map<String, String> map = new HashMap<String, String>();

                BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
                String inputString = "";
                while (br.readLine() != null) {
                    inputString += br.readLine();
                }
                br.close();

                Document document = DocumentHelper.parseText(inputString);
                // 得到xml根元素
                Element root = document.getRootElement();
                // 得到根元素的所有子节点
                List<Element> elementList = root.elements();

                // 遍历所有子节点
                elementList.forEach(element -> {
                    map.put(element.getName(), element.getText());
                });

                // 发送方帐号（open_id）
                String fromUserName = map.get("FromUserName");
                // 公众帐号
                String toUserName = map.get("ToUserName");
                // 消息类型
                String msgType = map.get("MsgType");
                // 消息内容
                String content = map.get("Content");

                String msg = "stay hangry stay foolish";

                result = MessageResponse.getTextMessage(fromUserName, toUserName, msg);

            } catch (Exception e) {
                e.printStackTrace();
                log.info("公众号回调业务处理异常e={}", e.getMessage());
            }
        }

        //回执请求
        if (result != null) {
            try {
                response.getWriter().write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
