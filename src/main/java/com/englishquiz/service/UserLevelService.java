package com.englishquiz.service;

import com.englishquiz.model.Level;
import com.englishquiz.model.User;
import com.englishquiz.model.UserLevel;
import com.englishquiz.server.Session;

import java.util.List;

import com.englishquiz.dao.UserLevelDAO;

public class UserLevelService {
    private UserLevelDAO userLevelDAO = new UserLevelDAO();

    public void createUserLevel(UserLevel userLevel) {
        userLevelDAO.save(userLevel);
    }

    public List<UserLevel> getUserLevels(Level level, User user) {
        return userLevelDAO.findByLevelAndUser(level, user);
    }

    public List<UserLevel> findByUser( User user) {
        return userLevelDAO.findByUser(user);
    }
    public void updateComplete(UserLevel userLevel) {
        userLevelDAO.update(userLevel);
    }
}
