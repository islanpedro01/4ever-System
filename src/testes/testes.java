package testes;

import modelo.Participante;
import modelo.Evento;
import regras_negocio.Fachada;
import repositorio.Repositorio;

public class testes {
    public static void main(String[] args) {
        System.out.println("Testes da classe Participante");
        Participante participante = new Participante("1234", "15/09/2001");
        System.out.println(participante.calcularIdade());
        System.out.println(participante.getCPF());

        System.out.println("Testes da classe Evento");

        Evento evento = new Evento(1, "03/12/2022", "Aula de BD", 3, 3.75);
        System.out.println(evento.getId());
        System.out.println(evento.lotado());
        System.out.println(evento.quantidadeIngressos());
        System.out.println(evento.totalArrecadado());


    }
}
