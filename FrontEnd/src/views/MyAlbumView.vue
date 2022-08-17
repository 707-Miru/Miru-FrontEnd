<template>
  <div class="container">
    <div class="container row mt-5 mb-5 ">
      <div class="col-7 col-md-8 col-lg-9 preview bg-secondary mx-auto p-3 d-flex">
      </div>
      <div class="col-5 col-md-4 col-lg-3 d-flex flex-column justify-content-between">
        <div>
          <h5>기능 선택</h5>
          <ul class="pagination justify-content-center">
            <li class="page-item" :class="{active : selectedConfig === 0}"><a class="page-link" @click="selectConfig(0)">일반</a></li>
            <li class="page-item" :class="{active : selectedConfig === 1}"><a class="page-link" @click="selectConfig(1)">명화 변환</a></li>
            <li class="page-item" :class="{active : selectedConfig === 2}"><a class="page-link" @click="selectConfig(2)">날씨 추천</a></li>
          </ul>
          <div v-show="selectedConfig === 1">
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
          <b-button v-show="selectedConfig" class="w-100 mb-1 mt-1" variant="secondary" @click.prevent="preview()">미리보기</b-button>
          <b-button class="w-100" variant="primary">액자로 전송</b-button>
        </div>
      </div>
    </div>
    <div class="d-flex mb-3">
      <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#uploadModal">
        파일업로드
      </button>
    </div>
    <my-picture-list></my-picture-list>
    <my-picture-pagination></my-picture-pagination>
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
              <hr>
              <div>
                <label class="form-label" for="userTags">태그(#tag1,#tag2,#tag3,...)</label>
                <input class="form-control" type="text" name="userTags" v-model="userTags">
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
import myPictureList from '@/components/myPictureList'
import myPicturePagination from '@/components/myPicturePagination'

import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'MyAlbumView',
  components : {
    myPictureList,
    myPicturePagination,
  },
  data () {
    return {
      selectedConfig: 0,
      artSelected: null,
      artOptions: [
        {value: 0, text: '나만의 스타일'},
        {value: 1, text: 'candy'},
        {value: 2, text: 'composition_vii'},
        {value: 3, text: 'escher_sphere'},
        {value: 4, text: 'feathers'},
        {value: 5, text: 'frida_kahlo'},
        {value: 6, text: 'la_muse'},
        {value: 7, text: 'mosaic'},
        {value: 8, text: 'mosaic_ducks_massimo'},
        {value: 9, text: 'pencil'},
        {value: 10, text: 'picasso'},
        {value: 11, text: 'portrait'},
        {value: 12, text: 'rain_princess'},
        {value: 13, text: 'seated_nude'},
        {value: 14, text: 'shipwreck'},
        {value: 15, text: 'starry_night'},
        {value: 16, text: 'stars'},
        {value: 17, text: 'strip'},
        {value: 18, text: 'the_scream'},
        {value: 19, text: 'udnie'},
        {value: 20, text: 'wave'},
        {value: 21, text: 'woman'},
      ],
    }
  },
  methods: {
    ...mapActions(['fetchMyPictures', 'uploadPicture', 'transfer']),
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
    preview() {
      const previewContent = document.querySelector('.selectedContent img')
      this.transfer(this.previewData)
      .then(
        previewContent.src = this.transferPicture.src
      )
    },
    selectConfig(data) {
      this.selectedConfig = data
    }
  },
  computed: {
    ...mapGetters(['myPictures', 'transferPicture']),
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
  mounted() {
    const preview = document.querySelector(".preview")
    const myStyle = document.querySelector(".myStyle")

    preview.addEventListener("dragover", e => {
      e.preventDefault()
    })

    preview.addEventListener("drop", e => {
      e.preventDefault()
      if (preview.hasChildNodes()) {
        preview.removeChild(preview.firstChild)
      }
      const draggable = document.querySelector(".dragging")
      const newDraggable = draggable.cloneNode(true)
      newDraggable.classList.add("w-100")
      newDraggable.classList.add("h-100")
      newDraggable.classList.remove("draggable")
      newDraggable.classList.remove("dragging")
      newDraggable.classList.add("selectedContent")
      preview.appendChild(newDraggable)
    })

    myStyle.addEventListener("dragover", e => {
      e.preventDefault()
    })

    myStyle.addEventListener("drop", e => {
      e.preventDefault()
      if (myStyle.childElementCount > 1) {
        const myStyleText = document.querySelector(".myStyleText")
        myStyle.removeChild(myStyle.lastChild)
        myStyleText.style.display = 'inline'
      }
      const draggable = document.querySelector(".dragging")
      const newDraggable = draggable.cloneNode(true)
      const myStyleText = document.querySelector(".myStyleText")
      newDraggable.classList.add("w-100")
      newDraggable.classList.add("h-100")
      newDraggable.classList.remove("mb-3")
      newDraggable.classList.remove("draggable")
      newDraggable.classList.remove("dragging")
      newDraggable.classList.add("selectedStyle")
      myStyleText.style.display = 'none'
      myStyle.appendChild(newDraggable)
    })
  }
}
</script>

<style scoped>
.preview {
  min-width: 640px;
  min-height: 360px;
}
</style>