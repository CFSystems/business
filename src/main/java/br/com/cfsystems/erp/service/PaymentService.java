package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cfsystems.erp.dao.AccountDAO;
import br.com.cfsystems.erp.dao.PaymentDAO;
import br.com.cfsystems.erp.model.Payment;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentDAO paymentDAO;
	@Autowired
	private AccountDAO accountDAO;
	
	public Collection<Payment> findAll(){
		return paymentDAO.findAll();
	}
	
	public Payment find(int id){
		Payment payment = paymentDAO.find(id);
		return payment;
	}
	
	@Transactional
	public void save(Payment payment) {
		paymentDAO.save(payment);
		accountDAO.updateAumontPaid(payment.getAccount());
	}
	
	public void delete(int id){
		try {
			Payment payment = paymentDAO.find(id);
			paymentDAO.remove(payment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
