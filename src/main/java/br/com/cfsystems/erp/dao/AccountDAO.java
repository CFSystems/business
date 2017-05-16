package br.com.cfsystems.erp.dao;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cfsystems.erp.model.Account;

@Repository
public class AccountDAO extends GenericDAO<Account, Serializable> {
	
	public void updateAumontSpent(Account account){
		Account a = find(account.getId());
		Query query = entityManager.createQuery("select sum(p.value) from Purchase p where p.account.id = :idAccount");
		query.setParameter("idAccount", a.getId());
		a.setAmountSpent((BigDecimal) query.getSingleResult());
	}
	
	public void updateAumontPaid(Account account){
		Account a = find(account.getId());
		Query query = entityManager.createQuery("select sum(p.value) from Payment p where p.account.id = :idAccount");
		query.setParameter("idAccount", a.getId());
		a.setAmountPaid((BigDecimal) query.getSingleResult());
	}
}
