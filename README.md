# 오늘 한 일

Vue 프로젝트 시작 방법

```
npm install -g @vue/cli # 또는 yarn global add @vue/cli
vue create hello-vue3
# select vue 3 preset
```

vuex 및 vue-router 시작방법

```
vue add vuex
vue add router
```

bootstrap 시작방법

```
npm install bootstrap bootstrap-vue-3
```

main.js/ts

```
import {createApp} from 'vue'
import BootstrapVue3 from 'bootstrap-vue-3'

// Optional, since every component import their Bootstrap functionality
// the following line is not necessary
// import 'bootstrap'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'

const app = createApp(App)
app.use(BootstrapVue3)
app.mount('#app')
```

## Git

0000(날짜) SH Add Fix Set Delete filename (method, class) + alpha



## 디자인시 컬러에 관해

1. 명도, 채도
   1. 명도와 채도를 맞춰서 사용하는 것이 통일감을 줘서 좋다.
2. 주요색상을 정한다
   1. 주요 색상을 정한 후 주요생상의 채도에따라 사용 비율을 정한다.
3. 보조 색상 및 강조 색상을 정한다.
4. 상황에 따른 상호작용 색상을 정한다.
5. 무채색상을 정한다.
6. UI에서 추가로 필요한 요소들의 색상을 정한다.



## API_명세서 작성

- API 명세서의 초안을 작성했습니다.



## Vue 환경설정

- 프로젝트에서 사용할 Vue 프로젝트를 생성했습니다.
- 프론트엔드 팀원들과 Vue코드 네이밍 컨벤션을 진행했습니다.
