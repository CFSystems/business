package br.com.cfsystems.erp.dao;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cfsystems.erp.model.Purchase;

@Repository
public class PurchaseDAO extends GenericDAO<Purchase, Serializable> {
	
	public void updateValue(Purchase purchase){
		Query query = entityManager.createQuery("select sum(pp.amount) from PurchaseProduct pp where pp.purchase.id = :idPurchase");
		query.setParameter("idPurchase", purchase.getId());
		purchase.setValue((BigDecimal) query.getSingleResult());
	}

}
