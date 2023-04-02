package fillter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*",dispatcherTypes = DispatcherType.REQUEST)
public class UTF8EncodingFillter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//HttpServletRequest httpRequest = (HttpServletRequest)request;
		//HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		request.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
