package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.UserDAO;
import br.com.cfsystems.erp.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public Collection<User> findAll(){
		return userDAO.findAll();
	}
	
	public User find(int id){
		User user = userDAO.find(id);
		return user;
	}
	
	public void save(User user){
		try {
			if (user.getId() == null) {
				userDAO.save(user);
			} else {
				userDAO.update(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			User user = userDAO.find(id);
			userDAO.remove(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
