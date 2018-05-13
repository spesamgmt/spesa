package com.spesa;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllException(Exception e){
		
		ModelAndView modelAndView = new ModelAndView("exceptionOccuredJSP");
		modelAndView.addObject("msgType", "alert-danger") ;
		modelAndView.addObject("headerMsg", "Unknown Exception occurred from Global") ;
		return modelAndView;
		
	}
	
	@ExceptionHandler(value=NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception e){

		ModelAndView modelAndView = new ModelAndView("exceptionOccuredJSP");
		modelAndView.addObject("msgType", "alert-danger") ;
		modelAndView.addObject("headerMsg", "Null Pointer Exception occurred from Global") ;
		return modelAndView;

	}

}
