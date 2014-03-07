package com.fita.mx.ejb;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/fitaNotificaCitas")})
public class EnviaNotificacionIniciaCitas implements MessageListener {

    @Resource(mappedName = "java:Mail")
    Session mailSession;

    public EnviaNotificacionIniciaCitas() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Tipo de mensaje recibido: " + message.getClass().getName());
            if (message instanceof TextMessage) {
                TextMessage txtMsg = (TextMessage)message;
                String carpeta = "";
                String subject = "Arranque del sistema de Citas.";
                String msg = txtMsg.getText();
                String correo = "", nombre = "", tipo = "";
                if (msg.contains(":")) {
                    String tmp[] = msg.split("\\:");
                    if (tmp.length == 3) {
                        tipo = tmp[0];
                        nombre = tmp[1];
                        correo = tmp[2];
                    } else {
                        throw new Exception("No se recuperaron los parametros en el mensaje." + msg);
                    }
                }
                try {
                    System.out.println("PLANETMEDIA:::fitaNotificaRegistro- -Destinatario: " + correo);
                    MimeMessage mailMessage = new MimeMessage(mailSession);
                    mailMessage.setSubject(subject);
                    String user = mailSession.getProperty("mail.user");
                    String textoMensaje = String.format("Buenos d&iacute;as, %s<br />", nombre);
                    MimeBodyPart texto = new MimeBodyPart();
                    texto.setText(textoMensaje, "utf-8");

                    //se configura el attachment
                    carpeta = mailSession.getProperty("mail.content.register");
                    String fileAttachment = carpeta+"NOTIFICACITA_"+tipo+".pdf";
                    Multipart multipart = new MimeMultipart();
                    multipart.addBodyPart(texto);
                    System.out.println("PLANETMEDIA:::Preparando el adjunto.");
                    texto = new MimeBodyPart();
                    DataSource source =  new FileDataSource(fileAttachment);
                    texto.setDataHandler(new DataHandler(source));
                    texto.setFileName(fileAttachment);

                    multipart.addBodyPart(texto);
                    // Put parts in message

                    System.out.println("PLANETMEDIA:::Se armo el mensaje correctamente.");
                    mailMessage.setRecipients(javax.mail.Message.RecipientType.TO, correo);
                    mailMessage.setRecipients(javax.mail.Message.RecipientType.CC, "comercial@fitamx.com");
                    mailMessage.setRecipients(javax.mail.Message.RecipientType.BCC, "cafaray@gmail.com");
                    mailMessage.setFrom(new InternetAddress(user));
                    mailMessage.setContent(multipart, "text/html; charset=utf-8");
                    //mailMessage.setContent(String.format(textoMensaje, ""), "text/html; charset=utf-8");
                    mailMessage.saveChanges();
                    System.out.println("PLANETMEDIA:::mailMessage saved.");
                    Transport transport = mailSession.getTransport("smtp");
                    try {
                        transport.connect();
                        System.out.println("PLANETMEDIA:::sending ...........");
                        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
                        System.out.println("PLANETMEDIA:::sending [ok]");
                    } finally {
                        transport.close();
                    }
                } catch (MessagingException e) {
                    e.printStackTrace(System.out);
                }
            } else {
                System.out.println("PLANETMEDIA:::No se logró interpretar el mensaje");
            }
        } catch (Exception e) {
            System.out.println("PLANETMEDIA:::Exception on MDB: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
