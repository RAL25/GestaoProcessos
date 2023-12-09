/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Util;

import javax.ejb.Local;
import javax.mail.MessagingException;

/**
 *
 * @author Gabriel Sizilio <gabriel.sizilio>
 */
@Local
public interface MailServiceLocal {

    void sendEmail(String nome, String to, String link) 
            throws MessagingException;

    public void recoveryPass(String nome, String to, String link) throws MessagingException;
    
}
