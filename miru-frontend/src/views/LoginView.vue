<template>
<div>
  <b-form @submit="login(credentials)" @reset="onReset" class="background">
    <b-form-group 
        id="input-group-1"
        label="아이디:"
        label-for="input-1"
        description="We'll never share your email with anyone else."
      >
        <b-form-input
          id="input-1"
          v-model="credentials.id"
          type="text"
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
      <b-button type="submit" variant="primary">로그인</b-button>
      <b-button type="reset" variant="danger">초기화</b-button>
    </div>
    <router-link
      :to="{ name: 'SignupView' }"
      class="text-decoration-none  float-end">
      <br>
      <h6 class="d-flex justify-content-center">아직 회원이 아닌가요?</h6>
      <b-button class="btn-signup w-30" style="display: block; margin: 0 auto">회원가입</b-button>
    </router-link>  
    <router-link
      :to="{ name: 'FindPassWordView' }"
      class="text-decoration-none  float-end">
      <br>
      <h6 class="d-flex justify-content-center">비밀번호를 까먹으셨나요?</h6>
      <b-button class="btn-signup w-30" style="display: block; margin: 0 auto">비밀번호 재설정</b-button>
    </router-link>    
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
        id: '',
        password: ''
      },
    }
  },
  methods: {
    ...mapActions(['login']),
    onReset () {
      this.credentials.id = ''
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

button {
  margin: 5px;
}
</style>