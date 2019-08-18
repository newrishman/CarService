package com.newrishman.service;

import com.newrishman.domain.ActionToWorker;

public interface ActionToWorkerService {
    ActionToWorker getActionToWorkerByidAction(long id);

    ActionToWorker getActionToWorkerByidWorker(long id);
}
