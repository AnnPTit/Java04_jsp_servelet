package fillter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/views/changepass" ,"/views/profile"})
public class LoginFillter implements Filter{

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		Object user = httpRequest.getSession().getAttribute("username");
		if(user == null) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/views/login");
			return;
		}
		chain.doFilter(httpRequest, httpResponse);

		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}