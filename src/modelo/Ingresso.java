package modelo;

public class Ingresso {
    private String codigo;
    private String telefone;
    private Evento evento;
    private Participante participante;

    public Ingresso(String codigo, Evento e, String telefone) {
        this.codigo = codigo;
        this.evento = e;
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

    public Participante getParticipante() {
        return participante;
    }


    public double calcularPreco() {
        return evento.totalArrecadado();
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "codigo='" + codigo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", evento=" + evento +
                ", participante=" + participante +
                '}';
    }
}
