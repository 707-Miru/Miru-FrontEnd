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
          <b-button class="w-100 mb-1 mt-1" variant="secondary" @click.prevent="preview(previewData)">미리보기</b-button>
          <b-button class="w-100" variant="primary">액자로 전송</b-button>
        </div>
      </div>
    </div>
    <div>
      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#uploadModal">
        파일업로드
      </button>
    </div>
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
    <div class="modal fade" id="uploadModal" tabindex="-1" aria-labelledby="uploadModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">파일업로드</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form id="formData">
              <div class="mb-3">
                <label for="formFile" class="form-label">그림 파일 선택</label>
                <input class="form-control" type="file" id="formFile">
              </div>
              <div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="publicFlag" id="publicFlag1" value="1">
                  <label class="form-check-label" for="publicFlag1">
                    파일 공개
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="publicFlag" id="publicFlag2" value="0" checked>
                  <label class="form-check-label" for="publicFlag2">
                    파일 비공개
                  </label>
                </div>
              </div>
              <hr>
              <div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="isPicture" id="isPicture1" value="1" checked>
                  <label class="form-check-label" for="isPicture1">
                    그림
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="isPicture" id="isPicture2" value="0">
                  <label class="form-check-label" for="isPicture2">
                    동영상
                  </label>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            <button type="submit" @click="uploadData()" data-bs-dismiss="modal" class="btn btn-primary">업로드</button>
          </div>
        </div>
      </div>
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
    return {
    }
  },
  data () {
    return {
      artSelected: null,
      artOptions: [
        {value: 0, text: '나만의 스타일'},
        {value: 1, text: '고흐'},
        {value: 2, text: '모네'},
      ],
    }
  },
  methods: {
    ...mapActions(['fetchMyPictures', 'transfer', 'uploadPicture']),
    preview() {
      const previewContent = document.querySelector('.selectedContent img')
      this.transfer(this.previewData).then(
        previewContent.src = this.transferPicture.src
      )
    },
    uploadData() {
      const formData = new FormData()
      const publicFlag = document.querySelector('input[name="publicFlag"]:checked').value
      const isPicture = document.querySelector('input[name="isPicture"]:checked').value
      formData.append('data',document.querySelector('#formFile').files[0]);
      formData.append('publicFlag', publicFlag)
      formData.append('isPicture', isPicture)
      formData.append('id', localStorage.getItem('currentUser'))
      this.uploadPicture(formData)
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
        if (style) {
          style_file_path = style.src
        } else {
          console.error("스타일을 선택해야 합니다.")
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