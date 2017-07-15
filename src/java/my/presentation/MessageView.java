/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MessageFacade;
import entities.Message;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Bext
 */
@Named(value = "messageView")
@RequestScoped
public class MessageView {

    @EJB
    private MessageFacade messageFacade;
    private final Message message;

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        this.message = new Message();
    }

    //Calls getMessage to retrive the message
    public Message getMessage() {
        return message;
    }
    
    //Return the total number of messages
    public int getNumberOfMessages() {
        return messageFacade.findAll().size();
    }
    
    // Save the message (persist it) and then return the string "theend"
    public String postMessage() {
        this.messageFacade.create(message);
        return "theend";
    }
}
