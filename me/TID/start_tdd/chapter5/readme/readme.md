# JUnit 5 기초

---

## JUnit 5 모듈 구성

* JUnit5 는 크게 세 개의 요소로 구성되어 있다.

1. JUnit 플랫폼 : 테스팅 프레임워크를 구동하기 위한 런처와 테스트 엔진을 위한 API를 제공한다.
2. JUnit 주피터(Jupiter) : JUnit5를 위한 테스트 API와 실행 엔진을 제공한다.
3. JUnit 빈티지(Vintage) : JUnit 3과 4로 작성된 테스트를 JUnit5 플랫폼에서 실행하기 위한 모
   듈을 제공한다.

## @Test 애노테이션과 테스트 메서드

* JUnit 코드의 기본 구조는 간단하다.
* 테스트로 사용할 클래스를 만들고 @Test 애노테이션을 메서드에 붙이기만 하면 된다.
* @Test 애노테이션을 붙인 메서드는 private 이면 안된다.
* JUnit 의 Assertions 클래스는 assertEquals() 메서드와 같이 값을 검증하기 위한
  목적의 다양한 정적 메서드를 제공한다.

## 주요 단언 메서드

    expected : 기대하는 값
    unexpected : 특정 값
    actual : 실제 값

* assertEquals(expected, actual) : 실제 값이 기대하는 값과 같은지 검사한다.
* assertNotEquals(expected, actual) : 실제 값이 특정 값 과 같지 않은지 검사한다.
* assertSame(Object expected, Object actual) : 두 객체가 동일한 객체인지 검사한다.
* assertNotSame(Object expected, Object actual) : 두 객체가 동일하지 않은 객체인지 검사한다.
* assertTrue(boolean condition) : 값이 true인지 검사한다.
* assertFalse(boolean condition) : 값이 false인지 검사한다.
* assetNull(Object actual) : 값이 null인지 검사한다.
* assertNotNull(Object actual) : 값이 null이 아닌지 검사한다.
* fail() : 테스트를 실패 처리한다.
* assertThrows(Class<T> expectedType, Executable executable) :
  excutable을 실행한 결과로 지정한 타입의 익셉션이 발생하는지 검사한다.
* assertDoesNotThrows(Executable executable) :
  executable 을 실행한 결과로 익셉션이 발생하지 않는지 검사한다.
    * assertThrows()와 assertDoesNotThrows() 메서드에서 사용하는 Excutable 인터
      페이스는 execute() 메서드를 가진 함수형 인터페이스이다.
    * assert메서드는 실패하면 다음 코드를 실행하지 않고 바로 익셉션을 발생한다.
    * 경우에 따라 모든 검증을 실행하고 실패한것이 있는지 학인하고 싶을 땐 assertAll()
      을 사용하면 된다.

## 테스트 라이프사이클

### @BeforeEach 애노테이션과 @AfterEach 애노테이션

* JUnit은 각 테스트 메서드마다 다음 순서대로 코드를 실행한다.

1. 테스트 메서드를 포함한 객체 생성
2. (존재하면) @BeforeEach 애노테이션이 붙은 메서드 실행
3. @Test 애노테이션이 붙은 메서드 실행
4. (존재하면) @AfterEach 애노테이션이 붙은 메서드 실행

### @BeforeAll 애노테이션과 @AfterAll 애노테이션

* 한 클래스의 모든 테스트 메서드가 실행되기 전에 특정 작업을 수행해야 한다면 @BeforeAll
  애노테이션을 사용한다.
* @BeforeAll 애노테이션은 적적 메서드에 붙이는데 이 메서드는 클래스의 모든 테스트 메서드를
  실행하기 전에 한 번 실행된다.
* @AfterAll 애노테이션은 반대로 클래스의 모든 테스트 메서드를 실행한 뒤에 실행된다.

## 테스트 메서드 간 실행 순서 의존과 필드 공유하지 않기

* 테스트 메서드가 특정 순서대로 실행된다는 가정하에 테스트 메서드를 작성하면 안된다.
* JUnit이 테스트 순서를 경정하긴 하지만 그 순서는 버전에 따라 달라질 수 있다.
* 순서가 달라지면 테스트도 실패한다.
* 각 테스트 메서드는 독립적으로 동작해야 한다.
* 한 테스트 메서드의 결과에 따라 다른 테스트 메서드의 실행 결과가 달라지면 안 된다.
* 테스트 메서드가 서로 필드를 공유한가더나 실행 순서를 가정하고 테스트를 작성하지 말아야 한다.

### 읽어보기
    테스트 메서드간에 의존이 생기면 테스트의 유지보수를 어렵게 만든다.
    테스트 코드 역시 코드이므로 유지보수가 중요하다.

## 추가 애노테이션 : @DisplayName, @Disable

* 자바는 메서드 이름에 공백이나 특수문자를 사용할 수 없기 때문에 메서드 이름만으로 테스트 
내용을 설명하기가 부족할 수 있다.
* 이럴때는 @DisplayName 애노테이션을 사용해서 테스트에 표시 이름을 붙일 수 있다.
* 특정 테스트를 실행하지 않고 싶을 때는 @Disable 애노테이션을 사용한다.
* JUnit은 @Disabled 애노테이션이 붙은 클래스나 메서드는 테스트 실행 대상에서 제외한다.

## 모든 테스트 실행하기

* 