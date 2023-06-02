const target = 'Is this all there is?';

const regExp = /is/;

regExp.exec(target);
// g플래그를 사용해도 첫 번째 매칭 결과만 반환한다.
