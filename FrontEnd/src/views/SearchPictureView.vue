<template>
  <div>
    <picture-list></picture-list>
  </div>
</template>

<script>
import PictureList from '@/components/PictureList'
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
    ...mapGetters(['isPicture', 'sortKey', 'currentUserId', 'page', 'pictures'])
  },
  methods : {
    ...mapActions(['fetchSearchPicture'])
  },

  created () {
    const datas = {
      'keyword' : this.keyword,
      'data' : {
        'isPicture' : this.isPicture,
        'id' : this.currentUserId,
        'sortKeyword' : this.sortKey,
        'page' : 1
      }
    }
    this.fetchSearchPicture(datas)
   
  }


}
</script>

<style>

</style>