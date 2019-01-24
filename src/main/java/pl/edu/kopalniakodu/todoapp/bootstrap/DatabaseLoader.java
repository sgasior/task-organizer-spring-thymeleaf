package pl.edu.kopalniakodu.todoapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.kopalniakodu.todoapp.domain.Task;
//import pl.edu.kopalniakodu.todoapp.domain.TaskWeight;
import pl.edu.kopalniakodu.todoapp.domain.TaskWeight;
import pl.edu.kopalniakodu.todoapp.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {


    private TaskRepository taskRepository;

    @Autowired
    public DatabaseLoader(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) {

        System.out.println("In run method");
        List<Task> taskList = new ArrayList<>();

        taskList.add(new Task("Java programming", "Learn jUnit5, spring, hibernate", true, TaskWeight.IMPORTANT));
        taskList.add(new Task("Exam", "Learn for exam which u have next Friday", true, TaskWeight.MD_IMPORANT));
        taskList.add(new Task("Shopping list", "Buy water, bread, ham", true, TaskWeight.NOT_IMPORTANT));

        for (Task task : taskList) {
            taskRepository.save(task);
        }
    }
}
