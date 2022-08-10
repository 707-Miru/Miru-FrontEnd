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
        <b-form  @submit="c">
            <b-form-input placeholder="이미지, 동영상 검색" v-model="keyword"></b-form-input>
        </b-form>
        <template #append>
        <b-dropdown :text="sortKey" variant="outline-secondary">
            <b-dropdown-item-button @click="changeKeyword">업데이트 순</b-dropdown-item-button>
            <b-dropdown-item-button @click="changeKeyword">좋아요 순</b-dropdown-item-button>
        </b-dropdown>
        </template>
    </b-input-group>
    </div>
  </div>
</template>

<script>

export default {
    name: 'SearchBar',
		
    data () {
        return {
					select: '이미지',
					keyword: '',
					sortKey: '업데이트 순',  
        }
    },

    computed: {
			isPicture () {
				return this.select === '이미지' ? true:false
			},
			sortKeyword () {
				return this.sortKey ==='업데이트 순' ? 'time':'like'
			}
    },

    methods: {
        changeSelect (event) {
					const target = event.target
					this.select = target.innerText
					this.$emit('onChangeSelect', this.isPicture)
        },

        changeKeyword (event) {
					const target = event.target
					this.sortKey = target.innerText
					this.$emit('onChangeKeyword', this.sortKeyword)
        },

				c () {
					
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