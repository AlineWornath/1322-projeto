package br.com.ada.t1322.tecnicasprogramacao.projeto.service;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import br.com.ada.t1322.tecnicasprogramacao.projeto.repository.TaskRepository;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.notification.Notifier;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.notification.TaskNotifier;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.validation.TaskValidator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class TaskServiceImpl extends AbstractTaskService {

    public TaskServiceImpl(TaskRepository taskRepository, TaskValidator taskValidator, Notifier notifier) {
        super(taskRepository, taskValidator, notifier);
    }

    public static TaskService create(TaskRepository repository, TaskValidator validator, TaskNotifier taskNotifier) {
    }

    @Override
    public List<Task> findAll(Optional<Comparator<Task>> orderBy) {
        return null;
    }

    @Override
    public List<Task> findByStatus(Task.Status status, Optional<Comparator<Task>> orderBy) {
        return List.of();
    }

    @Override
    public List<Task> findBy(Predicate<Task> predicate, Optional<Comparator<Task>> orderBy) {
        return List.of();
    }
}
