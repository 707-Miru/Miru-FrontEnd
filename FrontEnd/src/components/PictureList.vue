<template>
  <div id="columns">
    <picture-list-item v-for="picture in pictures"
    :key="picture.pictureIdx"
    :picture="picture"
    >
    </picture-list-item>
  </div>
  <div>
    <b-button @click="fetchPicture(datas)">more</b-button>
  </div>
</template>

<script>
import PictureListItem from '@/components/PictureListItem'
import { mapActions, mapGetters } from 'vuex'




export default {
  name: 'PictureList',

 

  components:{
    PictureListItem,
  },

  data () {
    return {
      datas : {
      'page' : this.tpage,
      'sortKeyword' : this.sortKeyword,
      'id' : this.currentUserId
      }
    }
  },

  computed: {
    ...mapGetters(['pictures', 'tpage', 'sortKeyword', 'currentUserId'])
  },

  methods: {
    ...mapActions(['fetchPicture'])
  },
 

  created () {

    console.log(this.pictures)

  }
}
</script>

<style>
#columns {
  margin: auto;
  width: 90%;
  column-count:3;
  column-gap: 15px;
}
#columns img{
  display: inline-block;
  border:1px solid rgba(0,0,0,0.2);
  margin:0;
  margin-top: 15px;
  padding:10px;
  box-shadow: 2px 2px 5px rgba(0,0,0,0.5);;
  width: 100%;
}
</style>