package com.newrishman.service;

import com.newrishman.domain.Actions;

import java.util.List;

public interface ActionsServ {

    Actions getActionsById(long id);

    Actions saveActions(Actions actions);

    void updateActions(Actions actions);

    void deleteActions(long id);

    List<Actions> findAll();
}