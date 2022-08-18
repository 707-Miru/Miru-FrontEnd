<template>
    <nav class="sticky-top navbar navbar-expand-lg justify-content-between shadow-sm" style="background-color: rgba(255, 255, 255, 0.95)">

        <div>
            <span>
                <a class=" navbar-text nav-margin" href="/picture" style="color:#898AA6">
                    <img src="@/assets/photoBoard.svg" alt="" width="28" height="28" class="d-inline-block nav-margin">
                    사진게시판 &nbsp;
                </a>   
            </span> 
        </div>
        
        <div>
            <a class="navbar-brand" href="/">
                <img src="@/assets/todayMonetLogo1.png" alt="" width="36" height="36" class="d-inline-block nav-margin">
                <img src="@/assets/todayMonetLogo2.png" alt="" width="104" height="24" class="d-inline-block nav-margin">
            </a>
        </div>

        <!-- 토글 버튼 -->
        <div>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div  class="nav-margin collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/" style="color:#898AA6">
                            <img src="@/assets/home.svg" alt="" width="18" height="18"  class="d-inline-block nav-margin">홈
                        </a>
                    </li>
                    <li v-if="!isLoggedIn" class="nav-item">
                        <a class="nav-link" href="/login" style="color:#C9BBCF">
                            <img src="@/assets/login.svg" alt="" width="18" height="18"  class="d-inline-block nav-margin">로그인
                        </a>
                        </li>
                    <li v-if="!isLoggedIn" class="nav-item">
                        <a class="nav-link" href="/signup" style="color:#C9BBCF">
                            <img src="@/assets/signUp.svg" alt="" width="18" height="18"  class="d-inline-block nav-margin">회원가입
                        </a>       <!--#Login 시 Sign up 없애고 나만의 앨범 기능 구현해야됨.-->
                    </li>

                    <li v-if="!!isLoggedIn" class="nav-item">
                        <a class="nav-link" @click.prevent="logout()" style="color:#C9BBCF">
                            <img src="@/assets/logout.svg" alt="" width="20" height="20" class="d-inline-block nav-margin">로그아웃
                        </a>
                    </li>
                    <li v-if="!!isLoggedIn" class="nav-item">
                        <a class="nav-link" href="/myalbum" style="color:#C9BBCF">
                            <img src="@/assets/myalbum.svg" alt="" width="24" height="24" class="d-inline-block nav-margin">나의 앨범
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


<!-- <footer class="container-fluid navbar-fixed-bottom">
  <p><a href="https://www.flaticon.com/free-icons/pond" title="pond icons">Pond icons created by Nikita Golubev - Flaticon</a></p>
</footer> -->



</template>


<script>
  import { mapGetters, mapActions } from 'vuex'

  export default {
    name: 'NavBar',
    computed: {
      ...mapGetters(['isLoggedIn', 'currentUser']),
    //   username() {
    //     return this.currentUser.username ? this.currentUser.username : 'guest'
    //   },
    },
    methods: {
      ...mapActions(['logout'])
    }
  }

function clickEffect(e){
var d=document.createElement("div");
    d.className="clickEffect";
    d.style.top=e.clientY+"px";d.style.left=e.clientX+"px";
    document.body.appendChild(d);
    d.addEventListener('animationend',function(){d.parentElement.removeChild(d);}.bind(this));
}
document.addEventListener('click',clickEffect);
</script>


<style>

.nav-margin {
    margin: 0px 5px;
}


@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700;900&display=swap');



nav div span a:hover {
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3), inset 0 0 1px rgba(255, 255, 255, 0.3);
  color: rgba(0, 0, 0, 1);
}


nav ul li a:hover {
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.3), inset 0 0 1px rgba(255, 255, 255, 0.3);
  color: rgba(0, 0, 0, 1);
}

div {
    font-family: 'Noto Sans KR', sans-serif;
    font-size: 14px;
}

a {
    text-decoration:none !important;
    font-weight: bold !important;
    /* color: #84b7ff !important; */
    /* color: #505050 !important; */
    /* font-family:'Noto Sans KR', sans-serif; */
}

div.clickEffect{
    position:fixed;
    box-sizing:border-box;
    border-style:solid;
    border-color:#c3dbff;
    border-radius:50%;
    animation:clickEffect 1.5s ease-out;
    z-index:99999;
    pointer-events: none;
}
@keyframes clickEffect{
    0%{
    opacity:1;
    width:0.5em; height:0.5em;
    margin:-0.25em;
    border-width:0.2em;
  }
    100%{
    opacity:0.2;
    width:15em; height:15em;
    margin:-7.5em;
    border-width:0.03em;
  }
}


</style>