package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.PaymentMethodDAO;
import br.com.cfsystems.erp.model.PaymentMethod;

@Service
public class PaymentMethodService {

	@Autowired
	private PaymentMethodDAO dao;
	
	public Collection<PaymentMethod> findAll(){
		return dao.findAll();
	}
	
	public PaymentMethod find(int id){
		PaymentMethod paymentMethod = dao.find(id);
		return paymentMethod;
	}
	
	public void save(PaymentMethod paymentMethod){
		try {
			if (paymentMethod.getId() == null) {
				dao.save(paymentMethod);
			} else {
				dao.update(paymentMethod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			PaymentMethod paymentMethod = dao.find(id);
			dao.remove(paymentMethod);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
