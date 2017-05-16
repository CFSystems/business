package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.ProductDAO;
import br.com.cfsystems.erp.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public Collection<Product> findAll(){
		return productDAO.findAll();
	}
	
	public Product find(int id){
		Product product = productDAO.find(id);
		return product;
	}
	
	public void save(Product product){
		try {
			if (product.getId() == null) {
				productDAO.save(product);
			} else {
				productDAO.update(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			Product product = productDAO.find(id);
			productDAO.remove(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
