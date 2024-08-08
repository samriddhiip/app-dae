package com.eventplanning.evento.service;

import com.eventplanning.evento.model.Payment;
import com.eventplanning.evento.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Integer id) {
        return paymentRepository.findById(id);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Integer id, Payment paymentDetails) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setAmount(paymentDetails.getAmount());
        payment.setCardNumber(paymentDetails.getCardNumber());
        payment.setCardHolder(paymentDetails.getCardHolder());
        payment.setExpiry(paymentDetails.getExpiry());
        payment.setCvc(paymentDetails.getCvc());
        return paymentRepository.save(payment);
    }

    public void deletePayment(Integer id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
        paymentRepository.delete(payment);
    }
}
