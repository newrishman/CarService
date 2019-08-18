package com.newrishman.service;

import com.newrishman.domain.Actions;


public interface ActionsService {
    Actions getIdByJob(String job);

    Actions getJobById(long id);
}