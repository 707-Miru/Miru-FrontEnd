package com.back.miru.controller;

import com.back.miru.model.dto.FavoritePicture;
import com.back.miru.model.dto.Picture;
import com.back.miru.model.service.JwtService;
import com.back.miru.model.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RequestMapping("/picture")
public class PictureController {
    public static final Logger logger = LoggerFactory.getLogger(PictureController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PictureService pictureService;

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getPictureList(@RequestBody Map<String, String> map) {
        System.out.println("PictureList controller 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        logger.info("사용 가능한 토큰!!!");
        try {
            List<Picture> pictureList = pictureService.getPictureList(map);
            resultMap.put("pictureList", pictureList);
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            logger.error("정보조회 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<Map<String, Object>>(resultMap, status);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
//
//    @GetMapping("/picture/{pictureIdx}")
//    public ResponseEntity<Map<String, Object>> getFavoriteUserInfo(@PathVariable String id, HttpServletRequest request) {
//        System.out.println("pictureInfo controller 시작");
//        Map<String, Object> resultMap = new HashMap<>();
//        HttpStatus status;
//        if (jwtService.isUsable(request.getHeader("token"))) {
//            logger.info("사용 가능한 토큰!!!");
//            try {
//                List<FavoriteUser> favoriteUserInfo = pictureService.infoFavoriteUser(id);
//                System.out.println(favoriteUserInfo);
//                resultMap.put("favoriteUserInfo", favoriteUserInfo);
//                resultMap.put("message", SUCCESS);
//                status = HttpStatus.ACCEPTED;
//            } catch (Exception e) {
//                logger.error("정보조회 실패 : {}", e);
//                resultMap.put("message", e.getMessage());
//                status = HttpStatus.INTERNAL_SERVER_ERROR;
//            }
//        } else {
//            logger.error("사용 불가능 토큰!!!");
//            resultMap.put("message", FAIL);
//            status = HttpStatus.ACCEPTED;
//        }
//        return new ResponseEntity<Map<String, Object>>(resultMap, status);
//    }
//
//    @PostMapping("/picture")
//    public ResponseEntity<Map<String, Object>> registFavoritePicture(@RequestBody Map<String, String> map, HttpServletRequest request) throws Exception {
//        System.out.println("resistFavorite controller 시작");
//        Map<String, Object> resultMap = new HashMap<>();
//        HttpStatus status;
//        if (jwtService.isUsable(request.getHeader("token"))) {
//            logger.info("사용 가능한 토큰!!!");
//            try {
//                pictureService.registFavoritePicture(map);
//                resultMap.put("message", SUCCESS);
//                status = HttpStatus.ACCEPTED;
//            } catch (Exception e) {
//                logger.error("정보조회 실패 : {}", e);
//                resultMap.put("message", e.getMessage());
//                status = HttpStatus.INTERNAL_SERVER_ERROR;
//            }
//        } else {
//            logger.error("사용 불가능 토큰!!!");
//            resultMap.put("message", FAIL);
//            status = HttpStatus.ACCEPTED;
//        }
//        return new ResponseEntity<Map<String, Object>>(resultMap, status);
//    }
//
//    @DeleteMapping("/picture")
//    public ResponseEntity<Map<String, Object>> deleteFavoritePicture(@RequestBody Map<String, String> map, HttpServletRequest request) {
//        System.out.println("deleteFavorite controller 시작");
//        Map<String, Object> resultMap = new HashMap<>();
//        HttpStatus status;
//        if (jwtService.isUsable(request.getHeader("token"))) {
//            logger.info("사용 가능한 토큰!!!");
//            try {
//                pictureService.deleteFavoritePicture(map);
//                resultMap.put("message", SUCCESS);
//                status = HttpStatus.ACCEPTED;
//            } catch (Exception e) {
//                logger.error("정보조회 실패 : {}", e);
//                resultMap.put("message", e.getMessage());
//                status = HttpStatus.INTERNAL_SERVER_ERROR;
//            }
//        } else {
//            logger.error("사용 불가능 토큰!!!");
//            resultMap.put("message", FAIL);
//            status = HttpStatus.ACCEPTED;
//        }
//        return new ResponseEntity<Map<String, Object>>(resultMap, status);
//    }
//
//    @GetMapping("/picture/{id}")
//    public ResponseEntity<Map<String, Object>> getFavoritePictureInfo(@PathVariable String id, HttpServletRequest request) {
//        System.out.println("FavoriteInfo controller 시작");
//        Map<String, Object> resultMap = new HashMap<>();
//        HttpStatus status;
//        if (jwtService.isUsable(request.getHeader("token"))) {
//            logger.info("사용 가능한 토큰!!!");
//            try {
//                List<pictureService> favoritePictureInfo = pictureService.infoFavoritePicture(id);
//                resultMap.put("favoritePictureInfo", favoritePictureInfo);
//                resultMap.put("message", SUCCESS);
//                status = HttpStatus.ACCEPTED;
//            } catch (Exception e) {
//                logger.error("정보조회 실패 : {}", e);
//                resultMap.put("message", e.getMessage());
//                status = HttpStatus.INTERNAL_SERVER_ERROR;
//            }
//        } else {
//            logger.error("사용 불가능 토큰!!!");
//            resultMap.put("message", FAIL);
//            status = HttpStatus.ACCEPTED;
//        }
//        return new ResponseEntity<Map<String, Object>>(resultMap, status);
//    }
//
//    @DeleteMapping("/picture")
//    public ResponseEntity<Map<String, Object>> deleteFavoriteUser(@RequestBody Map<String, String> map, HttpServletRequest request) {
//        Map<String, Object> resultMap = new HashMap<>();
//        HttpStatus status;
//        if (jwtService.isUsable(request.getHeader("token"))) {
//            logger.info("사용 가능한 토큰!!!");
//            try {
//                pictureService.deletePicture(map);
//                resultMap.put("message", SUCCESS);
//                status = HttpStatus.ACCEPTED;
//            } catch (Exception e) {
//                logger.error("정보조회 실패 : {}", e);
//                resultMap.put("message", e.getMessage());
//                status = HttpStatus.INTERNAL_SERVER_ERROR;
//            }
//        } else {
//            logger.error("사용 불가능 토큰!!!");
//            resultMap.put("message", FAIL);
//            status = HttpStatus.ACCEPTED;
//        }
//        return new ResponseEntity<Map<String, Object>>(resultMap, status);
//    }
}