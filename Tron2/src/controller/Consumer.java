package controller;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

public class Consumer {
	private JMSConsumer jmsConsumer;
	private JMSContext jmsContext;
	private Queue queue;

	Consumer(String url, String queueName) throws JMSException {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		jmsContext = connectionFactory.createContext();
		((com.sun.messaging.ConnectionFactory) connectionFactory)
				.setProperty(com.sun.messaging.ConnectionConfiguration.imqAddressList, url);
		queue = new com.sun.messaging.Queue(queueName);
		jmsConsumer = jmsContext.createConsumer(queue);
	}

	public JMSConsumer getJMSConsumer() {
		return jmsConsumer;

	}

	public String receiveQueueMessage() throws JMSException {
		Message msg = jmsConsumer.receive(10);
		if (msg instanceof TextMessage)
			return ((TextMessage) msg).getText();
		return null;
	}

	protected void finalize() {
		if (jmsConsumer != null)
			jmsConsumer.close();
		if (jmsContext != null)
			jmsContext.close();
	}
}
