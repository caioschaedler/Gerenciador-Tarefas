package br.edu.unisep.Model;

import java.util.ArrayList;
import java.util.List;

    public class GerenciadorTarefas {
        private List<Tarefa> tarefas;

        public GerenciadorTarefas() {
            this.tarefas = new ArrayList<>();
        }

        public void adicionarTarefa(String descricao) {
            tarefas.add(new Tarefa(descricao));
        }

        public void removerTarefa(int indice) {
            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.remove(indice);
            }
        }

        public void marcarTarefaComoConcluida(int indice) {
            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.get(indice).marcarComoConcluida();
            }
        }

        public List<Tarefa> listarTarefas() {
            return tarefas;
        }
    }


