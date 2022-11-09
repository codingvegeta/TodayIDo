package auth.command;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginHandler implements CommandHandler {

    private static final String FORM_VIEW = "/view/loginForm.jsp";
    private LoginService loginservice = new LoginService();

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (req.getMethod().equalsIgnoreCase("GET")) {
            return processForm(req, res);
        } else if (req.getMethod().equalsIgnoreCase("POST")) {
            return processSubmit(req, res);
        } else {
            res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return null;
        }
    }

    private String processForm(HttpServletRequest req, HttpServletResponse res) {
        return FORM_VIEW;
    }

    private String processSubmit(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        String id = trim(req.getParameter("id"));
        String password = trim(req.getParameter("password"));

        Map<String, Boolean> errors = new HashMap<>();
        req.setAttribute("errors", errors);

        if (id == null || id.isEmpty()) {
            errors.put("id", Boolean.TRUE);
        }

        if (password == null || password.isEmpty()) {
            errors.put("password", Boolean.TRUE);
        }

        if (!errors.isEmpty()) {
            return FORM_VIEW;
        }

        try {
            System.out.println(req.getContextPath());
            User user = loginservice.login(id, password);
            req.getSession().setAttribute("authUser", user);
            res.sendRedirect(req.getContextPath() + "/webContent/index.jsp");
            return null;
        } catch (LoginFailException e) {
            errors.put("idOrPwNotMatch", Boolean.TRUE);
            return FORM_VIEW;
        }
    }

    private String trim(String str) {
        return str == null ? null : str.trim();
    }
}


