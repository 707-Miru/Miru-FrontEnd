<template>
  <div class="find">
    <div class="findform">
      <h5>비밀번호를 재설정하고자 하는 아이디를 입력해 주세요.</h5>
      <b-form-input type="text" v-model="id" placeholder="Miru 아이디" class="findinput"></b-form-input>
      <b-button @click="checkId(id)">다음</b-button>
      
      <div v-if="check">
        <b-form-input type="text" v-model="email" placeholder="Miru 이메일"></b-form-input>
        <img src="@/assets/email.png" alt=""  @click="sendEmail" class="sendimg">
      </div>
    </div>

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


.find {
  background-image: url("@/assets/images/user.png");
  background-size: cover;
  height: 900px;
  width: 100%;
  display: flex;
  align-items: center;
}

.findform {
  height: 650px;
  width: 500px;
  border: 1px solid black;
  margin: auto;
  margin-top: 50px;
  background-color: rgba(55, 204, 214, 0.4);
  border-radius: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;  
  justify-content: center;
  
}

.findform * {
  width: 80%;
  margin: 10px;
}

.sendimg {
  width: 63px;
  height: 60px;
}

.findinput {
  width: 80% !important;
}
</style>