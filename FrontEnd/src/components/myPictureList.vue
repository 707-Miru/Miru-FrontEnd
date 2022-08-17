<template>
  <div class="row">
    <my-picture-list-item v-for="myPicture in p" 
    :key="myPicture.id" 
    :myPicture="myPicture"
    draggable="true" class="col-12 col-sm-6 col-md-4 col-lg-2 mb-3 draggable"
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
    const draggables = document.querySelectorAll(".draggable")

    draggables.forEach(draggable => {
      draggable.addEventListener("dragstart", () => {
        draggable.classList.add("dragging")
      })

      draggable.addEventListener("dragend", () => {
        draggable.classList.remove("dragging")
      })
    })
    this.fetchMyPictures()
  },
}
</script>

<style scoped>
.draggable {
  cursor: pointer;
}
.draggable :hover {
  transition: all 0.2s linear;
  transform:scale(1.2);
  -webkit-transform:scale(1.2);
  -moz-transform:scale(1.2);
  -o-transform:scale(1.2);
}
</style>