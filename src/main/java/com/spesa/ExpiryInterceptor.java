package com.spesa;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ExpiryInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("forwarded to JSP through ViewResolver completed");
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("controller execution completed");
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		boolean expired = false;
		//logic starts
		expired = true;
		//logic ends
		if(expired == false){
			
			request.setAttribute("msgType", "alert-warning");
			request.setAttribute("headerMsg","Application Expired as today is "+new Date());
			request.getRequestDispatcher("/JSPs/acknowledgement.jsp").forward(request, response);
			return false;
		}
		return true; 
				
	}

}
