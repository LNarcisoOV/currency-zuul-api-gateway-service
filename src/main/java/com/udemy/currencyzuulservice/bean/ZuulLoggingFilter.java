package com.udemy.currencyzuulservice.bean;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} -> request uri -> {}", request, request.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// true if you want to filter every request.
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		// There's 3 types of filter, which will filter, before, after or when
		// an error occurs.

		// pre
		// post
		// error
		return "pre";
	}

}
