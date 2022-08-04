<template>
  <div id="columns">
    <picture-list-item v-for="picture in p"
    :key="picture.url"
    :picture="picture"
    >
    </picture-list-item>
  </div>
  <div>
    <b-button >more</b-button>
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
      p:[
        {
          'url': require('@/assets/images/art.png')
        },
        // {
        //   'url': require('@/assets/images/background.png')
        // },
        {
          'url': require('@/assets/images/search.png')
        },
        {
          'url': require('@/assets/images/season.png')
        },
        {
          'url': require('@/assets/images/weather.png')
        },
        {
          'url': require('@/assets/frame.png')
        }
      ]
    }
  },

  computed: {
    ...mapGetters(['pictures'])
  },

  methods: {
    ...mapActions(['fetchPicture'])
  },

  // setup () {
  //   this.fetchPicture()
  // }
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