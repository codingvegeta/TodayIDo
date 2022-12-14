# 원격 프로그램의 실행

---
## 원격 프로그램 실행

---
* 브라우저와 WAS가 있어야 원격 프로그램 실행 가능
* 프로그램 등록
  * 외부에서 어떤 프로그램을 사용할지 등록
  * @Controller 애노테이션을 사용
* URL과 프로그램을 연결
  * RequestMapping을 사용 메서드와 연결
* URL로 원격 프로그램을 호출하면 톰캣이 객체를 생성해주고 메서드를 실행 시킨다.
* 왜 인스턴스 메서드로 하는가?
  * 변수 사용
* 접근 제한자가 private여도 사용이 가능한가?
  * RequestMapping은 접근 제어자 상관 없이 호출 가능하다.
  * 내부에서는 private 으로 다른 객체가 접근 할 수 없다.
  * Reflection API 를 사용해서 정보를 얻어서 다룰 수 있기 때문에 가능하다.

## HTTP 요청과 응답

---
* URL로 요청이 오면 Tomcat이 HttpServletRequest객체를 만들어서 요청 정보를 담는아서
메서드에 넘겨준다
* 쿼리스트링 = 값을 전달할 때 사용 URL은 문자열이다.
* 쿼리스트링 값은 name = value 형태로 존재한다.
* 동적 리소스
  * 사용자의 요청에 따라 매번 바뀌는 리소스
* 정적 리소스
  * 사용자의 요청에도 변하지 않는 리소스
* 프로토콜이란? HTTP
  * 서로간의 통신을 위한 약속, 규칙
  * 주고 받을 데이터에 대한 형식을 정의한 것
  * 단순하고 읽기 쉽다. - 텍스트 기반의 프로토콜
  * 상태를 정보를 유지하지 않는다.
    * stateless
  * 확장 가능하다. - 커스텀 헤더 추가 가능
* GET
  * 서버의 리소스를 가져오기 위해 설계
  * QUERY STRING을 통해 데이터를 전달
  * URL에 데이터 노출되므로 보안에 취약
  * 데이터 공유에 유리
* POST
  * 서버에 데이터를 올리기 위해 설계됨
  * 전송 데이터 크기의 제한이 없음(대용량)
  * 데이터를 요청 메시지의 body에 담아 전송
  * 보안에 유리, 데이터 공유에는 불리

### 텍스트 파일 vs, 바이너리 파일

---
* 바이너리 파일 : 문자와 숫자가 저장되어 있는 파일
  * 데이터를 있는 그대로 읽고 쓴다.
* 텍스트 파일 : 문자만 있는 저장되어 있는 파일
  * 숫자를 문자로 변환 후 쓴다.

### MIME


---
* 텍스트 기반 프로토콜에 바이너리 데이터 전송하기 위해 고안된 HTTP의 COntent-Type
* 헤더에 사용. 데이터의 타입을 명시

### 클라이언트와 서버

---
* 클라이언트 
  * 서비스를 요청하는 애플리케이션
* 서버
  * 서비스를 제공하는 애플리케이션
* WAS
  * 웹 애플리케이션 서버 : 웹 애플리케이션을 서비스하는 서버

## 관심사의 분리, MVC 패턴 - 이론

---
### 관심사의 분리

---
* 단일 책임 원칙
  * 하나의 메서드는 하나의 책임만 진다.

### 공통 코드의 분리 

---
* request로 매개변수를 받아와서 들어온걸 getParameter로 꺼내 쓴다.
* 클라이언트의 요청 타입을 매개변수로 받을 때 자동 형변환도 해준다.(변경 가능할 경우)
* Model을 매개변수로 설정하면 DispatcherServlet 이 생성해서 넣어준다.
* 컨트롤러에서 직접 만드려면 ModelAndView를 사용한다(잘 안씀)
* 반환타입이 String인 경유 뷰 이름 반환 한다.
* 반환타입이 void인 경우 매핑된 URL 끝단어가 뷰 이름으로 지정된다.
* 반환타입이 ModelAndView인 경우 Model과 뷰 이름을 반환한다.

## 서블릿과 JSP

---
### 서블릿의 생명 주기

---
* Servlet은 HttpServlet을 상속 받아야 한다.
* init() 서블릿이 초기화될 때 자동 호출되는 메서드
  * 서블릿의 초기화 작업 담당
* service() 실제로 작업을 처리하는 메서드
  * 입력 -> 처리 -> 출력
* destroy() 서블릿이 메모리에서 제거 될 때
  * 서블릿 컨테이너에 의해서 제거된다.
* 요청 -> 서블릿인스턴스 존재? 
* no -> 서블릿 클래스 로딩 & 인스턴스 생성 -> init() -> service() 
* yes-> service() 
* 서블릿은 싱글톤이다. 1개의 인스턴스로 재활용 한다.

### JSP와 서블릿 비교

