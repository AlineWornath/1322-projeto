package br.com.ada.t1322.tecnicasprogramacao.projeto.controller;

import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.TaskService;

public class TaskControllerImpl extends AbstractTaskController {

    public TaskControllerImpl(TaskService taskService) {
        super(taskService);
    }

    @Override
    protected void validateTitle(String title) {

    }

    @Override
    protected void validateDeadline(String deadline) {

    }

    @Override
    protected void validateStatus(Task.Status status) {

    }
}
