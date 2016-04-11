package com.rmc.oss.werewolf;

import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SMSSilverBullet {
    public void SendSMS() throws TwilioRestException {
    	BlackKnight knight = new BlackKnight();
        TwilioRestClient client = new TwilioRestClient(knight.getSID(), knight.getToken());
        Account account = client.getAccount();
        MessageFactory messageFactory = account.getMessageFactory();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", "+11234567890")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("From", knight.getNumber())); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("Body", "This is a test message from the automated event-nofication engine, Werewolf!!!"));
        Message sms = messageFactory.create(params);
    }
}
