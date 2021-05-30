package day22.mail;

import cn.itcast.mail.AttachBean;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class MailDemo {
    @Test
    public void fun1() throws MessagingException {
        //得到session
        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.163.com");
        properties.setProperty("mail.smtp.auth","true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("15607521232","YCUGTGMIHXRVJLCF");//邮箱账号和授权码
            }
        };
        Session session =  Session.getInstance(properties,authenticator);

        //创建MimeMessage
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("15607521232@163.com"));//设置发件人
        mimeMessage.setRecipients(Message.RecipientType.TO,"940102569@qq.com");//设置收件人
        //mimeMessage.setRecipients(Message.RecipientType.CC,"940102569@qq.com");
        //mimeMessage.setRecipients(Message.RecipientType.BCC,"940102569@qq.com");

        mimeMessage.setSubject("这是测试邮件");
        mimeMessage.setContent("垃圾邮件","text/html;charset=UTF-8");

        Transport.send(mimeMessage);



    }

    @Test
    public void fun2() throws MessagingException, IOException {
        //得到session
        //得到session
        Properties properties = new Properties();
        properties.setProperty("mail.host","smtp.163.com");
        properties.setProperty("mail.smtp.auth","true");

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("15607521232","YCUGTGMIHXRVJLCF");//邮箱账号和授权码
            }
        };
        Session session =  Session.getInstance(properties,authenticator);

        //创建MimeMessage
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("15607521232@163.com"));//设置发件人
        mimeMessage.setRecipients(Message.RecipientType.TO,"940102569@qq.com");//设置收件人
        mimeMessage.setSubject("带有附件的邮件");
        /**
         * 当发送的邮件包含附件的时候，邮件体就为多不见形式
         * 1.创建一个多部件的部件内容，MimeMultipart
         * MimeMultipart就是一个集合，用来装载多个部件主体
         * 2：我们要创建两个部件主题，一个时文本内容的，另一个时附件的
         * 主体部件叫MimeBosypart
         * 3:把MimeMultipart设置给Mimemessage的内容
         */
        MimeMultipart multipart = new MimeMultipart();

        //设置mimeBodyPart
        MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
        mimeBodyPart1.setContent("包含附件的垃圾邮件","text/html;charset=UTF-8");
        multipart.addBodyPart(mimeBodyPart1);

        //创建MimeBodyPart
        MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
        mimeBodyPart2.attachFile(new File("F:\\音乐\\周杰伦无损\\十二新作\\周杰伦 - 红尘客栈.flac"));//设置附件的内容
        mimeBodyPart2.setFileName(MimeUtility.encodeText("周杰伦红尘客栈.flac"));
        multipart.addBodyPart(mimeBodyPart2);

        mimeMessage.setContent(multipart);

        Transport.send(mimeMessage);



    }

    @Test
    public void fun3() throws IOException, MessagingException {
        //得到session
        Session session = MailUtils.createSession("smtp.163.com","15607521232","YCUGTGMIHXRVJLCF");

        //创建邮件对象
        Mail mail = new Mail("15607521232@163.com","940102569@qq.com","不是垃圾邮件了","这是正文");


        //创建附件对象
        AttachBean attachBean1 = new AttachBean(new File("F:\\音乐\\周杰伦无损\\十二新作\\周杰伦 - 红尘客栈.flac"),"周董.flac");
        AttachBean attachBean2 = new AttachBean(new File("C:\\Users\\94010\\Desktop\\ConfidentAndFearless.jpg"),"美女.jpg");

        mail.addAttach(attachBean1);
        mail.addAttach(attachBean2);

        MailUtils.send(session,mail);

    }

}
