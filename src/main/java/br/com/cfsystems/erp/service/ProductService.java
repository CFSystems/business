package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.ProductDAO;
import br.com.cfsystems.erp.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO dao;
	
	public Collection<Product> findAll(){
		return dao.findAll();
	}
	
	public Product find(int id){
		Product product = dao.find(id);
		return product;
	}
	
	public void save(Product product){
		try {
			if (product.getId() == null) {
				dao.save(product);
			} else {
				dao.update(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			Product product = dao.find(id);
			dao.remove(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