---
* JSP란? HTML 안에 자바 코드가 있는 파일.
* 확장자가 *.jsp인 경우 jspServlet이 받는다.
* JSP파일이 변경되면 다시 변환하고 컴파일 후 객체로 만드는 과정을 실행한다.
* 처음부터 객체를 만들어 두는게 아닌 요청이 들어왔을 때 만든다.
* 서블릿 = lazy-init 지연된 초기화
* 스프링 = early-init 미리 초기화
* JSP는 생성없이 사용할 수 있는 기본 객체가 있다.
  * service()의 지역번수 request, response, session, application, config, out, page 등등
* 4개 저장소가 있다.
  * pageContext
    * 유효 범위 : 1개 JSP 페이지
    * 설명 : JSP 페이지의 시작부터 끝까지. 해당 JSP 내부에서만 접근가능. 페이지당 1개
  * application
    * 유효 범위 : context 전체
    * 설명 : WevApplication의 시작부터 종료까지. context내부 어디에서나 접근 가능
    모든 클라이언트가 공유. context마다 1개
  * session
    * 유효 범위 : n개 JSP 페이지
    * 설명 : session의 시작부터 종료까지(로그인~로그아웃). 클라이언트마다 1개
  * request
    * 유효 범위 : 1+개 JSP 페이지
    * 설명 : 요청의 시작부터 응답까지. 다른 JSP로 전달 가능. 요청마다 1개
* 속성 관련 메서드
  * void setAttribute(String name, Object value) : 지정된 값(value)을 지정된 
  속성 이름(name)으로 저장
  * Object getAttribute(String name) : 지정된 이름(name)으로 저장된 속성의 값 반환

### JSTL

---
* JSP 표준 태그 라이브러리
* 복잡한 자바 코드 + HTML 을 줄이기 위해 사용한다.

### 필터

---
* 서블릿이 시작하기 전에 전처리 후처리가 중복되는 코드를 사용할경우 중복 코드를 분리한다.
* 요청 -> 전처리(필터) -> 서블릿 호출 -> 후처리(필터)
* 필터는 여러개를 사용할 수 있다.
  * 여러개 있는경우 필터는 다음 필터를 호출한다.
  * 후처리 필터의 경우 이전 필터를 호출한다.(역순임)


## @RequestParam과 @ModelAttribute

---
### @RequestParam

---
* 요청의 파라미터를 연결할 매개변수에 붙이는 애너테이션
* required true일 경우 필수 입력 해야하는 값, false일 경우 필수가 아님
* true일 경우 값이 없거나 잘못된 값을 주면 400번대 에러가 나온다 (무조건 클라이언트 잘못)
* false일 때도 잘못된 값을 주거나 주지 않을경우 500번대에러 400번대 에러 나올 수 있음
* 필수 입력이 아닐경우 default 값을 주는것도 좋은 방법이다.
* 파라미터를 객체로 받아올 수 있다.

### @ModelAttribute

---
* 적용대상을 Model의 속성으로 자동 추가해주는 애너테이션
* 반환타입 또는 컨트롤러 메서드의 매개변수에 적용 가능
  * 반환타입 키가 반환타입 값이 리턴값이 된다.
* 키 값을 적어주지 않으면 타입의 첫글자를 소문자로 한 글자를 사용한다.
* 컨트롤러 매개변수 RequestParam ModelAttribute
* 타입이 참조형일 경우 ModelAttribute가 생략되어있다.
  * 기본형이나 String일 때는 모델이 아니다.
* 기본형일 경우 RequestParam이 생략되어 있다.

### @GetMapping @PostMapping

---
* @RequestMapping 대신 사용 가능
* URL이 같아도 요청이 다르면 (POST,GET) 충돌이 나지 않는다.
* 공통 부분을 클래스에서 합칠 수 있다. @RequestMapping(~~)
* 위 애노테이션이 붙으면 다른 방식으로 접근했을 시 에러 화면이 나온다.
  * 매핑 우선순위
    1. 정확하게 일치
    2. 경로 맵핑
    3. 확장자 맵핑
    4. 3가지 전부 맵핑이 안될경우 404NOT FOUND

## redirect와 forward

---
### redirect와 forward의 처리 과정 비교

---
#### redirect
* 클라이언트의 요청을 웹 서버가 자동으로 다른곳으로 보냄
* request객체가 새로 생성됨
* 요청이 2번
* 헤드에 200번대 로 나오고 URL이 변경된다.
#### forward
* request객체를 그대로 다른 페이지로 보내준다.
* 요청이 1번
* URL이 변경되지 않는다.
* 문자열이 forward로 시작할 경우 InternalResourceView가 처리한다.

## 쿠키란?

---
### 쿠키란?

