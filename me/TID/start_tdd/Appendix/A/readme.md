# JUnit 5 추가 내용

---

## 조건에 따른 테스트

* @EnabledOnOs, @DisabledOnOs
* @EnabledOnJre, @DisabledOnJre
* @EnabledIfSystemProperty, @DisabledIfSystemProperty
* @EnabledIfEnvironmentVariable, @DisabledIfEnvironmentVariable


* 테스트 메서드가 특정 운영체제에만 동작해야 한다면 @EnabledOnOs
* 반대의 경우에는 @DisabledOnOs 를 사용한다.
* OS 타입은 열거 타입으로 WINDOWS, MAC, LINUX 와 같은 운영체제 이름을 값으로 정의하고있다.

   
* 자바 버전에 따라 테스트를 진행하고 싶다면 @EnabledOnJre
* 반대의 경우에는 @DisabledOnJre 를 사용한다.
* JRE 열거 타입은 자바 버전을 정의하고 있다.


* @EnabledIfSystemProperty 애노테이션과 @DisabledIfSystemProperty 애노테이션은
시스템 프로퍼티 값을 비교하여 테스트 실행 여부를 결정한다.
* @EnabledIfSystemProperty 애노테이션의 named 속성은 시스템 프로퍼티의 이름을 지정하고 
matches 속성에는 값의 일치 여부를 검사할 때 사용할 정규 표현식을 지정한다.
* @EnabledIfEnvironmentVariable 애노테이션도 named 속성과 matches 속성을 사용한다.
* 차이점은 named 속성에 환경변수 이름을 사용한다는 것이다.

## 태깅과 필터링

* @Tag 애노테이션은 테스트에 태그를 달 때 사용한다.
* @Tag 애노테이션은 클래스와 테스트 메서드에 적용할 수 있다.
* 태그의 이름은 다음 규칙을 따라야 한다.
  * null이나 공백이면 안 된다.
  * 좌우 공백을 제거한 뒤에 공백을 포함하면 안 된다.
  * ISO 제어 문자를 포함하면 안 된다.
  * 다음 글자를 포함하면 안 된다 : , () & | !

## 중첩 구성

* @Nested 애노테이션을 사용하면 중첩 클래스에 테스트 메서드를 추가할 수 있다.
* 중첩된 클래스는 내부 클래스 이므로 외부 클래스의 멤버에 접근할 수 있다.

## @Timeout 애노테이션을 이용한 테스트 실행 시간 검증

* 테스트가 일정 시간 내에 실행되는지 검증 할 수 있다.
* 초가 아닌 시간 단위를 사용하고 싶다면 unit 속성에 TimeUnit 값을 지정하면 된다.

