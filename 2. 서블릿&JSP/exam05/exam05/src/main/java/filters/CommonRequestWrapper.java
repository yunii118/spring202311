package filters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class CommonRequestWrapper extends HttpServletRequestWrapper {

    public CommonRequestWrapper(HttpServletRequest request) {
        super(request);
        request.setAttribute("siteConfig", "사이트 설정...");
    }

    @Override
    public String getParameter(String name) {

        String value = super.getParameter(name);
        value = value == null? value: value.toUpperCase();

        return value;
    }
}
