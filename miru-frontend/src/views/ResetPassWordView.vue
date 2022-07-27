<template>
  <div>
    <h3>비밀번호 재설정</h3>
    <b-form @submit="changePassWord(credentials)">
    <b-form-group 
        id="input-group-1"
        label="비밀번호:"
        label-for="input-1"
        description="We'll never share your email with anyone else."
      >
        <b-form-input
          id="input-1"
          v-model="credentials.password"
          type="password"
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
          v-model="credentials.password2"
          type="password"
          placeholder="Enter password"
          required
        ></b-form-input>
    </b-form-group>
    <b-button type="submit" variant="primary">비밀번호 변경</b-button>
    </b-form>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  name: 'ResetPassWordView',
  
  data () {
    return {
      credentials:{
        password:'',
        password2:''
      }
    }
  },

  methods: {
    ...mapActions(['changePassWord'])
  }

}
</script>

<style>

</style>