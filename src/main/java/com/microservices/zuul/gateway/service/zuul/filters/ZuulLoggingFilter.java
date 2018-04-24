package com.microservices.zuul.gateway.service.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private static Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);
	
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("Request : " + request + "Request Uri :" + request.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	/**
	 * pre,post,error
	 * pre - will execute this logging filter before request processing.
	 * post - will execute this logging filter after request is processed.
	 * error - will execute this logging filter when execution occured during
	 * 			request processing.
	*/
	@Override
	public String filterType() {
		return "pre";
	}

	
}
