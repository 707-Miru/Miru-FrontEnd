<template>
  <div>
      <div>
        <img class="mw-100 mh-100" :src="myPicture.url" :alt="myPicture.id">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg position-absolute top-0 end-0 me-3 mt-1" viewBox="0 0 16 16" @click="deleteData(myPicture.id)">
          <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
        </svg>
      </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'myPictureListItem',
  
  props: {
    myPicture: Object
  },
  methods: {
    ...mapActions(['deletePicture']),
    deleteData(id) {
      const data = {
        pictureIdx : id
      }
      this.deletePicture(data)
      .then(
        this.fetchMyPictures()
      )
    },
  }
}
</script>

<style>

</style>