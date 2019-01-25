package pl.edu.kopalniakodu.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.kopalniakodu.todoapp.repository.TaskRepository;

@Controller
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping({"/","index.html","index"})
    public String taskList(Model model) {
        model.addAttribute("tasks", taskRepository.findByActiveTrue());
        return "index";
    }


    @GetMapping("/history")
    public String taskHistory(Model model) {
        model.addAttribute("tasks", taskRepository.findByActiveFalse());
        return "history";
    }



}
