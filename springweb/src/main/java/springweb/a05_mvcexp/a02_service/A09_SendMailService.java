package springweb.a05_mvcexp.a02_service;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import springweb.a05_mvcexp.z01_vo.MailSender;

@Service
public class A09_SendMailService {
	// container에서 선언한 객체 호출.
	// required = false : 객체가 생성되지 않더라도 에러 발생하지 않게 처리..
	@Autowired(required = false)
	private JavaMailSender sender;
	
	// 메일 발송 메서드
	public String sendMail(MailSender email) {
		String msg = "메일 발송 성공";
		// 1. 메일 발송 데이터 전송을 위한 객체 생성.
		MimeMessage mmsg = sender.createMimeMessage();
		
		// 2. 해당 객체로 입력된 내용 할당.
		try {
			// 1) 제목
			mmsg.setSubject(email.getTitle());
			// 2) 수신자
			mmsg.setRecipient(RecipientType.TO, 
					new InternetAddress(email.getReceiver()) );
			// 3) 내용
			mmsg.setText(email.getContent());
		// 3. 발송처리.
			sender.send(mmsg);
		} catch (MessagingException e) {
			System.out.println("메시지 전송 에러:"+e.getMessage());
			msg="메시지 전송 에러:"+e.getMessage();
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
			msg="일반 에러:"+e.getMessage();
		}
		return msg;
	}
	
}
