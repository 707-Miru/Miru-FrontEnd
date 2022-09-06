import { createRouter, createWebHistory } from 'vue-router'
import MainView from '@/views/MainView'
import LoginView from '@/views/LoginView.vue'
import SignupView from '@/views/SingupView.vue'
import FindPassWordView from '@/views/FindPassWordView.vue'
import ResetPassWordView from '@/views/ResetPassWordView.vue'
import NotFoundView from '@/views/NotFoundView'

import SearchPictureView from '@/views/SearchPictureView.vue'
import PictureView from '@/views/PictureView.vue'
import MyAlbumView from '@/views/MyAlbumView.vue'
import PhotoDetailView from '@/views/PhotoDetailView.vue'
import store from '../store'


const routes = [
  {
    path: '/',
    name: 'MainView',
    component: MainView
  },
  {
    path : "/login",
    name : "LoginView",
    component : LoginView,
  },
  {
    path : "/signup",
    name : "SignupView",
    component : SignupView,
  },
  {
    path : "/findpw",
    name : "FindPassWordView",
    component : FindPassWordView,
  },
  {
    path : "/resetpw",
    name : "ResetPassWordView",
    component : ResetPassWordView,
  },
  {
    path: '/picture',
    name: 'PictureView',
    component: PictureView
  },
  {
    path : "/myalbum",
    name : "MyAlbumView",
    component : MyAlbumView,
  },
  {
    path : "/picture/detail",
    name : "PhotoDetailView",
    component : PhotoDetailView,
  },

  {
    path : "/search/:keyword",      
    name : "SearchPictureView",
    component : SearchPictureView,
  },
  {
    path: '/:catchAll(.*)',
    name: 'NotFoundView',
    component: NotFoundView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

router.beforeEach((to, from, next) => {
  // 이전 페이지에서 발생한 에러메시지 삭제
  store.commit('SET_AUTH_ERROR', null)

  const { isLoggedIn } = store.getters


  const noAuthPages = ['LoginView', 'SignupView', 'FindPassWordView', 'MainView', 'PictureView', 'MyAlbumView']


  const isAuthRequired = !noAuthPages.includes(to.name)

  if (isAuthRequired && !isLoggedIn) {
    alert('Require Login. Redirecting..')
    next({ name: 'LoginView' })
  } else {
    next()
  }
  if (!isAuthRequired && isLoggedIn) {
    next({ name: 'MainView' })
  } 
})

export default router
