package com.back.miru.model.service;

import com.back.miru.model.dao.PictureDAO;
import com.back.miru.model.dto.FavoriteUser;
import com.back.miru.model.dto.ListParameterDto;
import com.back.miru.model.dto.PageNavigation;
import com.back.miru.model.dto.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDAO pictureDAO;

    @Override
    public List<Picture> getPictureList(Map<String, String> map) throws Exception {
        int pgno = Integer.parseInt(map.get("page"));
        int countPerPage = 20; // 한 페이지당 보여줄 개수
        int start = (pgno - 1) * countPerPage;
        String sortKeyword = map.getOrDefault("sortKeyword", null);
        sortKeyword = sortKeyword == null ? "time" : sortKeyword;
        String id = map.get("id");

        ListParameterDto listParameterDto = new ListParameterDto();
        listParameterDto.setStart(start);
        listParameterDto.setCurrentPerPage(countPerPage);
        listParameterDto.setSortKeyword(sortKeyword);
        listParameterDto.setId(id);
        System.out.println("listParameterDto = " + listParameterDto);
        return pictureDAO.selectAllPictures(listParameterDto);
    }

    @Override
    public void registPicture(Map<String, String> map) throws Exception {
        pictureDAO.registPicture(map);
    }

    @Override
    public void deletePicture(Map<String, String> map) throws Exception {
        pictureDAO.deletePicture(map);
    }

    @Override
    public PageNavigation makePageNavigation(String id, String pg) throws Exception {
        PageNavigation pageNavigation = new PageNavigation();
        int pgno = Integer.parseInt(pg);
        int currentPage = pgno;
        int naviSize = 5;
        int countPerPage = 5;
        pageNavigation.setCurrentPage(currentPage);
        pageNavigation.setCountPerPage(countPerPage);
        pageNavigation.setNaviSize(naviSize);

//        int totalCount = pictureDAO.getTotalCount(id);
//        pageNavigation.setTotalCount(totalCount);
//        int totalPageCount = (totalCount - 1) / countPerPage + 1;
//        pageNavigation.setTotalPageCount(totalPageCount);
//
//        pageNavigation.setStartRange(currentPage <= naviSize);
//        boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
//        pageNavigation.setEndRange(endRange);
//        pageNavigation.makeNavigator();
        return pageNavigation;
    }

    @Override
    public List<String> selectAllFilePath(String id) {
        return null;
    }

}
