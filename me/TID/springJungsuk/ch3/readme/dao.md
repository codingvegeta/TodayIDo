# DAO의 작성과 적용

---
## DAO(Data Access Object) 란?

---
* 데이터에 접근하기 위한 객체
* Database에 저장된 데이터를 읽기, 쓰기, 삭제, 변경을 수행
* CRUD?
  * 읽기, 쓰기, 삭제, 변경
* DB테이블당 하나의 DAO를 작성

### 계층의 분리

----
* 중복되는 메서드를 분리하기 위해 별도의 객체(dao)를 만든다.
* Presentation Layer = Data를 보여주는 계층
* Business Layer = 비즈니스 로직을 담은 계층
* Persistence Layer = Data AccessLayer (Dao 영속계층)

