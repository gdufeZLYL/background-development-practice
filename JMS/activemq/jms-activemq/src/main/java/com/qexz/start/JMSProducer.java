package com.qexz.start;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息生产者
 * @author zzqnxx@foxmail.com
 * @date 2018/5/22 15:28
 */
public class JMSProducer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; //  默认的连接密码
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;   //  morning的连接地址
    private static final int SENDNUM = 10;  //  发送的消息数量

    public static void main(String[] args) {
        ConnectionFactory connectionFactory; // 连接工厂
        Connection connection = null;  // 连接
        Session session;    //  会话接受或者发送消息的线程
        Destination destination;    // 消息目的地
        MessageProducer messageProducer;    // 消息生产者

        // 实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME,
                JMSProducer.PASSWORD, JMSProducer.BROKEURL);

        try {
            connection = connectionFactory.createConnection();  //  通过连接工厂获取连接
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE); //  创建session
            destination = session.createQueue("FirstQueue1"); //  创建消息队列
            messageProducer = session.createProducer(destination);  //  创建消息生产者
            sendMessage(session, messageProducer);  //  发送消息
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 发送消息
     * @param session
     * @param messageProducer
     * @throws Exception
     */
    public static void sendMessage(Session session, MessageProducer messageProducer) throws Exception {
        for (int i = 0; i < JMSProducer.SENDNUM; i++) {
            TextMessage message = session.createTextMessage("ActiveMQ 发送的消息"+i);
            System.out.println("发送消息: "+"ActiveMQ 发送的消息"+i);
            messageProducer.send(message);
        }
    }
}
