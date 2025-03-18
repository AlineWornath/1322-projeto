package br.com.ada.t1322.tecnicasprogramacao.projeto.repository;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaskRepositoryImpl implements TaskRepository {

    private static final TaskRepositoryImpl instance = new TaskRepositoryImpl();

    private TaskRepositoryImpl() {};

    public static TaskRepository getInstance() {
        return instance;
    }

    private static long counter = 0;

    List<Task> tasks = new ArrayList<>();

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(counter++);
            tasks.add(task);
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId().equals(task.getId())) {
                    tasks.set(i, task);
                    return task;
                }
            }
        }
        return task;
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public List<Task> findByStatus(String status) {
        return tasks.stream().filter(t -> t.getStatus().getDescricao().equalsIgnoreCase(status)).collect(Collectors.toList());
    }

    @Override
    public List<Task> findByStatus(Task.Status status) {
        return tasks.stream().filter(t -> t.getStatus() == status).collect(Collectors.toList());
    }

    @Override
    public List<Task> findBy(Predicate<Task> predicate) {
        return tasks.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public Optional<Task> findById(Long id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    @Override
    public boolean deleteById(Long id) {
        return tasks.removeIf(t -> t.getId().equals(id));
    }

    @Override
    public void deleteAll() {
        tasks.clear();
    }
}
