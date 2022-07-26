<template>
  <div class="main container-fluid p-0">
    <div class="item position-relative">
      <img class="w-100" src="@/assets/images/background.png" alt="">
      <a type="button" class="" data-bs-toggle="modal" data-bs-target="#artModal" style="width:15%; position: absolute; top: 10.5%; left: 51.8%;">
        <img class="w-100" src="@/assets/images/art.png" alt="">
      </a>
      <a type="button" class="" data-bs-toggle="modal" data-bs-target="#seasonModal" style="width:34%; position: absolute; top: 42.5%; left: 49%;">
        <img class="w-100" src="@/assets/images/season.png" alt="">
      </a>
      <a type="button" class="" data-bs-toggle="modal" data-bs-target="#weatherModal" style="width:10%; position: absolute; top: 44.8%; left: 33.2%;">
        <img class="w-100" src="@/assets/images/weather.png" alt="">
      </a>
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
  <div class="modal fade" id="artModal" tabindex="-1" aria-labelledby="artLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="artnLabel">명화 변환 기능</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <video src="@/assets/videos/flowers.mp4" type="video/mp4" controls></video>
      </div>
    </div>
  </div>
  </div>
  <div class="modal fade" id="seasonModal" tabindex="-1" aria-labelledby="seasonLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="seasonLabel">사계절 적용기능</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <img src="@/assets/images/season.png" alt="">
      </div>
    </div>
  </div>
  </div>
  <div class="modal fade" id="weatherModal" tabindex="-1" aria-labelledby="weatherLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="weatherLabel">날씨에 따른 사진 추천 기능</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <img src="@/assets/images/weather.png" alt="">
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