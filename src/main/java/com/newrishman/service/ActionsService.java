package com.newrishman.service;

import com.newrishman.domain.Actions;


public interface ActionsService {
    Actions getActionsByJob(String job);

    Actions getActionsById(long id);
}