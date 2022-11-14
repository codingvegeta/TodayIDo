package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /*
    // 1. 명령어와 관련된 비즈니스 로직 처리
    ...
    // 2. 뷰 페이지에서 사용할 정보 저장
    request.setAttribute("",~)
    // 3. 뷰 페이지의 URI 리턴
    return "/~~/~~.jsp"
    */
}
