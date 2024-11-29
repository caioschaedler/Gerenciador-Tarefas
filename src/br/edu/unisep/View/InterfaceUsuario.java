package br.edu.unisep.View;

import br.edu.unisep.Model.GerenciadorTarefas;


import javax.swing.*;

public class InterfaceUsuario {
    private GerenciadorTarefas gerenciador;

    public InterfaceUsuario() {
        this.gerenciador = new GerenciadorTarefas();
    }

    public void exibirMenu() {
        boolean executando = true;
        while (executando) {
            String[] opcoes = {"Adicionar tarefa", "Marcar tarefa como concluída", "Remover tarefa", "Exibir todas as tarefas", "Sair"};
            String escolha = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecione uma opção:",
                    "Gerenciador de Tarefas",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            if (escolha == null || escolha.equals("Sair")) {
                executando = false;
            } else {
                switch (escolha) {
                    case "Adicionar tarefa":
                        adicionarTarefa();
                        break;
                    case "Marcar tarefa como concluída":
                        marcarTarefaComoConcluida();
                        break;
                    case "Remover tarefa":
                        removerTarefa();
                        break;
                    case "Exibir todas as tarefas":
                        exibirTarefas();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                        break;
                }
            }
        }
    }

    private void adicionarTarefa() {
        String descricao = JOptionPane.showInputDialog("Digite a descrição da nova tarefa:");
        if (descricao != null && !descricao.trim().isEmpty()) {
            gerenciador.adicionarTarefa(descricao.trim());
            JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "A descrição da tarefa não pode ser vazia.");
        }
    }

    private void marcarTarefaComoConcluida() {
        if (gerenciador.listarTarefas().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas para marcar como concluída.");
            return;
        }

        StringBuilder lista = new StringBuilder("Selecione o número da tarefa a ser marcada como concluída:\n");
        for (int i = 0; i < gerenciador.listarTarefas().size(); i++) {
            lista.append(i + 1).append(". ").append(gerenciador.listarTarefas().get(i)).append("\n");
        }

        String input = JOptionPane.showInputDialog(lista.toString());
        if (input != null) {
            try {
                int indice = Integer.parseInt(input) - 1;
                gerenciador.marcarTarefaComoConcluida(indice);
                JOptionPane.showMessageDialog(null, "Tarefa marcada como concluída.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
            }
        }
    }

    private void removerTarefa() {
        if (gerenciador.listarTarefas().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas para remover.");
            return;
        }

        StringBuilder lista = new StringBuilder("Selecione o número da tarefa a ser removida:\n");
        for (int i = 0; i < gerenciador.listarTarefas().size(); i++) {
            lista.append(i + 1).append(". ").append(gerenciador.listarTarefas().get(i)).append("\n");
        }

        String input = JOptionPane.showInputDialog(lista.toString());
        if (input != null) {
            try {
                int indice = Integer.parseInt(input) - 1;
                gerenciador.removerTarefa(indice);
                JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
            }
        }
    }

    private void exibirTarefas() {
        if (gerenciador.listarTarefas().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há tarefas cadastradas.");
        } else {
            StringBuilder lista = new StringBuilder("Lista de Tarefas:\n");
            for (int i = 0; i < gerenciador.listarTarefas().size(); i++) {
                lista.append(i + 1).append(". ").append(gerenciador.listarTarefas().get(i)).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }
}

