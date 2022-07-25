<template>
  <div>
    !!23
  </div>
</template>

<script>

// import axios from 'axios'
// import drf from '@/api/drf'
import { mapGetters } from 'vuex'

export default {
  name:'SignupView',

  data() {
    const formData = new FormData()
    return{
      credentials:{
        username: '',
        password1: '',
        password2: '',
        
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
      this.credentials.password1 = '',
      this.credentials.password2 = ''
    },

    signup () {
      this.formData.append("username", this.credentials.username)
      this.formData.append("password1", this.credentials.password1)
      this.formData.append("password2", this.credentials.password2)
      this.$store.dispatch('signup', this.formData)
      
    },
  },
}
</script>

<style>

</style>