package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.PaymentMethodDAO;
import br.com.cfsystems.erp.model.PaymentMethod;

@Service
public class PaymentMethodService {

	@Autowired
	private PaymentMethodDAO paymentMethodDAO;
	
	public Collection<PaymentMethod> findAll(){
		return paymentMethodDAO.findAll();
	}
	
	public PaymentMethod find(int id){
		PaymentMethod paymentMethod = paymentMethodDAO.find(id);
		return paymentMethod;
	}
	
	public void save(PaymentMethod paymentMethod){
		try {
			if (paymentMethod.getId() == null) {
				paymentMethodDAO.save(paymentMethod);
			} else {
				paymentMethodDAO.update(paymentMethod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			PaymentMethod paymentMethod = paymentMethodDAO.find(id);
			paymentMethodDAO.remove(paymentMethod);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
