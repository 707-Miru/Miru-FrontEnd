<template>
  <div class="container">
    <div class="like" @click="likePicture(pictuer.id)">
      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
        <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
      </svg>
      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
      </svg>
      <span>좋아요 수</span>
    </div>
    <img :src="picture.url" alt="">
    

    <div class="tag">
      태그들
    </div>
  </div>

</template>

<script>
import { mapActions } from 'vuex'


export default {
  name: 'PictureListItem',

  props: {
    picture: Object
  },

  methods: {
    ...mapActions(['likePicture',])
  },


}
</script>

<style scoped>

.container {
  position: relative;
}

.like {
  display: inline-block;
  color: #fff;
  padding: 5px 7px;
  border-radius: 2px;
  transition: .2s;
  position: absolute;
  left: 0;
  right: 0;
  top: -15px;
  padding: 10px 10px 8px 6px;
  opacity: 0;
  transition: .25s;
  /* background: linear-gradient(0deg,rgba(0,0,0,.6) 0,transparent); */
  font-size: 14px;
  text-align: right;
}

.tag {
  display: inline-block;
  color: #fff;
  padding: 5px 7px;
  border-radius: 2px;
  transition: .2s;
  position: absolute;
  left: 0;
  right: 0;
  bottom: -15px;
  padding: 10px 10px 8px 6px;
  opacity: 0;
  transition: .25s;
  background: linear-gradient(0deg,rgba(0,0,0,.6) 0,transparent);
  font-size: 14px;
}
  
.container:hover .tag {
  opacity: 1;
  bottom: 10px;
  left: 22px;
  right: 22px;
}

.container:hover .like {
  opacity: 1;
  top: 20px;
  left: 22px;
  right: 22px;
}

</style>