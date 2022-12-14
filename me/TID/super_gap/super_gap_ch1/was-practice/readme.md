## HTTP

* 서버와 클라이언트가 웹에서 데이터를 주고받기 위한 프로토콜(규약)
* 참고
* 1.1 2는 TCP 기반 위에서 동작
* 3 는 UDP 기반 위에서 동작

## HTTP 특징

* 클라이언트 - 서버 모델
* 무상태 프로토콜 (stateless)
* 서버가 클라이언트 상태를 유지하지 않음
* 해결책 : Keep-Alive 속성 사용
* 비 연결성
* 서버가 클라이언트 요청에 대해 응답을 마치면 맺었던 연결을 끊어 버림
* 해결책 : 쿠키(클라이언트에 정보 저장), 세션(서버에 정보 저장),JWT

## CGI 프로그램과 서블릿

* CGI(Common Gateway Interface)
* 웹 서버와 애플리케이션 사이에 데이터를 주고받는 규약
* CGI 규칙에 따라서 만들어진 프로그램을 CGI 프로그램이라고 함
* CGI 프로그램 종류로는 컴파일 방식과 인터프리터방식이 있다.

## ServletContainer

* 서블릿의 생성부터 소멸까지의 라이프사이클을 관리하는 역할
* 서블릿 컨테이너는 웹 서버와 소켓을 만들고 통신하는 과정을 대신 처리해준다.
    * 개발자는 비즈니스 로직에만 집중하면 된다.
* 서블릿 객체를 싱글톤으로 관리 (인스턴스 하나만 생성하여 공유하는 방식)
    * 상태를 유지(stateful)하게 설계하면 안됨
    * Thread safety 하지 않음

## WAS vs 서블릿 컨테이너

* WAS는 서블릿 컨테이너를 포함하는 개념
* WAS는 매 요청마다 스레드 풀에서 기존 스레드를 사용함
* WAS의 주요 튜닝 포인트는 max thread 수
* 대표적인 WAS로는 톰캣이 있다.

## Servlet 인터페이스
* 서블릿 컨테이너가 서블릿 인터페이스에 있는 메소드들을 호출함
* 서블릿 생명주기와 관련된 메서드
  * init(), service(), destroy()
* 서블릿 기타 메서드
  * getServletConfig()
  * getServletInfo()

	