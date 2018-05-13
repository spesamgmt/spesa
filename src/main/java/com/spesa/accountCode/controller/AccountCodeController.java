package com.spesa.accountCode.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spesa.accountCode.service.AccountCodeService;
import com.spesa.pojo.DTO.AccountCodeDTO;

@Controller
@RequestMapping(method=RequestMethod.GET,  value="/accountCode")public class AccountCodeController {

	@Autowired
	private AccountCodeService  accountCodeServiceImpl;

	@RequestMapping(method=RequestMethod.GET,  value="/create")
	public ModelAndView loadCreatePage(){
		ModelAndView modelAndView = new ModelAndView();
		AccountCodeDTO accountCodeDTO = new AccountCodeDTO();
		modelAndView.addObject("accountCode", accountCodeDTO);
		modelAndView.setViewName("accountCodeJSP");
		return modelAndView;
	}



	@RequestMapping(method=RequestMethod.POST,  value="/save")
	public ModelAndView saveAccountCode(@ModelAttribute("accountCode") AccountCodeDTO accountCodeDTO){

		ModelAndView modelAndView = new ModelAndView();
		accountCodeServiceImpl.addAccountCode(accountCodeDTO);
		return modelAndView;
	}

}
