package modelo;

import regras_negocio.Fachada;
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
        double valorTotal = 0;
        //percorrer todos os ingressos do evento e somar os preços
        for (Ingresso i: ingressos) {
            valorTotal += i.calcularPreco();
        }
        return valorTotal;
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

    public void adicionarIngresso(Ingresso i){
        i.setEvento(this);
        ingressos.add(i);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", descricao='" + descricao + '\'' +
                ", capacidade=" + capacidade +
                ", preco=" + preco +
                '}';
    }
}
