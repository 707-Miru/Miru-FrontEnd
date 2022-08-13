<template>
  <div>
    <h3>비밀번호를 재설정하고자 하는 아이디를 입력해 주세요.</h3>
    <b-form-input type="text" v-model="id" placeholder="Miru 아이디"></b-form-input>
    <b-button @click="checkId(id)">다음</b-button>
    <h4 ref="email"></h4>
    
    <img src="@/assets/email.png" alt="" v-if="check" @click="sendEmail">

  </div>

</template>

<script>
import axios from 'axios'
import drf from '@/api/drf'

export default {
  name: 'FindPassWordView',

  data () {
    return {
      id : '',
      email: '',
      check: 0
    }
  },

  methods: {
    checkId (id) {
      axios({
        url:drf.accounts.checkId(id),
        method:'get',
      })
      .then(res => {
        if (res.data === 1) {
          console.log(res)
          this.check = res.data
          // this.$ref.email.innerText = res
        } else if (res.data === 0) {
          this.check = res.data
        }
      })
    },

    sendEmail (id) {
      axios({
        url:drf.accounts.sendEmail(id),
        method:'get',
        params:{
          'email':this.email
        }
      })
      .then(
        console.log('!!!')
      )
    }
  }

}
</script>

<style>

</style>