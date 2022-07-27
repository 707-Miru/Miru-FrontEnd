<template>
  <div>
    <b-form @submit="signup(credentials)" @reset="onReset" class="background">
      <b-form-group 
          id="input-group-1"
          label="아이디:"
          label-for="input-1"
          description="We'll never share your email with anyone else."
        >
        <div class="check">
          <b-form-input
            id="input-1"
            v-model="credentials.id"
            type="text"
            placeholder="Enter username"
            required
          ></b-form-input>
          <b-button pill id="check" class="idcheck" v-if="check" @click="checkId(credentials.id)">체크</b-button>
          <font-awesome-icon icon="fa-solid fa-check" v-else/>
        </div>
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
import axios from 'axios'
import { mapGetters } from 'vuex'
import drf from '@/api/drf'

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
      check: 1
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

    checkId (id) {
      axios({
        url:drf.accounts.checkId(id),
        method:'get',
      })
      .then(res => {
        if (res === 1) {
          alert("중복된 아이디가 있습니다.")
        } else if (res === 0) {
          this.check = res
        }
      })
    },
  },
}
</script>

<style scoped>
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
.check {
  display: flex;
  align-items: center;
  height: 40px;
  font-size: 5px;
}

.idcheck {
  height: 40px;
  font-size: 5px;
  width: 60px;
  height: 30px;
}

/* input {
  height: 40px;
} */

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

button {
  margin: 5px;
}
</style>