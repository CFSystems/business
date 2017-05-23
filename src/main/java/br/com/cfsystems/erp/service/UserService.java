package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.UserDAO;
import br.com.cfsystems.erp.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	
	public Collection<User> findAll(){
		return dao.findAll();
	}
	
	public User find(int id){
		User user = dao.find(id);
		return user;
	}
	
	public void save(User user){
		try {
			if (user.getId() == null) {
				dao.save(user);
			} else {
				dao.update(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			User user = dao.find(id);
			dao.remove(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
