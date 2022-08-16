<template>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet" href="css/style.css">

  </head> 
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
    <!-- 밑에 위치한 화살표(아래로 향함) -->
    <svg xmlns="http://www.w3.org/2000/svg" id="bottomArrow" width="32" height="32" fill="currentColor" class="bi bi-arrow-down-circle-fill fixed-bottom mx-auto mb-3" viewBox="0 0 16 16" opacity = "0.2">
      <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z"/>
    </svg>
    <!-- 아래에 위치한 화살표(위로 향함) -->
    <svg xmlns="http://www.w3.org/2000/svg" id="topArrow" width="32" height="32" fill="currentColor" class="bi bi-arrow-up-circle-fill fixed-top mx-auto mt-3" viewBox="0 0 16 16">
      <path d="M16 8A8 8 0 1 0 0 8a8 8 0 0 0 16 0zm-7.5 3.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z"/>
    </svg>
    <div class="fixed-bottom me-3 d-flex justify-content-end">
      <button class="btn btn-secondary mb-3" id="toTopButton">맨위로</button>
    </div>
    <div class="item container d-flex align-items-center" style="height: 100vh;" id="artPage">
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
    <div class="item container d-flex align-items-center justify-content-center" style="height: 100vh;" id="seasonPage">
      <div class="">
        <div class="mb-5">
        </div>
        <div class="text-start">
          <h1 class="fw-bold">다양한 테마로의 전환 기능</h1>
          <p class="fs-5">내가 찍은 사진을 오늘의 모네가 다양한 테마로 바꾸어 드립니다</p>
            <div class="item container d-flex align-items-center justify-content-center">
              <div data-aos="fade-up" data-aos-once="True" data-aos-offset="1500" style="position: relative;">
                <img src="@/assets/images/theme21/candy.jpg" alt="" style="height: 150px; margin:5px;">
                <div data-aos="fade-up" data-aos-once="True" data-aos-offset="1500" style="position: absolute; top: -5px; left: 60px;"><img src="@/assets/images/theme21/strip.jpg" alt="" style="width: auto; height: 165px; margin:5px;"></div>
              </div>
              <img data-aos="fade-up" data-aos-once="True" data-aos-offset="1500" src="@/assets/images/theme21/the_scream.jpg" alt="" style="width: auto; height: 185px; margin:5px; z-index: 5;">
              <img data-aos="fade-up" data-aos-once="True" data-aos-offset="1500" src="@/assets/images/theme21/udnie.jpg" alt="" style="width: auto; height: 200px; margin:5px; z-index: 6">
              <img data-aos="fade-up" data-aos-once="True" data-aos-offset="1500" src="@/assets/images/theme21/mosaic.jpg" alt="" style="width: auto; height: 215px; margin:5px; z-index: 6">
              <img data-aos="fade-up" data-aos-once="True" data-aos-offset="1500" src="@/assets/images/theme21/starry_night.jpg" alt="" style="width: auto; height: 185px; margin:5px; z-index: 5;">
              <div data-aos="fade-up" data-aos-once="True" data-aos-offset="1500" class="" style="position: relative; left: 150px;">
                <img src="@/assets/images/theme21/feathers.jpg" alt="" style="height: 140px; margin:5px;">
                <div data-aos="fade-up" data-aos-once="True" data-aos-offset="1500" style="position: absolute; bottom: -5px; right: 60px;"><img src="@/assets/images/theme21/composition_vii.jpg" alt="" style="width: auto; height: 155px; margin:5px;"></div>
              </div>
            </div>  
        </div>
      </div>
    </div>
    <div class="item container d-flex align-items-center justify-content-center" style="height: 100vh;" id="weatherPage">
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
    <div class="modal-content container-fluid m-0 p-0">
      <button type="button" class="btn-close position-absolute top-0 end-0 me-3 mt-3" data-bs-dismiss="modal" aria-label="Close"></button>
      <video src="@/assets/videos/flowers.mp4" type="video/mp4" id="artVideo" class="h-100"></video>
      <button type="button" class="btn btn-primary position-absolute bottom-0 end-0 me-3 mb-3" data-bs-dismiss="modal" id="artButton">
        설명으로 가기
      </button>
    </div>
  </div>
  </div>
  <div class="modal fade" id="seasonModal" tabindex="-1" aria-labelledby="seasonLabel" aria-hidden="true">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="seasonLabel">다양한 테마로의 전환 기능</h5>
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
import { onMounted } from '@vue/runtime-core'
import AOS from 'aos'

