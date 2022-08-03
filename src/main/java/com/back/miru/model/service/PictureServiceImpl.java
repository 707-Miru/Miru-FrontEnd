package com.back.miru.model.service;

import com.back.miru.model.dao.FavoriteDAO;
import com.back.miru.model.dto.FavoritePicture;
import com.back.miru.model.dto.FavoriteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDAO pictureDAO;

    @Override
    public void registPicture(Map<String, String> map) throws Exception {
        pictureDAO.registFavoriteUser(map);
    }

    @Override
    public void deletePicture(Map<String, String> map) throws Exception {
        pictureDAO.deleteFavoriteUser(map);
    }

    @Override
    public List<FavoriteUser> infoPicture(String id) throws Exception {
        return pictureDAO.infoFavoriteUser(id);
    }

}
