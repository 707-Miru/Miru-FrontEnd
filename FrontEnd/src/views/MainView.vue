<template>
  <div class="main container-fluid p-0">
    <div class="item position-relative">
      <img class="w-100" src="@/assets/images/background.png" alt="">
      <a type="button" class="" style="width:15%; position: absolute; top: 10.5%; left: 51.8%;">
        <img class="w-100" src="@/assets/images/art.png" alt="">
      </a>
      <a type="button" class=""  style="width:34%; position: absolute; top: 41.5%; left: 49%;">
        <video class="w-100 h-100 small" src="@/assets/videos/flowers.mp4" alt="" autoplay loop></video>
      </a>
      <a type="button" class=""  style="width:10%; position: absolute; top: 44.8%; left: 33.2%;">
        <img class="w-100" src="@/assets/images/weather.png" alt="">
      </a>
    </div>
    <svg xmlns="http://www.w3.org/2000/svg" id="bottomArrow" width="32" height="32" fill="currentColor" class="bi bi-arrow-down-circle-fill fixed-bottom mx-auto mb-3" viewBox="0 0 16 16">
      <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z"/>
    </svg>
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
          <img src="@/assets/images/season.png" alt="">
        </div>
        <div class="text-start">
          <h1 class="fw-bold">사계절 적용 기능</h1>
          <p class="fs-5">내가 찍은 풍경 사진을 MIRU의 AI가 현재 계절에 어울리게 바꾸어 드립니다</p>
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

 
  <div class="video-wrap">
    <div class="video-inner">
      <video class="video-player" src="@/assets/videos/flowers.mp4"  preload="auto">
        <source src="@/assets/videos/flowers.mp4" type='video/mp4; codecs="vp8.0, vorbis"'>
        <p>Sorry, but your browser does not support this video format.</p>
      </video>
      <button class="action action--close">
        <i class="fa fa-close"></i>
        <span class="action__label action__label--hidden">Close preview</span>
      </button>
    </div>


    <div class="content">
      <div class="loader">
        <i class="fa fa-spinner fa-pulse"></i>
      </div>
      <button class="action action--hidden action--play">
        <i class="fa fa-play"></i><span class="action__label">Watch the video</span>
      </button>
    </div>
  </div>

  


</template>

<script>
import { onMounted } from '@vue/runtime-core'

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
        var bodyEl = document.body,
        videoWrap = document.querySelector('.video-wrap'),
        videoEl = videoWrap.querySelector('video'),
        playCtrl = document.querySelector('.action--play'),
        closeCtrl = document.querySelector('.action--close');

        function init() {
          initEvents();
        }

        function initEvents() {
          playCtrl.addEventListener('click', play);
          closeCtrl.addEventListener('click', hide);
          videoEl.addEventListener('canplaythrough', allowPlay);
          videoEl.addEventListener('ended', hide);
        }

        function allowPlay() {
          bodyEl.classList.add('video-loaded');
        }

        function play() {
          videoEl.currentTime = 0;
          videoWrap.classList.remove('video-wrap--hide');
          videoWrap.classList.add('video-wrap--show');
          setTimeout(function() {videoEl.play();}, 600);
        }

        function hide() {
          videoWrap.classList.remove('video-wrap--show');
          videoWrap.classList.add('video-wrap--hide');
          videoEl.pause();
        }

        init();

      const topArrow = document.querySelector('#topArrow')
      const bottomArrow = document.querySelector('#bottomArrow')
 

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
  

    })
  },
}
</script>

<style scoped>
*,
*:after,
*:before {
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

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

.modal-body {
  position: relative;
}
.modal-body:after {
  position: absolute;
}

#artButton {
  display: none;
  z-index: 1;
}
#bottomArrow :hover {
  cursor: pointer;
}
#topArrow {
  display: none;
}
#topArrow :hover {
  cursor: pointer;
}

video.small {
  animation: full 2s;
}

.video-wrap {
	position: fixed;
	z-index: 1000;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	pointer-events: none;
	display: -webkit-flex;
	display: flex;
	-webkit-align-items: center;
	align-items: center;
}

.video-wrap--show {
	pointer-events: auto;
}

.video-inner {
	position: relative;
	overflow: hidden;
	width: 100%;
	height: 100%;
	margin: 0 auto;
	opacity: 0;
	background: black;
}

.video-wrap--show .video-inner {
	opacity: 1;
}

.video-player {
	position: absolute;
	top: 50%;
	width: 100%;
	-webkit-transform: translate3d(0,-50%,0);
	transform: translate3d(0,-50%,0);
}

.content {
	position: relative;
}

/* Loader */
.loader {
	font-size: 2.5em;
	position: absolute;
	top: 50%;
	left: 50%;
	-webkit-transform: translate3d(-50%,-50%,0);
	transform: translate3d(-50%,-50%,0);
}

.video-loaded .loader {
	opacity: 0;
	pointer-events: none;
	-webkit-transition: opacity 0.3s;
	transition: opacity 0.3s;
}

.action {
	font-family: 'Avenir Next', 'Helvetica Neue', 'Lato', 'Segoe UI', Helvetica, Arial, sans-serif;
	font-size: 1.15em;
	font-weight: bold;
	position: relative;
	overflow: hidden;
	margin: 0;
	padding: 1em 2em;
	color: #fff;
	border: 2px solid;
	border-radius: 40px;
	background: none;
	-webkit-flex: none;
	flex: none;
}

