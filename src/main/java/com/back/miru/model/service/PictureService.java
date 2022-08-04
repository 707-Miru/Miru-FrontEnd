package com.back.miru.model.service;

import com.back.miru.model.dto.PageNavigation;
import com.back.miru.model.dto.Picture;

import java.util.List;
import java.util.Map;

public interface PictureService {
    List<Picture> getPictureList(Map<String, String> map) throws Exception;

    void registPicture(Map<String, String> map) throws Exception;

    void deletePicture(Map<String, String> map) throws Exception;

    PageNavigation makePageNavigation(String id, String pg) throws Exception;
}
