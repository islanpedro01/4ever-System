package appswing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class TelaPrincipal {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menuEvento;
	private JMenu menuParticipante;
	private JMenu menuIngressos;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JSeparator separator;

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
		frame.getContentPane().setLayout(null);
		
		button = new JButton("Eventos");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaEventos tela = new TelaEventos();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(435, 96, 151, 43);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("Participantes");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(435, 173, 151, 43);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("Ingressos");
		
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBounds(435, 251, 151, 43);
		frame.getContentPane().add(button_2);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(365, 0, 2, 391);
		frame.getContentPane().add(separator);
	}
}
