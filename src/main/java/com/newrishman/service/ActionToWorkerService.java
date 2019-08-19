package com.newrishman.service;

import com.newrishman.domain.ActionToWorker;

import java.util.Set;

public interface ActionToWorkerService {
    Set<ActionToWorker> getActionToWorkerByidActions(long id);
}
