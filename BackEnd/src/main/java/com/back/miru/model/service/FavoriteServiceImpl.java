package com.back.miru.model.service;

import com.back.miru.model.dao.FavoriteDAO;
import com.back.miru.model.dto.FavoritePicture;
import com.back.miru.model.dto.FavoriteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteDAO favoriteDAO;

    @Override
    public void registFavoriteUser(Map<String, String> map) throws Exception {
        favoriteDAO.registFavoriteUser(map);
    }

    @Override
    public void deleteFavoriteUser(String followId, Map<String, String> map) throws Exception {
        map.put("followId", followId);
        favoriteDAO.deleteFavoriteUser(map);
    }

    @Override
    public List<FavoriteUser> infoFavoriteUser(String id) throws Exception {
        return favoriteDAO.infoFavoriteUser(id);
    }

    @Override
    public void registFavoritePicture(Map<String, String> map) throws Exception {
        favoriteDAO.registFavoritePicture(map);
    }

    @Override
    public void deleteFavoritePicture(String pictureIdx, Map<String, String> map) throws Exception {
        map.put("pictureIdx", pictureIdx);
        favoriteDAO.deleteFavoritePicture(map);
    }

    @Override
    public List<FavoritePicture> infoFavoritePicture(String id) throws Exception {
        return favoriteDAO.infoFavoritePicture(id);
    }
}
