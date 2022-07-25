<template>
<div>
  <b-form @submit="login" @reset="onReset" class="background">
    <b-form-group 
        id="input-group-1"
        label="아이디:"
        label-for="input-1"
        description="We'll never share your email with anyone else."
      >
        <b-form-input
          id="input-1"
          v-model="credentials.username"
          type="username"
          placeholder="Enter username"
          required
        ></b-form-input>
    </b-form-group>
    <b-form-group
        id="input-group-2"
        label="비밀번호:"
        label-for="input-2"
      >
        <b-form-input
          id="input-2"
          v-model="credentials.password"
          type="password"
          placeholder="Enter password"
          required
        ></b-form-input>
    </b-form-group>
    <div class="d-flex justify-content-between">
      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </div>
  </b-form>
  

 
</div>

</template>

<script>
// import * as _ from 'lodash'
import { mapActions, mapGetters } from 'vuex'
// import axios from 'axios'


export default {
  name: 'LoginView',

  data () {
    return {
      credentials : {
        username: '',
        password: ''
      },
      url : 'https://image.tmdb.org/t/p/w500/',
      path : ''
    }
  },
  methods: {
    ...mapActions(['login']),
    onReset () {
      this.credentials.username = ''
      this.credentials.password = ''
    }
  },
  computed: {
    ...mapGetters(['authError'])
  },

}
</script>

<style scoped>
#appMountPoint {
  height: auto;
}
.background {
  margin: auto;
  background-image: url("@/assets/frame.png");
  width: 512px;
  height: 750px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  
  
}
#input-group-1 {
 
  top: 300px;
  width: 60%;
  
  
  
}
#input-group-2 {
  width: 60%;
  
  
  
  
}
</style>