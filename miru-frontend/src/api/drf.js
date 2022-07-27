

const HOST = 'http://127.0.0.1:9999/'





export default {
  accounts: {
    login: () => HOST  + 'user/login/',
    logout: () => HOST  + 'logout/',
    signup: () => HOST  + 'user/',
    // Token 으로 현재 user 판단
    currentUserInfo: (id) => HOST+ `user/info/${id}`,
    checkId: (id) => HOST + `user/check/${id}`,
    sendEmail: (id) => HOST + `user/${id}`,
    changePw : () => {}
  },
  movies: {

  },
}
