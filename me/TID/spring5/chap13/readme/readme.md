# 세션 인터셉터 쿠키

---
## 컨트롤러에서 HttpSession 사용하기

---
* 로그인 상태를 유지하는 방법은 HttpSession을 이용하는 방법과
쿠키를 이용하는 방법이 있다.
* 컨트롤러에서 HttpSession을 사용하려면 두가지 방법 중 한가지를 사용하면 된다.
  * 요청 매핑 애노테이션 적용 메서드에 HttpSession 파라미터를 추가한다
  * 요청 매핑 애노테이션 적용 메서드에 HttpServletRequest 파라미터를 추가하고
  HttpServletRequest를 이용해서 HttpSession을 구한다.
* 요청 매핑 애노테이션 적용 메서드에 HttpSession 파라미터가 존재할 경우 스프링 MVC는
컨트롤러의 메서드를 호출할 때 HttpSession 객체를 파라미터로 전달한다.
* HttpSession을 생성하기 전이면 새로운 HttpSession을 생성하고 그렇지 않으면 기존에
존재하는 HttpSession을 전달한다.
* 두번째 방법은 getSession()을 사용하는 것이다.
* 첫번째 방법은 항상 HttpSession을 생성하지만 두번째 방법은 필요한 시점에만 HttpSession
을 생성할 수 있다.

## 인터셉터 사용하기

---
* 다수의 컨트롤러에 대해 동일한 기능을 적용해야 할 때 사용할 수 있는 것이
HandlerInterCeptor이다.
* HandlerInterCeptor 인터페이스를 사용하면 다음의 세 시점에 공통 기능을 넣을 수 있다
  * 컨트롤러(핸들러) 실행 전
    * boolean preHandle()throws Exception
    * 메서드가 false를 리턴하면 컨트롤러를 실행하지 않는다.
  * 컨트롤러(핸들러) 실행 후, 뷰를 실행하기 전
    * void postHandle()throws Exception
    * 핸들러가 정상적으로 실행된 이후에 추가 기능을 구현 할 때 사용한다.
  * 뷰를 실행한 이후
    * void afterCompletion()throws Exception
    * 뷰가 클라이언트에 응답을 전송한 뒤에 실행된다.
    * 컨트롤러 실행 과정에서 익셉션이 발생하면 메서드의 네번째 파라미터로 전달된다.

## 컨트롤러에서 쿠키 사용하기

---
* @CookieValue 애노테이션의 value 속성은 쿠키의 이름을 지정한다.
* 지정한 이름을 가진 쿠키가 존재하지 않을 수도 있다면 required 속성값을 false로 지정하자

## 변환 처리에 대한 이해

---
* 스프링 MVC는 요청 매핑 애노테이션 적용 메서드와 DispatcherServlet 사이를 연결하기 위해
RequestMappingHandlerAdapter 객체를 사용한다.
* 이 핸들러 어댑터 객체는 요청 파라미터와 커맨드 객체 사이의 변환 처리를 위해 WebDataBinder를 이용한다.
* WebDataBinder는 커맨드 객체를 생성하고 커맨드 객체의 프로퍼티와 같은 이름을 갖는 요청 파라미터를
이용해서 프로퍼티 값을 생성한다.

## @PathVariable을 이용한 경로 변수 처리

---
* @PathVariable 애노테이션을 사용하면 가변경로를 처리할 수 있다.
* 매번 다른 웹 사이트 주소를 사용할 수 있다.