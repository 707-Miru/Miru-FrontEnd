import { createApp } from 'vue'
import App from './App.vue'

import BootstrapVue3 from 'bootstrap-vue-3'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'

import store from './store'
import router from './router'

createApp(App).use(router).use(store).use(BootstrapVue3).mount('#app')
