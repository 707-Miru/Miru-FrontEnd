<template>
  <div id="columns">
    <my-picture-list-item v-for="myPicture in myPictures" 
    :key="myPicture.id" 
    :myPicture="myPicture"
    draggable="true" class="draggable"
    >
    </my-picture-list-item>
  </div>
</template>

<script>
import myPictureListItem from '@/components/myPictureListItem'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'myPictureList',
  components: {
    myPictureListItem
  },
  methods: {
    ...mapActions(['fetchMyPictures']),
  },
  computed: {
    ...mapGetters(['myPictures']),
  },
  data () {
    return {
      p:[
        {
          'url': require('@/assets/images/art.png'),
          'id' : 1
        },
        {
          'url': require('@/assets/images/search.png'),
          'id' : 2
        },
        {
          'url': require('@/assets/images/season.png'),
          'id' : 3
        },
        {
          'url': require('@/assets/images/weather.png'),
          'id' : 4
        },
        {
          'url': require('@/assets/frame.png'),
          'id' : 5
        }
      ]
    }
  },
  mounted() {
    this.fetchMyPictures()
  },
}
</script>

<style scoped>
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