package com.newrishman.controller;

import com.newrishman.domain.ActionToWorker;
import com.newrishman.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@RestController
@RequestMapping("/register")
public class Controller {

    private ActionsService actionsService;
    private ActionToWorkerService actionToWorkerService;
    private CarOwnerService carOwnerService;
    private CarsService carsService;
    private JobService jobService;
    private OwnersService ownersService;
    private WorkersService workersService;
    private BlockingQueue<Long> list;
    private Set<ActionToWorker> workers;

    @Autowired
    public void setActionsService(ActionsService actionsService) {
        this.actionsService = actionsService;
    }

    @Autowired
    public void setActionToWorkerService(ActionToWorkerService actionToWorkerService) {
        this.actionToWorkerService = actionToWorkerService;
    }

    @Autowired
    public void setCarOwnerService(CarOwnerService carOwnerService) {
        this.carOwnerService = carOwnerService;
    }

    @Autowired
    public void setCarsService(CarsService carsService) {
        this.carsService = carsService;
    }

    @Autowired
    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    @Autowired
    public void setOwnersService(OwnersService ownersService) {
        this.ownersService = ownersService;
    }

    @Autowired
    public void setWorkersService(WorkersService workersService) {
        this.workersService = workersService;
    }

    //поиск рабочего, который будет выполнять работу
    @GetMapping("/search/")
    public void get(@RequestParam String action, @RequestParam String date) {
        //поиск рабочих, выполняющих данную работу
        workers = new HashSet<>();
        workers =
                actionToWorkerService.getActionToWorkerByidActions(
                        actionsService.getActionsByJob(action).getIdAction()
                );
        // постановка ID рабочих в очередь
        list = new ArrayBlockingQueue<>(10);
        for (ActionToWorker worker : workers) {
            try {
                list.put(worker.getIdWorker());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // я получил работника из очереди. Надо проверить, свободен ли он
        list.poll();


    }
}
