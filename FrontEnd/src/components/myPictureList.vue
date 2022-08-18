<template>
  <div id="columns">
    <my-picture-list-item v-for="myPicture in myPictures" 
    :key="myPicture.id" 
    :myPicture="myPicture"
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
            "likeCnt": 1,
            "filepath": "var/www/html/crawling/img/lucky-cat-cookies-on-display.jpg",
            "pictureIdx": 477,
            "updateTime": "2022-08-16T08:56:13.000+00:00",
            "tag": "Cooking, Lunar New Year"
        },
        {
            "likeCnt": 1,
            "filepath": "/var/www/html/crawling/img/siamese-cat-laying-in-white-bedding.jpg",
            "pictureIdx": 476,
            "updateTime": "2022-08-16T08:56:10.000+00:00",
            "tag": "Cats, Home, Bedroom, Pets, Room, Pets & Animals"
        },
        {
            "likeCnt": 1,
            "filepath": "/var/www/html/crawling/img/cat-eyes-photo.jpg",
            "pictureIdx": 475,
            "updateTime": "2022-08-16T08:56:06.000+00:00",
            "tag": "Cats, Pets, Hair, Pets & Animals, White"
        }
    ],
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