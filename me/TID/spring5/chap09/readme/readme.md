# 스프링 MVC 프레임워크 동작 방식

---

## 1 스프링 MVC 핵심 구성 요소

---
<img src="https://oopy.lazyrockets.com/api/v2/notion/image?src=https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F183bb42c-2998-4362-ade1-b7d75f75a851%2FUntitled.png&blockId=209ecc2e-d659-4a44-a519-675c16309d89">

* 중앙에 위치한 DispatcherServlet은 모든 연결을 담당한다.
* 웹 브라우저로부터 요청이 들어오면 DispatcherServlet은 그 요청을 처리하기 위한 컨트롤러 객체를 검색한다.
* 이때 DispatcherServlet은 컨트롤러를 직접 검색하지 않고 HandlerMapping 이라는 객체에 컨트롤러 검색을 
요청한다.
* HandlerMapping은 클라이언트의 요청 경로를 이용해서 이를 처리할 컨트롤러 빈 객체를 DispatcherServlet에 전달
한다.
* DispatcherServlet은 HandlerMapping이 찾아준 컨트롤러 객체를 처리할 수 있는 HandlerAdapter 빈에게
요청 처리를 위임한다.
* HandlerAdapter는 컨트롤러의 알맞은 메서드를 호출해서 요청을 처리하고 그 결과를 DispatcherServlet에
리턴한다.
* HandlerAdapter로부터 컨트롤러의 요청 처리 결과를 ModelAndView로 받으면 DispatcherServlet은 결과를
보여줄 뷰를 찾기 위해 ViewResolver 빈 객체를 사용한다.
* ModelAndView는 컨트롤러가 리턴한 뷰 이름을 담고 있는데 ViewResolver는 이 뷰 이름에 해당하는 View 객
체를 찾거나 생성해서 리턴한다.
* 응답을 생성하기 위해 JSP를 사용하는 ViewResolver는 매번 새로운 View 객체를 생성해서 DispatcherServlet에
리턴한다.
* DispatcherServlet은 ViewResolver가 리턴한 View 객체에게 응답 결과를 생성을 요청한다.
* View 객체는 웹 브라우저에 전송할 응답 결과를 생성하고 이로써 모든 과정이 끝이 난다.

### 1.1 컨트롤러와 핸들러

---
* 클라이언트의 요청을 실제로 처리하는 것은 컨트롤러이고 DispatcherServlet은 클라이언트의 요청을
전달받는 창구 역할을 한다.
* DispatcherServlet 입장에서는 클라이언트 요청을 처리하는 객체의 타입이 반드시 @Controller를 적용한
클래스 일 필요는 없다.
* MVC 웹 요청을 실제로 처리하는 객체를 핸들러(Handler)라고 표현하고 있으며 @Controller 적용 객체나
Controller 인터페이스를 구현한 객체는 모두 스프링 MVC 입장에서는 핸들러가 된다.
* 따라서 특정 요청 경로를 처리해주는 핸들러를 찾아주는 객체를 HandlerMapping 이라고 부른다.
* DispatcherServlet은 핸들러 객체의 실제 타입에 상관없이 실행 결과를 ModelAndView 라는 타입으로
만 받을 수 있으면 된다.
* 하지만 실제 핸들러의 구현타입에 따라 ModelAndView를 리턴하는 객체도 그러지 않은 객체도 있다.
* 이러한 처리결과를 ModelAndView로 변환해주는 객체가 HandlerAdapter 이다.
* 핸들러 객체의 실제 타입마다 그에 알맞은 HandlerMapping과 HandlerAdapter가 존재하기 때문에
사용할 핸들러의 종류에 따라 스프링 빈으로 등록해야 한다.

## 2 DispatcherServlet과 스프링 컨테이너

---
* DispatcherServlet은 전달받은 설정 파일을 이용해서 스프링 컨테이너를 생성한다.
* 이 컨테이너에는 HandlerMapping, HandlerAdapter, 컨트롤러, ViewResolver 등의 빈은 
DispatcherServlet이 사용하는 설정 파일에 이들 빈에 대한 정의가 포함되어 있어야 한다.

