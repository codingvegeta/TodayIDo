# 서비스 계층의 분리와 @Transaction

---
## 서비스 계층(Layer)의 분리 - 비지니스 로직의 분리

---
* @Controller -> @Service -> @Repository
* 컨트롤러에서 다오에 직접 접근하는것은 좋지않다. 유지보수에 좋지 않음
  * 레포지토리가 늘어나면 컨트롤러의 코드도 무지하게 늘어남
* 컨트롤러가 서비스를 호출해서 사용하게 된다면 서비스가 아무리 늘어나도 컨트롤러는 코드 추가 없이
서비스만 호출해서 사용 가능 (유지 보수++ 중복 제거)

## TransactionManager 란?

----
* 같은 Tx내에서 같은 Connection을 사용할 수 있게 관리
* Dao 에서 Connection을 얻거나 반환할 때 DataSourceUtils를 사용해야 한다.
* Tx 매니저 생성 -> DefaultTransactionDefinition()    
->Tx 시작 -> Tx 끝 성공(커밋)/Tx 실패 (롤백)

### Transactional로 Transaction 적용하기

---
* AOP를 이용한 핵심 기능과 부가 기능의 분리
* @Transactional은 클래스나 인터페이스에도 붙일 수 있음
  * 클래스에 붙일경우 모든 메서드에 적용
* @Transactional 의 속성
  * readOnly : Tx이 데이터를 읽기만 하는 경우, true로 지정하면 성능이 향상됨
  * rollbackFor : 지정된 예외가 발생하면, Tx를 rollback
    * 익셉션의 자손은 처리하지 못함
    * 특정 예외를 지정하려면 애노테이션 옆에 (rollbackFor = 클래스)를 지정해줘야 한다.
  * noRollbackFor : 지정된 예외가 발생해도, Tx을 rollback하지 않음
  * timeout 지정된 시간(초)내에 Tx이 종료되지 않으면, Tx를 강제종료
* propagation 속성의 값
  * REQUIRED : Tx이 진행중이면 참여하고, 없으면 새로운 Tx 시작(디폴트)
  * REQUIRES_NEW : Tx이 진행 중이건 아니건, 새로 Tx 시작
* 같은 클래스에 속한 메서드끼리의 호출(내부 호출)의 프록시 방식의 AOP는 내부호출인 경우,
Advice가 적용되지 않는다. 그래서 같은 클래스 내에서는 Tx가 적용되지 않는다.

