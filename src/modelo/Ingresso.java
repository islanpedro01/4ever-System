package modelo;

import repositorio.Repositorio;

public class Ingresso {

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
//        e.adicionarIngresso(this);
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante p) {
        this.participante = p;
//        p.adicionarIngresso(this);
    }

    public double calcularPreco() {
        if(participante.calcularIdade() > 18)return evento.getPreco()*0.1;
        if(participante.calcularIdade() >= 18 && participante.calcularIdade() < 60) return evento.getPreco();
        return evento.getPreco()*0.2;

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
