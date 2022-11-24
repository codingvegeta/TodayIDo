package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC6 {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, BindingResult result) {
		   System.out.println("result="+result);
		   FieldError error = result.getFieldError();
		   
		   System.out.println("code="+error.getCode());
		   System.out.println("field="+error.getField());
		   System.out.println("msg="+error.getDefaultMessage());
		ex.printStackTrace();
		return "yoilError";
	}
	
    @RequestMapping("/getYoilMVC6") // http://localhost/ch2/getYoilMVC6
//    public String main(@ModelAttribute("myDate") MyDate date, Model model) { // 아래와 동일
        public String main(MyDate date, BindingResult result) {
   System.out.println("result="+result);
 
        // 1. 유효성 검사
    	if(!isValid(date)) 
    		return "yoilError";  // 유효하지 않으면, /WEB-INF/views/yoilError.jsp로 이동
    	
        // 2. 처리
//    	char yoil = getYoil(date);

        // 3. Model에 작업 결과 저장
//        model.addAttribute("myDate", date);
//        model.addAttribute("yoil", yoil);
        
        // 4. 작업 결과를 보여줄 View의 이름을 반환
        return "yoil"; // /WEB-INF/views/yoil.jsp
    }
    
    private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
	}

	private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " 일월화수목금토".charAt(dayOfWeek);
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // 간단히 체크 
    }
} 