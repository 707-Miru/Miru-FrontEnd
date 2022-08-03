package com.back.miru.model.service;

import com.back.miru.model.dto.FavoritePicture;
import com.back.miru.model.dto.FavoriteUser;

import java.util.List;
import java.util.Map;

public interface FavoriteService {

    void registPicture(Map<String, String> map) throws Exception;

    void deletePicture(Map<String, String> map) throws Exception;

    List<Picture> infoPicture(String id) throws Exception;

}
