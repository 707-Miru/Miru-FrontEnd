import drf from '@/api/drf'
import axios from 'axios'


export const pictures = {
  state: {
    totalPictures : [],
    transferPicture : {},
  },
  getters: {
    totalPictures: state => state.totalPictures,
    transferPicture: state => state.transferPicture
  },
  mutations: {
    SET_TOTAL_PICTURES : (state, totalPictures) => state.totalPictures = totalPictures,
    SET_TRANSFER_PICTURE : (state, transferPicture) => state.transferPicture = transferPicture,
  },
  actions: {
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
