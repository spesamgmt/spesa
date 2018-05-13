package com.spesa.codeGenerator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spesa.codeGenerator.CodeWritingUtility;
import com.spesa.codeGenerator.form.CodeGeneratorForm;
import com.spesa.codeGenerator.form.FieldForm;

@Controller
@RequestMapping(method=RequestMethod.GET,  value="/codeGenerator")
public class CodeGeneratorController {


	@RequestMapping(method=RequestMethod.GET,  value="/create")
	public ModelAndView loadCreatePage(){

		ModelAndView modelAndView = new ModelAndView();
		CodeGeneratorForm codeGeneratorForm = new CodeGeneratorForm();
		FieldForm fieldForm = new FieldForm();
		fieldForm.setElement("eeee");
		fieldForm.setElement("rrr");
		
		
		FieldForm fieldForm1 = new FieldForm();
		fieldForm1.setElement("eeee");
		fieldForm1.setElement("rrr");
		
		List Filed = new ArrayList();
		Filed.add(fieldForm1);
		Filed.add(fieldForm);
		codeGeneratorForm.setFieldList(Filed);
		
		
		modelAndView.addObject("fields", codeGeneratorForm);
		modelAndView.setViewName("main_multi");	
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST,  value="/generate")
	public ModelAndView generate(@ModelAttribute("fields") CodeGeneratorForm codeGeneratorForm, HttpServletRequest request){
		System.out.println(request.getContextPath());
		
		CodeWritingUtility codeWritingUtility = new CodeWritingUtility();
		
		codeWritingUtility.writeJSP(codeGeneratorForm, request.getContextPath());
		codeWritingUtility.writeController(codeGeneratorForm, request.getContextPath());
		codeWritingUtility.writeForm(codeGeneratorForm);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("headerMsg", "check the created master through this <a href=\""+request.getContextPath()+"/all/"+codeWritingUtility.formName+"/create\">link</a>") ;
		modelAndView.setViewName("acknowledgement");
		return modelAndView;
	}
}
