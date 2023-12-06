package modelo;

import regras_negocio.Fachada;
import repositorio.Repositorio;

public class Ingresso {

    Repositorio repositorio;
    private String codigo;
    private String telefone;
    private Evento evento;
    private Participante participante;
    private Convidado convidado;

    public Ingresso(String codigo, String telefone) {
        this.codigo = codigo;
        this.telefone = telefone;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento e) {
        this.evento = e;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante p) {
        this.participante = p;
    }

    public double calcularPreco() {
        //sabendo o preço caso o participante seja convidado;
        if (participante instanceof Convidado){
            if (participante.calcularIdade() > 18) {
                double valor = 0;
                valor = evento.getPreco() * 0.9;
                valor = valor * 0.5;
                return valor;
            }
            if (participante.calcularIdade() >= 18 && participante.calcularIdade() < 60) {
                return evento.getPreco() * 0.5;
            }
            double valor = 0;
            valor = evento.getPreco() * 0.8;
            valor = valor * 0.5;
            return valor;
        }
        //caso seja um participante comum
        if (participante.calcularIdade() > 18) return evento.getPreco() * 0.9;
        if (participante.calcularIdade() >= 18 && participante.calcularIdade() < 60) return evento.getPreco();
        return evento.getPreco() * 0.8;
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "codigo='" + codigo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", evento=" + evento +
                ", participante=" + participante +
                ", convidado=" + convidado +
                '}';
    }
}
