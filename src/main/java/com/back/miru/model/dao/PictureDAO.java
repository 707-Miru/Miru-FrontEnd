package com.back.miru.model.dao;

import com.back.miru.model.dto.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface PictureDAO {

	void registPicture(Map<String, String> map) throws Exception;

	void deletePicture(Map<String, String> map) throws Exception;

	List<Picture> infoPicture(String id) throws Exception;

}