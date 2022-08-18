<template>
  <div class="background">
    <div>
    <b-input-group>
        <template #prepend>
        <b-dropdown :text="select" variant="info" >
            <b-dropdown-item-button @click="changeSelect">이미지</b-dropdown-item-button>
            <b-dropdown-item-button @click="changeSelect">동영상</b-dropdown-item-button>
        </b-dropdown>
        </template>
        <b-form  @submit.prevent="searchKeyword">
            <b-form-input placeholder="이미지, 동영상 검색" v-model="keyword"></b-form-input>
        </b-form>

        <template #append>
        <b-dropdown :text="sortKey" variant="outline-secondary">
            <b-dropdown-item-button @click="changeKeyword">업데이트 순</b-dropdown-item-button>
            <b-dropdown-item-button @click="changeKeyword">좋아요 순</b-dropdown-item-button>
        </b-dropdown>
        </template>

        <!-- <div>
          <b-dropdown :text="sortKey" variant="link" toggle-class="text-decoration-none" no-caret>
            <template #button-content>
              &#x1f50d;
            </template>
            <b-dropdown-item @click="changeKeyword">업데이트 순</b-dropdown-item>
            <b-dropdown-item @click="changeKeyword">좋아요 순</b-dropdown-item>
          </b-dropdown>
        </div> -->

    </b-input-group>
    </div>
    <b-button class="mb-1 mt-1" variant="secondary" @click.prevent="userLocation()">날씨 그림 추천</b-button>
  </div>
</template>

<script>
import router from '@/router'
import { mapActions } from 'vuex'

export default {
    name: 'SearchBar',
		
    data () {
        return {
					keyword: '', 
          select: '이미지',
          sortKey: '업데이트 순'
        }
    },

    computed: {
      

    },

    methods: {
        ...mapActions(['onChangeSelect', 'onChangeKeyword', 'userPosition']),
        changeSelect (event) {
          const target = event.target
          this.select = target.innerText
          this.onChangeSelect(this.select)
        },

        changeKeyword (event) {
					const target = event.target
					this.sortKey = target.innerText
          this.onChangeKeyword(this.sortKey)
        },

				searchKeyword () {
          router.push({name:'SearchPictureView', params:{keyword:this.keyword.trim()}})
          
        },

        userLocation() {
          navigator.geolocation.getCurrentPosition((pos) => {
            const lat = pos.coords.latitude
            const lon = pos.coords.longitude
            const data = {
              lat,
              lon
            }
            this.userPosition(data)
          })
        },
    }

}
</script>

<style scoped>
.background {
  margin: auto;
  background-image: url("@/assets/images/search.png");
  height: 486px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  opacity: 0.8;
}
</style>