package appswing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import modelo.Convidado;
import modelo.Ingresso;
import modelo.Participante;
import regras_negocio.Fachada;

public class TelaParticipantes {

	private JFrame frame;
	private JTextField cpfField;
	private JTextField nascField;
	private JTextField empresaField;
	private JCheckBox checkBox;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel labelEmpresa;
	private JButton button_1;
	private JButton button_2;
	private JLabel label_3;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel labelAviso;
	private JSeparator separator_2;
	private JButton button_3;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton button_4;
	private JSeparator separator_3;
	private JLabel label_4;
	private JTextArea textArea;
	private JLabel label_5;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaParticipantes window = new TelaParticipantes();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaParticipantes() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				labelEmpresa.setVisible(false);
				empresaField.setVisible(false);
				listagem();
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		frame.setTitle("4Ever System - Participantes");
		frame.setBounds(100, 100, 1223, 479);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		cpfField = new JTextField();
		cpfField.setBounds(10, 68, 332, 31);
		frame.getContentPane().add(cpfField);
		cpfField.setColumns(10);

		nascField = new JTextField();
		nascField.setColumns(10);
		nascField.setBounds(10, 136, 332, 31);
		frame.getContentPane().add(nascField);

		empresaField = new JTextField();
		empresaField.setColumns(10);
		empresaField.setBounds(10, 262, 332, 31);
		frame.getContentPane().add(empresaField);

		checkBox = new JCheckBox("Você foi convidado?");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					labelEmpresa.setVisible(true);
					empresaField.setVisible(true);
				} else {
					labelEmpresa.setVisible(false);
					empresaField.setVisible(false);
				}
			}
		});

		checkBox.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkBox.setBounds(79, 195, 195, 31);

		frame.getContentPane().add(checkBox);

		label = new JLabel("CPF");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 47, 118, 21);
		frame.getContentPane().add(label);

		label_1 = new JLabel("Data de nascimento");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(10, 119, 164, 21);
		frame.getContentPane().add(label_1);

		label_2 = new JLabel("Ex.: 20/20/2020");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		label_2.setBounds(10, 166, 79, 13);
		frame.getContentPane().add(label_2);

		labelEmpresa = new JLabel("Nome da empresa");
		labelEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelEmpresa.setBounds(10, 245, 164, 21);
		frame.getContentPane().add(labelEmpresa);

		button_1 = new JButton("Limpar");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nascField.setText("");
				cpfField.setText("");
				empresaField.setText("");
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(10, 401, 104, 31);
		frame.getContentPane().add(button_1);

		button_2 = new JButton("Criar");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (checkBox.isSelected()) {
						Fachada.criarConvidado(cpfField.getText(), nascField.getText(), empresaField.getText());
					} else {
						Fachada.criarParticipante(cpfField.getText(), nascField.getText());
					}
					labelAviso.setText("Participante criado com sucesso!");
					listagem();
				} catch (Exception ex) {
					labelAviso.setText(ex.getMessage());
				}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_2.setBounds(238, 401, 104, 31);
		frame.getContentPane().add(button_2);

		label_3 = new JLabel("Criar participante");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(98, 23, 157, 21);
		frame.getContentPane().add(label_3);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(385, 20, 1, 412);
		frame.getContentPane().add(separator);

		separator_1 = new JSeparator();
		separator_1.setBounds(10, 381, 332, 2);
		frame.getContentPane().add(separator_1);

		labelAviso = new JLabel("");
		labelAviso.setBounds(10, 358, 332, 13);
		frame.getContentPane().add(labelAviso);

		separator_2 = new JSeparator();
		separator_2.setBounds(417, 381, 408, 2);
		frame.getContentPane().add(separator_2);

		button_3 = new JButton("Apagar Selecionado");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cpf = (String) table.getValueAt(table.getSelectedRow(), 0);
				try {
					Fachada.apagarParticipante(cpf);
					labelAviso.setText("Participante apagado com sucesso!");
				} catch (Exception ex) {
					labelAviso.setText(ex.getMessage());
				}
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_3.setBounds(608, 401, 218, 31);
		frame.getContentPane().add(button_3);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 70, 406, 295);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		button_4 = new JButton("Listar Ingressos");
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				String cpf = (String) table.getValueAt(table.getSelectedRow(), 0);
				List<Participante> part = Fachada.listarParticipantes();
				for (Participante p : part) {
					if (p.getCPF().equals(cpf)) {
						List<Ingresso> ingressos = p.getIngressos();
						for(Ingresso ing : ingressos) {
							textArea.append(String.format("Código: %s Telefone: %s \n",ing.getCodigo(),ing.getTelefone()));
							
						}
					}
				}

			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_4.setBounds(417, 401, 149, 31);
		frame.getContentPane().add(button_4);

		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(857, 20, 1, 412);
		frame.getContentPane().add(separator_3);

		label_4 = new JLabel("Listagem de ingressos");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(923, 23, 218, 21);
		frame.getContentPane().add(label_4);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(876, 68, 312, 295);
		frame.getContentPane().add(scrollPane_1);

		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);

		label_5 = new JLabel("Listar participantes");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(542, 23, 157, 21);
		frame.getContentPane().add(label_5);
	}

	public void listagem() {
		List<Participante> part = Fachada.listarParticipantes();

		DefaultTableModel model = new DefaultTableModel();

		// criar as colunas da tabela
		model.addColumn("CPF");
		model.addColumn("Data Nasc");
		model.addColumn("Idade");
		model.addColumn("Empresa");

		// criar as linhas da tabela
		for (Participante p : part) {
			if (p instanceof Convidado) {
				Convidado convidado = (Convidado) p; // Downcast para Convidado
				model.addRow(new Object[] { convidado.getCPF() + "", String.join(",", convidado.getNascimento()),
						convidado.calcularIdade(), convidado.getEmpresa() });
			} else {
				model.addRow(
						new Object[] { p.getCPF() + "", String.join(",", p.getNascimento()), p.calcularIdade(), "-" });
			}
		}
		table.setModel(model);
		// labelAviso.setText("resultados: " + lista.size() + " linhas - selecione uma
		// linha");

		// redimensionar a coluna 2
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // desabilita
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); // habilita

	}
}
