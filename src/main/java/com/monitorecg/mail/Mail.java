/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.mail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class Mail {
        public static String enviarEmail(String mail){
            String envio = ""; 
            Properties props = new Properties();
            props.setProperty("mail.smtp.host","smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port","587");
            props.setProperty("mail.smtp.user","monitorecg046@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            Session sesion = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(sesion);
            try {
                message.setFrom(new InternetAddress("monitorecg046@gmail.com"));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
                message.setSubject("Message Subject");
                //preparar la pagina 
                String pagina = "<h1>Monitor ECG</h1>"+
                                "<p>Si deseas cambiar tu contraseña en monitor ecg oprime el siguiente botón, en caso contrario no hagas caso a este email.</p>"+
                                "<a href='http://monitor-ecg046.herokuapp.com/RecuperarContrasena.jsp' style='text-decoration: none;'>Cambiar contraseña</a>";
                message.setContent(pagina, "text/html");
                Transport t = sesion.getTransport("smtp");
                t.connect("monitorecg046@gmail.com","monitorecg-a046");

                t.sendMessage(message, message.getAllRecipients());
                t.close();
                envio = "Si se envio"; 
            } catch (AddressException ex) {
                Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
                envio = "Ocurrió un error, verifica tu conexión"; 
            } catch (MessagingException ex) {
                Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
                envio = "Ocurrió un error, verifica tu conexión"; 
            }
            
            return envio; 
        }
}
