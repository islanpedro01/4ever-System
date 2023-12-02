package regras_negocio;

import modelo.Convidado;
import modelo.Evento;
import modelo.Participante;
import repositorio.Repositorio;

public class Fachada {
    private static Repositorio repositorio = new Repositorio();

    public static void criarEvento(String data, String descricao, int capacidade, double preco) {
        int idEvento = repositorio.gerarId();
        Evento evento = new Evento(idEvento, data, descricao, capacidade, preco);
        repositorio.adicionar(evento);
    }

    public static void criarParticipante(String cpf, String nascimento) throws Exception {
        Participante part = repositorio.localizarParticipante(cpf);

        if (part != null) {
            String mensagem = "O cpf " + cpf + " já está cadastrado!";
            throw new Exception(mensagem);
        }

        Participante participante = new Participante(cpf, nascimento);
        repositorio.adicionar(participante);
    }

    public static void criarConvidado(String cpf, String nascimento, String empresa) throws Exception{
        Participante part = repositorio.localizarParticipante(cpf);

        if (part != null) {
            String mensagem = "O cpf " + cpf + " já está cadastrado!";
            throw new Exception(mensagem);
        }

        Convidado convidado = new Convidado(cpf, nascimento);
        convidado.setEmpresa(empresa);
        repositorio.adicionarConvidado(convidado);
    }

    public static void criarIngresso
}
