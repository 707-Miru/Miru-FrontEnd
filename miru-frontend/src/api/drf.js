

const HOST = 'http://127.0.0.1:9999/'





export default {
  accounts: {
    login: () => HOST  + 'user/login/',
    logout: () => HOST  + 'logout/',
    signup: () => HOST  + 'user/',
    // Token 으로 현재 user 판단
    currentUserInfo: () => HOST+ 'user/',
    // username으로 프로필 제공
    profile: username => HOST + 'profile/' + username + '/',
  },
  movies: {

  },
}
