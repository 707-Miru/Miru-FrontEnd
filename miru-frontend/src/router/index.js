import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '@/views/LoginView.vue'
import SignupView from '@/views/SingupView.vue'
import HomeView from '@/views/HomeView.vue'
import FindPassWordView from '@/views/FindPassWordView.vue'
import ResetPassWordView from '@/views/ResetPassWordView.vue'


const routes = [
  {
    path : "/",
    name : "HomeView",
    component : HomeView,
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
  }


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
