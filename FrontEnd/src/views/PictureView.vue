<template>
  <div>
    <search-bar></search-bar>
    <picture-list :pictures="pictuers"></picture-list>

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
    ...mapGetters(['pictures', 'currentUserId', 'tpage', 'sortKeyword', 'isPicture'])
  },

  methods:{
    ...mapActions(['fetchPicture']),
  },

  created () {
    const datas = {
      'id' : this.currentUserId,
      'sortKeyword' : this.sortKeyword,
      'page' : this.tpage
    }
    this.fetchPicture(datas),
    console.log(datas)
  }

}
</script>

<style>

</style>