package com.back.miru.model.dao;

import com.back.miru.model.dto.Interest;
import com.back.miru.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserDAO {
	int checkId(String id) throws SQLException;

	void registerUser(Map<String, String> map) throws SQLException;

	void updateUser(Map<String, String> map);

	void deleteUser(String id) throws SQLException;

	User infoUser(String id) throws SQLException;

	User loginUser(String id, String password) throws SQLException;

	int checkPasswordFind(User user) throws SQLException;

	int checkPassword(Map<String, String> map) throws SQLException;

	void updatePw(Map<String, String> map);

	List<Interest> getInterestList(String id) throws Exception;

	int registerInterest(Map<String, String> map) throws Exception;

	int deleteInterest(Map<String, String> map) throws Exception;

    List<Interest> interestList(String id) throws Exception;

    int addInterest(Map<String, String> map) throws Exception;

    int removeInterest(Map<String, String> map) throws Exception;
}