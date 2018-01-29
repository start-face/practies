package javaMail;
import com.tuhao.model.so;
import org.junit.Test;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class JavaMail {

    @Test
    public void test2() throws Exception {

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接  ---一般都使用
        properties.put("mail.debug", "true");//设置是否显示debug信息  true 会在控制台显示相关信息
        //得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        //设置发件人邮箱地址
        message.setFrom(new InternetAddress("13216543@qq.com"));
        //设置收件人地址
        message.setRecipients(MimeMessage.RecipientType.TO,new InternetAddress[] { new InternetAddress("456498@qq.com"),new InternetAddress("995956062@qq.com") });
        //设置邮件标题
        message.setSubject("这是封邮件");
        //设置邮件内容
        message.setText("歇会吧！~");
        //得到邮差对象
        Transport transport = session.getTransport();
        //连接自己的邮箱账户
        transport.connect("465497@qq.com", "huguhgu");//密码为刚才得到的授权码
        //发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        //关闭资源
        transport.close();
    }

    @Test
    public void test1() throws Exception {

        //发件人的邮箱
        String userName = so.userName;
        String passWord = so.passWord;

        //发件人的SMTP
        String myEmailSMTPHost = "smtp.qq.com";

        //收件人邮箱
        String receiveMailAccount = "4654646@qq.com";

        //创建参数配置,用于链接邮件服务器的参数配置
        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp"); //使用的协议
        prop.setProperty("mail.smtp.host", myEmailSMTPHost); //发件人的smtp服务器地址
        prop.setProperty("mail.smtp.auth", "true"); //需要请求认证

        //根据配置创建会话对象,用于和邮件服务器交互
        Session session = Session.getDefaultInstance(prop);
        session.setDebug(true); //设置为调试模式,可以查看详细的发送log

        //创建一封邮件
        MimeMessage mimeMessage = createMimeMessage(session, myEmailSMTPHost, receiveMailAccount);
        //根据session获取邮件传输对象
        Transport transport = session.getTransport();
        //使用账户和密码链接邮件服务器,认证的邮箱必须与message中的发件人邮箱一致,否则报错
        transport.connect(userName, "festgfsrtgr");
        //发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        //关闭连接
        transport.close();
    }

    private MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {

        //创建一封邮件
        MimeMessage mimeMessage = new MimeMessage(session);
        //发件人
        mimeMessage.setFrom(new InternetAddress(sendMail, "某宝网", "UTF-8"));
        //收件人
        mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));
        //邮件主题
        mimeMessage.setSubject("Hello Word !", "UTF-8");
        //邮件内容
        mimeMessage.setContent("XX用户你好, 今天全场5折, 快来抢购, 错过今天再等一年。。。", "text/html;charset=UTF-8");
        //设置发件时间
        mimeMessage.setSentDate(new Date());
        //保存设置
        mimeMessage.saveChanges();

        return mimeMessage;
    }
}
