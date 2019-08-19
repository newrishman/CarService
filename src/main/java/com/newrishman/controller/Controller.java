package com.newrishman.controller;

import com.newrishman.domain.ActionToWorker;
import com.newrishman.domain.Job;
import com.newrishman.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

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
    private Set<ActionToWorker> workers;
    private long idWorker;


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

    @GetMapping("/search/")
    public String get(@RequestParam String action, @RequestParam String date) {
        //поиск всех рабочих, выполняющих данную работу
        workers = new HashSet<>();
        workers =
                actionToWorkerService.getActionToWorkerByidActions(
                        actionsService.getActionsByJob(action).getIdAction()
                );
        // поиск свободного работника
        Long id = jobService.getFreeWorker(workers, date);
        if (id==null){
            System.err.println("Данное время записи уже занято");
            return "Данное время записи уже занято, запись невозможна";
        } else {
            idWorker = id;
            return "Данное время записи свободно. Введите имя, фамилию и марку автомобиля";
        }
    }

    @PostMapping("/save/")
public void add(@RequestParam String First_Name, @RequestParam String Last_Name,
                @RequestParam String Car_Model){

        Job save = new Job();
jobService.saveJob()
    }
}
