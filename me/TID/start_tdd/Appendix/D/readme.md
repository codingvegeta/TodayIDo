# AssertJ 소개

---

## AssertJ 사용 이유

* JUnit은 테스트 실행을 위한 프레임워크를 제공하지만 단언에 대한 표현력이 부족하다.
* AssertJ를 사용하면 테스트 코드의 표현력이 높아질 뿐만 아니라 개발 도구의 자동완성 기능을
  활용할 수 있다.

## AssertJ 기본 사용법

* AssertJ의 기본 사용법은 다음과 같다

      assertThat(실제값).검증메서드(기댓값)
* assertThat() 메서드는 주요 타입별로 존재하며 타입에 따라 다른 검증 메서드를 제공한다.

### 기본 검증 메서드

* isEqualTo(값) : 값과 같은지 검증한다.
* isNotEqualTo(값) : 값과 다른지 검증한다.
* isNull() : null인지 검증한다.
* isIn(값 목록) : 값 목록에 포함되어 있는지 검증한다.
* isNotIn(값 목록) : 값 목록에 포함되어 있지 않는지 검증한다.
* isIn 과 isNotIn은 값 목록은 가변 인자로 주거나 List와 타입을 이용해서 전달한다.


* Comparable 인터페이스를 구현한 타입이나 int,double과 같은 숫자 타입의 경우 다음 메서드를
  이용해서 값을 검증할 수 있다.
* isLessThan(값) : 값보다 작은지 검증한다.
* isLessThanOrEqualTo(값) : 값보다 작거나 같은지 검증한다.
* isGreaterThan(값) : 값보다 큰지 검증한다.
* isGreaterThanOrEqualTo(값) : 값보다 크거나 같은지 검증한다.
* isBetween(값1, 값2) : 값1과 값2 사이에 포함되는지 검증한다.


* boolean, Boolean 타입을 위한 검증 메서드는 다음 두 개가 존재한다.
* isTrue() : 값이 true 인지 검증한다.
* isFalse() : 값이 false인지 검증한다.

## String에 대한 추가 검증 메서드

### 특정 값을 포함하는지 검사하는 메서드

