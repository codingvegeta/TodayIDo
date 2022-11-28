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

## URI 와 URL 차이

---
* URL : 리소스 경로
* URN : 리소스의 유일한 이름
* URI : Identifier 유일한 이름

### RedirectAttributes

* 세션을 이용한 1회성 저장
---
* model객에체 메세지를 넣어서 뷰 페이지에서 사용할 경우 새로고침을 하면 매번 같은 메세지가 뜬다.
* 이경우 메시지를 한번만 띄우고 싶을 때 사용하는 기능이 RedirectAttributes 이다.
* 이 객체에 addFlashAttribute() 메서드를 이용해서 넣고 뷰 페이지에서 사용하면 
새로고침해도 같은 메세지가 계속 뜨지 않는다.

### attribute vs property

---
* attribute : Html 태그 안에 적어주는 것
* property : 브라우저가 읽으면 new InputEliment(title, "text")를 생성한다
  * 생성된 객체의 속성이라고 생각하면 좋다.

## 검색 기능 구현하기

----
* 동적 쿼리를 작성할 줄 알아야 한다.
  * 공통부분을 \<sql>로 정의하고 \<include>로 포함시켜 재사용
  * AND 조건을 연결시키기 위해 true를 붙인다 
  * \<if>문 은 여러개를 다 비교하는 반면 \<choose>문은 조건에 맞는게 있다면 나머지는 비교하지 않는다.
  * 와일드 카드 %,_ 
    * %의 경우에는 
      * ex-> tomato% == tomato 또는 tomato2134
      * %자리 이후에 글자가 없거나 다른 글자가 와도 상관없음
    * _의 경우에는 
      * ex-> tomato_ == tomato1
      * _자리 이후에는 글자가 무조건 한자리 있어야 한다.
  * \<foreach> : 배열로 값을 넘겨준다.
* 페이지 이동을 잘 할줄 알아야 한다.
* 
