package modelo;

public class Ingresso {
	private String codigo;
	private String telefone;
	private Evento evento;
	private Participante participante;

	public Ingresso(String codigo, Evento e, String telefone){
		this.codigo = codigo;
		this.evento = e;
		this.telefone = telefone;
		
		
	}
	
	public String getCodigo () {
		return codigo;
	}

}
