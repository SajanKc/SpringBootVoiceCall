package com.kcsajan.main;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/api/v1")
public class VoiceCallController {
	public static final String ACCOUNT_SID = SecretKey.ACCOUNT_SID;
	public static final String AUTH_TOKEN = SecretKey.AUTH_TOKEN;
	public static final String FROM_NUMBER = SecretKey.FROM_NUMBER;
	public static final String TO_NUMBER = SecretKey.TO_NUMBER;

	static {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}

	@GetMapping("/voicecall")
	public String makeVoiceCall() throws URISyntaxException {
		Call call = Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				new URI("http://demo.twilio.com/docs/voice.xml")).create();
		System.out.println(call.getSid());
		return "Calling..." + TO_NUMBER;
	}

}
