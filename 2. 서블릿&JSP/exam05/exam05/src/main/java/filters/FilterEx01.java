package filters;


import jakarta.servlet.*;

import java.io.IOException;

public class FilterEx01 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter01 요청 전");

        chain.doFilter(request, response);

        System.out.println("Filter01 요청 후");
    }
}
