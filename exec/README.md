# 오늘의 모네

<p align="center">
  <br>
  <img src="./images/sample.jpeg">
  <br>
</p>

## 목차
- [기술 스택](#기술-스택)
- [구현 기능](#구현-기능)
  - [역할 분담](#역할-분담)
- [시연 시나리오](#시연-시나리오)
- [프로젝트 회고](#프로젝트-회고)

## 프로젝트 소개
### 프로젝트 동기
  1. 기존 디지털 액자 서비스는 사용자가 직접 업로드 한 사진만을 이용할 수 있었기 때문에 다양한 사진을 액자로 활용하기 어렵다.
  2. 단순히 사진을 띄워주기만 하기 때문에 기능이 부족하다.
  3. 움직이는 사진을 지원하지 않았다.

### 프로젝트 개요
    1. 사용자가 직접 업로드 한 사진뿐 아니라, 서버에서 제공하는 사진 모두를 액자의 배경으로 사용할 수 있다. <br>
    2. 지정한 사진을 21가지 중 사용자가 선택한 화풍을 적용한 사진으로 변경하는 기능을 제공한다.<br>
    3. 용자가 직접 사진을 등록하면 해당 사진의 화풍을 다른 사진에 적용할 수 있다.<br>
    4. 사용자가 선호하는 사진과 사용자 위치에 기반한 날씨에 따라 사진 추천 서비스를 제공한다.<br>
    5. 핸드 트래킹을 이용하여 액자를 손쉽게 컨트롤 할 수 있다.<br>

## 기술 스택
### 공통

- GitLab
- Jira
- Mattermost
- Webex

### BackEnd 


| Java   | SpringBoot | MySQL  | MyBatis | Node.js |
| :----: | :--------: | :----: | :-----: |:------: |
| Java 8 |   5.3.19   | 8.0.30 | 3.5.9   | 18.7.0  |

| Ubuntu(EC2) | Docker   | Jenkins | Raspbian | IntelliJ IDEA                |
| :---------: | :------: | :-----: | :------: | :--------------------------: |
| 20.04.4     | 20.10.17 | 2.346.3 | Latest   | 2022.1.2 (Ultimate Edition)  |

### FrontEnd 


|    Vue     | vuex  | bootstrap | eslint |  aos  |
| :--------: | :---: | :-------: | :----: | :---: |
| Vue 3.2.13 | 4.0.0 |   5.2.0   | 7.32.0 | 2.3.4 |

| axios  | lodash  | core-js | vue-router | Visual Studio Code |
| :----: | :-----: | :-----: | :--------: | :----------------: |
| 0.27.2 | 4.17.21 |  3.8.3  |   4.0.3    |       1.70.0       |



#### Build

- SpringBoot

1. Dockerfile
``` bash
FROM openjdk:8\-jdk\-alpine
ARG JAR\_FILE\=\*.jar
COPY ${JAR\_FILE} app.jar
ENTRYPOINT \["java","-jar","/app.jar"\]
```

- java 8 사용
- 현 경로에서의 jar 파일을 파라미터로 하여 app.jar로 전달
- java -jar app.jar 명령어를 수행하는 이미지 생성
- docker build -t [컨테이너명] [Dockerfile 경로]

<br>

2. 수동 Build
``` bash
mvn clean build
```

<br>

- Vue
1. npm 설치
``` bash
npm i npm
npm i -g @vue/cli-service
npm i -g @vue/cli-plugin-babel
npm i -g @vue/cli-plugin-eslint
```

2. Vue Build
``` bash
npm i
````
dependancy에 등록된 패키지 전부 설치

``` bash
npm run build
```
dist 폴더 생성

3. Vue 실행

```bash
npm run serve
```

<br>

- MySQL

1. 컨테이너 생성
``` bash
docker run --name [컨테이너명] -e MYSQL_ROOT_PASSWORD='[패스워드]' -d -p [외부포트]:[내부포트] [이미지명]
````

2. MySQL 접속
``` bash
docker exec -it [컨테이너명] bash
mysql -u root -p
```

<br>

## 구현 기능

- 회원 관리

### 역할 분담
- Back end
  - 권민지 : 
  - 정태영 : 
  - 조준식 : 회원 관리, 사진 조회, 데이터베이스 설계 및 구축, AWS 서버 설계 및 구축, Jenkins 자동 빌드

- Front end
  - 엄윤규 : 
  - 오현규 : Nav-bar, 메인뷰 애니메이션 추가, Figma 초안 작성, Jira 스프린트 관리, 로고 제작, 중간 발표 PPT/대본 작성, 광고 UCC/시연 영상 제작
  - 이상현 : 

## 시연 시나리오
### 기능 1

### 기능 2

### 기능 3

### 기능 4

<br>

## 프로젝트 회고

1. keep(만족한 것)
- 프로젝트 및 Git Commit 네이밍컨벤션 정의
- API 명세서를 정의한 것
- 프로젝트 진행의 흐름을 경험할 수 있었던 것
- 보완할 점/부족한 점을 알 수 있게된 것

2. problem(불편했던 것)
- 실시간 자원 접근이 안 되는 것
- 무중단 배포가 안 되는 것
- Refrash Token을 사용하지 않은 것
- 자신이 맡지 않은 포지션(Back/Front)에서 어떤 작업을 하고 있는지 이해와 소통이 부족했던 것
- 일정 관리가 원활하지 않아 제품의 완성도를 챙기지 못한 것

3. try(개선 방법)
- EC2뿐만 아니라 AWS 여러 자원, 특히 S3 사용하기
- Spring Security를 같이 사용하여 보안 설정하기
- Jenkins에서 Shell script와 pipeline을 이용하여 Build 구성하기
- 주 단위나 격주 단위로 프로젝트 현재 상황 브리핑 시간을 가지고 대처하기
- 각 기능을 구현하는 데 걸리는 시간을 최대한 보수적으로 계산하고 기획하여 최종 산출물 완성도 높이기


