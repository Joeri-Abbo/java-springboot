package com.skillsoft.springboot.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BookHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    private JavaMailSender javaMailSender;
    private static final SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getParameter("bookId") != null) {
            System.out.println("preHandle() method sending book access mail...");
            sendEmail(request.getParameter("bookId"), "Book accessed");
            System.out.println("Done");
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (request.getParameter("bookId") != null) {
            System.out.println("afterCompletion() method sending book access mail...");
            sendEmail(request.getParameter("bookId"), "Request and response complete");
            System.out.println("Done");
        }
    }

    private void sendEmail(String bookId, String messageText) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("joeriabbo@hotmail.com");
        msg.setSubject("Book related activity for book: " + bookId);
        msg.setText(messageText+ " : " + dateformat.format(new Date()));
    }
}
