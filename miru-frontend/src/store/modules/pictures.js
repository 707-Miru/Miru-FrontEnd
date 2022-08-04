// import router from "@/router"
// import drf from '@/api/drf'
// import axios from 'axios'

import drf from "@/api/drf"
import axios from "axios"



export const pictures = {
  state: {
    pictures: [],
    picture: {},
    page: 0,
    keyword: ''
  },

  getters: {
    pictures: state => state.pictures,
    picture: state => state.picture,
    page: state => state.page,
  },

  mutations: {
    FETCH_PICTURE: (state, pictures) => state.pictures.push(...pictures),

    INCREASE_PAGE: (state, page) => state.page = page + 20

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

  },

}
