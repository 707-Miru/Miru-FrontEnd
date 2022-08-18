import drf from "@/api/drf"
import axios from "axios"



export const pictures = {
  state: {
    pictures: [],

    picture: {},
    tpage: 1,
    totalPictures : [],

    page: 0,
    keyword: '',
    myPage: 1,
    myPictures : [],
    totalPictureCnt : 1,

    transferPicture : {},
    select: '이미지',
    sortKey: '업데이트 순'
    
  },

  getters: {
    pictures: state => state.pictures,
    page: state => state.page,
    tpage: state => state.tpage,

    totalPictures: state => state.totalPictures,

    select: state => state.select,
    sortKey: state => state.sortKey,
    isPicture (state) {
      return state.select === '이미지' ? true:false
    },
    sortKeyword (state) {
      return state.sortKey ==='업데이트 순' ? 'time':'like'
    },

    myPage: state => state.myPage,
    myPictures: state => state.myPictures,
    transferPicture: state => state.transferPicture,
    totalPictureCnt: state => state.totalPictureCnt
  },

  mutations: {
    RESET_PICTURES: (state) => state.pictures = [],
    FETCH_PICTURE: (state, pictures) => state.pictures.push(...pictures),
    INCREASE_PAGE: (state, tpage) => state.tpage = tpage + 1,
    SET_MY_PICTURES : (state, myPictures) => {
      const totalPictureCnt = myPictures.pop()
      state.totalPictureCnt = totalPictureCnt['totalPictureCnt']
      state.myPictures = myPictures
    },
    SET_MY_PAGE: (state, myPage) => state.myPage = myPage,
    SET_TRANSFER_PICTURE : (state, transferPicture) => state.transferPicture = transferPicture,
    SET_SELECT : (state, select) => state.select = select,
    SET_SORTKEY  :(state, sortKey) => state.sortKey = sortKey
  },

  actions: {

    onChangeSelect ({ commit }, select) {
      commit('SET_SELECT', select)
    },

    onChangeKeyword ({ commit }, sortKey) {
      commit('SET_SORTKEY', sortKey)
    },

    likePicture ({getters}, id) {
      axios({
        url: drf.pictures.like(),
        method: 'post',
        data: {
          'id' : getters.currentUserId,
          'pictureIdx' : id
        }
      })
    },

    fetchPicture ({ commit, getters }, datas) {
      axios({
        url: drf.pictures.picture(),
        method: 'get',
        headers: getters.authHeader,
        params: datas 
      })
      .then( res => {
        console.log(res)
        commit('FETCH_PICTURE', res.data.pictureList)
        commit('INCREASE_PAGE', getters.tpage)
      })
      .catch( err => console.error( err ))
    },

    fetchSearchPicture ({ getters, commit }, datas) {
      commit('RESET_PICTURES')
      axios({
        url: drf.pictures.search(datas.keyword),
        method: 'post',
        data: datas.data,
        headers: getters.authHeader
      })
      .then( res => {
        console.log(res)
        commit('FETCH_PICTURE', res.data.pictureList)
      })
      .catch( err => console.error(err))
    },

    fetchMyPictures ({ commit, getters }) {
      const userId = localStorage.getItem('currentUser')
      axios({
        url: drf.pictures.myPictures(userId),
        method: 'get',
        headers: getters.authHeader,
        params: {
          page: getters.myPage
        },
      })
      .then(res => {        
        console.log(res.data)
        commit('SET_MY_PICTURES', res.data)
      })
      .catch(err => {
        console.log(err)
      })         
    },

    transfer ({ getters, commit }, data) {
      console.log(data)
      axios({
        url: drf.pictures.transfer(),
        method: 'post',
        headers: getters.authHeader,
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

    uploadPicture ({ getters }, data) {
      console.log(data.get('tag'))
      axios({
        url: drf.pictures.uploadPicture(),
        method: 'post',
        headers: getters.authHeader,
        data,
      })
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
    },

    deletePicture ({ getters }, data) {
      axios({
        url: drf.pictures.deletePicture(data.pictureIdx),
        method: 'delete',
        headers: getters.authHeader,
        data,
      })
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
    },
    
    showPicture ({ getters }, data) {
      console.log(data)
      axios({
        url: drf.pictures.showPicture(),
        method: 'post',
        headers: getters.authHeader,
        data,
      })
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
    },

    userPosition ({ getters }, data) {
      axios({
        url: drf.pictures.weather(),
        method: 'post',
        headers: getters.authHeader,
        data,
      })
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
    }
  },
}
