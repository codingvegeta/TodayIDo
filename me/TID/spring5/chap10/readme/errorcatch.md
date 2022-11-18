# MySQLNonTransientConnectionException
## 이 오류는 DB 버전을 확인해줘야 한다
```
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.30</version>
        </dependency>
```
* 현재 설치되어있는 mysql 버전과 pom.xml의 버전을 잘 확인해주자...
* mysql 5.7 버전까지는 driverClassName을 com.mysql.jdbc.Driver를 
그대로 사용하지만 8버전 부터는 com.mysql.cj.jdbc.Driver를 사용함