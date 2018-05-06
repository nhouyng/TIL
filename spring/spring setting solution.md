# spring mvc project setting solution
1. spring mvc project 생성
- File > New > Other > Spring > Spring Legacy Project 선택
- Project name 입력 > Templates > Spring MVC Project 선택
- package 입력; 3-level 규칙(com.company.webname) > Finish
- Maven이 인터넷에서 필요 라이브러리 설치 과정(인내)
- pom.xml > properties > springframework-version 수정 (http://projects.spring.io/spring-framework/ spring 버전 확인)
- Project 우클릭 > Properties > Project Facets > Java > Version 수정 (본인 JDK version) > Apply
- Servers 추가(기존 Servers 제거) 후 서버 실행
  - 아래 ERROR 발생 시 error book 참조
  - 8080 port ERROR
  - starting tomcat v9.0 server at localhost has encountered a problem
- http://localhost:8000/WEB_PROJECT_NAME 결과확인

2. web.xml 수정
- webapp/index.jsp 추가
- spring.md > web.xml > web 기본 페이지 설정 코드 추가
- spring.md > web.xml > servlet 설정 코드 변경

3. pom.xml <dependency> 추가
