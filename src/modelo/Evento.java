package modelo;

import repositorio.Repositorio;

import java.util.ArrayList;

public class Evento {
    private int id;
    private String data;
    private String descricao;
    private int capacidade;
    private double preco;

    private ArrayList<Ingresso> ingressos = new ArrayList<>();

    public Evento(int id, String data, String descricao, int capacidade, double preco) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public boolean lotado() {
        if (capacidade == ingressos.size()) {
            return true;
        }
        return false;
    }

    public int quantidadeIngressos() {
        return ingressos.size();
    }

    public double totalArrecadado() {
        return preco * quantidadeIngressos();
    }

    public double getPreco() {
        return preco;
    }

    public String getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + getId() +
                ", data='" + getData() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", capacidade=" + getCapacidade() +
                ", preco=" + getPreco() +
                ", ingressos=" + getIngressos() +
                '}';
    }
}
