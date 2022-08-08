import { createStore } from 'vuex'
import { accounts } from '@/store/modules/accounts'
import { pictures } from '@/store/modules/pictures'
import { myalbum } from '@/store/modules/myalbum'

export default createStore({
  modules: { accounts, pictures, myalbum }
})
