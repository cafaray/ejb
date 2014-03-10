package edu.dgsca.mail;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Operaciones {

	public Operaciones() {}

	/**
	 * "send" metodo que se encarga de enviar el correo electronico.
	 */
	public void send(String smtpServer, String to, String from, String subject, String body) throws Exception {
			Properties props = System.getProperties();
			// Generamos la sesion de trabajo
			props.put("mail.smtp.host", smtpServer);
			Session session = Session.getDefaultInstance(props, null);
			// Creamos un nuevo mensaje
			Message msg = new MimeMessage(session);
			// Colocamos la direccion de correo origen y destino
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to, false));
			// Si requerimos incluir elementos de CC
			//     msg.setRecipients(Message.RecipientType.CC
			//         ,InternetAddress.parse(cc, false));
			// Coloca el asunto y el texto del correo
			msg.setSubject(subject);
			msg.setText(body);
			// Coloca información de cabecera del correo
			msg.setHeader("X-Mailer", "LOTONtechEmail");
			msg.setSentDate(new Date());
			// Realiza el envio del mensaje
			System.out.print(this.getClass().getName() + ":::Message sent ");
			Transport.send(msg);
			System.out.println("[OK]");
	}

	/**
	 * "receive" metodo que lee los correos que vienen del servidor
	 */
	public void receive(String popServer, String popUser, String popPassword) throws Exception {
		Store store = null;
		Folder folder = null;
		try {
			// Obtiene y mantiene la sesion con el servidor
			Properties props = System.getProperties();
			Session session = Session.getDefaultInstance(props, null);
			// Obtiene la conexion al contenedor 
			store = session.getStore("pop3");
			store.connect(popServer, popUser, popPassword);

			// Obtiene el enlace a la carpeta default del contenedor
			folder = store.getDefaultFolder();
			if (folder == null)
				throw new Exception("No default folder");
			// ahora a la INBOX
			folder = folder.getFolder("INBOX");
			if (folder == null)
				throw new Exception("No POP3 INBOX");
			// Abre la carpeta de forma que solo se pueda leer
			folder.open(Folder.READ_ONLY);
			// Obtiene los mensages y manda a imprimir
			Message[] msgs = folder.getMessages();
			for (int msgNum = 0; msgNum < msgs.length; msgNum++) {
				printMessage(msgs[msgNum]);				
			}
		} finally {
			// Cierra los elementos abiertos
			try {
				if (folder != null)
					folder.close(false);
				if (store != null)
					store.close();
			} catch (Exception e) {
				throw new Exception(e);
			}
		}
	}

	/**
	 * "printMessage" imprime los mensajes que se envian desde la lectura del INBOX
	 */
	public void printMessage(Message message) {
		try {
			// obtiene la información de cabecera
			String from = ((InternetAddress) message.getFrom()[0]).getPersonal();
			if (from == null){
				from = ((InternetAddress) message.getFrom()[0]).getAddress();
			}
			System.out.println("FROM: " + from);
			String subject = message.getSubject();
			System.out.println("SUBJECT: " + subject);
			// Extrae la información del mensaje
			Part messagePart = message;
			Object content = messagePart.getContent();
			// o el multiparte en caso de que venga en varias partes
			if (content instanceof Multipart) {
				messagePart = ((Multipart) content).getBodyPart(0);
				System.out.println("[ Multipart Message ]");
			}
			// Obtenemos el contenido
			String contentType = messagePart.getContentType();
			// Imprimimos 
			System.out.println("CONTENT:" + contentType);
			if (contentType.startsWith("text/plain") || contentType.startsWith("text/html")) {
				InputStream is = messagePart.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				String thisLine = reader.readLine();
				while (thisLine != null) {
					System.out.println(thisLine);
					thisLine = reader.readLine();
				}
			}
			// esta linea de codigo nos permite marcar el correo como leido, 
			// en este caso aqui ubicaremos el cambio de estado aunque se debe
			// de hacer el cambo cuando realmente el usuario haya leído el correo
			// message.setFlag(Flags.Flag.ANSWERED,true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
