package regras_negocio;

import modelo.Convidado;
import modelo.Evento;
import modelo.Ingresso;
import modelo.Participante;
import repositorio.Repositorio;

import java.util.ArrayList;

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

    public static void criarConvidado(String cpf, String nascimento, String empresa) throws Exception {
        Participante part = repositorio.localizarParticipante(cpf);

        if (part != null) {
            String mensagem = "O cpf " + cpf + " já está cadastrado!";
            throw new Exception(mensagem);
        }

        Convidado convidado = new Convidado(cpf, nascimento, empresa);
        repositorio.adicionarConvidado(convidado);
    }

    public static void criarIngresso(int id, String cpf, String telefone) {
        Evento e = repositorio.localizarEvento(id);
        String codigo = id + " - " + cpf;

        Ingresso ingresso = new Ingresso(codigo, e, telefone);
    }

    public static void apagarEvento(int id){
        Evento e = repositorio.localizarEvento(id);
        repositorio.remover(e);
    }

    public static void apagarParticipante(String cpf){
        Participante p = repositorio.localizarParticipante(cpf);
        repositorio.remover(p);
    }

    public static void apagarIngresso(String codigo){
        Ingresso i = repositorio.localizarIngresso(codigo);
        repositorio.remover(i);
    }

    public static ArrayList<Evento> listarEventos(){
        return repositorio.getEventos();
    }

    public static ArrayList<Participante> listarParticipantes(){
        return repositorio.getParticipantes();
    }

    public static  ArrayList<Ingresso> listarIngressos(){
        return repositorio.getIngressos();
    }
}
