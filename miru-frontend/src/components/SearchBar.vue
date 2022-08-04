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
        <b-form  @submit="fetchPicture">
            <b-form-input placeholder="이미지, 동영상 검색" v-model="keyword"></b-form-input>
        </b-form>
        <template #append>
        <b-dropdown :text="sortKeyword" variant="outline-secondary">
            <b-dropdown-item-button @click="changeKeyword">업데이트 순</b-dropdown-item-button>
            <b-dropdown-item-button @click="changeKeyword">좋아요 순</b-dropdown-item-button>
        </b-dropdown>
        </template>
    </b-input-group>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
    name: 'SearchBar',

    data () {
        return {
            select: '이미지',
            sortKeyword: '업데이트 순',
            keyword: ''
        }
    },

    methods: {
        ...mapActions(['fetchPicture']),

        changeSelect (event) {
            const target = event.target
            this.select = target.innerText
        },
        changeKeyword (event) {
            const target = event.target
            this.sortKeyword = target.innerText
        },

        check() {
            console.log('!!')
        }
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
}
</style>