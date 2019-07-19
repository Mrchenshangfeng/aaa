package cm.itcast.sms.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class QueueController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @RequestMapping("/sendsms")
    public void sendSms(){
        Map map=new HashMap<>();
        map.put("mobile", "18829340752");
        map.put("template_code", "SMS_170180500");
        map.put("sign_name", "靓妆");
        map.put("param", "{\"code\":\"113595\"}");
        jmsMessagingTemplate.convertAndSend("sms",map);

    }
}
