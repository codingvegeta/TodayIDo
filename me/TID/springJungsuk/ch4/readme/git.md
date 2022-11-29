# git의 기본 사용법과 원리

----
## git이란?

---
* 여러사람이 문제없이 어떻게 협업 할 것인가?
* 이력관리 history 어떻게 남기는가?
* 로컬 저장소 = 지역 저장소
* 리모트 저장소 = 원격 저장소
* git init 을 이용하면 로컬 레포지토리가 생긴다.
## 커밋이란?

---
* Working Directory -add-> Staging Area -commit-> Local Repository

* [주의] 파일을 삭제할 때, working directory에서 직접 삭제하지 말고 git
을 통해 삭제해야 이력이 관리된다.
* soft 옵션을 사용하면 가볍게 된다.
* hard 옵션을 사용하면 워킹 디렉토리에도 영향을 줄 수 있다.
* 이동하고 싶은 커밋의 아이디를 알면 이동할 수 있다.