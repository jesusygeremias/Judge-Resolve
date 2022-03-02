package com.judgeandresolve.backendrest.dao.interfaces;

import com.judgeandresolve.backendrest.models.Task;
import java.util.List;

public interface TaskDAO {

    public List<Task> getTasks();
    public void createTask(Task task);

}