.action:focus {
	outline: none;
}

.action__label {
	display: inline-block;
	margin: 0 0 0 0.75em;
}

.action__label--hidden {
	position: absolute;
	top: 200%;
}

.action--play {
	display: block;
	margin: 1em auto;
	opacity: 0;
	pointer-events: none;
	-webkit-transition: opacity 0.3s 0.1s;
	transition: opacity 0.3s 0.1s;
}

.video-loaded .action--play {
	opacity: 1;
	pointer-events: auto;
}

.action--close {
	line-height: 1;
	position: absolute;
	z-index: 1000;
	top: 30px;
	right: 30px;
	width: 60px;
	height: 60px;
	padding: 0;
	opacity: 0;
	-webkit-transition: -webkit-transform 0.3s, opacity 0.3s;
	transition: transform 0.3s, opacity 0.3s;
	-webkit-transform: scale3d(0.7,0.7,1);
	transform: scale3d(0.7,0.7,1);
}

.video-wrap--show .action--close {
	opacity: 1;
	-webkit-transition-delay: 1.2s;
	transition-delay: 1.2s;
	-webkit-transform: scale3d(1,1,1);
	transform: scale3d(1,1,1);
}

@media screen and (min-width: 25em) {
	.video-inner {
		width: 30vw;
		height: 30vw;
		border: 20px solid #fff;
		-webkit-transform: scale3d(0.1,0.1,1) rotate3d(0,0,1,-5deg);
		transform: scale3d(0.1,0.1,1) rotate3d(0,0,1,-5deg);
	}
	.video-wrap--show .video-inner {
		opacity: 0;
		-webkit-animation: showVideo-1 1.25s forwards;
		animation: showVideo-1 1.25s forwards;
	}
	.video-wrap--hide .video-inner {
		-webkit-animation: hideVideo 1.25s forwards;
		animation: hideVideo 1.25s forwards;
	}
	.video-player {
		left: 50%;
		width: auto;
		height: 100vh;
		-webkit-transition: -webkit-transform 1s;
		transition: transform 1s;
		-webkit-transform: translate3d(-50%,-50%,0) scale3d(0.7,0.7,1) rotate3d(0,0,1,5deg);
		transform: translate3d(-50%,-50%,0) scale3d(0.7,0.7,1) rotate3d(0,0,1,5deg);
	}
	.video-wrap--show .video-player,
	.video-wrap--hide .video-player {
		-webkit-transform: translate3d(-50%,-50%,0) scale3d(1,1,1);
		transform: translate3d(-50%,-50%,0) scale3d(1,1,1);
	}
}

@media screen and (min-width: 25em) and (min-aspect-ratio: 1280/720) {
	.video-inner {
		width: 30vh;
		height: 30vh;
	}
	.video-wrap--show .video-inner {
		-webkit-animation: showVideo-2 1.25s forwards;
		animation: showVideo-2 1.25s forwards;
	}
	.video-player {
		width: 100vw;
		height: auto;
	}
}

@-webkit-keyframes showVideo-1 {
	50% {
		width: 50vw;
		height: 50vw;
		opacity: 1;
		-webkit-transform: scale3d(0.5,0.5,1) rotate3d(0,0,1,-5deg);
		transform: scale3d(0.5,0.5,1) rotate3d(0,0,1,-5deg);
	}
	100% {
		width: 100vw;
		height: 100vh;
		opacity: 1;
		-webkit-transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
		transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
	}
}

@keyframes showVideo-1 {
	50% {
		width: 50vw;
		height: 50vw;
		opacity: 1;
		-webkit-transform: scale3d(0.5,0.5,1) rotate3d(0,0,1,-5deg);
		transform: scale3d(0.5,0.5,1) rotate3d(0,0,1,-5deg);
	}
	100% {
		width: 100vw;
		height: 100vh;
		opacity: 1;
		-webkit-transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
		transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
	}
}

@-webkit-keyframes showVideo-2 {
	50% {
		width: 50vh;
		height: 50vh;
		opacity: 1;
		-webkit-transform: scale3d(0.5,0.5,1) rotate3d(0,0,1,-5deg);
		transform: scale3d(0.5,0.5,1) rotate3d(0,0,1,-5deg);
	}
	100% {
		width: 100vw;
		height: 100vh;
		opacity: 1;
		-webkit-transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
		transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
	}
}

@keyframes showVideo-2 {
	50% {
		width: 50vh;
		height: 50vh;
		opacity: 1;
		-webkit-transform: scale3d(0.5,0.5,1) rotate3d(0,0,1,-5deg);
		transform: scale3d(0.5,0.5,1) rotate3d(0,0,1,-5deg);
	}
	100% {
		width: 100vw;
		height: 100vh;
		opacity: 1;
		-webkit-transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
		transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
	}
}
@-webkit-keyframes hideVideo {
	0% {
		width: 100vw;
		height: 100vh;
		opacity: 1;
		-webkit-transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
		transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
	}
	100% {
		width: 100vw;
		height: 100vh;
		opacity: 0;
		-webkit-transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
		transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
	}
}

@keyframes hideVideo {
	0% {
		width: 100vw;
		height: 100vh;
		opacity: 1;
		-webkit-transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
		transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
	}
	100% {
		width: 100vw;
		height: 100vh;
		opacity: 0;
		-webkit-transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
		transform: scale3d(1,1,1) rotate3d(0,0,1,0deg);
	}
}
</style>