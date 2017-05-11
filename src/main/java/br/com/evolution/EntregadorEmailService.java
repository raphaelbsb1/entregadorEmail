/**
 * 
 */
package br.com.evolution;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

/**
 * @author raphael
 *
 */
@Service
public class EntregadorEmailService {

	public void enviar(String nome, String emailDestinatario) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("teste@gmail.com", "teste123"));
			email.setSSLOnConnect(true);

			email.setFrom("teste@gmail.com");
			email.setSubject("Você foi cadastrado no Sistema de Gestão Patrimonial");
			email.setMsg("Olá " + nome + ". Você acaba de adicionado no Sistema de Gestão Patrimonial.");
			email.addTo(emailDestinatario);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}

	}
}
