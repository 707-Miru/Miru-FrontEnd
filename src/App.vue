<template>
  <div id="app">
    <nav-bar class="nav" v-if="checked"></nav-bar>
    <router-view/>

  <footer class="text-center text-white">
    <!-- Copyright -->
    <div class="text-center text-dark p-3" style="background-color: #white;">
      © 2022 Copyright:Miru ENT.
    </div>
    <div>
      <a style="color:darkslateblue" href="https://www.flaticon.com/free-icons/pond" title="pond icons">Pond icons created by Nikita Golubev - Flaticon</a>
    </div>      
    <!-- Copyright -->
  </footer>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import store from './store'
import NavBar from '@/components/NavBar.vue'


export default {
  name : 'App',

  data () {
    return {
      'checked': true
    }
  },

  components: { NavBar },

  methods: {
    ...mapActions(['fetchCurrentUser'])
  },
  created () {
    if (store.getters.currentUserId) {
      console.log(store.getters.currentUserId)
      this.fetchCurrentUser(store.getters.currentUserId)
   }

    if (document.location.pathname === '/login') {
      this.checked = false
    }

    if (document.location.pathname === '/signup') {
      this.checked = false
    }
  }
}
</script>


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}


</style>
