<template>
  <div>
    <div v-for="picture in totalPictures" :key="picture.id">
      <img :src="picture.url" :alt="picture.id">
    </div>
    <div></div>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'MyAlbumView',
  data () {
    return {
    }
  },
  methods: {
    ...mapActions(['fetchTotalPictures']),
  },
  computed: {
    ...mapGetters(['totalPictures'])
  },
}
</script>

<style>

</style>