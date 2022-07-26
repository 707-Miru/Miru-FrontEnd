<template>
  <div>
    <b-form @submit="signup(credentials)" @reset="onReset" class="background">
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
          label="e-mail:"
          label-for="input-2"
        >
          <b-form-input
            id="input-2"
            v-model="credentials.email"
            type="email"
            placeholder="Enter email"
            required
          ></b-form-input>
      </b-form-group>

      <b-form-group 
          id="input-group-3"
          label="비밀번호:"
          label-for="input-3"
        >
          <b-form-input
            id="input-3"
            v-model="credentials.password"
            type="password"
            placeholder="Enter password"
            required
          ></b-form-input>
      </b-form-group>

      <b-form-group
          id="input-group-4"
          label="비밀번호2:"
          label-for="input-4"
        >
          <b-form-input
            id="input-4"
            v-model="credentials.password2"
            type="password"
            placeholder="Enter password2"
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

import { mapGetters } from 'vuex'

export default {
  name:'SignupView',

  data() {
    const formData = new FormData()
    return{
      credentials:{
        id: '',
        email: '',
        password: '',
        password2: '',
        recommendFlag: 1
      },
      formData : formData,
    }
  },
  computed:{
    ...mapGetters(['authError']),
  },
  methods:{
    onReset () {
      this.credentials.username = '',
      this.credentials.email = '',
      this.credentials.password1 = '',
      this.credentials.password2 = ''
    },

    signup () {
      this.$store.dispatch("signup", this.credentials)
      
    },
  },
}
</script>

<style>
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

#input-group-3 {
  width: 60%;
}

#input-group-4 {
  width: 60%;
}
</style>