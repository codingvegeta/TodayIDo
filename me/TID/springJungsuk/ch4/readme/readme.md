# MyBatis

---
## SqlSessionFactoryBean 과 SqlSessionTemplate

---
* MyBatis 가 제공하는 인터페이스
  * SqlSessionFactory - SqlSession을 생성해서 제공
  * SqlSession - SQL명령을 수행하는데 필요한 메서드 제공
* MyBatisSpring 이 인터페이스를 구현
  * SqlSessionFactoryBean - Spring에서 사용하기 위한 빈
  * SqlSessionTemplate - SQL명령을 수행하는데 필요한 메서드 제공 (thread-safe)
    * 여러개의 DAO가 공유 가능 멀티 쓰레드 환경에서도 안전하다.
* \<typeAliases> 로 별멸을 지정할 수 있다.
  * 실제 이름이 너무 길 경우 별명으로 이름을 줄일 수 있다.
  * 별명은 대소문자를 구별하지 않는다.
  * 실제 이름은 대소문자를 구별한다.

## DTO란? - Data Transfer Object

---
* 계층간의 데이터를 주고 받기 위해 사용되는 객체
* DTO에 데이터를 담아서 움직인다.
* Controller -> Service -> Repository
  * @Controller
    * 요청과 응답처리
    * 데이터 유효성 검증
    * 실행 흐름을 제어
    * 서비스에서 처리하지 못한 예외를 처리한다.
  * @Service
    * 비즈니스 로직 담당
    * 트랜잭션 처리
    * 처리할 수 있는것만 처리하고 컨트롤러로 던지기
  * @Repository
    * 순수 Data Access 기능
    * 조회, 등록, 수정, 삭제
    * 모든 예외는 되던지기 한다.

## #{}와  ${}의 차이

---
* #{} 는 PreparedStatement로 바뀐다.
  * sql에 문에서 값에 대해서만 ?를 사용 가능함
  * ''생략 가능하다.
  * SQL Injection 방지 가능
* ${} 는 Statement로 바뀐다.
  * PreparedStatement에 비해 유연하다. 
  * 문자일 경우 ''가 필요하다.
  * SQL Injection 방지 불가능
  * 내부적으로만 사용해야 한다.
  * 외부값을 사용할 경우 철저한 검증이 필요하다.

## XML의 특수 문자 처리

----
* XML 내의 특수 문자 (<,>,&,...)는 &lt; &gt로 변환이 필요하다.
* 특수문자가 포함된 쿼리를 \<![CDATA[와]]>로 감싼다.
* \<![CDATA[]]> 캐릭터 데이터 XMLTag가 없다는 의미이다.