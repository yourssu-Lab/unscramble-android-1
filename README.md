## unscramble-android-1

🛠 **뒤죽박죽 되어 있는 스펠링을 보고 원래 단어를 맞추는 게임**🛠

### 필수 조건
- YDS TextField & Button 사용해보기
- Clean Architecture
- 레파지토리 패턴
    - 랜덤으로 단어를 레퍼지토리에서 가져오기. String array resource
    - getWord() : Repository
- LiveData & Viewmodel
    - 타이머 구현, 점수, process
  
 ### 기술 정리

- MVVM + MVI
- xml
- Flow
- hilt
- base
- YDS
### Branch name
- 개인 개발 브랜치
  ` feature/{nickname}/{feature-name}`
- 공용 개발 브랜치
  `feature/{feature-name}`

### 예시
- 개인 브랜치 → develop
> feature/mint/search → develop
> feature/harry/search → develop
> feature/peter/search → develop

- 공용 브랜치 → develop
> feature/search → develop

- 개인 브랜치 → 공용 브랜치
> feature/peter/search → feature/search


### PR Title
`[<repo name>-#<issue num>] <title>`
- repo name은  UA1

### ✏️ Commit Convention
`<타입> : <제목> 형식으로 작성하며 제목은 최대 50글자 정도로만 입력`
- 제목 끝에 마침표 금지, 무엇을 했는지 명확하게 작성
- 추가 설명을 아랫줄에 작성(생략 가능)

### 🏷️ Type
- add: Feat 이외의 부수적인 코드 추가, 라이브러리 추가, 새로운 View나 Activity 생성
- chore: 코드 수정, 내부 파일 수정
- correct: 주로 문법의 오류나 타입의 변경, 이름 변경 등에 사용
- del: 쓸모없는 코드 삭제
- docs: README나 WIKI 등의 문서 개정
- feat: 새로운 기능 구현
- fix: 버그, 오류 해결
- move: 프로젝트 내 파일이나 코드의 이동
- refactor: 리팩토링
- rename: 파일 이름 변경이 있을 때 사용

### 🗒️ [1팀 노션](https://www.notion.so/yourssu/unscramble-1-e574482745f6450fa64ef434b9cfaa80?pvs=4)
