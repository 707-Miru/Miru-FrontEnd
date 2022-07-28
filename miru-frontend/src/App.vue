<template>
  <nav>
    <router-link to="/login">Login</router-link> |
    <router-link to="/signup">Signup</router-link>
  </nav>
  <router-view/>
</template>

<script>
import { mapActions } from 'vuex'
import store from './store'


export default {
  name : 'App',

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
