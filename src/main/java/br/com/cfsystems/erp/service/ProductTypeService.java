package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.ProductTypeDAO;
import br.com.cfsystems.erp.model.ProductType;

@Service
public class ProductTypeService {

	@Autowired
	private ProductTypeDAO dao;

	public Collection<ProductType> findAll() {
		return dao.findAll();
	}

	public ProductType find(int id) {
		ProductType account = dao.find(id);
		return account;
	}

	public void save(ProductType account) {
		try {
			if (account.getId() == null) {
				dao.save(account);
			} else {
				dao.update(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			ProductType account = dao.find(id);
			dao.remove(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