---
* 이름과 값의 쌍으로 구성된 작은 정보
* 유효기간을 가지고 있다.
* 서버에서 생성 후 브라우저에 저장. 유효기간 이후 자동 삭제
* 서버에 요청시 domain, path가 일치(하위경로 포함)하는 경우에만 자동 전송
* 클라이언트 식별 기술

### 쿠키 생성 과 삭제

---
* 쿠키 생성 : 쿠키 유효기간 설정 -> 쿠키 추가 responser.addCookie(쿠키)
* 쿠키 삭제 : 변경할 쿠키와 같은 이름 쿠키 생성 -> 유효기간을 0으로 설정 -> 응답에 쿠키 추가
* 쿠키 변경 : 변경할 쿠키와 같은 이름 쿠키 생성 -> 값의 변경 -> 도메인의 변경 -> 경로 변경 -> 유효기간 추가
-> 응답에 쿠키 추가
* 쿠키 읽어오기 : Cokkie[] cookie = request.getCookies();
  * 쿠키가 없는경우 null이다.

## 세션 이론

---
### 세션이란?

---
* 동일한 브라우저에서 매번 독립적으로 요청을 보내지 않고 같은 세션아이디를 이용해서 요청과 응답을 묶을 수 있는 기능
* 서로 관련된 요청들을 하나로 묶은 것 - 쿠키를 이용
* 브라우저마다 개별 저장소(session객체)를 서버에서 제공
* 브라우저와 세션은 1 : 1 이다.
* 브라우저가 요청을 보내면 응답 쿠키에 세션 아이디를 적어서 준다.
* 세션 -> 수동 종료와 자동종료가 존재한다.
* 세션 실행 이전의 페이지가 false 일 경우 세션을 만들지 않아 서버에 부담이 적다(세션이 실행 되기 전)
* 세션이 시작 이후 -> session=false 기존 연결된 세션이 끊어지는 것이 아니다.

## 예외 처리

---
### @ExceptionHandler와 @ControllerAdvice

---
* @ExceptionHandler 예외 처리를 위한 메서드를 작성하고 @ExceptionHandler를 붙인다.
* 여러 종류의 예외를 처리하는 메서드면 배열 타입으로 설정할 수 있다.
* @ControllerAdvice 전역 예외 처리 클래스 작성 가능(패키지 지정 가능)
* 예외처리 메서드가 중복인 경우, 컨트롤러 내의 예외 처리 메서드가 우선

### @ResponseStatus

---
* 응답 메세지의 상태 코드를 변경할 때 사용
* 예외 처리 메서드 앞에 붙임 @ExceptionHandler 로 에러코드를 뷰로 보내면 요청이 200번으로 나온다
  (예외처리(요청처리)가 잘 되었다는 뜻) 이 때 에러코드 변경 가능
* 사용자 정의 예외 클래스 앞에 작성한다. 
* 브라우저가 -> DispatcherServlet -> Controller
  * handlerExceptionResolvers
    1. ExceptionHandlerExceptionResolver
    2. ResponseStatusExceptionResolver
    3. DefaultHandlerExceptionResolver
  * 컨트롤러 메서드 내에서 try-catch로 처리
  * 컨트롤러에 @ExceptionHandler 메서드가 처리
  * @ControllerAdvice 클래스의 @ExceptionHandler 메서드가 처리
  * 예외 종류별로 뷰 지정 - SimpleMappingExceptionResolver
  * 응답 상태 코드별로 뷰 지정 -  <error-page>

## 데이터의 변환과 검증

----
### WebDataBinder

---
* 타입 변환
  * 커스텀 PropertyEditor
  * ConversionService
  * DefaultPropertyEditor
* 데이터 검증
### PropertyEditor

---
* 양방향 타입 변화 (String -> 타입, 타입 -> String) 특정 타입이나 이름의 필드에 적용 가능
* 디폴트 PropertyEditor - 스프링이 기본적으로 제공
* 커스텀 PropertyEditor - 사용자가 직접 구현. PropertyEditorSupport를 상속하면 편리
* 모든 컨트롤러 내에서의 변환 - WebBindingInitializer를 구현 후 등록
* 특정 컨트롤러 내에서의 변환 - 컨트롤러에 @InitBinder가 붙은 메서드를 작성
* Converter - 단방향 타입 변환 (타입 A -> 타입 B) PropertyEditorㅡ이 단점을 개선 (stateful -> stateless)
* Formatter - 양뱡향 타입 변환(String -> 타입, 타입 -> String) 바인딩할 필드에 적용 - @
NumberFormat, @DateTimeFormat

### Validator?

---
* 객체를 검증하기 위한 인터페이스. 객체 검증기(validator)구현에 사용
* 수동 검증과 자동 검증이 있다.
  * 수동검증 valdiator를 직접 생성하고 validate()를 직접 호출
  * 수동 검증에는 supports 와 validate 두가지 메서드가 있다.
  * supports 가 검증이 가능한 객체인지 판별 한 후 validate에서 검증한다.

