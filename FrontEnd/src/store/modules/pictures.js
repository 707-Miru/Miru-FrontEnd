
import drf from "@/api/drf"
import axios from "axios"



export const pictures = {
  state: {
    pictures: [],
    picture: {},
    page: 1,
    totalPictures : [],
    transferPicture : {},
    
  },

  getters: {
    pictures: state => state.pictures,
    picture: state => state.picture,
    page: state => state.page,
    totalPictures: state => state.totalPictures,
    transferPicture: state => state.transferPicture
  },

  mutations: {
    FETCH_PICTURE: (state, pictures) => state.pictures.push(...pictures),

    INCREASE_PAGE: (state, page) => state.page = page + 20,

    SET_TOTAL_PICTURES : (state, totalPictures) => state.totalPictures = totalPictures,
    SET_TRANSFER_PICTURE : (state, transferPicture) => state.transferPicture = transferPicture,
  },

  actions: {
    fetchPicture ({ commit, getters }, d) {
      console.log(d)
      axios({
        url: drf.pictures.picture(),
        method: 'get',
        params: d,
        headers: getters.authHeader
      })
      .then( res => {
        console.log(res)
        commit('FETCH_PICTURE', res.data)
        commit('INCREASE_PAGE', getters.page)
      })
      .catch( err => console.error( err ))
    },

    fetchSearchPicture ({ getters }, data, keyword) {
      axios({
        url:  drf.pictures.search(keyword),
        method: 'post',
        data: data,
        headers: getters.authHeader
      })
    },

    fetchTotalPictures ({ commit }, data) {
      axios({
        url: drf.pictures.totalPictures(),
        method: 'get',
        data,
      })
      .then(res => {        
        console.log(res)
        commit('SET_TOTAL_PICTURES', res.data)
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
