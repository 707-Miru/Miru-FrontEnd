import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '@/views/LoginView.vue'
import SignupView from '@/views/SingupView.vue'



const routes = [
  {
    path : "/login",
    name : "LoginView",
    component : LoginView,
  },
  {
    path : "/signup",
    name : "SignupView",
    component : SignupView,
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
