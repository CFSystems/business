package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.PurchaseProductDAO;
import br.com.cfsystems.erp.model.PurchaseProduct;

@Service
public class PurchaseProductService {

	@Autowired
	private PurchaseProductDAO purchaseProductDAO;
	
	public Collection<PurchaseProduct> findAll(){
		return purchaseProductDAO.findAll();
	}
	
	public PurchaseProduct find(int id){
		PurchaseProduct purchaseProduct = purchaseProductDAO.find(id);
		return purchaseProduct;
	}
	
	public void save(PurchaseProduct purchaseProduct){
		try {
			if (purchaseProduct.getId() == null) {
				purchaseProductDAO.save(purchaseProduct);
			} else {
				purchaseProductDAO.update(purchaseProduct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			PurchaseProduct purchaseProduct = purchaseProductDAO.find(id);
			purchaseProductDAO.remove(purchaseProduct);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
