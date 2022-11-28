# Rest API 와 Ajax

---
### JSON

---
  * Java Script Object Notation : 자바 스크립트 객체 표기법
  * XML이 너무 복잡하고 Data보다 태그가 많아서 대체를 위해 사용
  * {속성명1:속성값1, 속성명2:속성값2,...} - 기본형식
  * [{속성명:속성값,...},{속성명:속성값,...},...] - 배열형식
  * {키1:{속성명:속성값,...},{키2:{속성명:속성값,...} - Map 형식
* stringify()와 parse()
  * JS객체를 서버로 전송하려면, 직렬화(문자열로 변환)가 필요하다.
  * stringify() - 객체를 JSON 문자열로 변환
  * parse() - JSON 문자열을 객체로 변환

### Ajax

---
* Asynchronous javascript and XML - 요즘은 JSON을 주로 사용
* 비동기 통신으로 데이터를 주고 받기 위한 기술
* 웹페이지(data+UI) 전체 가 아닌 일부만 업데이트 가능
* 비동기?
  * 요청을 처리하는동안 다른일을 할 수 있음
  * 처리가 끝난걸 알려주기 위해 콜백(callback)함수를 사용

### Ajax요청과 응답 과정

---
* 메서드에서 반환으로 객체를 반환한다.
* ResponseBody -> 몸통에 담아서 주고 받는다.
* jackson-databind 가 각 언어에 맞게 변환해준다.

### @RestController

---
* @ResponseBody 대신, 클래스에 @RestController 사용 가능
* 메서드 마다 @ResponseBody 를 붙이면 메서드마다 붙이기 힘듦

### REST란?

---
* 웹 서비스 디자인 아키텍쳐 접근방식
* 프로토콜에 독립적이며, 주로 HTTP를 사용해서 구현
* 리소스 중심의 API디자인 - HTTP메서드로 수행할 작업을 정의
* REST 규약을 준수하는 API
* 