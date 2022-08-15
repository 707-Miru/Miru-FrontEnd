<template>
  <div class="container">
    <nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center">
        <li class="page-item">
          <a class="page-link" aria-label="Previous" @click="movePage(myPage-1)">
            <span aria-hidden="true">&laquo;</span>
          </a>
        </li>
        <li v-for="page in numPages" :key="page" class="page-item" :class="{ active: isActive === page }"><a class="page-link" @click="movePage(page)">{{ page }}</a></li>
        <li class="page-item">
          <a class="page-link" aria-label="Next" @click="movePage(myPage+1)">
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'myPicturePagination',
  data () {
    return {
      pageCount: 5,
      isActive: 1,
    }
  },
  methods: {
    ...mapActions(['fetchMyPictures']),
    movePage(page) {
      if (page < 1) {
        page = 1
      } else if (page > this.totalPages) {
        page = this.totalPages
      }
      this.$store.commit('SET_MY_PAGE',page)
      this.isActive = page
      this.fetchMyPictures()
    },
  },
  computed: {
    ...mapGetters(['myPage', 'totalPictureCnt']),
    totalPages() {
      return parseInt(this.totalPictureCnt/6) + 1
    },
    pageGroup() {
      return parseInt(this.myPage/this.pageCount) + 1
    },
    numPages() {
      let lastNumber = this.pageGroup * this.pageCount
      if (lastNumber > this.totalPages) {
        lastNumber = this.totalPages
      }
      let firstNumber = lastNumber - (this.pageCount - 1)
      if (firstNumber < 1) {
        firstNumber = 1
      }
      const pageList = []
      for (let i = firstNumber; i <= lastNumber; i++) {
        pageList.push(i)
      }
      return pageList
    }
  },
}
</script>

<style scoped>
li :hover{
  cursor: pointer;
}

</style>