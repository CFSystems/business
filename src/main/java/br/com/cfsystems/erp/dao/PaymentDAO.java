package br.com.cfsystems.erp.dao;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cfsystems.erp.model.Payment;

@Repository
public class PaymentDAO extends GenericDAO<Payment, Serializable> {
	
	public BigDecimal amountPaid(Payment payment){
		Query query = entityManager.createQuery("select sum(p.value) from Payment p where p.account.id = :idAccount");
		query.setParameter("idAccount", payment.getAccount().getId());
		return (BigDecimal) query.getSingleResult();
	}
}
