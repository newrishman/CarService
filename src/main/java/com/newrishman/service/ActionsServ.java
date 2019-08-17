package com.newrishman.service;

import com.newrishman.domain.Actions;

import java.util.List;

public interface ActionsServ {

    Actions getActionsById(long id);

    void deleteActions(long id);

    List<Actions> findAll();
}