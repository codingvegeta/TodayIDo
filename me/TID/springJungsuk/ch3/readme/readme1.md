# Spring DI 활용하기

---
## 빈(Bean)이란?

---
* JavaBeans - 재사용 가능한 컴포넌트, 상태(iv), getter&setter, no-args constructor
* Servlet & JSP bean - MVC의 Model, EL, scope, JSP container가 관리
* EJB - 복잡한 규칙, EJB container가 관리 (빈 생성 -> 소멸)
* Spring Bean - POJO 단순, 독립적, Spring container가 관리
* Bean - Spring Container 가 관리하는 객체
* Spring container - Bean 저장소, Bean을 저장, 관리(생성, 소멸, 연결)
  * BeanFactory - Bean을 생성, 연결 등의 기본 기능을 정의
  * ApplicationContext - BeanFactory를 확장해서 여러 기능을 추가 정의

## IoC와 DI

---
* 제어의 역전 IoC - 제어의 흐름을 전통적인 방식과 다르게 뒤바꾸는 것
  * [전통적인 방식] 사용자 코드가 Framework 코드를 호출
  * [IoC] Framework 코드가 사용자 코드를 호출 - 전략패턴
* 의존성 주입 DI - 사용할 객체를 외부에서 주입받는 것

## 스프링 애너테이션

---
### @Autowired

---
* 인스턴스 변수(iv), setter, 참조형 매개변수를 가진 생성자, 메서드에 적용
* 넣어줄게 없으면 에러가 난다.
* 생성자의 @Autowired 생략 가능
  * 생성자가 여러 개 있을 경우는 생략 불가 생략시 자동 주입 X
* Spring container에서 타입으로 빈을 검색해서 참조변수에 자동 주입(DI)   
검색된 빈이 n개이면, 그 중에 참조변수와 이름이 일치하는 것을 주입
* 주입 대상이 변수일 때, 검색된 빈이 1개 아니면 예외 발생   
주입 대상이 배열일 때, 검색된 빈이 n개라도 예외 발생x
* @Autowired(required=false)일 때, 주입할 빈을 못찾아도 예외 발생x.
* 같은 타입이 여러개일 때 @Qualifier로 이름을 정해 줄 수 있다.

### @Resource

---
* Spring container에서 이름으로 빈을 검색해서 참조 변수에 자동 주입(DI)   
일치하는 이름의 빈이 없으면, 예외 발생
* 이름 생략하면 참조변수의 이름이 빈의 이름이 된다.

### @Component

---
* <component-scan>로 @Component가 클래스를 자동 검색해서 빈으로 등록
* @Component 애노테이션을 작성하고 이름을 생략하면 클래스 이름의 첫글자를 소문자로 바꿔서
빈으로 등록한다.
* @Controller, @Service, @Repository, @ControllerAdvice의 메타 애너테이션


