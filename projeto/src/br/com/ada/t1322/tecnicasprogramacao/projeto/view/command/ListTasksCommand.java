package br.com.ada.t1322.tecnicasprogramacao.projeto.view.command;

import br.com.ada.t1322.tecnicasprogramacao.projeto.controller.TaskController;
import br.com.ada.t1322.tecnicasprogramacao.projeto.model.Task;
import br.com.ada.t1322.tecnicasprogramacao.projeto.view.View;
import br.com.ada.t1322.tecnicasprogramacao.projeto.service.TaskComparators;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ListTasksCommand implements Command {

    private final View view;
    private final TaskController taskController;

    public ListTasksCommand(View view, TaskController taskController) {
        this.view = view;
        this.taskController = taskController;
    }

    @Override
    public void execute() {
        Optional<Comparator<Task>> orderBy = getSortingMethod();
        List<Task> tasks = taskController.getAllTasks(orderBy);

        if (tasks.isEmpty()) {
            view.showMessage("📭 Nenhuma tarefa encontrada.");
        } else {
            tasks.forEach(task -> view.showMessage(task.toString("dd/MM/yyyy")));
        }
    }

    private Optional<Comparator<Task>> getSortingMethod() {
        view.showMessage("Escolha o critério de ordenação:");
        view.showMessage("1 - Por Data Limite");
        view.showMessage("2 - Por Título");
        view.showMessage("3 - Por Status");
        view.showMessage("4 - Por Id");
        view.showMessage("5 - Sem ordenação");

        int option = view.getIntInput("Digite o número da opção");

        if (option == 5) {
            return Optional.empty();
        }

        view.showMessage("Deseja ordem reversa? (S/N)");
        boolean reversed = view.getInput("").trim().equalsIgnoreCase("S");

        String criteria = switch (option) {
            case 2 -> "title";
            case 3 -> "status";
            case 4 -> "id";
            default -> "deadline";
        };

        return Optional.of(TaskComparators.getComparator(criteria, reversed));
    }
}
