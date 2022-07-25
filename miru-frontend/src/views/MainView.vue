<template>
  <div class="main container-fluid p-0">
    <div class="item">
      <img class="w-100" src="@/assets/images/background.png" alt="">
    </div>
    <div class="item container d-flex align-items-center" style="height: 100vh;">
      <div class="d-flex align-items-center">
        <div class="mx-5">
          <img src="@/assets/images/art.png" alt="">
        </div>
        <div class="text-start">
          <h1 class="fw-bold">명화 변환 기능</h1>
          <p class="fs-5">내가 찍은 사진을 MIRU의 AI가 내가 원하는 작가의 작품으로 만들어 드립니다</p>
        </div>
      </div>
    </div>
    <div class="item container d-flex align-items-center justify-content-center" style="height: 100vh;">
      <div class="">
        <div class="mb-5">
          <img src="@/assets/images/season.png" alt="">
        </div>
        <div class="text-start">
          <h1 class="fw-bold">사계절 적용 기능</h1>
          <p class="fs-5">내가 찍은 풍경 사진을 MIRU의 AI가 현재 계절에 어울리게 바꾸어 드립니다</p>
        </div>
      </div>
    </div>
    <div class="item container d-flex align-items-center justify-content-center" style="height: 100vh;">
      <div class="d-flex flex-row-reverse align-items-center">
        <div class="mx-5">
          <img src="@/assets/images/weather.png" alt="">
        </div>
        <div class="text-start">
          <h1 class="fw-bold">날씨에 따른 사진 추천 기능</h1>
          <p class="fs-5"> 오늘의 날씨에 따라 기분 좋게 만드는 사진을 추천해드립니다</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MainView',
  components: {
  }
}
</script>

<style scoped>
.main {
  overflow: auto;
  scroll-snap-type: y mandatory;
}
.item {
  scroll-snap-align: center;
}
</style>