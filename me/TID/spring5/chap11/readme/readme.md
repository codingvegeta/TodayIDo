# MVC2 : 메시지, 커맨드 객체 검증

---

## \<spring:message> 태그로 출력하기

---
* 하드 코딩하면 동일 문자열 변경시 모든 파일에서 찾아 변경해 줘야하고, 다국어 지원시 각 언어에
맞게 뷰 코드를 따로 만들어야 한다.
* 스프링은 약간의 수고를 들이면 각각의 언어별로 알맞은 문자열을 출력하도록 JSP 코드를 구현할
수 있다.
  * 문자열을 담은 메시지 파일을 작성한다.
  * 메시지 파일에서 값을 읽어오는 MessageSource 빈을 설정한다.
  * JSP 코드에서 \<spring:message> 태그를 사용해서 메시지를 출력한다.
  * \<spring:message> 태그의 code에 해당하는 메시지가 존재하지 않으면 익셉션이 발생

## 커맨드 객체의 값 검증과 에러 메시지 처리

---
* 폼 값 검증과 에머 메시지 처리는 어플리케이션을 개발할 때 놓쳐서는 안된다.
* 폼에 입력한 값을 검증하지 않으면 잘못된 값이 시스템에 입력되어 어플리케이션이 비정상 동작할 수 있다.
* 에러 메시지를 제대로 보여주지 않으면 사용자는 서비스를 제대로 이용할 수 없게 된다.
* 스프링이 제공하는 두가지 방법
  * 커맨드 객체를 검증하고 결과를 에러 코드로 저장
  * JSP에서 에러 코드로부터 메시지 출력

### 커맨드 객체 검증과 에러 코드 지정하기

---
* 스프링 MVC에서 커맨드 객체의 값이 올바른지 검사하려면 다음의 두 인터페이스를 사용한다.
  * org.springframework.validation.Validator
  * org.springframework.validation.Errors
* 요청 매핑 애노테이션을 붙인 메서드에 Errors 타입의 파라미터를 추가할 때 주의할 점
은 Errors 타입 파라미터는 반드시 커맨드 객체를 위한 파라미터 다음에 위치해야 한다.
* 커맨드 객체 앞에 위치하면 요청 처리를 올바르게 하지 않고 익셉션이 발생하게 된다.

## 글로벌 범위 Validator와 컨트롤러 범위 Validator

---
* 스프링 MVC는 모든 컨트롤러에 적용할 수 있는 글로벌 Validator와 단일 컨트롤러에 적용할 수 있는
Validator를 설정하는 방법을 제공한다.
* 글로벌 범위 Validator는 모든 컨트롤러에 적용할 수 있는 Validator이다.
  * 설정 클래스에서 WebMvcConfigurer의 getValidator() 메서드가 Validator 구현 객체를 
  리턴하도록 구현
  * 글로벌 범위 Validator가 검증할 커맨드 객체에 @Valid 애노테이션 적용
* 스프링 MVC는 WebMvcConfigurer 인터페이스의 getValidator() 메서드가 리턴한 객체를
글로벌 범위 Validator로 사용한다.
* 글로벌 범위 Validator를 지정하면 @Valid 애노테이션을 사용해서 Validator를 적용할 수 있다.
* @Valid 애노테이션을 붙이면 글로벌 범위 Validator가 해당 타입을 검증할 수 있는지 확인한다.
* 메서드를 실행하기 전에 @Valid 애노테이션이 붙은 파라미터를 글로벌 범위 Validator로 검증한다.
  * @Valid 애노테이션을 사용할 때 주의할 점은 Errors 타입 파라미터가 없으면 검증 실패시
  400 에러를 응답한다.
* @InitBinder는 컨트롤러 범위 Validator이다.
* @InitBinder가 붙은 메서드는 컨트롤러의 요청 처리 메서드를 실행하기 전에 매번 실행된다.

## Bean Validation을 이용한 값 검증 처리

---
* @Valid 애노테이션은 Bean Validation 스펙에 정의되어 있다.
* 이 스펙은 @Valid 애노테이션뿐만 아니라 @NotNUll, @Digit, @Size 등의 애노테이션을 정의하고 있다.
* 이 애노테이션을 사용하면 Validator 작성 없이 애노테이션만으로 커맨드 객체의 값 검증을 처리할 수 있다.
* Bean Validation을 이용해서 커맨드 객체의 값을 검증하는 방법
  * Bean Validation과 관련된 의존을 설정에 추가한다.
  * 커맨드 객체에 @NotNull, @Digit 등의 애노테이션을 이용해서 검증 규칙을 설정한다.