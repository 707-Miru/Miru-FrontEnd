<template>
    <div>
                    <!-- 상단 컴포넌트 -->
        <div>
            <div class="cover-left cover"> 
                <!-- <div>
                    <div class="cover modal-dialog modal-fullscreen">
                        <img src="@/assets/zoom.svg" alt="" width="30" height="30" >
                    </div>
                </div> -->

                <div class="cover" v-if="likecnt === 1" v-on:click="likecnt--">
                    <a href="#">
                        <img src="@/assets/heart.svg" alt="" width="30" height="30" >
                    </a>
                </div>

                <div class="cover" v-if="likecnt === 0" v-on:click="likecnt++">
                    <a href="#">
                        <img src="@/assets/non-heart.svg" alt="" width="30" height="30" >
                    </a>
                </div>

                <div class="cover" v-if="bookmarkcnt === 1" v-on:click="bookmarkcnt--">
                    <a href="#">
                        <img src="@/assets/star.svg" alt="" width="30" height="30" >
                    </a>
                </div>

                <div class="cover" v-if="bookmarkcnt === 0" v-on:click="bookmarkcnt++">
                    <a href="#">
                        <img src="@/assets/non-star.svg" alt="" width="30" height="30" >
                    </a>
                </div>


            </div>

            <div class="cover-right">
                <a href="/picture">
                    <img src="@/assets/detail_close.svg" alt="" width="30" height="30" >
                </a>
            </div>
        </div>

            <!-- 디테일 사진과 양쪽 화살표 -->
        <!-- <div>
            <a href="#" class="contain-left">
                <img src="@/assets/go-previous.svg" alt="" width="30" height="30" >
            </a>
        </div> -->
        <div class="container-main">
            <a href="#">
                <img src="@/assets/images/art.png" alt="">  
            </a>
        </div>
        <!-- <div>
            <a href="#" class="contain-right">
                <img src="@/assets/go-next.svg" alt="" width="30" height="30" >
            </a>
        </div> -->

<!-- 태그 컴포넌트 만들기 (임시) -->
        <!-- <p class="tags">
            <a href="/ko/images/search/%EB%AC%B4%EC%A7%80%EA%B0%9C/">무지개
            </a>

            <span class="noselect">
                <a href="/ko/photos/">사진</a>
            </span>
        <div> {{ $store.state.keyword }}</div>  하나씩 뿌려주기
        </p> -->

    </div>
</template>

<style>
.tags {
    display: flex;
    position: absolute;
    bottom: 5%;
    left: 50%;
    justify-content: center;
}

.cover {
    display: flex;
    margin-right: 25px
}

.cover-left {
    position: absolute;
    top: 80px;
    left:2.5%;
}

.cover-right {
    position: fixed;
    top: 80px;
    right: 2.5%;
}   

.contain-left {
    position: fixed ;
    top: 350px;
    left: 3%;
}

.contain-right {
    position: fixed;
    top: 350px;
    right: 3%;
}
.container-main {
    margin: 0;
    position: absolute;
    top: 400px;
    left: 50%;
    transform: translate(-50%, -50%); 
}

</style>

<script>
// import { mapGetters } from 'vuex'

export default {
    name: 'PhotoDetailView',

    data() {
        return {
            likecnt: 0,
            bookmarkcnt: 0,
        }
    }
}

</script>