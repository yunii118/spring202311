package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class FilterEx02 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter02 요청 전");
        chain.doFilter(request, response);
        System.out.println("Filter02 요청 후");
    }
}
