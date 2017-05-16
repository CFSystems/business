package br.com.cfsystems.erp.dao;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cfsystems.erp.model.PurchaseProduct;

@Repository
public class PurchaseProductDAO extends GenericDAO<PurchaseProduct, Serializable> {
	
	public BigDecimal value(PurchaseProduct purchaseProduct){
		Query query = entityManager.createQuery("select sum(pp.amount) from PurchaseProduct pp where pp.purchase.id = :idPurchase");
		query.setParameter("idPurchase", purchaseProduct.getPurchase().getId());
		return (BigDecimal) query.getSingleResult();
	}
	
}
