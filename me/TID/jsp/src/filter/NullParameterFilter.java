package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.StringTokenizer;

public class NullParameterFilter implements Filter {
    private String[] parameterNames = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String names = filterConfig.getInitParameter("parameterNames");
        StringTokenizer st = new StringTokenizer(names, ",");
        parameterNames = new String[st.countTokens()];

        for (int i = 0; st.hasMoreTokens(); i++) {
            parameterNames[i] = st.nextToken();
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        NullParameterRequestWrapper requestWrapper = new NullParameterRequestWrapper((HttpServletRequest) servletRequest);
        requestWrapper.checkNull(parameterNames);

        filterChain.doFilter(requestWrapper, servletResponse);
    }
    @Override
    public void destroy() {
    }
}
