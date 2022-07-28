import router from "@/router"
import drf from '@/api/drf'
import axios from 'axios'


export const accounts = {
  state:{
    token : localStorage.getItem('token') || '',
    currentUser: {},
    currentUserId : localStorage.getItem('currentUser') || '',
    authError: null,
  },

  getters:{
    currentUserId : state => state.currentUserId,
    isLoggedIn : state => !!state.token,
    authHeader  (state) {
      return {"token": state.token}
    },
    currentUser : state => state.currentUser,
    authError: state => state.authError,
  },

  mutations:{
    SET_TOKEN (state, token) {
      state.token = token
    },
    SET_CURRENT_USER : (state, user) => state.currentUser = user,
    SET_AUTH_ERROR: (state, error) => state.authError = error,
  },

  actions:{
    saveToken ({ commit }, token) {
      commit('SET_TOKEN', token)
      localStorage.setItem('token', token)   // 새로고침 후에도 유지
    },
    
    removeToken ({ commit }) {
      commit('SET_TOKEN', '')
      localStorage.setItem('token', '')
    },

    removeCurrentUser ({ commit }) {
      commit('SET_CURRENT_USER', {})
      localStorage.setItem('currentUser', '')
    },

    login ({ dispatch, commit }, credentials) {
      axios({
        url: drf.accounts.login(),
        method: 'post',
        data: credentials
      })
      .then(res => {        
        console.log(res)
        dispatch('saveToken', res.data.token)
        dispatch('fetchCurrentUser', credentials.id)
        router.push({name:'HomeView'})
      })
      .catch(err => {
        // console.error(err)
        commit('SET_AUTH_ERROR', err.response.data)
      })         
    },

    signup ({ dispatch, commit }, credentials) {
      axios({
        url : drf.accounts.signup(),
        method : 'post',
        data : credentials,
      })
      .then(res => {
        dispatch('saveToken', res.data)
        dispatch('fetchCurrentUser', credentials.id) 
        router.push({name:'HomeView'})   
      })
      .catch(err => {
        console.error(err.response.data)
        commit('SET_AUTH_ERROR', err.response.data)
      })

    },

    logout ({ getters, dispatch}) {
      axios({
        url:drf.accounts.logout(),
        method:'post',
        headers: getters.authHeader
      })
      .then(() => {
        dispatch('removeToken')
        alert('로그아웃 성공!')
        router.push({name:'login'})
      })
    },

    fetchCurrentUser ({ commit, getters, dispatch}, id) { // user 식별 위해
      if (getters.isLoggedIn) {
        axios({
          url: drf.accounts.currentUserInfo(id),
          method: 'get',
          headers: getters.authHeader
        })
        .then(res => {
          commit('SET_CURRENT_USER', res.data.userInfo)
          localStorage.setItem('currentUser', res.data.userInfo.id)
        })
        //만료된 토큰일 경우 로그아웃 처리 추가해야함.
        .catch( err => {
          if (err.response.status === 401) {
            dispatch('removeToken')
            router.push({name:'login'})
          }
        })
      }
    },

    changePassWord ( obj) {
      const id = obj.currentUser.id
      axios({
        url: drf.accounts.changePw(id),
        method: 'put',
        data: obj.credentials
      })
      .then(res => {
        console.log(res)
        // dispatch('logout')
      })
    }

    // searchKeyword ({ getters,commit } ,keyword) {
      
    //   axios({
    //     url:drf.movies.search(keyword),
    //     method:"get",
    //     headers:getters.authHeader
    //   })
    //   .then( res => {
    //     commit('FETCH_SEARCHMOVIES', res.data)
    //     router.push({name:'search', params:{keyword:keyword}})
    //   })
    // }
  }

}

