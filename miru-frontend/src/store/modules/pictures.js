// import router from "@/router"
// import drf from '@/api/drf'
// import axios from 'axios'

import axios from "axios"


export const pictures = {
  state: {
    pictures: [],
    picture: {},
    page: 0,
  },

  getters: {
    pictures: state => state.pictures,
    picture: state => state.picture,
    page: state => state.page,
  },

  mutations: {
    FETCH_PICTURE: (state, pictures) => state.pictures.push(...pictures),

    INCREASE_PAGE: (state, page) => state.page = page + 30

  },

  actions: {
    fetchPicture ({ commit, getters }) {
      axios({

      })
      .then( res => {
        commit('FETCH_PICTURE', res.data)
        commit('INCREASE_PAGE', getters.page)
      })
      .catch( err => console.error( err.response ))
    },

  },

}
