<template>
  <div class="myItem">
    <div class="delete">
      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16" @click="deleteData(myPicture.id)">
        <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
      </svg>
    </div>
    <img class="w-100 draggable" draggable="true" :src="url + filepath" :alt="myPicture.pictureIdx">
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'myPictureListItem',
  
  props: {
    myPicture: Object
  },

  data () {
    return {
      url : 'https://i7a707.p.ssafy.io/api/img/'
    }
  },

  computed: {
    filepath () {
      return this.myPicture.filepath.split('/').reverse()[0]
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
  },
  methods: {
    ...mapActions(['deletePicture']),
    deleteData(id) {
      const data = {
        pictureIdx : id
      }
      this.deletePicture(data)
      .then(
        this.fetchMyPictures()
      )
    },
  }
}
</script>

<style scoped>
.draggable {
  cursor: pointer;
}

.myItem {
  position: relative;
}

.delete {
  display: inline-block;
  color: #fff;
  border-radius: 2px;
  transition: .2s;
  position: absolute;
  left: 0;
  right: 0;
  top: -15px;
  padding: 10px 10px 8px 6px;
  opacity: 0;
  transition: .25s;
  font-size: 14px;
  background: linear-gradient(0deg,rgba(0,0,0,.6) 0,transparent);
  text-align: right;
}

.myItem:hover .delete {
  opacity: 1;
  top: 15px;
}
</style>