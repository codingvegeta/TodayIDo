# 클라이언트와의 대화

-----

## 1.쿠키 사용하기

----

쿠키는 웹 브라우저가 보관하는 데이터이다.   
웹 브라우저는 웹 서버에 요청을 보낼 때 쿠키를 함께 전송하며 웹 서버는 웹 브라우저가 전송한 쿠키를 사용해서 필요한 데이터를 읽을 수 있다.

쿠키의 동작 방식
* 쿠키 생성 단계 : JSP 프로그래밍에서 쿠키는 웹 서버 측에서 생성한다.   
생성한 쿠키를 응답데이터의 헤더에 저장해서 웹브라우저에 전송한다.
* 쿠키 저장 단계 : 웹 브라우저는 응답 데이터에 포함된 쿠키를 쿠키 저장소에 보관한다.
* 쿠키 전송 단계 : 웹 브라우저는 저장한 쿠키를 요청이 있을 때 마다 웹 서버에 전송한다.

-웹 브라우저는 쿠키가 삭제되기 전까지 웹 서버에 쿠키를 전송한다.
웹 어플리케이션을 사용하는 동안 지속적으로 유지해야 하는 정보는 쿠키에 저장한다.

### 1.1 쿠키의 구성

----
1. 이름 : 쿠키를 구별하는데 사용되는 이름   
2. 값 : 쿠키의 이름과 관련된 값   
3. 유효시간 : 쿠키의 유지 시간
4. 도메인 : 쿠키를 전송할 도메인
5. 경로 : 쿠키를 전송할 요청 경로

* 쿠키의 핵심요소는 이름과 값이다.
* 하나의 웹 브라우저는 여러개의 쿠키를 가질 수 있다.
* 유효시간을 사용하면 브라우저가 쿠키를 보관할 시간을 정할 수 있다.
  * 설정한 시간이 지나면 웹 브라우저는 쿠키를 삭제한다.
* 도메인이나 경로를 지정 할 수 있다.\

### 1.2 쿠키의 생성 

---
* JSP 에서는 쿠키를 생성할 때에는 Cookie 클래스를 사용한다.
``` 
<%   
  Cookie cookie = new Cookie("cookieName", "cookieValue");
  response.addCookie(cookie);
%> 
```
* 첫번째 줄은 쿠키를 담고 있는 Cookie 객체를 생성한다.(쿠키이름 , 쿠키의 값);
* 생성할 쿠키 정보를 담고 있는 Cookie 객체를 생성했다면 response 기본 객체의 addCookie()
메서드를 사용하여 쿠키를 추가하면 된다.

### 1.3 쿠키 값 읽어오기

---
* 쿠키를 생성하면 이후부터는 해당 쿠키를 사용할 수 있다.
웹 브라우저는 요청헤더에 쿠키를 저장해서 보낸다.
```
Cookie[] cookies = request.getCookies();
```
* request.getCookie() 메서드는 Cookie 배열을 리턴한다.
* 이 메서드는 읽어올 쿠키가 존재하지 않으면 null을 리턴한다.

### 1.4 쿠키 값 변경 및 삭제하기

---
* 쿠키의 값을 변경하려면 같은 이름의 쿠키를 새로 생성해서 응답데이터로 보내면 된다.
* 쿠키의 값을 변경한다는 것은 기존에 존재하는 쿠키의 값을 변경한다는 것이다.
* 쿠키 값을 변경하려면 기존에 쿠키가 존재여부를 확인 해 주어야 한다.
* 쿠키를 삭제하려면 setMaxAge(); 메서드를 호출할 때 인자값으로 0을 주면 된다
* 쿠키는 별도의 삭제기능이 존재하지 않는다.

### 1.5 쿠키의 도메인

---
* 쿠키는 쿠키를 생성한 서버에만 전송된다.
  - www.google.com 에 생성된 쿠키는 다른 사이트로 연결 할 때에는 전송되지 않는다.
* 다른 도메인에 쿠키를 보내야 할 때는 setDomain() 메서드를 사용한다.
  * .somehost.com : 점으로 시작하는 경우 관련 도메인에 모두 쿠키를 전송한다.   
   ex) mail.somehost.com , www.somehost.com , javacan.somehost.com 에 모든 쿠키를 전송한다.
  * www.somegost.com : 특정 도메인에 대해서만 쿠키를 전송한다.
* 도메인을 지정할 때 주의해야 할 점은 setDomain()의 값으로 현재 서버의 도메인 및 상위 도메인만 지정 할 수있다.
  * ex) mail.somehost.com 에서 setDomain() 메서드에 줄 수 있는 값은 "mail.somehost.com" 이나   
  ".somehost.com" 이다. "www.somehost.com"과 같은 다른 주소를 값으로 주는 경우 쿠키는 생성되지 않는다.
* 쿠키 도메인이 쿠키를 생성한 서버의 도메인을 벗어나면 웹 브라우저는 쿠키를 저장하지 않는다.

### 1.6 쿠키의 경로

---
* 도메인이 쿠키를 공유할 도메인 범위를 지정한다면 경로는 쿠키를 공유할 기준 경로를 지정한다.
* 쿠키의 경로를 지정할 때에는 Cookie 클래스의 setPath() 메서드를 사용한다.
* http://localhost:8080/chap09/path2/viewCookies.jsp
* 이 URL에서 경로는 서버 주소 이후 부분인 **/chap09/path2/viewCookies.jsp** 이다
* setPath() 메서드를 사용하여 쿠키의 경로를 지정하면 웹 브라우저는 지정한 경로 또는 하위경로에 대해서만
 쿠키를 전송한다.
* 일반적으로 쿠키는 웹 어플리케이션에 포함된 다수의 JSP와 서블릿에서 사용하기 때문에, 쿠키 경로를 "/"로 지정한다.

### 1.7 쿠키의 유효시간

---
* 쿠키는 유효시간을 지정하지 않으면 웹 브라우저를 종료할 때 쿠키를 함께 삭제시킨다.
  * 웹 브라우저 종료 후 다시 웹 브라우저를 실행시키면 삭제한 쿠키는 서버에 전송되지 않는다.
  * 유효시간을 정해놓으면 웹 브라우저를 종료해도 유효시간이 지나지 않으면 삭제하지 않는다.
* 쿠키의 유효시간을 지정할 땐 setMaxAge()메서드를 사용한다.
  * setMaxAge()는 초 단위로 유효시간을 지정한다.
  * 


