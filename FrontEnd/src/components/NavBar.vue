<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light justify-content-between shadow-sm">

        <div>
            <a class="navbar-text nav-margin" href="/picture">
                <img src="@/assets/photoBoard_icon.svg" alt="" width="18" height="18" class="d-inline-block nav-margin">
                Photo Board
            </a>    
        </div>
        
        <div>
            <a class="navbar-brand" href="#">
                <img src="@/assets/todayMonet.png" alt="" width="18" height="18" class="d-inline-block nav-margin">
                ^o^ LOGO logo Logo
            </a>
        </div>

        <!-- 토글 버튼 -->
        <div>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="nav-margin collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/">
                            <img src="@/assets/home_icon.svg" alt="" width="18" height="18" class="d-inline-block nav-margin">Home
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">
                            <img src="@/assets/key_icon.svg" alt="" width="18" height="18" class="d-inline-block nav-margin">Login
                        </a>         <!--Login 시 Login 없애고 logout 기능 구현해야됨.-->
                        </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/signup">
                            <img src="@/assets/signUp_icon.svg" alt="" width="18" height="18" class="d-inline-block nav-margin">Sign Up
                        </a>       <!--#Login 시 Sign up 없애고 나만의 앨범 기능 구현해야됨.-->
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>


<style>

.nav-margin {
    margin: 0px 5px;
}


@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap');

div {
    font-family: 'Noto Sans KR', sans-serif;
    font-size: 12px;
}

a {
    text-decoration:none !important;
}

</style>