package modelo;

public class Convidado extends Participante {
    private String empresa;

    public Convidado(String cpf, String nascimento) {
        super(cpf, nascimento);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
