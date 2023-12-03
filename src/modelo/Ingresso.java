package modelo;

import repositorio.Repositorio;

public class Ingresso {

    private static Repositorio repositorio;
    private String codigo;
    private String telefone;
    private Evento evento;
    private Participante participante;

    public Ingresso(String codigo, Evento e, String telefone) {
        this.codigo = codigo;
        this.evento = e;
        this.telefone = telefone;
        String cpfPart = codigo.split("-")[1];
        participante = repositorio.localizarParticipante(cpfPart);
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

    public Participante getParticipante() {
        return participante;
    }

    public double calcularPreco() {
        return evento.totalArrecadado();
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "codigo='" + getCodigo() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", evento=" + getEvento() +
                ", participante=" + getParticipante() +
                '}';
    }
}
