
import drf from "@/api/drf"
import axios from "axios"



export const pictures = {
  state: {
    pictures: [],
    picture: {},
    page: 0,
    keyword: '',
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
