<template>
  <div>
    <search-bar></search-bar>
    <picture-list></picture-list>

  </div>
</template>

<script>
import PictureList from '@/components/PictureList.vue'
import SearchBar from '@/components/SearchBar.vue'
import { mapActions, mapGetters } from 'vuex'



export default {
  name: 'PictureView',

  components:{
    PictureList,
    SearchBar
  },



  computed: {
    ...mapGetters(['currentUserId', 'tpage', 'sortKeyword', 'isPicture'])
  },

  methods:{
    ...mapActions(['fetchPicture']),
  },

  created () {
    const datas = {
      'page' : this.tpage,
      'sortKeyword' : this.sortKeyword,
      'id' : this.currentUserId
    }
    this.fetchPicture(datas),
    console.log(datas)
  }

}
</script>

<style>

</style>