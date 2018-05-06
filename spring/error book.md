# ERROR BOOK

> port(8080) ERROR

Tomcat vx.0 Server at localhost 더블 클릭 > HTTP/1.1 > Port Number 수정(8080 -> 8000)

> starting tomcat v9.0 server at localhost has encountered a problem

spring mvc project 생성하고 처음으로 server를 실행 할 때 발생. 해결방법으로 eclipse 종료 -> maven의 repository의 모든 파일을 제거 -> eclipse 실행 -> project - maven - update project 하고 server 실행 시 해결.

> Folder 생성시 Package모습으로 나올 경우

Build Path > Configure Build Path
Excluded > Edit > Exclusion patterns: > Add > ** > Ok

> An internal error occurred during: "Initializing Java Tooling". java.lang.NullPointerException

EclipseProject Folder > .metadata > .plugins > org.eclipse.core.resources > .projects > 모든 파일 삭제 > eclipse restart > 다시 .projects Folder에 RemoteSystemsTempFiles Folder 추가

> Cannot load JDBC driver class 'oracle.jdbc.driver.OracleDriver'

tomcat > libs에 ojdbc.jar을 붙여넣는다.
