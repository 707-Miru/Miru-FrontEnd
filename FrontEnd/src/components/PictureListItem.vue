<template>
  <div class="container">
    <div class="like">
      <svg @click="likePicture(picture.pictureIdx)" v-if="!likeflag" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
        <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
      </svg>
      <svg @click="dislikePicture(picture.pictureIdx)" v-if="likeflag" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314z"/>
      </svg>
      <span> {{ likeCnt }}</span>
    </div>
    <img :src="url + filepath" alt="">
    
    

    <div class="tag">
      {{ picture.tag }}
    </div>
  </div>

</template>

<script>
import drf from "@/api/drf"
import axios from "axios"
import { mapGetters } from 'vuex'


export default {
  name: 'PictureListItem',

  data () {
    return {
      url : 'https://i7a707.p.ssafy.io/api/img/',
      check : 0,
      cnt: 0
      
    }
  },

  props: {
    picture: Object
  },

  computed: {
    ...mapGetters(['currentUserId', 'authHeader']),
    filepath () {
      const path = this.picture.filepath.split('/').reverse()
      let realpath = ''
      for (var i = 0; i < path.length; i ++) {
        if (path[i] !== 'img') {
          realpath = path[i] + '/' + realpath
        }
        else if (path[i] === 'img') {
          break
        }
      }

      return realpath
    },

    likeCnt () {
      if (this.check === 0){
        return this.picture.likeCnt
      }
      else {
        return this.cnt
      }
    },

    likeflag () {
      let flag
      if (this.check === 0) {
        flag = this.picture.likeflag
      } else if (this.check === 1) {
        flag = 1
      } else if (this.check === 2) {
        flag = 0
      }
      return flag
    }
  },

  methods: {

    likePicture (id) {
      this.check = 1
      axios({
        url: drf.pictures.like(),
        method: 'post',
        headers: this.authHeader,
        data: {
          'id' : this.currentUserId,
          'pictureIdx' : id
        }
      })
      .then( res => this.cnt = res.data.likeCnt)
      .catch( err => console.error(err))
    },

    dislikePicture (id) {
      this.check = 2
      axios({
        url: drf.pictures.dislike(id),
        method: 'delete',
        headers: this.authHeader,
        data: {
          'id' : this.currentUserId,
        }
      })
      .then( res => this.cnt = res.data.likeCnt) 
      .catch( err => console.error(err))
    }
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