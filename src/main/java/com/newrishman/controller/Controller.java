package com.newrishman.controller;

import com.newrishman.domain.*;
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
    private UserInputService userInputService;
    private long idAction;

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

    @Autowired
    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    @GetMapping("/search/")
    public String get(@RequestParam String action, @RequestParam String date) {

        // поиск ID работы по названию
        idAction = actionsService.getActionsByJob(action).getIdAction();

        // поиск всех рабочих, выполняющих данную работу
        List<ActionToWorker> workers = actionToWorkerService.getActionToWorkerByidActions(idAction);

        // поиск наличия свободных работников

        Long id = jobService.getFreeWorker(workers, date);
        if (id == null) {
            return "Данное время уже занято, выбирите другую дату или время";
        } else {
            return "Данное время записи свободно. Введите имя, фамилию и марку автомобиля";
        }
    }


    @PostMapping("/save/")
    public String add(@RequestBody UserInput userInput) {

        // поиск ID работы по названию
        idAction = actionsService.getActionsByJob(userInput.getAction()).getIdAction();

        // поиск всех рабочих, выполняющих данную работу
        List<ActionToWorker> workers = actionToWorkerService.getActionToWorkerByidActions(idAction);

        // поиск наличия свободных работников
        Long id = jobService.getFreeWorker(workers, userInput.getDate());
        if (id != null) {

            // сохранение всех данных пользователя
            Set<Cars> cars = new HashSet<>();
            Cars car = carsService.saveCars(new Cars(userInput.getCar_Model()));
            cars.add(car);
            Owners owners = ownersService.saveOwner(new Owners(userInput.getFirst_Name(), userInput.getLast_Name()));
            owners.setCars(cars);

            // сохранение записи на ремонт
            jobService.saveJob(new Job(idAction, car.getIdCar(), id, userInput.getDate()));

            return userInput.getFirst_Name() + " " + owners.getLastName() + ", Ваш автомобиль "
                    + userInput.getCar_Model() + " записан на " + userInput.getAction()
                    + " " + userInput.getDate() + ".  Вас будет обслуживать: "
                    + workersService.getWorkersById(id);
        } else {
            return "Ничего не выйдет, записи нет, все заняты. И вообще, у нас обед";
        }
    }

    @GetMapping
    public List<Job> getAllJob() {
        return jobService.getAllJob();
    }

    @GetMapping("/getAll")
    public List<UserInput> getAlJob() {
        return userInputService.getAllUserInput();
    }
}
