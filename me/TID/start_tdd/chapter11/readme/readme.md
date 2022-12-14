# 마치며

---

## 테스트 우선과 스트레스

* 빨리 구현해야 한다는 압박은 높은 스트레스를 주며 이는 본인이 만든 코드를 충분히 테스트하지 않고
  다음 기능을 구현하게 만든다.
* 코드를 충분히 테스트하지 않으면 버그를 포함할 가능성이 커진다.
* 구현한 코드를 제대로 테스트하지 못했다는 사실 또한 스트레스를 증가시킨다.
* 충분하지 않은 테스트와 피로감은 판단력을 흐리게 해서 소프트웨어의 품질을 점점 망가뜨린다.
* 테스트 코드는 회귀 테스트로 사용할 수 있다.
* 코드를 수정하거나 새로 추가할 때 앞서 작성한 테스트 코드를 사용하면 다른 기능에 문제가
  없는지 바로 확인할 수 있다.
* 테스트 코드는 안전장치가 되어 변경한 코드로 인해 소프트웨어가 비정상적으로 동작하는 것을
  사전에 막아준다.

### 회귀 테스트

* 회귀 테스트는 개발하고 테스트한 소프트웨어가 이후에 코드를 수정해도 기존 코드가 올바르게
동작하는지 확인하기 위한 테스트이다.
* 소프트웨어를 변경하면 이전에 고쳤던 결함이 재발하거나 새로운 결함이 발생하는 일이 종종 발생한다.
* 결함을 수정하고 이를 확인할 테스트를 만든다.
* 소프트웨어가 바뀔 때마다 실행해서 결함이 재발하지 않는지 확인한다.

## TDD 전파하기

* TDD가 어느정도 몸에 붙으면 다음의 효과를 느낄 수 있다.
  * 결함 감소
  * 스트레스 감소
  * 빠른 피드백
  
## TDD와 개발 시간

* 개발 시간은 크게 세가지로 나눌 수 있다.
  * 처음 코딩 시간
  * 테스트 시간
  * 디버깅 시간
* 개발 시간은 테스트 전까지의 코딩 시간과 테스트 시간 그리고 문제를 없애기 위한 디버깅 시간을 
포함한다.
* 전체 개발 시간을 줄이려면 코딩 시간뿐만 아니라 테스트 시간과 디버깅 시간을 줄여야 한다.
* 반면에
  * TDD는 기능을 구현하자마자 테스트를 진행한다.
  * TDD는 디버깅 시간을 줄여준다.
  * TDD는 리팩토링을 포함한다.
