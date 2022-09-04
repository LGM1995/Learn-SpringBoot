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

### Run 03 레이아웃
#### header - content - footer
#### 헤더와 풋터를 미리 만들어 놓고 페이지에서 변수처럼 불러서 사용한다.

### Run 04 Form
#### 입력폼 만들기
#### form 데이터를 DTO로 객채로 받기

### Run 05 DB연결
#### DTO가 넘길 정보를 Entity가 받게 하여 DB로 넘어갈수 있게끔 설정한다.
#### h2 DB를 사용하며 main/resources에 application.properties에서 spring.h2.console.enabled=true 의 설정값을 입력한다.
#### Lombok 사용 필수기능을 간소화하여 코드 리펙토링 작업을 한다.

### Run 06 데이터 조회
#### JPA를 사용하여 데이터를 조회할 수 있다.

### Run 07 데이터를 ArrayList로 받기
#### Entity의 데이터를 ArrayList로 받아 mustache에서 데이터를 반복하여 활용한다.

### Run 08 Link 와 Redirect 사용하기
#### 페이지의 자연스러운 이동과 연결을 위해 Link 와 Redirect를 사용하여 페이지간 이동 흐름을 자연스럽게 한다.

### Run 09 update 페이지 만들기
#### form 은 get과 post만 지원함

### Run 10 RestAPI
#### 모든 클라이언트(핸드폰, 테블릿, 워치, CCTV등)가 사용할 수 있도록 화면을 보내는게 아니고 데이터를 보내준다
#### 데이터를 보낼때는 XML과 JSON으로 보내는 것이 가능하며 JSON(자바스크립트에서 사용이 가능한 객체적 표현)이 추세이다


### Run 11 RestController 와 일반 Controller
#### RestController는 텍스트나 JSON을 반환하는 반면에 Controller는 View를 반환한다.

### Run 12 Service 계층
#### RestController와 Repository 사이에 Service 계층을 추가하여 처리 업무의 순서를 총괄함
#### 트랜잭션은 일련의 과정 전체를 예기한다. 
#### 만약 식당에 예약 시스템이 중간에 실패 된다면 이 일련의 과정은 초기화 되어 다시 진행되어야 하며 이를 롤백이라 한다.

### Run 13 TDD(Test Driven Development)
#### 테스트 코드를 만들어 통과한 최소한의 고트에 대해서 개선을 하는 작업을 말한다.

### Run 14 PK and FK
#### 프라이머리키와 포린키는 너무 어렵게 생각할거 없이 자신의 상태를 나타내는 것으로 pk는 자신을 fk는 대상을 예기한다.
#### 예를 들어 사람들의 아이디를 pk라 본다면 그들이 댓글을 남긴 댓글의 번호를 fk로 보면 된다.