export default {
  name: 'MainView',
  components: {
  },
  setup() {
    function myBottomScroll(y) {
      const artPage = document.querySelector('#artPage')
      const seasonPage = document.querySelector('#seasonPage')
      const weatherPage = document.querySelector('#weatherPage')
      const artTop = Math.ceil(window.pageYOffset + artPage.getBoundingClientRect().top)
      const seasonTop = Math.ceil(window.pageYOffset + seasonPage.getBoundingClientRect().top)
      const weatherTop = Math.ceil(window.pageYOffset + weatherPage.getBoundingClientRect().top)
      let yTo = 0
      if (y < artTop) {
        yTo = artTop
      } else if (y < seasonTop) {
        yTo = seasonTop
      } else {
        yTo = weatherTop
      }
      return yTo
    }
    function myTopScroll(y) {
      const artPage = document.querySelector('#artPage')
      const seasonPage = document.querySelector('#seasonPage')
      const artTop = Math.ceil(window.pageYOffset + artPage.getBoundingClientRect().top)
      const seasonTop = Math.ceil(window.pageYOffset + seasonPage.getBoundingClientRect().top)
      let yTo = 0
      if (y > seasonTop) {
        yTo = seasonTop
      } else if (y > artTop+50) {
        yTo = artTop
      } else {
        yTo = 0
      }
      return yTo
    }
    onMounted(() => {
      AOS.init()
      const topArrow = document.querySelector('#topArrow')
      const bottomArrow = document.querySelector('#bottomArrow')
      const artModalEl = document.querySelector('#artModal')
      const art = document.querySelector('#artVideo')
      const artButton = document.querySelector('#artButton')
      const artPage = document.querySelector('#artPage')
      const weatherPage = document.querySelector('#weatherPage')
      const artTop = Math.ceil(window.pageYOffset + artPage.getBoundingClientRect().top)
      const weatherTop = Math.ceil(window.pageYOffset + weatherPage.getBoundingClientRect().top)
      const toTopButton = document.querySelector('#toTopButton')
      window.addEventListener('scroll', () => {
        if (Math.ceil(window.pageYOffset) < artTop) {
          topArrow.style.display = 'none'
          bottomArrow.style.display = 'inline'
          toTopButton.style.display = 'none'
        } else if (Math.ceil(window.pageYOffset) < weatherTop-50) {
          topArrow.style.display = 'inline'
          bottomArrow.style.display = 'inline'
          toTopButton.style.display = 'none'
        } else {
          topArrow.style.display = 'inline'
          bottomArrow.style.display = 'none'
          toTopButton.style.display = 'inline'
        }
      })
      toTopButton.addEventListener('click',() => {
        window.scrollTo({ left: 0, top: 0, behavior: "smooth" })
      })
      bottomArrow.addEventListener('click',() => {
        window.scrollTo({ left: 0, top: myBottomScroll(Math.ceil(window.pageYOffset)), behavior: "smooth" })
      })
      topArrow.addEventListener('click',() => {
        window.scrollTo({ left: 0, top: myTopScroll(Math.ceil(window.pageYOffset)), behavior: "smooth" })
      })
      artModalEl.addEventListener('shown.bs.modal',() => {
        art.play()
      })
      artModalEl.addEventListener('hidden.bs.modal',() => {
        art.currentTime = 0
        art.pause()
        artButton.style.display = 'none'
      })
      art.addEventListener('ended',() => {
        artButton.style.display = 'inline'
      })
      artButton.addEventListener('click',() => {
        window.scrollTo({ left: 0, top: Math.ceil(window.pageYOffset + artPage.getBoundingClientRect().top), behavior: "smooth" })
      })
    })
  },
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
button {
  z-index: 1;
}
#artButton {
  display: none;
  z-index: 1;
}
#bottomArrow :hover {
  cursor: pointer;
  fill: black !important;
  opacity: 1;

}
#topArrow {
  display: none;
  top: 50px;
  opacity: 0.2;
}
#topArrow :hover {
  cursor: pointer;
  fill: black !important;
  opacity: 1;

}
</style>