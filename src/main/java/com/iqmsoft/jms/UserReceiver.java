package com.iqmsoft.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.iqmsoft.jms.domain.Confirmation;
import com.iqmsoft.jms.domain.User;

import javax.jms.Message;
import java.util.concurrent.atomic.AtomicInteger;


@Component
public class UserReceiver {

    private Logger logger = LoggerFactory.getLogger( UserReceiver.class );
    private static AtomicInteger id = new AtomicInteger( );

    @Autowired
    private Sender confirmationSender;

  
    @JmsListener( destination = "myQueue", containerFactory = "myFactory")
    public void receiveMessage( User receivedUser, Message message ) {
        logger.info( " >>>>>>>>>> Original Received user message: " + message);
        logger.info( " >>>>>>>>>> Received user: " + receivedUser);

        confirmationSender.sendMessage( new Confirmation( id.incrementAndGet(),
                "User " + receivedUser.getLastName() + " received" ) );

    }
}
