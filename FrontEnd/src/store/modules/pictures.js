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
    totalPictureCnt : 50,

    transferPicture : {},
    select: '이미지',
    sortKey: '업데이트 순'
    
  },

  getters: {
    pictures: state => state.pictures,
    page: state => state.page,

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
    FETCH_PICTURE: (state, pictures) => state.pictures.push(...pictures),
    INCREASE_PAGE: (state, page) => state.page = page + 20,
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



    fetchPicture ({ commit, getters }) {
      axios({
        url: drf.picture.picture(),
        method: 'get',
        data: {
          'page': getters.page,
          'sortKeyword': getters.keyword,
        },
      })
      .then( res => {
        console.log(res)
        commit('FETCH_PICTURE', res.data)
        commit('INCREASE_PAGE', getters.page)
      })
      .catch( err => console.error( err ))
    },

    fetchSearchPicture ({ getters }, datas) {
      axios({
        url:  drf.pictures.search(datas.keyword),
        method: 'post',
        data: datas.data,
        headers: getters.authHeader
      })
    },
    fetchMyPictures ({ commit, getters }) {
      const userId = localStorage.getItem('currentUser')
      axios({
        url: drf.pictures.myPictures(userId),
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
      console.log(data)
      axios({
        url: drf.pictures.transfer(),
        method: 'post',
        data,
        headers: {
          token: localStorage.getItem('token')
        }
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
      console.log(data.get('data'))
      console.log(data.get('publicFlag'))
      console.log(data.get('isPicture'))
      console.log(data.get('id'))
      console.log(data.get('tag'))
      axios({
        url: drf.pictures.uploadPicture(),
        method: 'post',
        headers: {
          'Content-Type': 'multipart/form-data',
          token: localStorage.getItem('token')
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
    deletePicture (context, data) {
      axios({
        ure: drf.pictures.deletePicture(data.pictureIdx),
        method: 'delete',
        data,
        headers: {
          token: localStorage.getItem('token')
        }
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
