<template>
  <div>
    <search-bar></search-bar>
    <picture-list></picture-list>

  </div>
</template>

<script>
import PictureList from '@/components/PictureList.vue'
import SearchBar from '@/components/SearchBar.vue'



export default {
  name: 'PictureView',

  components:{
    PictureList,
    SearchBar
    
  }
}
</script>

<style>

</style>