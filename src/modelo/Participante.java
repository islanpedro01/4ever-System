package modelo;

import repositorio.Repositorio;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Participante {
	private String cpf;
	private String nascimento;
	private ArrayList<Ingresso> ingressos = new ArrayList <>();

	public Participante (String cpf, String nascimento) {
		this.cpf = cpf;
		this.nascimento = nascimento;
	}

	public void adicionarIngresso(Ingresso i){
		i.setParticipante(this);
		ingressos.add(i);
	}

	public ArrayList<Ingresso> getIngressos(){
		return ingressos;
	}

	public String getCPF() {
		return cpf;
	}
	
	public Ingresso lastIngresso(){ //Método auxiliar para o método apagarParticipante() da fachada.
		return ingressos.get(ingressos.size()-1);

	}

	public void removerIngressos(){ //Método auxiliar para o método apagarParticipante() da fachada.
		for (Ingresso ingresso:ingressos){
			ingressos.remove(ingresso);
		}

	}

	public int calcularIdade() {
		DateTimeFormatter f1;
		f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataNasc = LocalDate.parse(nascimento,f1); 
		LocalDate dataAtual = LocalDate.now();
		
		return Period.between(dataNasc, dataAtual).getYears();
	}

	@Override
	public String toString() {
		return "Participante{" +
				"cpf='" + cpf + '\'' +
				", nascimento='" + nascimento + '\'' +
				'}';
	}



}

