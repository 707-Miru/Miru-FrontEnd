package com.back.miru.model.service;

import com.back.miru.model.dao.PictureDAO;
import com.back.miru.model.dto.ListParameterDto;
import com.back.miru.model.dto.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDAO pictureDAO;

    @Override
    public List<Picture> getPictureList(Map<String, String> map) throws Exception {
        int pgno = Integer.parseInt(map.get("page"));
        int countPerPage = 20; // 한 페이지당 보여줄 개수
        int start = (pgno - 1) * countPerPage;
        String sortKeyword = map.getOrDefault("sortKeyword", "time");
        String id = map.get("id");

        ListParameterDto listParameterDto = new ListParameterDto();
        listParameterDto.setStart(start);
        listParameterDto.setCurrentPerPage(countPerPage);
        listParameterDto.setSortKeyword(sortKeyword);
        listParameterDto.setId(id);
        return pictureDAO.selectAllPictures(listParameterDto);
    }

    @Override
    public void registPicture(Map<String, String> map) throws Exception {
        pictureDAO.registPicture(map);
    }

    @Override
    public void deletePicture(String pictureIdx) throws Exception {
        pictureDAO.deletePicture(pictureIdx);
    }

    @Override
    public List<Picture> searchPictureList(String keyword, Map<String, String> map) {
        int pgno = Integer.parseInt(map.get("page"));
        int countPerPage = 20; // 한 페이지당 보여줄 개수
        int start = (pgno - 1) * countPerPage;
        String sortKeyword = map.getOrDefault("sortKeyword", "time");
        String id = map.get("id");
        boolean isPicture = "true".equals(map.getOrDefault("isPicture", null)) ? true : false;

        ListParameterDto listParameterDto = new ListParameterDto();
        listParameterDto.setStart(start);
        listParameterDto.setCurrentPerPage(countPerPage);
        listParameterDto.setKeyword(keyword);
        listParameterDto.setSortKeyword(sortKeyword);
        listParameterDto.setIsPicture(isPicture);
        listParameterDto.setId(id);
        return pictureDAO.searchPictureList(listParameterDto);
    }

    @Override
    public Map<String, Object> getPictureDetail(String pictureIdx) throws Exception {
        return pictureDAO.getPictureDetail(pictureIdx);
    }

    @Override
    public void showPicture(Map<String, String> map) throws Exception {
        int showFlag = Integer.parseInt(map.get("showFlag"));
        StringTokenizer st = new StringTokenizer(map.get("pictureIdx"), ",");
        int len = st.countTokens();
        int[] idxArr = new int[len];
        for (int i = 0; i < len; i++) {
            idxArr[i] = Integer.parseInt(st.nextToken());
        }
        String[] pathArr = new String[len];
        for (int i = 0; i < len; i++) {
            int idx = idxArr[i];
            pathArr[i] = pictureDAO.getPicturePath(idx);
        }
        String path = Arrays.toString(pathArr);
        path = path.substring(1, path.length() - 1);

        // 사진 인덱스에 해당하는 파일의 경로 찾아오기 or 사진의 경로를 바로 전달
        Socket socket = null;            //Server와 통신하기 위한 Socket
        PrintWriter out = null;            //서버로 내보내기 위한 출력 스트림
        InetAddress ia = null;

        ia = InetAddress.getByName("miru707.ddns.net");    //서버로 접속, 서버 주소 입력
        socket = new Socket(ia, 8888); // 서버가 열어놓은 포트 입력
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));

        out.println(showFlag + ", " + path);   //서버로 데이터 전송
        out.flush();
        socket.close();
    }
}
