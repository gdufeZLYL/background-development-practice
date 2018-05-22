package com.qexz.subscription;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听-订阅者1
 * @author zzqnxx@foxmail.com
 * @date 2018/5/22 16:52
 */
public class Listener1 implements MessageListener {
    public void onMessage(Message message) {
        try {
            System.out.println("订阅者1收到的消息: "+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