## 3 @Controller를 위한 HandlerMapping과 HandlerAdapter

---
* @Controller 적용 객체는 DispatcherServlet 입장에서 보면 한 종류의 핸들러
객체이다.
* DispatcherServlet은 브라우저의 요청을 처리할 핸들러 객체를 찾기 위해 
HandlerMapping을 사용하고 핸들러를 실행하기 위해 HandlerAdapter를 사용한다.
* RequestMappingHandlerMapping은 @Contlroller 애노테이션이 적용된 객체의
요청 매핑 애노테이션 값을 이용해서 웹 브라우저의 요청을 처리한 컨트롤러 빈을 찾는다.
* RequestMappingHandlerAdapter는 컨트롤러의 메서드를 알맞게 실행하고 그 결과를
ModelAndView 객체로 변환해서 DispatcherServlet에 리턴한다.

## 4 WebMvcConfigurer 인터페이스와 설정

---
* @EnableWebMvc 애노테이션을 사용하면 @Controller 애노테이션을 붙인 컨트롤러를 위한
설정을 생성한다.
* @EnableWebMvc 애노테이션을 사용하면 WebMvcConfigurer 타입의 빈을 이용해서 MVC 
설정을 추가로 생성한다.

## 5 디폴트 핸들러와 HandlerMapping의 우선순위

---
* 매핑경로가 '/'인 경우 .jsp로 끝나는 요청을 제외한 모든 요청을 DispatcherServlet이 처리한다.
* @EnableWebMvc 애노테이션이 등록하는 HandlerMapping은 @Controller 애노테이션
을 적용한 빈 객체가 처리할 수 있는 요청 경로만 대응할 수 있다.
* DefaultServletHttpRequestHandler는 클라이언트의 모든 요청을 WAS가 제공하는
디폴트 서블릿에 전달한다.
* 그리고 SimpleUrlHandlerMappin을 이용해서 모든 경로("/**")를 DefaultServletHttpRequestHandler
를 이용해서 처리하도록 설정한다
* @EnableWebMvc 애노테이션이 등록하는 RequestMappingHandlerMapping의 적용 우선순위가 
DefaultServletHandlerConfigurer#enable() 메서드가 등록하는 SimpleUrlHandlerMapping의 
우선순위보다 높다.
  1. RequestMappingHandlerMapping을 사용해서 요청을 처리한 핸들러를 검색한다.
     * 존재하면 해당 컨트롤러를 이용해서 요청을 처리한다.
  2. 존재하지 않으면 SimpleUrlHandlerMapping을 사용해서 요청을 처리할 핸들러를 검색한다.
     *  DefaultServletHandlerConfigurer#enable() 메서드가 등록한 SimpleUrlHandler
     Mapping은 "/**"경로에 대해 DefaultServletHttpRequestHandler를 리턴한다.
     * DispatcherServlet은 DefaultServletHttpRequestHandler에 처리를 요청한다.
     * DefaultServletHttpRequestHandler는 디폴트 서블릿에 처리를 위입한다.

## 6 정리

---
* DispatcherServlet은 웹 브라우저의 요청을 받기위한 창구 역할을 한다.
  * 다른 주요 구성 요소들을 이용해서 요청 흐름을 제어하는 역할을 한다.
* HandlerMapping은 클라이언트의 요청을 처리할 핸들러 객체를 찾아준다.
  * 핸들러 객체는 클라이언트의 요청을 실제로 처리한 뒤 뷰 정보와 모델을
  설정한다.
* HandlerAdapter는 DispatcherServlet과 핸들러 객체 사이의 변화를 알맞게
처리해 준다.
* ViewResolver는 요청 처리 결과를 생성할 View를 찾아준다
* View는 최종적으로 클라이언트에 응답을 생성해서 전달한다.