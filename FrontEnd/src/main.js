import { createApp } from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import BootstrapVue3 from 'bootstrap-vue-3'
import "aos/dist/aos.css";

import { library } from '@fortawesome/fontawesome-svg-core'
import { faCheck } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
library.add(faCheck)

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'


createApp(App).use(router).use(store).use(BootstrapVue3).component("font-awesome-icon", FontAwesomeIcon).mount('#app')
