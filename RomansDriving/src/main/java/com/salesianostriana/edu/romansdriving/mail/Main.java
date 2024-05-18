package com.salesianostriana.edu.romansdriving.mail;

import com.resend.Resend;
import com.resend.services.emails.model.SendEmailRequest;
import com.resend.services.emails.model.SendEmailResponse;

public class Main {
    public static void main(String[] args) {
        Resend resend = new Resend("re_b8WahWdD_EUDLRayHtypoyDvNpBrLtLFS");

        SendEmailRequest sendEmailRequest = SendEmailRequest.builder()
                .from("onboarding@resend.dev")
                .to("roman.abcar24@triana.salesianos.edu")
                .subject("Hello World")
                .html("HOLA ANGEL")
                .build();


       
        SendEmailResponse data = resend.emails().send(sendEmailRequest);
    }
}
