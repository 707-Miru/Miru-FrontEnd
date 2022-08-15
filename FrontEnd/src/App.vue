<template>
  <div id="app">
    <nav-bar class="nav"></nav-bar>
    <router-view/>
    <footer><a href="https://www.flaticon.com/free-icons/pond" title="pond icons">Pond icons created by Nikita Golubev - Flaticon</a></footer>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import store from './store'
import NavBar from '@/components/NavBar.vue'


export default {
  name : 'App',

  components: { NavBar },

  methods: {
    ...mapActions(['fetchCurrentUser'])
  },
  created () {
    if (store.getters.currentUserId) {
      console.log(store.getters.currentUserId)
      this.fetchCurrentUser(store.getters.currentUserId)
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
