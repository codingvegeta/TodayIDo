# Transaction, Commit, Rollback

---
## Transaction 이란?
* 더이상 나눌 수 없는 작업의 단위
* 둘 이상의 작업이 하나로 묶여서 '모' 아니면 '도' 둘다 성공하거나 둘다 실패 해야 함
* Transaction의 속성
  * 원자성 - Atomicity : 나눌 수 없는 하나의 작업으로 다뤄져야 한다.
  * 일관성 - Consistency : Tx 수행 전과 후가 일관된 상태를 유지해야 한다.
  * 고립성 - Isolation : 각 Tx는 독립적으로 수행되어야 한다.
    * READ UNCOMMITED - 커밋되지 않은 데이터도 읽기 가능
      * dirty read 커밋 되기 이전에 입력된 데이터를 다른 사람이 손댈 수 있음
    * READ COMMITED - 커밋된 데이터만 읽기 가능
      * phantom read 커밋 되기 이전에는 입력된 데이터를 다른사람이 읽어올 수 없음
    * REPEATABLE READ - Tx이 시작된 이후 변경은 무시됨 (default)
      * Tx의 시작 후 다른 Tx의 변경은 무시됨
    * SERIALIZABLE - 한번에 하나의 Tx만 독립적으로 수행 (고립도 최고)
      * 한번에 하나의 Tx만 독립적으로 수행(직렬화), 성능은 떨어지지만 품질은 올라감
  * 영속성 - Durability : 성공한 Tx의 결과는 유지되어야 한다.
* 커밋(commit)
  * 작업 내용을 DB에 영구적으로 저장
* 롤백(rollback)
  * 최근 변경사항을 취소(마지막 커밋으로 복귀)
  * 커밋 이전상태로는 돌아 갈 수 없다.
* 자동커밋(Auto commit)
  * 명령 실행 후, 자동으로 커밋이 수행 (rollback불가)
* 수동 커밋
  * 명령 실행 후, 명시적으로 commit 또는 rollback을 입력