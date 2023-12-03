package vol2.chapter1.scopebean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.util.Date;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginUser
{
    String loginID;
    String name;
    Date loginTime;

    public String getLoginID()
    {
        return loginID;
    }

    public void setLoginID(String loginID)
    {
        this.loginID = loginID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getLoginTime()
    {
        return loginTime;
    }

    public void setLoginTime(Date loginTime)
    {
        this.loginTime = loginTime;
    }
}
