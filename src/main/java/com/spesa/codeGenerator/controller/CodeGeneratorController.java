package com.spesa.codeGenerator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spesa.codeGenerator.utility.CodeWritingUtility;
import com.spesa.pojo.DTO.CodeGeneratorDTO;
import com.spesa.pojo.DTO.FieldDTO;

@Controller
@RequestMapping(method=RequestMethod.GET,  value="/codeGenerator")
public class CodeGeneratorController {


	@RequestMapping(method=RequestMethod.GET,  value="/create")
	public ModelAndView loadCreatePage(){

		ModelAndView modelAndView = new ModelAndView();
		CodeGeneratorDTO CodeGeneratorDTO = new CodeGeneratorDTO();
		FieldDTO FieldDTO = new FieldDTO();
		
		List Filed = new ArrayList();
		Filed.add(FieldDTO);
		CodeGeneratorDTO.setFieldList(Filed);
		
		modelAndView.addObject("fields", CodeGeneratorDTO);
		modelAndView.setViewName("main_multi");	
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST,  value="/generate")
	public ModelAndView generate(@ModelAttribute("fields") CodeGeneratorDTO CodeGeneratorDTO, HttpServletRequest request){
		System.out.println(request.getContextPath());
		
		CodeWritingUtility codeWritingUtility = new CodeWritingUtility();
		
		codeWritingUtility.writeJSP(CodeGeneratorDTO, request.getContextPath());
		codeWritingUtility.writeController(CodeGeneratorDTO, request.getContextPath());
		codeWritingUtility.writeForm(CodeGeneratorDTO);
		codeWritingUtility.writeDo(CodeGeneratorDTO);
		codeWritingUtility.writeService(CodeGeneratorDTO, request.getContextPath());
		codeWritingUtility.writeServiceImpl(CodeGeneratorDTO, request.getContextPath());
		codeWritingUtility.writeDAO(CodeGeneratorDTO, request.getContextPath());
		codeWritingUtility.writeDaoImpl(CodeGeneratorDTO, request.getContextPath());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("headerMsg", "check the created master related files at C:\\generated_code\\"+codeWritingUtility.formName) ;
		modelAndView.setViewName("acknowledgement");
		return modelAndView;
	}
}
