package pl.mprzybylski.taskMenager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mprzybylski.taskMenager.dao.TaskDao;
import pl.mprzybylski.taskMenager.model.Task;

@Controller
public class TaskController {

    @Autowired
    private TaskDao taskDao;

    @GetMapping("/add")
    public String add() {
        return "tasks/add";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        taskDao.add(task);
        return "redirect:/all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Task task) {
        taskDao.update(task);
        return "redirect:/all";
    }

    @GetMapping("/tasks/{id}")
    public String getTask(@PathVariable Integer id, ModelMap modelMap){
        modelMap.put("task", taskDao.findById(id));
        return "tasks/show";
    }

    @GetMapping("/all")
    public String all(ModelMap modelMap) {
        modelMap.put("tasks", taskDao.findAll());
        modelMap.put("description", "Lista zadań");
        return "tasks/all";
    }

    @GetMapping("/finished")
    public String allFinished(ModelMap modelMap) {
        modelMap.put("tasks", taskDao.allFinished());
        modelMap.put("description", "Lista zadań nieukończonych");
        return "tasks/all";
    }

    @GetMapping("/unFinished")
    public String allUnFinished(ModelMap modelMap) {
        modelMap.put("tasks", taskDao.allUnFinished());
        modelMap.put("description", "Lista zadań ukończonych");
        return "tasks/all";
    }


}
