package no.nith.pg6100;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName="jms/Queue", activationConfig =  {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class MessageReceiverMDB implements MessageListener {

    @PostConstruct
    public void intitialize(){
        System.out.println(getClass().getName()+" has been successfully initialized!");
    }

    public void onMessage(Message message) {
        System.out.println("Message received!"+message);
    }

}
