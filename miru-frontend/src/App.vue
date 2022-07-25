<template>
  <!-- <nav>                    # Vue 자동 생성된 코드입니다. 코드 복붙하며 임시로 주석 처리해놨고, 삭제해도 OK.
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </nav> -->
  
  <div id="app">
    <nav-bar class="nav"></nav-bar>
    <router-view></router-view>
  </div>

  <router-view/>
</template>


<script>
  import NavBar from '@/components/NavBar.vue'

  export default {
    name: 'App',
    components: { NavBar },
    methods: {
      // ...mapActions(['fetchCurrentUser'])  # 코드 복붙하면서 같이 끌고 온 코드입니다. 삭제해도 OK.
    },
    created() {
      // this.fetchCurrentUser()              # 코드 복붙하면서 같이 끌고 온 코드입니다. 삭제해도 OK.
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
