package regras_negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import modelo.Convidado;
import modelo.Evento;
import modelo.Ingresso;
import modelo.Participante;
import repositorio.Repositorio;

public class Fachada {
	private static Repositorio repositorio = new Repositorio();

	public static void criarEvento(String data, String descricao, int capacidade, double preco) throws Exception {
		if (preco < 0) {
			throw new Exception("O preço não pode ser negativo!");
		}
		if (data.isEmpty()) {
			throw new Exception("A data não pode ser vazia!");
		}
		if (descricao.isEmpty()) {
			throw new Exception("A descrição não pode ser vazia!");
		}
		if (capacidade < 2) {
			throw new Exception("A capacidade do evento deve ser de no mínimo 2 ingressos!");
		}
		int idEvento = repositorio.gerarId();
		Evento evento = new Evento(idEvento, data, descricao, capacidade, preco);
		repositorio.adicionar(evento);
		repositorio.salvarObjetos();
	}

	public static void criarParticipante(String cpf, String nascimento) throws Exception {
		Participante part = repositorio.localizarParticipante(cpf);

		if (part != null) {
			String mensagem = "O cpf " + cpf + " já está cadastrado!";
			throw new Exception(mensagem);
		}

		if (cpf.isEmpty()) {
			throw new Exception("O CPF não pode ser vazio!");
		}

		if (nascimento.isEmpty()) {
			throw new Exception("A data de nascimento não pode ser vazia!");
		}

		part = new Participante(cpf, nascimento);
		repositorio.adicionar(part);
		repositorio.salvarObjetos();
	}

	public static void criarConvidado(String cpf, String nascimento, String empresa) throws Exception {
		Participante part = repositorio.localizarParticipante(cpf);

		if (part != null) {
			String mensagem = "O cpf " + cpf + " já está cadastrado!";
			throw new Exception(mensagem);
		}

		if (empresa.isEmpty()) {
			throw new Exception("O campo empresa não pode ser vazio!");
		}

		Convidado convidado = new Convidado(cpf, nascimento, empresa);
		repositorio.adicionar(convidado);
		repositorio.salvarObjetos();
	}

	public static void criarIngresso(int id, String cpf, String telefone) throws Exception {
		if (cpf.isEmpty()) {
			throw new Exception("O campo cpf não pode estar vazio!");
		}
		if (telefone.isEmpty()) {
			throw new Exception("O campo telefone não pode estar vazio!");
		}

		Evento e = repositorio.localizarEvento(id);
		Participante p = repositorio.localizarParticipante(cpf);

		if (e == null) {
			throw new Exception("O evento informado não existe!");
		}

		if (p == null) {
			throw new Exception("O CPF informado não é de um participante válido!");
		}

		if (e.lotado()) {
			throw new Exception("O evento está em sua capacidade máxima!");
		}

		String codigo = id + "-" + cpf;

		Ingresso i = repositorio.localizarIngresso(codigo);

		if (i != null) {
			throw new Exception("Ingresso Duplicado!");
		}

		Ingresso ingresso = new Ingresso(codigo, telefone, e, p);
		e.adicionarIngresso(ingresso);
		p.adicionarIngresso(ingresso);

		repositorio.adicionar(ingresso);
		repositorio.salvarObjetos();
	}

	public static void apagarEvento(int id) throws Exception {
		Evento e = repositorio.localizarEvento(id);

		if (e.quantidadeIngressos() != 0) {
			throw new Exception("Não é possível apagar o evento. Há ingressos cadastrados!");
		}
		for (Ingresso ingresso : e.getIngressos()) {
			ingresso.setEvento(null);
		}
		repositorio.remover(e);
		repositorio.salvarObjetos();
	}

	public static void apagarParticipante(String cpf) throws Exception {
		Participante p = repositorio.localizarParticipante(cpf);
		String data = p.lastIngresso().getEvento().getData();
		DateTimeFormatter f1;
		f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataIng = LocalDate.parse(data, f1);
		LocalDate dataAtual = LocalDate.now();

		if (dataAtual.isBefore(dataIng)) {
			throw new Exception("O participante ainda possui ingressos válidos!");
		}

		for (Ingresso ingresso : p.getIngressos()) {
			ingresso.setParticipante(null);
		}
		p.removerIngressos();
		repositorio.remover(p);
		repositorio.salvarObjetos();

	}

	public static void apagarIngresso(String codigo) {
		Ingresso i = repositorio.localizarIngresso(codigo);
		Evento e = i.getEvento();
		Participante p = i.getParticipante();

		for (Ingresso ingresso : e.getIngressos()) {
			if (ingresso.getCodigo() == i.getCodigo()) {
				e.getIngressos().remove(ingresso);
			}
		}

		for (Ingresso ingresso : p.getIngressos()) {
			if (ingresso.getCodigo() == i.getCodigo()) {
				p.getIngressos().remove(ingresso);
			}
		}
		repositorio.remover(i);
		repositorio.salvarObjetos();

	}

	public static ArrayList<Evento> listarEventos() {
		return repositorio.getEventos();
	}

	public static ArrayList<Participante> listarParticipantes() {
		return repositorio.getParticipantes();
	}

	public static ArrayList<Ingresso> listarIngressos() {
		return repositorio.getIngressos();
	}
}
