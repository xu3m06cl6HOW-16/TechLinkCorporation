package com.struts2.helloworld;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FilterDispatcher
 */
@WebFilter("*.action")
public class FilterDispatcher extends HttpFilter implements Filter {
       
    
	public void destroy() {}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		//1.接收servletPath
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		
		String path = null;
		
		if("/product-input.action".equals(servletPath)) {
			path = "/WEB-INF/pages/input.jsp";
		}
		
		if("/product-save.action".equals(servletPath)) {
			String productName = req.getParameter("productName");
			String productDesc = req.getParameter("productDesc");
			String productPrice = req.getParameter("productPrice");
			
			
			Product product = new Product(1, productName, productDesc, Double.parseDouble(productPrice));
			System.out.println(product);
			
			req.setAttribute("product", product);
			path = "/WEB-INF/pages/details.jsp";
		}

		if(path != null) {
			request.getRequestDispatcher(path).forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {}

}
