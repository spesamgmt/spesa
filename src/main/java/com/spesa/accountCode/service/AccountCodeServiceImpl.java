package com.spesa.accountCode.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spesa.accountCode.DAO.AccountCodeDAO;
import com.spesa.pojo.DTO.AccountCodeDTO;


@Service
public class AccountCodeServiceImpl implements AccountCodeService{


	@Autowired
	private AccountCodeDAO  accountCodeDAO;
	public void addAccountCode(AccountCodeDTO accountCodeDTO){
		accountCodeDAO.addAccountCode(accountCodeDTO);
	}
}
