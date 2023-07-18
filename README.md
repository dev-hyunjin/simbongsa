# simbongsa |<a href="http://www.simbongsa.site/main/"> JPA 프로젝트 : 봉사, 후원, 펀딩, 커뮤니티 종합 플랫폼 서비스(http://www.simbongsa.site/main/)</a>

# 🖥️ 프로젝트 소개
기존 운영되고 있는 봉사활동 사이트들과는 차별화된 서비스를 제공하고자 봉사 말고도 펀딩, 후원, 커뮤니티 등 다양한 기능을 추가로 결합한 서비스
봉사활동을 통해 적립한 포인트를 입시나 취업 등 자격증명에 활용할 수 있으며 이 포인트를 사용하여 후원과 펀딩을 할 수 있어
봉사자들에게 보상감을 제공하고 어려운 사람들을 돕는 사회적 가치를 실현한다.


<br>
 🕰️ 개발 기간
* 23.04.11 - 23.05.25 (6주)

### 🧑‍🤝‍🧑 멤버구성 - 백엔드 업무
 - 팀장  : 황자현 - 메인페이지, 봉사, 후원
 - 부팀장 : 문은서 - 펀딩
 - 팀원1 : 김주연 - 로그인, 회원가입, PW찾기, 마이페이지
 - 팀원2 : 김서현 - 커뮤니티 게시판
 - 팀원3 : 정현진 - 관리자페이지, 복지센터 검색, 고객센터
 
 
 # 프로젝트 목적 
 지역사회 발전을 위해 봉사활동의 중요성을 인식시키고, 다양한 연령층의 봉사활동 참여를 유도하기위한 목적
 
 # 기획배경
 ![image](https://github.com/coder-juyeon/simbongsa/assets/122768623/282ae3e9-2510-4210-aba9-20d945d85483)<br>
 
현재의 봉사 참여 방식은 일관성이 없거나 개인의 우려와 필요를 고려하지 못하는 경우가 있어 참여자들의 경험을 개선하고, 
더욱 의미 있는 봉사 활동을 할 수 있는 기획을 목표로 기획

 # 목적 및 기대 효과
 ![image](https://github.com/coder-juyeon/simbongsa/assets/122768623/eb9067b4-6db7-4f51-973f-b71bfb2151ea)<br>

- 다양한 봉사 활동 체험 : 다양한 봉사 활동 체험을 통해 누구나 손쉽게 봉사활동에 참여 할 수 잇는 기회를 제공
- 자발적 참여 유도 :  봉사활동을 통해 적립한 포인트를 후원할 수 있는 방식으로 봉사자들에게 보상감을 제공, 
 후원자들은 포인트를 사용하여 후원을 할 수 있는 기회를 제공하여 봉사활동과 후원 모두에 대한 관심과 참여를 유도
- 청년층 참여 활성화 : 사회 구성원들 간의 연대와 협력을 촉진하여 사회적 유대감과 상호의존성을 강화
- 봉사활동 공유 문화 확산 : 후원과 펀딩을 통해 봉사활동을 지원하는 모든 사람들이 함께 사회적 책임과 가치를 공유하는 문화를 확산시키며, 지속 가능한 사회 발전에 기여


## ⚙️ 개발 환경
- java
- jQuery
- Thymeleaf
- QueryDSL
- JPA
- Spring Boot
- HTML, CSS, JS
- Oracle
- JDK 11.0.15
- YAML
- JSON
- REST:API
- Sourcetree
- DBeaver
- IntelliJ IDEA
- git, gitHub
- JUnit5
- POSTMAN
- Lombok
- Boot pay
- Naver OAuth
- Kakao OAuth
- SMTP

 # 📌 프로젝트에서 맡은 역할 
- 서비스 기획 및 전반적인 디자인 업무 수행
- 프론트 업무 : 메인페이지, 서비스소개페이지, 복지센터
- 백엔드 업무 : 회원가입, 로그인, 비밀번호찾기, 마이페이지

### 프론트 진행 - <a href="https://github.com/coder-juyeon/simbongsa/wiki/front" > 상세보기 - WIKI 이동</a>
- 메인페이지 
- 서비스소개페이지
- 복지센터 
- 오류페이지

### 백엔드 진행 - <a href="https://github.com/coder-juyeon/simbongsa/wiki/backend" >상세보기 - WIKI 이동</a>
##### 로그인/회원가입
- 회원가입
- 로그인
- OAuth 2.0
- Security
- 비밀번호찾기

##### 마이페이지
- 후원요청목록
- 작성한게시물
- 내문의사항
- 봉사활동내역
- 후원내역
- 공양미내역
- 공양미환전요청
- 회원정보수정
- 공양미충전

# ERD
<img width="1025" alt="심봉사_디비버_ERD" src="https://github.com/coder-juyeon/simbongsa/assets/122768623/84c83553-c765-4d5e-b790-69a9c199fb54">

# 프로젝트에서 느낀점
어려웠던 부분 : 시큐리티와 오어스의 개념이 어려웠습니다. 시큐리티의 개념을 이해하는데도 한참 걸렸으며, 인증과 인가의 개념이 헷갈렸고, 오어스를 시큐리티로 처리해야 하는데 자료가 별로 없어서 여러 자료를 찾아보고 유튜브를 통해 강의를 듣기도 했습니다.

극복방법: 시큐리티와 오어스를 맡은 각 팀원들과 함께 작업 진행 상황을 공유하고, 발생하는 문제에 대해 서로의 의견을 나누는 미팅을 주기적으로 진행하면서 최적의 해결 방법을 찾아갔고 이 도전을 함께 극복할 수 있었습니다.

문제 : OAuth2를 Spring Security로 통합하는 과정에서 오류가 많았는데, 오어스 코드를 구현하니 일반회원의 시큐리티 권한설정이 작동되지 않는 오류가 있었습니다.

해결 : 문제점이 무엇인지 구글링을 통해 알아보았는데, Spring Security의 UserDetails 인터페이스가 사용자의 세부 정보를 저장하고 관리하는 역할을 하는 것을 알게 되었습니다. 따라서, 사용자에게 부여된 권한을 GrantedAuthority 객체의 컬렉션으로 반환하는 getAuthorities() 메소드를 오버라이드하여 문제를 해결했습니다. 이 지식을 팀원들에게 공유하며 해결해 나갔고 서로서로 협업하며 프로젝트를 성공적으로 완료할 수 있었습니다. 

총평: 이러한 경험을 통해 팀원들과의 소통과 협업의 중요성을 느끼게 되었습니다. 또한, 새로운 기술을 적용하고 도전적인 문제 해결에 대한 자신감을 얻을 수 있었습니다. 입사 후에도 팀원들과의 소통과 협업을 통해 제 역할을 더욱 효과적으로 수행하고, 팀과 조직의 성공에 기여할 것입니다.

