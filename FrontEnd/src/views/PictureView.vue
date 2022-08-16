<template>
  <div>
    <search-bar @onChangeSelect="changeSelect" @onChangeKeyword="changeKeyword"></search-bar>
    <picture-list></picture-list>

  </div>
</template>

<script>
import PictureList from '@/components/PictureList.vue'
import SearchBar from '@/components/SearchBar.vue'



export default {
  name: 'PictureView',

  emits: ['onChangeSelect', 'onChangeKeyword'],

  components:{
    PictureList,
    SearchBar
  },

  data () {
    return {
      isPicture:'',
      SortKey: ''
    }
  },

  methods:{
    changeSelect (isP) {
      
      this.isPicture = isP
      console.log(this.isPicture)
    },
    changeKeyword (key) {
      console.log(key)
      this.sortKey = key
    }
  }

}
</script>

<style>

</style>