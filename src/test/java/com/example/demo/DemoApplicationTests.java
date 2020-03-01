package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;


    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("今晚开会");
        message.setText("九点开会");
        message.setTo("599571971@qq.com");
        message.setFrom("1638343272@qq.com");
        mailSender.send(message);
    }


    @Test
    public void test() throws Exception{
        //1.创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        //邮件设置
        helper.setSubject("测试");
        helper.setText("<b style='color:red'>测试呀</b>",true);
        helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\萌宠平台\\resources\\微信图片_20200216230918.jpg"));
        helper.setTo("599571971@qq.com");
        helper.setFrom("1638343272@qq.com");
        mailSender.send(mimeMessage);
    }

}
