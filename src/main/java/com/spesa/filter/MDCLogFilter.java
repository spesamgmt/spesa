package com.spesa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.MDC;

public class MDCLogFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
            // Setup MDC data:
			HttpSession  session = ((HttpServletRequest) request).getSession(false);
			String sessionId = "BLANK";
			if(null != session
					&& null != session.getId()) {
				sessionId = session.getId();
			}
			
            String mdcData = String.format("[sessionId:%s] ", sessionId);
            MDC.put("mdcData", mdcData); //Variable 'mdcData' is referenced in Spring Boot's logging.pattern.level property
            chain.doFilter(request, response);
        } finally {
           // Tear down MDC data:
           // ( Important! Cleans up the ThreadLocal data again )
           MDC.clear();
        }
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



	
}
