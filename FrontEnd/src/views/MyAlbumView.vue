<template>
  <div class="container">
    <div class="container row mt-5 mb-5 ">
      <div class="col-7 col-md-8 col-lg-9 preview bg-secondary mx-auto p-3 d-flex">
      </div>
      <div class="col-5 col-md-4 col-lg-3 d-flex flex-column justify-content-between">
        <div>
          <div>
            <h3>스타일 선택</h3>
            <b-form-select v-model="artSelected" :options="artOptions"></b-form-select>
            <div v-show="artSelected===0">
              <div class="myStyle mt-1 mb-0 border border-danger mx-auto p-1 d-flex">
                <h2 class="text-danger myStyleText">여기에 드래그 앤 드롭</h2>
              </div>
            </div>
          </div>
        </div>
        <div>
          <b-button class="w-100 mb-1 mt-1" variant="secondary" @click="preview(previewData)">미리보기</b-button>
          <b-button class="w-100" variant="primary">액자로 전송</b-button>
        </div>
      </div>
    </div>
    <!-- <div v-for="picture in totalPictures" :key="picture.id">
      <img :src="picture.url" :alt="picture.id">
    </div> -->
    <div class="container">
      <b-row>
        <div draggable="true" class="col-12 col-sm-6 col-md-4 col-lg-2 mb-3 draggable">
          <img class="mw-100 mh-100" src="@/assets/images/placeholder_600x400.png" alt="1">
        </div>
        <div draggable="true" class="col-12 col-sm-6 col-md-4 col-lg-2 mb-3 draggable">
          <img class="mw-100 mh-100" src="@/assets/images/placeholder_600x400.png" alt="2">
        </div>
        <div draggable="true" class="col-12 col-sm-6 col-md-4 col-lg-2 mb-3 draggable">
          <img class="mw-100 mh-100" src="@/assets/images/placeholder_600x400.png" alt="3">
        </div>
        <div draggable="true" class="col-12 col-sm-6 col-md-4 col-lg-2 mb-3 draggable">
          <img class="mw-100 mh-100" src="@/assets/images/placeholder_600x400.png" alt="4">
        </div>
        <div draggable="true" class="col-12 col-sm-6 col-md-4 col-lg-2 mb-3 draggable">
          <img class="mw-100 mh-100" src="@/assets/images/placeholder_600x400.png" alt="5">
        </div>
        <div draggable="true" class="col-12 col-sm-6 col-md-4 col-lg-2 mb-3 draggable">
          <img class="mw-100 mh-100" src="@/assets/images/placeholder_600x400.png" alt="6">
        </div>
      </b-row>
    </div>
  </div>
</template>

<script>
import { onMounted } from '@vue/runtime-core'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'MyAlbumView',
  setup() {
    onMounted(() => {
      const draggables = document.querySelectorAll(".draggable")
      const preview = document.querySelector(".preview")
      const myStyle = document.querySelector(".myStyle")

      draggables.forEach(draggable => {
        draggable.addEventListener("dragstart", () => {
          draggable.classList.add("dragging")
        })
  
        draggable.addEventListener("dragend", () => {
          draggable.classList.remove("dragging")
        })
      })

      preview.addEventListener("dragover", e => {
        e.preventDefault()
        if (preview.hasChildNodes()) {
          preview.removeChild(preview.firstChild)
        }
      })

      preview.addEventListener("drop", e => {
        e.preventDefault()
        const draggable = document.querySelector(".dragging")
        const newDraggable = draggable.cloneNode(true)
        newDraggable.classList.add("w-100")
        newDraggable.classList.add("h-100")
        newDraggable.classList.remove("draggable")
        newDraggable.classList.add("selectedContent")
        preview.appendChild(newDraggable)
      })

      myStyle.addEventListener("dragover", e => {
        e.preventDefault()
        if (myStyle.childElementCount > 1) {
          const myStyleText = document.querySelector(".myStyleText")
          myStyle.removeChild(myStyle.lastChild)
          myStyleText.style.display = 'inline'
        }
      })

      myStyle.addEventListener("drop", e => {
        e.preventDefault()
        const draggable = document.querySelector(".dragging")
        const newDraggable = draggable.cloneNode(true)
        const myStyleText = document.querySelector(".myStyleText")
        newDraggable.classList.add("w-100")
        newDraggable.classList.add("h-100")
        newDraggable.classList.remove("mb-3")
        newDraggable.classList.remove("draggable")
        newDraggable.classList.add("selectedStyle")
        myStyleText.style.display = 'none'
        myStyle.appendChild(newDraggable)
      })
      
    })
  },
  data () {
    return {
      artSelected: null,
      artOptions: [
        {value: 0, text: '나만의 스타일'},
        {value: 1, text: '고흐'},
        {value: 2, text: '모네'},
        {value: 3, text: '피카소'},
      ],
    }
  },
  methods: {
    ...mapActions(['fetchTotalPictures', 'transfer',]),
    preview() {
      const previewContent = document.querySelector('.selectedcontent img')
      this.transfer(this.previewData).then(
        previewContent.src = this.transferPicture.src
      )
    },
  },
  computed: {
    ...mapGetters(['totalPictures', 'transferPicture']),
    previewData() {
      const option_num = this.artSelected
      const content_file_path = document.querySelector('.selectedContent img').src
      const style = document.querySelector('.selectedStyle img')
      let style_file_path = null
      if (option_num === 0) {
        if (style === null) {
          console.error("스타일을 선택해야 합니다.")
        } else {
          style_file_path = style.src
        }

        const body = {
          option_num,
          content_file_path,
          style_file_path,
        }
        return body
      } else {
        const body = {
          option_num,
          content_file_path,
          style_file_path,
        }
        return body
      }
    },
  },
}
</script>

<style scoped>
.preview {
  max-width: 640px;
  height: 360px;
}
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