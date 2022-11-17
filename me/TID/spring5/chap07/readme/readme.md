# DB 연동

---
## 1 JDBC 프로그래밍의 단점을 보완하는 스프링

---
* 구조적인 반복을 줄이기 위한 방법은 템플릿 메서드 패턴과 전략 패턴을 함께 사용하는 것이다.
* 스프링은 바로 이 두 패턴을 엮은 JdbcTemplate 클래스를 제공한다.
* 스프링의 제공하는 또 다른 장점은 트랜잭션 관리가 쉽다는 것이다.
* 스프링을 사용하면 트랜잭션을 적용하고 싶은 메서드에 @Transactional 애노테이션을
붙이기만 하면 된다.
* 커밋과 롤백 처리는 스프링이 알아서 처리한다.


* 커넥션의 상태에 대해 알아보기
  * 커넥션 풀은 커넥션을 생성하고 유지한다.
  * 커넥션 풀에 커넥션을 요청하면 해당 커넥션은 활성 상태가 되고, 커넥션을 다시 커넥션
  출에 반환하면 유휴 상태가 된다.
  * getConnection()을 실행하면 풀에서 커넥션을 가져와 커넥션이 활성 상태가 된다.
  * 반대로 커넥션을 종료(close)하면 커넥션은 풀로 돌아가 유휴 상태가 된다.

## 2 JdbcTemplate을 이용한 쿼리 실행

---
* 스프링을 사용하면 DataSource나 Connection, Statement, ResultSet을 직접 사용하지 않고
JdbcTemplate을 이용해서 편리하게 쿼리를 실행할 수 있다.
* JdbcTemplate 클래스는 SELECT 쿼리 실행을 위한 query() 메서드를 제공한다.
  * List<T> query(String sql, RowMapper<T> rowMapper)
  * query() 메서드는 sql 파라미터로 전달받은 쿼리를 실행하고 RowMapper를 이용해서
  ResultSet의 결과를 자바 객체로 변환한다.
* 결과가 1행인 경우 queryForObject() 메서드를 사용할 수 있다.
  * T queryForObject(String sql, Class<T> requiredType)
  * 쿼리 실행 결과는 반드시 한 행이여야 한다.
  * 결과행이 없거나 두개 이상이면 Exception이 발생
* INSERT, UPDATE, DELETE 쿼리는 update() 메서드를 사용한다.
  * update() 메서드는 실행 결과로 변경된 행의 개수를 리턴한다.

## 3 트랜잭션 처리

---
* 스프링이 제공하는 @Transactional 애노테이션을 사용하면 트랜잭션 범위를 매우 쉽게
지정할 수 있다.
* 트랜잭션 범위에서 실행하고 싶은 메서드에 @Transactional 애노테이션만 붙이면 된다.
* @Transactional 애노테이션이 제대로 동작하려면 두가지 내용을 스프링에 추가해야 한다.
  * 플랫폼 트랜잭션 매니저 빈 설정
  * @Transactional 애노테이션 활성화 설정
* @EnableTransactionManagement 애노테이션은 @Transactional 애노테이션이 붙은
메서드를 트랜적션 범위에서 실행하는 기능을 활성화한다.

### 3.1 @Transactional과 프록시

---
* 여러 빈 객체에 공통으로 적용되는 기능을 구현하는 방법으로 AOP가 있는데 트랜잭션도 공통
기능중에 하나이다.
* @Transactional 애노테이션을 이용해서 트랜잭션을 처리하기 위해 내부적으로 AOP를 사용한다.
* getBean()으로 가져오는 객체는 트랜잭션 처리를 위해 생성한 프록시 객체를 리턴한다.

### 3.2 @Transactional 적용 메서드의 롤백 처리

---
* 커밋을 수행하는 주체가 프록시 객체였던 것처럼 롤백을 처리하는 주체 또한 프록시 객체이다.
* 
