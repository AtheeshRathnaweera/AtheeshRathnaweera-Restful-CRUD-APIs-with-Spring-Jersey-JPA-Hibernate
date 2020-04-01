package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.service.EmailService;
import com.atheesh.app.ws.shared.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;


@Service("emailService")
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendTextMail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    @Override
    public void sendOrderConfirmationMail(String to, String subject, PaymentDTO paymentDTO) {

        String userName = paymentDTO.getOrder().getUser().getFirstName()+" "+paymentDTO.getOrder().getUser().getLastName();
        String itemName = paymentDTO.getOrder().getStore().getItem().getName();
        Integer quantity = paymentDTO.getOrder().getAmount();
        Integer orderId = paymentDTO.getOrder().getId();
        String estDeliveryDate = "Tue, Apr 18 - Wed, May 25";
        String userAddress = "No.16, Wela Road,Maharagama.";
        String shopName = paymentDTO.getOrder().getStore().getShop().getName();
        String price = "Rs. "+String.valueOf(paymentDTO.getOrder().getPrice());
        String serviceCharge = "Rs. "+45.50f;
        float totalAmount = paymentDTO.getOrder().getPrice()+45.50f;
        String total = "Rs. "+String.valueOf(totalAmount);
        String payedBy = paymentDTO.getMethod()+" , "+paymentDTO.getCardNo();

        MimeMessagePreparator preparator = mimeMessage -> {
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setFrom(new InternetAddress("chamalkarathnaweera123@gmail.com"));
            mimeMessage.setSubject(subject);
            mimeMessage.setContent("<html>\n" +
                    "\n" +
                    "<body style=\"padding-top:5%; padding-bottom:5%; padding-right: 10%; padding-left: 10%; background-color: whitesmoke; box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2)\">\n" +
                    "    <h1 style=\"color:skyblue; font-size: 40px;\">EasyBay</h1>\n" +
                    "    <p style=\"margin-left: 20px; font-size: 28px; color: darkmagenta;\">Thanks for another purchase "+userName+" ! Your older is confirmed.</p>\n" +
                    "    <div style=\"margin-left: 20px;\">\n" +
                    "        <p style=\"font-size: 24px;\">Order Summary</p>\n" +
                    "        <div style=\"padding: 0px 20px 0px 20px;\">\n" +
                    "           <p style=\"color: darkblue; font-size: 20px;\">"+itemName+"</p>"+
                    "            <table style=\"margin-left: 20px;\">\n" +
                    "                <tr style=\"font-size: 15px;\">\n" +
                    "                    <td width=\"10%\" style=\"font-size: 15px; color: darkcyan;\"><b>Quantity</b></td>\n" +
                    "                    <td width=\"90%\">"+quantity+"</td>\n" +
                    "                </tr>\n" +
                    "                <tr style=\"font-size: 15px;\">\n" +
                    "                    <td width=\"10%\" style=\"font-size: 15px; color: darkcyan;\"><b>Order ID</b></td>\n" +
                    "                    <td width=\"90%\">"+orderId+"</td>\n" +
                    "                </tr>\n" +
                    "            </table>\n" +
                    "        </div>\n" +
                    "        <p style=\"font-size: 24px;\">Order Details</p>\n" +
                    "        <div style=\"padding: 0px 20px 0px 20px;\">\n" +
                    "            <table style=\"margin-left: 20px;\">\n" +
                    "                <tr>\n" +
                    "                    <td width=\"50%\">\n" +
                    "                        <span style=\"font-size: 15px; color: darkcyan;\"><b>Estimated Delivery</b></span>\n" +
                    "                        <br>\n" +
                    "                        <span style=\"margin-left: 10px;\">"+estDeliveryDate+"</span>\n" +
                    "                    </td>\n" +
                    "                    <td width=\"50%\">\n" +
                    "                        <span style=\"font-size: 15px; color: darkcyan;\"><b>Your Address</b></span>\n" +
                    "                        <br>\n" +
                    "                        <span style=\"margin-left: 10px;\">"+userAddress+"</span>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "            </table>\n" +
                    "            <table style=\"margin-left: 20px; width: 90%; margin-top: 10px;\">\n" +
                    "                <tr style=\"padding-top: 10px;\">\n" +
                    "                    <td width=\"50%\">\n" +
                    "                        <span style=\"font-size: 15px; color: darkcyan;\"><b>Seller</b></span>\n" +
                    "                        <br>\n" +
                    "                        <span style=\"margin-left: 10px;\">"+shopName+"</span>\n" +
                    "                    </td>\n" +
                    "                </tr>\n" +
                    "\n" +
                    "            </table>\n" +
                    "        </div>\n" +
                    "        <p style=\"font-size: 24px;\">Payment Details</p>\n" +
                    "        <div style=\"padding: 0px 20px 0px 20px;\">\n" +
                    "            <table style=\"margin-left: 20px; width: 90%;\">\n" +
                    "                <tr>\n" +
                    "                    <td width=\"30%\" style=\"font-size: 15px; color: darkcyan;\"><b>Price</b></td>\n" +
                    "                    <td width=\"70%\"><i>"+price+"</i></td>\n" +
                    "                </tr>\n" +
                    "                <tr>\n" +
                    "                    <td width=\"30%\" style=\"font-size: 15px; color: darkcyan;\"><b>Service Charge</b></td>\n" +
                    "                    <td width=\"70%\">"+serviceCharge+"</td>\n" +
                    "                </tr>\n" +
                    "            </table>\n" +
                    "            <table style=\"margin-left: 20px; width: 90%;\">\n" +
                    "                <tr>\n" +
                    "                    <td width=\"30%\" style=\"font-size: 15px; color: darkcyan;\"><b>Total Amount</b></td>\n" +
                    "                    <td width=\"70%\">"+total+"</td>\n" +
                    "                </tr>\n" +
                    "            </table>\n" +
                    "            <p style=\"font-size: 15px\"><b>Paid By </b>\n" +
                    "                <span style=\"margin-left: 10px;\">"+payedBy+"</span>\n" +
                    "            </p>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>\n","text/html");
        };

        try {
            mailSender.send(preparator);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}
