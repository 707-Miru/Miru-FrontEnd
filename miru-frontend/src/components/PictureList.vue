<template>
  <div>
    <picture-list-item v-for="picture in pictures"
    :key="picture.id"
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

    }
  },

  computed: {
    ...mapGetters(['pictures'])
  },

  methods: {
    ...mapActions(['fetchPicture'])
  },

  setup () {
    this.fetchPicture()
  }
}
</script>

<style>

</style>