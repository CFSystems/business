package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.PurchaseProductDAO;
import br.com.cfsystems.erp.model.PurchaseProduct;

@Service
public class PurchaseProductService {

	@Autowired
	private PurchaseProductDAO dao;
	
	public Collection<PurchaseProduct> findAll(){
		return dao.findAll();
	}
	
	public PurchaseProduct find(int id){
		PurchaseProduct purchaseProduct = dao.find(id);
		return purchaseProduct;
	}
	
	public void save(PurchaseProduct purchaseProduct){
		try {
			if (purchaseProduct.getId() == null) {
				dao.save(purchaseProduct);
			} else {
				dao.update(purchaseProduct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			PurchaseProduct purchaseProduct = dao.find(id);
			dao.remove(purchaseProduct);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
