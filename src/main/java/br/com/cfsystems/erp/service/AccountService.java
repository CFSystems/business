package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.AccountDAO;
import br.com.cfsystems.erp.model.Account;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public Collection<Account> findAll(){
		return accountDAO.findAll();
	}
	
	public Account find(int id){
		Account account = accountDAO.find(id);
		return account;
	}
	
	public void save(Account account){
		try {
			if (account.getId() == null) {
				accountDAO.save(account);
			} else {
				accountDAO.update(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			Account account = accountDAO.find(id);
			accountDAO.remove(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
