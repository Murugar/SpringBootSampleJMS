package com.iqmsoft.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.iqmsoft.jms.domain.Confirmation;


@Component
public class Sender {

    private static Logger logger = LoggerFactory.getLogger( Sender.class );

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage( final Confirmation confirmation ) {
        jmsTemplate.convertAndSend("conQueue", confirmation);
    }
}
