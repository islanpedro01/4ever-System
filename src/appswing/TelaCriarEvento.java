package appswing;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import regras_negocio.Fachada;

public class TelaCriarEvento {

	private JFrame frame;
	private JLabel labelMain;
	private JTextField fieldData;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField fieldDescricao;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField valorQuant;
	private JButton button;
	private JButton button_1;
	private JLabel label_6;
	private JLabel label_7;
	public int contador = 0;
	private JButton button_2;
	private JLabel label_8;
	private JTextField fieldPreco;
	private JLabel label_9;
	private JLabel labelAviso;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// TelaCriarEvento window = new TelaCriarEvento();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public TelaCriarEvento() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("4Ever System - Criar Evento");
		frame.setBounds(100, 100, 362, 513);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		labelMain = new JLabel("Criar Evento");
		labelMain.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelMain.setHorizontalAlignment(SwingConstants.CENTER);
		labelMain.setBounds(115, 10, 118, 28);
		frame.getContentPane().add(labelMain);

		fieldData = new JTextField();

		fieldData.setToolTipText("");
		fieldData.setBounds(10, 73, 328, 34);
		frame.getContentPane().add(fieldData);
		fieldData.setColumns(10);

		label_1 = new JLabel("Data do Evento");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(10, 48, 118, 21);
		frame.getContentPane().add(label_1);

		label_2 = new JLabel("Ex.: 20/20/2020");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_2.setBounds(10, 109, 249, 13);
		frame.getContentPane().add(label_2);

		label_3 = new JLabel("Breve descrição");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(10, 132, 118, 21);
		frame.getContentPane().add(label_3);

		fieldDescricao = new JTextField();
		fieldDescricao.setToolTipText("");
		fieldDescricao.setColumns(10);
		fieldDescricao.setBounds(10, 157, 328, 34);
		frame.getContentPane().add(fieldDescricao);

		label_4 = new JLabel("Ex.: Hackaton");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_4.setBounds(10, 193, 249, 13);
		frame.getContentPane().add(label_4);

		label_5 = new JLabel("Capacidade máxima");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(10, 300, 249, 21);
		frame.getContentPane().add(label_5);

		valorQuant = new JTextField();
		valorQuant.setFont(new Font("Tahoma", Font.BOLD, 16));
		valorQuant.setHorizontalAlignment(SwingConstants.CENTER);
		valorQuant.setText("0");
		valorQuant.setToolTipText("");
		valorQuant.setColumns(10);
		valorQuant.setBounds(146, 331, 55, 34);
		frame.getContentPane().add(valorQuant);

		button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contador += 1;
				valorQuant.setText(String.valueOf(contador));
			}
		});
		button.setBounds(226, 331, 33, 30);
		frame.getContentPane().add(button);

		button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contador -= 1;
				valorQuant.setText(String.valueOf(contador));
			}
		});
		button_1.setBounds(90, 331, 33, 30);
		frame.getContentPane().add(button_1);

		label_6 = new JLabel("+");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(220, 369, 45, 13);
		frame.getContentPane().add(label_6);

		label_7 = new JLabel("-");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(84, 369, 45, 13);
		frame.getContentPane().add(label_7);

		button_2 = new JButton("Criar");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Fachada.criarEvento(fieldData.getText(), fieldDescricao.getText(),
							Integer.parseInt(valorQuant.getText()), Double.parseDouble(fieldPreco.getText()));
					labelAviso.setText("Evento criado com sucesso!");
					fieldData.setText("");
					fieldDescricao.setText("");
					valorQuant.setText("");
					fieldPreco.setText("");
				} catch (Exception ex) {
					labelAviso.setText(ex.getMessage());
				}
			}
		});
		button_2.setBounds(118, 438, 111, 28);
		frame.getContentPane().add(button_2);

		label_8 = new JLabel("Preço");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(10, 216, 118, 21);
		frame.getContentPane().add(label_8);

		fieldPreco = new JTextField();
		fieldPreco.setToolTipText("");
		fieldPreco.setColumns(10);
		fieldPreco.setBounds(10, 241, 328, 34);
		frame.getContentPane().add(fieldPreco);

		label_9 = new JLabel("Ex: 100");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_9.setBounds(10, 277, 249, 13);
		frame.getContentPane().add(label_9);

		labelAviso = new JLabel("");
		labelAviso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labelAviso.setBounds(10, 404, 328, 13);
		frame.getContentPane().add(labelAviso);
	}
}
