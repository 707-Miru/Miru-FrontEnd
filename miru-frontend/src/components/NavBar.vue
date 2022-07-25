<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light  justify-content-between">

        <div class="navbar" id="navbarText">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="#">Login</a>         <!--Login 시 Login 없애고 logout 기능 구현해야됨.-->
                </li>
                <li class="nav-item">
                <a class="nav-link" href="#">Sign Up</a>       <!--#Login 시 Sign up 없애고 나만의 앨범 기능 구현해야됨.-->
                </li>
            </ul>
        </div>

        <div>
            <a class="navbar-brand" href="#">Navbar w/ text</a>
        </div>

        <div>
            <span class="navbar-text">
                Navbar text with an inline element
            </span>
        </div>
    </nav>
</template>