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
    private PictureService pictureService;

    @PostMapping("/tracking")
    public ResponseEntity<Map<String, Object>> handTracking(@RequestBody HashMap<String, String> map, HttpServletRequest request) {
        System.out.println("transferPicture 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        try {
            HandTracking.tracking();
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            logger.error("핸드 트래킹 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<Map<String, Object>>(resultMap, status);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping("/transfer")
    public ResponseEntity<Map<String, Object>> transferPicture(@RequestBody HashMap<String, String> map) {
        System.out.println("transferPicture 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        try {
            String transferPicturePath = TransformPainting.transform(map.get("optionNum"), map.get("styleFilePath"), map.get("contentFilePath"));
            resultMap.put("transferPicturePath", transferPicturePath);
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            logger.error("파일 명화 변경 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<Map<String, Object>>(resultMap, status);
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
    public ResponseEntity<Map<String, Object>> getPictureDetail(@PathVariable String pictureIdx) {
        System.out.println("getPictureDetail 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        try {
            Map<String, Object> picture = pictureService.getPictureDetail(pictureIdx);
            resultMap.put("picture", picture);
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

    // 사진 등록
    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> registPicture(@RequestBody Map<String, String> map) throws Exception {
        System.out.println("registPicture 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        try {
            map.put("filepath", "c:\\filename.jpg");
            pictureService.registPicture(map);
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            logger.error("파일 업로드 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<Map<String, Object>>(resultMap, status);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    // 사진 삭제
    @DeleteMapping("/{pictureIdx}")
    public ResponseEntity<Map<String, Object>> deletePicture(@PathVariable String pictureIdx) {
        System.out.println("deletePicture 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        try {
            pictureService.deletePicture(pictureIdx);
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

    // 파이에서 요청한 사진 보여주기
    @PostMapping("/show")
    public ResponseEntity<Map<String, Object>> showPicture(@RequestBody Map<String, String> map) throws Exception {
        System.out.println("showPicture 시작");
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        try {
            pictureService.showPicture(map);
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            logger.error("소켓 통신 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<Map<String, Object>>(resultMap, status);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

}
