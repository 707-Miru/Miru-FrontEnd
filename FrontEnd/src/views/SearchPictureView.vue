<template>
  <div id="columns">
    <picture-list-item v-for="picture in p"
    :key="picture.url"
    :picture="picture"
    >
    </picture-list-item>
  </div>
</template>

<script>
import PictureListItem from '@/components/PictureListItem'

export default {
  name: 'SearchPictureView',

  components: {
    PictureListItem,
  },

  data () {
    return {
      
    }
  }



}
</script>

<style>

</style>