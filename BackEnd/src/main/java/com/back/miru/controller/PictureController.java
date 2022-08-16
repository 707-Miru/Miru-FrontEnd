package com.back.miru.controller;

import com.back.miru.ai.tracking.HandTracking;
import com.back.miru.ai.transfer.TransformPainting;
import com.back.miru.model.dto.Picture;
import com.back.miru.model.service.JwtService;
import com.back.miru.model.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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

    @PostMapping("/tracking")
    public ResponseEntity<Map<String, Object>> handTracking(@RequestBody HashMap<String, String> map, HttpServletRequest request) {
        System.out.println("transferPicture 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        if (jwtService.isUsable(request.getHeader("token"))) {
            logger.info("사용 가능한 토큰!!!");
            try {
                HandTracking.tracking();
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
                logger.error("핸드 트래킹 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            logger.error("사용 불가능 토큰!!!");
            resultMap.put("message", FAIL);
            status = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Map<String, Object>> transferPicture(@RequestBody HashMap<String, String> map, HttpServletRequest request) {
        System.out.println("transferPicture 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        if (jwtService.isUsable(request.getHeader("token"))) {
            logger.info("사용 가능한 토큰!!!");
            try {
                String transferPicturePath = TransformPainting.transform(map.get("optionNum"), map.get("styleFilePath"), map.get("contentFilePath"));
                resultMap.put("transferPicturePath", transferPicturePath);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
                logger.error("파일 명화 변경 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            logger.error("사용 불가능 토큰!!!");
            resultMap.put("message", FAIL);
            status = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    // 전체 사진 목록 불러오기
    // selectAllPictures
    @GetMapping()
    public ResponseEntity<Map<String, Object>> getPictureList(@RequestParam Map<String, String> map) {
        System.out.println("getPictureList controller 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        logger.info("사용 가능한 토큰!!!");
        try {
            List<Picture> pictureList = pictureService.getPictureList(map);
            resultMap.put("pictureList", pictureList);
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            logger.error("목록 불러오기 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<Map<String, Object>>(resultMap, status);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping("/{keyword}")
    public ResponseEntity<Map<String, Object>> searchPicture(@PathVariable String keyword, @RequestBody Map<String, String> map) {
        System.out.println("searchPicture controller 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        logger.info("사용 가능한 토큰!!!");
        try {
            List<Picture> pictureList = pictureService.searchPictureList(keyword, map);
            resultMap.put("pictureList", pictureList);
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            logger.error("정보 조회 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<Map<String, Object>>(resultMap, status);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    // 사진 디테일
    @GetMapping("/detail/{pictureIdx}")
    public ResponseEntity<Map<String, Object>> getPictureDetail(@PathVariable String pictureIdx, HttpServletRequest request) {
        System.out.println("getPictureDetail 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        if (jwtService.isUsable(request.getHeader("token"))) {
            logger.info("사용 가능한 토큰!!!");
            try {
                Map<String, Object> picture = pictureService.getPictureDetail(pictureIdx);
                resultMap.put("picture", picture);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
                logger.error("정보 조회 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            logger.error("사용 불가능 토큰!!!");
            resultMap.put("message", FAIL);
            status = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    // 사진 등록
    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Object registPicture(@RequestParam("data") MultipartFile file,
                                @RequestParam("publicFlag") String publicFlag,
                                @RequestParam("isPicture") String isPicture,
                                @RequestParam("id") String id,
                                @RequestParam("tag") String tag,
                                HttpServletRequest request) throws Exception {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();

        System.out.println("registPicture 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;

        if (jwtService.isUsable(request.getHeader("token"))) {
            logger.info("사용 가능한 토큰!!!");
            try {
                //        String root = "C:\\Users\\SSAFY\\Desktop\\";
                String root = "/var/www/html/S07P12A707/BackEnd/src/main/resources/static/img/";
                sb.append(root);
                sb.append(id);

                // 폴더 생성
                File convFile = new File(sb.toString());
                System.out.println("convFile = " + convFile);
                if(!convFile.exists()) convFile.mkdir();

                // 사진 저장
                String filepath = convFile + "/" + file.getOriginalFilename();
                System.out.println("filepath = " + filepath);
                file.transferTo(new File(filepath));

                map.put("filepath", filepath);
                map.put("tag", tag);
                map.put("publicFlag", publicFlag);
                map.put("isPicture", isPicture);
                map.put("id", id);

                pictureService.registPicture(map);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;

                pictureService.registPicture(map);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
                logger.error("파일 업로드 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            logger.error("사용 불가능 토큰!!!");
            resultMap.put("message", FAIL);
            status = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    // 사진 삭제
    @DeleteMapping("/{pictureIdx}")
    public ResponseEntity<Map<String, Object>> deletePicture(@PathVariable String pictureIdx, HttpServletRequest request) {
        System.out.println("deletePicture 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        if (jwtService.isUsable(request.getHeader("token"))) {
            logger.info("사용 가능한 토큰!!!");
            try {
                pictureService.deletePicture(pictureIdx);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
                logger.error("정보조회 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            logger.error("사용 불가능 토큰!!!");
            resultMap.put("message", FAIL);
            status = HttpStatus.ACCEPTED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

}
