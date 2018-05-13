package com.spesa.accountCode.DAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spesa.pojo.DO.AccountCodeMst;
import com.spesa.pojo.DTO.AccountCodeDTO;

@Repository
public class AccountCodeDaoImpl implements AccountCodeDAO{


	@Autowired
	private SessionFactory sessionFactory;
	public void addAccountCode(AccountCodeDTO accountCodeDTO) {
		AccountCodeMst accountCodeMst = new AccountCodeMst(); 
		BeanUtils.copyProperties(accountCodeDTO, accountCodeMst);
		sessionFactory.getCurrentSession().saveOrUpdate(accountCodeMst);
	}

}
