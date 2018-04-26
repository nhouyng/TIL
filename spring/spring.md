#spring
### web.xml
서블릿 배포 기술자;DD(Deploment Descriptor)라고 하며, tomcat(Web Application Server)이 최초 구동할 때, WEB-INF 디렉토리의 web.xml의 설정을 구성한다. 즉, 각종 설정을 위한 설정파일이다.
- web 기본 페이지 설정
```xml
<welcome-file-list>
  <welcome-file>index.jsp</welcome-file>
<welcome-file-list>
```
- servlet 설정
contextConfigLocation 설정은 기존 dispatcher설정인 /WEB-INF/spring/appServlet/servlet-context.xml을 /WEB-INF/config/action-servlet.xml로 변경하기위함이다.(서블릿 설정 변경 후 기존 servlet-context.xml을 WEB-INF 아래 config 디렉토리 생성하고 그곳으로 복사 후 action-context.xml로 수정한다. && spring 디렉토리 삭제) 그와 함께 동적 웹 프로젝트에서 사용자의 요청과 응답을 처리해주는 servlet에서 mapping을 설정한다.(.do)
```xml
<servlet>
  <servlet-name>action</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  <init-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>/WEB-INF/config/*-servlet.xml</param-value>
  </init-param>
  <load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
  <servlet-name>action</servlet-name>
  <url-pattern>*.do</url-pattern>
</servlet-mapping>
```
---
### pom.xml
Maven 관련 파일

---
### servlet-context.xml
서블릿 설정
- prefix & suffix
prefix와 suffix를 자동으로 붙여 jsp의 전체 경로를 붙이지 않게한다.
```xml
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
  <beans:property name="prefix" value="/WEB-INF/views/" />
  <beans:property name="suffix" value=".jsp" />
</beans:bean>
```
- bean 설정
스프링에서 사용하는 bean을 Annotation으로 자동 인식.
```xml
<context:component-scan base-package="com.nhouyng.web01" />
```
---
### Service
Service 영역은 두개의 파일로 구성된다. Service 인터페이스와 이 인터페이스를 실제로 구현한 ServiceImpl 클래스로 구성된다. 이는 Spring의 IoC/DI(Inversion of Control / Dependency Injection) 기능을 이용한 Bean 관리 기능을 사용하기 위함이다 ??????

---
# Anotation
### @Controller
컨트롤러(Controller)는 웹 클라이언트에서 들어온 요청을 해당 비지니스 로직으로 호출하고, 수행결과와 함께 응답해주는 Dispatcher 역할을 한다.
### @RequestMapping
RequestMapping은 요청 URL을 의미한다.

---
