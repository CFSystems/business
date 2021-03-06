package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.AccountDAO;
import br.com.cfsystems.erp.model.Account;

@Service
public class AccountService {

	@Autowired
	private AccountDAO dao;
	
	public Collection<Account> findAll(){
		return dao.findAll();
	}
	
	public Account find(int id){
		Account account = dao.find(id);
		return account;
	}
	
	public void save(Account account){
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
	
	public void delete(int id){
		try {
			Account account = dao.find(id);
			dao.remove(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
