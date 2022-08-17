


const HOST = 'https://i7a707.p.ssafy.io/api/'






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

  pictures: {
    picture: () => HOST + 'picture',
    totalPictures: () => HOST + 'pictures/',
    search: (keyword) => HOST + `picture/${keyword}`,
    myPictures: (id) => HOST + `favorite/picture/${id}`,
    transfer: () => HOST + 'picture/transfer/',
    uploadPicture: () => HOST + 'picture/upload/',
    deletePicture: (id) => HOST + `picture/delete/${id}`,
    like: () => HOST + 'favorite/picture/',
    showPicture: () => HOST + 'picture/show',
  },
}
