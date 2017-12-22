package com.iqmsoft.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.iqmsoft.jms.domain.Confirmation;


@Component
public class Receiver {

    private Logger logger = LoggerFactory.getLogger( Receiver.class );

    //listens to the confirmationQueue and logs confirmation messages
    @JmsListener( destination = "conQueue", containerFactory = "myFactory" )
    public void receiveConfirmation( Confirmation confirmation ) {
        logger.info(" >>>>>>>>>> Received Confirmation: " + confirmation );
    }
}
