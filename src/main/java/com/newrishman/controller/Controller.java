package com.newrishman.controller;

import com.newrishman.domain.ActionToWorker;
import com.newrishman.domain.Cars;
import com.newrishman.domain.Job;
import com.newrishman.domain.Owners;
import com.newrishman.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
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
    private long idAction;
    private String date;
    private String action;


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
        //поиск ID работы по названию
        this.action = action;
        idAction = actionsService.getActionsByJob(action).getIdAction();

        //поиск всех рабочих, выполняющих данную работу
        workers = new HashSet<>();
        workers = actionToWorkerService.getActionToWorkerByidActions(idAction);
        // поиск свободного работника
        this.date = date;
        Long id = jobService.getFreeWorker(workers, date);
        if (id == null) {
            System.out.println("Данное время записи уже занято");
            return "Данное время уже занято, выбирите другую дату или время";
        } else {
            idWorker = id;
            System.out.println("Данное время записи свободно");
            return "Данное время записи свободно. Введите имя, фамилию и марку автомобиля";
        }
    }

    @PostMapping("/save/")
    public String add(@RequestParam String First_Name, @RequestParam String Last_Name,
                      @RequestParam String Car_Model) {
        // сохранение всех данных пользователя
        Set<Cars> cars = new HashSet<>();
        Cars car = carsService.saveCars(new Cars(Car_Model));
        cars.add(car);
        Owners owners = ownersService.saveOwner(new Owners(First_Name, Last_Name));
        owners.setCars(cars);
        
        //сохранение записи на ремонт
        jobService.saveJob(new Job(idAction, car.getIdCar(), idWorker, date));
        System.out.println("эта надпись - конец.");
        return (First_Name + " " + Last_Name + ", Ваш автомобиль " + Car_Model
                + " записан на " + action + " на дату " + date);
    }

    @GetMapping
    public List<Job> getAllJob(){
        return jobService.getAllJob();
    }
}
