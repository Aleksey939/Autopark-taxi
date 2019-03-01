package org.ivanov.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UtfFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        //servletResponse.setContentType("text/html;charset=UTF-8");

        //HttpServletRequest req = (HttpServletRequest) servletRequest;
        //HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //resp.sendRedirect("/person");

      //  req.getRequestDispatcher("/WEB-INF/person/index.jsp").forward(req, resp);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
