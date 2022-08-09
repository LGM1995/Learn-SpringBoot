# Clone_Quizlet

## 본 프로젝트는 클론코딩으로 스터디 웹 어플리케이션 퀴즐렛을 클론코딩하는 프로젝트이다.
## 상업적 목적은 없으며 디자인보다는 기능구현을 최종목표로 한다.

### 본 프로젝트는 스트링부트를 활용한다.


### Run 01 spring boot 개발환경 조성
#### homebrew 설치 : 구글에 homebrew 설치를 검색하여 터미널에 명려얼를 입력
#### jdk 설치 : 기업에서 주로 활용하는 openjdk8버전이 있으나 나는 최신버전을 사용
#### IJ에서 자바컴파일과 런실행시 설정값이 17버전으로 되어있는 오류 발생
####  -> preferences에서 gradle jvm 버전을 변경
####  -> IJ우측 상단에서 Run/Debug Configurations의 build and run을 java 18버전으로 변경 
#### localhost8080:CQ.html을 통해 웹페이지 접속
#### src/main/java/com/exampl/clone_quizlet/CloenQuizletApplication 의 메인을 실행시켜야 서버가 동작하며 웹페이지 연결가능

### Run 02 MVC 패턴
#### 간단하게 말해 웹페이지에 틀을 만들고 사용자에 따라 변할수 있게 만드는 패턴
#### 컨트롤러를 통해 페이지를 띄웠으나 한글깨짐이 있어서 스트링부트를 다운그레이 했다.
