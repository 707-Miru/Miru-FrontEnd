<template>
  <div>
    <picture-list></picture-list>
  </div>
</template>

<script>
import PictureList from '@/components/PictureListItem'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'SearchPictureView',

  components: {
    PictureList,
  },

  data () {
    return {
      keyword : this.$route.params.keyword
    }
  },

  computed: {
    ...mapGetters(['isPicture', 'sortKey', 'currentUserId', 'page'])
  },
  methods : {
    ...mapActions(['fetchSearchPicture'])
  }
  ,
  setup: {
    
  }


}
</script>

<style>

</style>