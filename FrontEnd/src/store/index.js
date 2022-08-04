import { createStore } from 'vuex'
import { accounts } from '@/store/modules/accounts'
import { pictures } from '@/store/modules/pictures'

export default createStore({
  modules: { accounts, pictures }
})