* contains(CharSequence...values) : 인자로 지정한 문자열들을 모두 포함하고 있는지 검증한다.
* containsOnlyOnce(CharSequence...values) : 해당 문자열을 딱 한 번만 포함하는지 검증한다.
* containsOnlyDigit() : 숫자만 포함하는지 검증한다.
* containsWhitespaces() : 공백 문자를 포함하고 있는지 검증한다.
* containsOnlyWhitespaces() : 공백 문자만 포함하는지 검증한다. (공백 여부는 Character#isWhitespace() 메서드를 따른다.)
* containsPattern(CharSequence regex) : 지정한 정규 표현식에 일치하는 문자를 포함 하는지 검증한다.
* containsPatter(Pattern pattern) : 지정한 정규 표현식에 일치하는 문자를 포함 하는지 검증한다.

### 포함하지 않는지 여부를 확인하는 메서드도 있다.

* doesNotContain(CharSequence...values) : 인자로 지정한 문자열들을 모두 포함하고 있지 않은지 검증한다.
* doesNotContainAnyWhitespaces() : 공백 문자를 포함하고 있지 않은지를 검증한다.
* doesNotContainOnlyWhitespaces() : 공백 문자만 포함하고 있지 않은지를 검증한다.
* doesNotContainPattern(Pattern pattern) : 정규 표현식에 일치하는 문자를 포함하고 있지 않은지를 검증한다.
* doesNotContainPattern(CharSequence pattern) : 정규 표현식에 일치하는 문자를 포함하고 있지 않은지를 검증한다.

### 특정 문자열로 시작하거나 끝나는지 검증할 때에는 다음 메서드를 사용한다.

* startWith(CharSequence prefix) : 지정한 문자열로 시작하는지를 검증한다.
* doesNotStartWith(CharSequence prefix) : 지정한 문자열로 시작하지 않는지를 검증한다.
* endsWith(CharSequence suffix) : 지정한 문자열로 끝나는지를 검증한다.
* doesNotEndWith(CharSequence suffix) : 지정한 문자열로 끝나지 않는지를 검증한다.


## 숫자에 대한 추가 검증 메서드

### 숫자 타입에 대해서 추가로 지원하는 주요 검증 메서드

* isZero() / isNotZero() : 0인지 또는 0이 아닌지를 검증한다.
* inOne() : 1인지를 검증한다.
* isPositive() / isNotPositive() : 양수인지 양수가 아닌지를 검증한다.
* isNegative() / isNotNegative() : 음수인지 음수가 아닌지를 검증한다.

## 날짜/시간에 대한 검증 메서드

### LocalDateTime이 특정 시간 이후인지를 검증한다.

### LocalDateTime, LocalDate, Date 등 날짜와 시간 관련된 타입에 대해 비교할 값은 같은 타입이다.
* isBefore(비교할 값) : 비교할 값보다 이전인지 검증한다.
* isBeforeOrEqualTo(비교할 값) : 비교할 값보다 이후인지 검증한다.
* isAfterOrEqualTo(비교할 값) : 비교할 값보다 이후이거나 같은지 검증한다.

### LocalDateTime, OffsetDateTime, ZonedDateTime 타입은 다음의 검증 메서드 추가로 제공한다.

* isEqualToIgnoringNanos(비교할 값) : 나노 시간을 제외한 나머지 값이 같은지 검증한다. 초 단위 까지 같은지 검증한다.
* isEqualToIgnoringSeconds(비교할 값) : 초 이하 시간을 제외한 나머지 값이 같은지 검증한다. 분 단위 까지 같은지 검증한다.
* isEqualToIgnoringMinutes(비교할 값) : 분 이하 시간을 제외한 나머지 값이 같은지 검증한다. 시 단위까지 값이 같은지 검증한다.
* isEqualToIgnoringHours(비교할 값) : 시 이하 시간을 제외한 나머지 값이같은지 검증한다. 일 단위까지 값이 같은지 검증한다.

## 콜렉션에 대한 검증 메서드

### List,Set 등 콜렉션에 대한 주요 검증 메서드는 다음과 같다.

* hasSize(int expected) : 콜렉션의 크기가 지정한 값과 같은지 검사한다.
* contains(E ... values) : 콜렉션이 지정한 값을 포함하는지 검증한다.
* containsOnly(E ... values) : 콜렉션이 지정한 값 만 포함하는지 검증한다.
* containsAnyOf(E ... values) : 콜렉션이 지정한 값 중 일부를 포함하는지 검증한다.
* containsOnlyOnce(E ... values) : 콜렉션이 지정한 값을 한 번만 포함하는지 검증한다.

### Map을 위한 주요 검증 메서드

* containsKey(K key) : Map이 지정한 키를 포함하는지 검증한다.
* containsKeys(k ... keys) : Map이 지정한 키들을 포함하는지 검증한다.
* containsOnlyKeys(K ... keys) : Map이 지정한 키만 포함하는지 검증한다.
* doesNotContainKeys(K...keys) : Map이 지정한 키들을 포함하지 않는지 검증한다.
* containsValues(VALUE ... values) : Map이 지정한 값들을 포함하는지 검증한다.
* contains(Entry<K,V> ... values) : Map이 지정한 Entry<K,V>를 포함하는지 검증한다.

## 익셉션 관련 검증 메서드

* 익셉션 발생 여부를 검증하고 싶다면 assertThaThrownBy() 메서드를 사용한다.
~~~ 
assertThatThrownBy(()-> readFile(new File("nofile.txt))); 
~~~
* 인자로 받은 람다에서 익셉션이 발생하는지 검증한다.
* 발생한 익셉션의 타입을 추가로 검증하고 싶다면 isInstanceOf() 메서드를 사용한다.
~~~ 
assertThatThrownBy(()-> readFile(new File("nofile.txt)))
.isInstanceOf(IOException.class); 
~~~
* 특정 타입의 익셉션이 발생하는지 검증하는 또다른 방법은 assertThatExceptionOfType() 
메서드를 사용하는 것이다.
~~~ 
assertThatExceptionOfType(IOException.class)
    .isThrownBy(() -> {
      readFile(new File("nofile.txt"));
      }); 
~~~
* 익셉션이 발생하지 않는 것을 검증할 수도 있다.
* doesNotThrowAnyException을 사용하면 된다.

## as()와 describedAs()로 설명 달기

### as() 메서드는 테스트에 설명을 붙인다.
~~~
assertThat(id).as("ID 검사").isEqualTo("abc");
~~~
* 위 코드는 검증 실패시 [ID 검사] 로 실패했다는 메시지를 출력한다.
* as() 메서드에는 문자열 포맷을 사용할 수 있다.
* 첫 번째 인자는 포맷팅을 포함한 문자열이고 두 번째 인자열 부터는 포맷팅에 사용할 값을 전달한다.
* as()메서드 대신에 describedAs() 메서드를 사용해도 된다.