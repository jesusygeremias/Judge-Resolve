package com.judgeandresolve.backendrest.controllers;

import com.judgeandresolve.backendrest.dao.interfaces.TaskDAO;
import com.judgeandresolve.backendrest.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TaskController {

    @Autowired
    private TaskDAO taskDAO;

    /*@RequestMapping(value = "/api/gettask", method = RequestMethod.GET)
    public List<Task> getTasks() {

    }*/

    @RequestMapping(value = "/api/gettasks", method = RequestMethod.GET)
    public List<Task> getTasks() {
        return taskDAO.getTasks();
    }

    @RequestMapping(value = "/api/createtask", method = RequestMethod.POST)
    public void createTask(@RequestBody Task task) {
        taskDAO.createTask(task);
    }

}
