import drf from "@/api/drf"
import axios from "axios"



export const pictures = {
  state: {
    pictures: [],
    page: 0,
    keyword: '',
    myPage: 1,
    myPictures : [],
    transferPicture : {},
  },

  getters: {
    pictures: state => state.pictures,
    page: state => state.page,
    myPage: state => state.myPage,
    myPictures: state => state.myPictures,
    transferPicture: state => state.transferPicture
  },

  mutations: {
    FETCH_PICTURE: (state, pictures) => state.pictures.push(...pictures),
    INCREASE_PAGE: (state, page) => state.page = page + 20,
    SET_MY_PICTURES : (state, myPictures) => state.myPictures = myPictures,
    SET_TRANSFER_PICTURE : (state, transferPicture) => state.transferPicture = transferPicture,
  },

  actions: {
    fetchPicture ({ commit, getters }) {
      axios({
        url: drf.picture.picture(),
        method: 'get',
        data: {
          'page': getters.page,
          'sortKeyword': getters.keyword,
         }
      })
      .then( res => {
        commit('FETCH_PICTURE', res.data)
        commit('INCREASE_PAGE', getters.page)
      })
      .catch( err => console.error( err.response ))
    },
    fetchMyPictures ({ commit, getters }) {
      const userId = localStorage.getItem('currentUser')
      axios({
        url: drf.pictures.myPictures() + userId,
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
        method: 'post',
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
    uploadPicture (context, data) {
      console.log(data.get('isPicture'))
      axios({
        url: drf.pictures.uploadPicture(),
        method: 'post',
        headers: {
          'Content-Type': 'multipart/form-data'
        },
        data,
      })
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
    },
    deletePicture (data) {
      axios({
        ure: drf.pictures.deletePicture(),
        method: 'delete',
        data,
      })
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
    },
  },
}
