package ru.maslov.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class MyJmsMessageListener implements javax.jms.MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(MyJmsMessageListener.class);

    @Override
    public void onMessage(Message message) {
        try {
            int messageCount = message.getIntProperty("messageCount");
            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage) message;
                String msg = tm.getText();
                System.out.println("\n----------------\n" + msg);
            }
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
