

const HOST = 'http://15.165.15.68:9999/'





export default {
  accounts: {
    login: () => HOST  + 'user/login/',
    logout: () => HOST  + 'user/logout/',
    signup: () => HOST  + 'user/',
    // Token 으로 현재 user 판단
    currentUserInfo: (id) => HOST+ `user/info/${id}`,
    checkId: (id) => HOST + `user/check/${id}`,
    sendEmail: (id) => HOST + `user/${id}`,
    changePw : (id) => HOST + `user/${id}`
  },
  movies: {

  },
}
