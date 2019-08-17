package com.newrishman.service;

import com.newrishman.domain.ActionToWorker;

import java.util.List;

public interface ActionToWorkerServ{

        ActionToWorker getActionToWorkerById(long id);

        ActionToWorker saveActionToWorker(ActionToWorker actionToWorker);

        void updateActionToWorker(ActionToWorker actionToWorker);

        void deleteActionToWorker(long id);

        List<ActionToWorker> findAll();

}
