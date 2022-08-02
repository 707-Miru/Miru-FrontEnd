import drf from '@/api/drf'
import axios from 'axios'


export const pictures = {
  state: {
    totalPictures : [],
  },
  getters: {
    totalPictures: state => state.totalPictures,
  },
  mutations: {
    SET_TOTAL_PICTURES : (state, totalPictures) => state.totalPictures = totalPictures,
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
  },
}
