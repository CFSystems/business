package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.ConsumerDAO;
import br.com.cfsystems.erp.model.Consumer;

@Service
public class ConsumerService {

	@Autowired
	private ConsumerDAO dao;
	
	public Collection<Consumer> findAll(){
		return dao.findAll();
	}
	
	public Consumer find(int id){
		Consumer c = dao.find(id);
		return c;
	}
	
	public void save(Consumer consumer){
		try {
			if (consumer.getId() == null) {
				System.out.println("Criando cliente " + consumer.getName());
				dao.save(consumer);
			} else {
				System.out.println("Alterando cliente " + consumer.getName());
				dao.update(consumer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			Consumer consumer = dao.find(id);
			dao.remove(consumer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
}
