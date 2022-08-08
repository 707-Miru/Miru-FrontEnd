import drf from "@/api/drf"
import axios from "axios"

export const myalbum = {
  state: {
    myPage: 1,
    myPictures : [],
    transferPicture : {},
  },

  getters: {
    myPage: state => state.myPage,
    myPictures: state => state.myPictures,
    transferPicture: state => state.transferPicture
  },

  mutations: {
    SET_MY_PICTURES : (state, myPictures) => state.myPictures = myPictures,
    SET_TRANSFER_PICTURE : (state, transferPicture) => state.transferPicture = transferPicture,
  },

  actions: {
    fetchMyPictures ({ commit, getters }) {
      axios({
        url: drf.pictures.myPictures(),
        method: 'get',
        headers: {
          token: localStorage.getItem('token')
        },
        data: {
          page: getters.myPage
        },
      })
      .then(res => {        
        console.log(res)
        commit('SET_MY_PICTURES', res.data)
      })
      .catch(err => {
        console.log(err)
      })         
    },
    transfer ({ commit }, data) {
      axios({
        url: drf.pictures.transfer(),
        method: 'get',
        data,
      })
      .then(res => {        
        console.log(res)
        commit('SET_TRANSFER_PICTURE', res.data)
      })
      .catch(err => {
        console.log(err)
      })         
    },
  },
}
