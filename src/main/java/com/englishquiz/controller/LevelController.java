package com.englishquiz.controller;

import java.util.List;

import com.englishquiz.model.Level;
import com.englishquiz.model.UserLevel;
import com.englishquiz.server.Session;
import com.englishquiz.service.LevelService;
import com.englishquiz.service.UserLevelService;

public class LevelController {
    LevelService levelService = new LevelService();
    UserLevelService userLevelService = new UserLevelService();


    public List<UserLevel> getLevels() {
        List<Level> levels = levelService.listarTodosNiveis();
        return getUserLevels(levels);
    }
    
    public List<UserLevel> getUserLevels(List<Level> levels) {
        List<UserLevel> userLevels;
        userLevels = userLevelService.findByUser(Session.getInstance().getLoggedUser());

        if(userLevels.isEmpty()) {
            for(int i = 0; i < levels.size(); i++) {
                createLevelUser(levels.get(i));
            }
            userLevels = userLevelService.findByUser(Session.getInstance().getLoggedUser());
            return userLevels;
        }
        else {
            return userLevels;
        }
        
    }
    
    public void createLevelUser(Level level) {
        UserLevel userLevel = new UserLevel();
        userLevel.setLevel(level);
        userLevel.setUser(Session.getInstance().getLoggedUser());
        userLevel.setIsComplete(false);
        userLevelService.createUserLevel(userLevel);
    }


    public void completeUserLevel(UserLevel level) {
        level.setIsComplete(true);
        System.err.println(level.getIsComplete());
        userLevelService.updateComplete(level);
    }
}
