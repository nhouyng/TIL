# Log4j

### Log4j 구조
|  <center>요소</center> |  <center>설명</center> |
|:--------|:--------:|
|<center>Logger</center>|<center>출력할 메세지를 Appender에 전달한다.</center>|
|<center>Appender</center>|<center>전달된 로그를 어디에 출력할지 결정한다.(콘솔 출력, 파일 기록, DB 저장 등)</center>|
|<center>Layout</center>|<center>로그를 어떤 형식으로 출력할지 결정한다.</center>|

### Log4j 레벨
|  <center>요소</center> |  <center>설명</center> |
|:--------|:--------:|
|<center>FATAL</center>|<center>아주 심각한 에러가 발생한 상태를 나타낸다.</center>|
|<center>ERROR</center>|<center>어떠한 요청을 처리하는 중문제가발생한 상태를 나타낸다.</center>|
|<center>WARN</center>|<center>프로그램의 실행에는 문제가 없지만, 향후 시스템 에러의 원인이 될 수 있는 경고성 메세지를 나타낸다.</center>|
|<center>INFO</center>|<center>어떠한 상태변겅과 같은 정보성 메세지를 나타낸다.</center>|
|<center>DEBUG</center>|<center>개발시 디버그 용도로 사용하는 메세지를 나타낸다.</center>|
|<center>TRACE</center>|<center>디버그 레벨이 너무광범위한것을 해결하기 위해서 좀 더 상세한 이벤트를 나타낸다.</center>|
---

### 마이바티스(MyBatis) 쿼리 로그 출력 및 정렬
1. log4jdbc-remix.jar 추가
  - http://mvnrepository.com 에서 log4jdbc-remix dependency 복사
  - maven에 log4jdbc-remix dependency 추가
2. Log4j.xml 수정
```xml
<appender name="console-infolog" class="org.apache.log4j.ConsoleAppender">
  <param name="Target" value="System.out" />
  <layout class="org.apache.log4j.PatternLayout">
    <param name="ConversionPattern" value="%-5p: %c - %m%n" />
  </layout>
</appender>

<!-- Query Loggers -->
<logger name="jdbc.sqlonly" additivity="false">
  <level value="info"/>
  <appender-ref ref="console-infolog"/>
</logger>

<logger name="jdbc.resultsettable" additivity="false">
  <level value="info"/>
  <appender-ref ref="console"/>
</logger>
```

3. log4j bean 추가
프로젝트와 DB를 연동하는 xml에 bean을 추가한다.
```xml
<bean id="dataSource" class="net.sf.log4jdbc.Log4jdbcProxyDataSource">
<constructor-arg ref="dataSourceSpied" />
<property name="logFormatter">
<bean class="net.sf.log4jdbc.tools.Log4JdbcCustomFormatter">
<property name="loggingType" value="MULTI_LINE" />
<property name="sqlPrefix" value="SQL > "/>
</bean>
</property>
</bean>
```
---
