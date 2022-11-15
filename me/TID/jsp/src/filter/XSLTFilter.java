package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@WebFilter(filterName = "xsltFilter", urlPatterns = {"/xml/*"})
public class XSLTFilter implements Filter {

    private String xslPath = null;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html; charset=utf-8");
        PrintWriter printWriter = servletResponse.getWriter();
        XSLTResponseWrapper responseWrapper = new XSLTResponseWrapper((HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, servletResponse);

        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Reader xslReader = new BufferedReader(new FileReader(xslPath));

            StreamSource xslSource = new StreamSource(xslReader);

            Transformer transformer = factory.newTransformer(xslSource);

            String xmlDocument = responseWrapper.getBufferedString();
            Reader xmlReader = new StringReader(xmlDocument);
            StreamSource xmlSource = new StreamSource(xmlReader);

            StringWriter stringWriter = new StringWriter(4096);
            transformer.transform(xmlSource, new StreamResult(stringWriter));

            printWriter.print(stringWriter.toString());
        } catch (Exception e) {
            throw new ServletException(e);
        }

        printWriter.flush();
        printWriter.close();
    }

    @Override
    public void destroy() {
    }
}
