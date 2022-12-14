# JSON 응답과 요청 처리

---

## JSON 개요

---
* JSON은 간단한 형식을 갖는 문자열로 데이터 교환에 주로 사용한다.
* JSON 규칙은 중괄호를 사용해서 객체를 표현한다.
* 객체는 (이름, 값) 쌍을 갖는다.
* 이름과 값은 콜론(:)으로 구분한다.
* 값에 올수 있는것들은 다음과 같다.
  * 문자열, 숫자, 불리언, null
  * 배열
  * 다른 객체
* 문자열은 큰따옴표나 작은따옴표 사이에 위치한 값이다.
* 문자열은 \\"(큰따옴표), \n(뉴라인), \r(캐리지 리턴), \t(탭)과 같이 역슬래시를
이용해서 특수 문자를 표시할 수 있다.
* 숫자는 10진수 표기법이나 지구표기법을 따른다.
* 불리언 타입 값은 true와 false가 있다.
* 배열은 대괄호로 표현한다.
  * 개돨호 안에 콤마로 구분한 값 목록을 갖는다.

## Jackson 의존 설정

--- 
* Jackson은 자바 객체와 JSON 형식 문자열 간 변환을 처리하는 라이브러리이다.
* 스프링 MVC에서 Jackson 라이브러리를 이용해서 자바 객체를 JSON으로 변환하려면 클래스
패스에 Jackson 라이브러리를 추가하면 된다.
* Jackson은 프로퍼티의 이름과 값을 JSON 객체의 (이름, 값)쌍으로 사용한다.
* 프로퍼티 타입이 배열이나 List인 경우 JSON 배열로 변환된다.

## @RestController로 JSON 형식 응답

---
* 스프링 MVC에서 JSON 형식으로 데이터를 응답하는 것은 매우 간단하다.
* @Controller 애노테이션 대신 @RestController 애노테이션을 사용하면 된다.

### @JsonIgnore를 이용한 제외 처리

---
* Jackson이 제공하는 @JsonIgnore 애노테이션을 사용하면 민감한 데이터는 응답결과에서 제외시킬 수 있다.
* JSON 응답에 포함시키지 않을 대상에 @JsonIgnore 애토테이션을 붙인다.

### 날짜 형식 변화 처리: @JsonFormat 사용

---
* @JsonFormat 애노테이션의 pattern 속성을 사용하면 원하는 형식으로 변환해서 출력할 수 있다.

### 날짜 형식 변화 처리: 기본 적용 설정

---
* @JsonFormat 애노테이션을 모든 대상에 붙여야 한다면 상당히 힘들다.
* Jackson의 변환 규칙을 모든 날짜 타입에 적용하려면 스프링MVC 설정을 변경해야 한다.
* 스프링 MVC는 자바 객체를 HTTP 응답으로 변환할 때 HttpMessageConverter라는 것을 사용한다.
* 모든 Date 타입의 값을 원하는 형식으로 출력하도록 설정하고 싶다면 Jackson2ObjectMapperBuilder
메서드를 이용해서 패턴을 지정한다.

### 응답 데이터의 컨텐츠 형식

---
* 크롬 브라우저에서 개발자도구를 실행하고 JSON 응답을 제공하는 API를 호출하면 응답헤더의 Content-Type이
application/json인 것을 알 수 있다.

## @RequestBody로 JSON 요청 처리

---
* JSON 형식의 요청 데이터를 자바 객체로 변환하는 기능이다.
* POST 방식이나 PUT 방식을 사용하면 쿼리 문자열 형식이 아니라 JSON 형식의 데이터를 요청 데이터로
전송할 수 있다.
* JSON 형식으로 전송된 요청 데이터를 커맨드 객체로 전달받는 방법은 커맨드 객체에 @RequestBody 애노테이션
을 붙이기만 하면 된다.

## ResponseEntity로 객체 리턴하고 응답 코드 지정하기

---

### ResponseEntity를 이용한 응답 데이터 처리

---
* 요청이 정상인 경우와 비정상인 경우 모두 JSON으로 응답을 전송하는 방법은 ResponseEntity를 사용하는 것이다.
* 스프링 MVC는 리턴 타입이 ResponseEntity이면 ResponseEntity의 body로 지정한 객체를 사용해서
변환을 처리한다.
* ResponseEntity를 생성하는 기본 방법은 status와 body를 이용해서 상태 코드와 JSON으로 변환할 객체를
지정하는 것이다.(ResponseEntity.status(HttpStatus.상태).body(객체))
* 몸체 내용이 없는 경우 body를 지정하지 않고 build()로 바로 생성한다.
* status() 메서드 대신에 다음과 같이 관련 메서드를 사용해도 된다.
  * noContent() : 204
  * badRequest() : 400
  * notFound() : 404

### @ExceptionHandler 적용 메서드에서 ResponseEntity로 응답하기

---
<img src="image/ErrorHandler.PNG">

* 특정 오류를 핸들링해준다.