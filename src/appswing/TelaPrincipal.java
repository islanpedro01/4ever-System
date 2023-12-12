package appswing;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class TelaPrincipal {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menuEvento;
	private JMenu menuParticipante;
	private JMenu menuIngressos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("4Ever Sytem");
		frame.setBounds(100, 100, 670, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menuEvento = new JMenu("Eventos");
		menuEvento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaEventos tela = new TelaEventos();
			}
		});
		menuBar.add(menuEvento);
		
		menuParticipante = new JMenu("Participantes");
		menuParticipante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaParticipantes tela = new TelaParticipantes();
			}
		});
		menuBar.add(menuParticipante);
		
		
		menuIngressos = new JMenu("Ingressos");
		menuIngressos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaIngressos tela = new TelaIngressos();
			}
		});
		menuBar.add(menuIngressos);
	}

}
