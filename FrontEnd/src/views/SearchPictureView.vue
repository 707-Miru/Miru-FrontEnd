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
  },

  created () {
    const datas = {
      'keyword' : this.keyword,
      'data' : {
        'isPicture' : this.isPicture,
        'id' : this.currentUserId,
        'sortKey' : this.sortKey,
        'page' : this.page
      }
    }
    this.fetchSearchPicture(datas)
    console.log(datas)
  }


}
</script>

<style>

</style>