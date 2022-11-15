package filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

public class XSLTResponseWrapper extends HttpServletResponseWrapper {

    private ResponseBufferWriter bufferWriter = null;

    public XSLTResponseWrapper(HttpServletResponse response) {
        super(response);
        bufferWriter = new ResponseBufferWriter();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return bufferWriter;
    }

    @Override
    public void setContentType(String type) {
    }

    public String getBufferedString() {
        return bufferWriter.toString();
    }
}
