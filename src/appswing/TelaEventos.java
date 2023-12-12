package appswing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Evento;
import modelo.Ingresso;
import regras_negocio.Fachada;

public class TelaEventos {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel labelAviso;
	private JButton button_1;
	private JButton button_2;
	private JButton button;
	private JTextArea textArea;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaEventos window = new TelaEventos();
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
	public TelaEventos() {
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
				listagem();
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				listagem();
			}
		});
		frame.setTitle("4Ever System - Eventos");
		frame.setBounds(100, 100, 871, 479);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 837, 256);
		frame.getContentPane().add(scrollPane);

		table = new JTable() {
			public boolean isCellEditable(int rowIndex, int vColIndex) {
				return false;
			}
		};

		table.setGridColor(Color.BLACK);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowGrid(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		// Configurar a tabela no JScrollPane
		scrollPane.setViewportView(table);

		labelAviso = new JLabel("");
		labelAviso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAviso.setBounds(20, 301, 827, 29);
		frame.getContentPane().add(labelAviso);

		button_1 = new JButton("Criar");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaCriarEvento tela = new TelaCriarEvento();
			}
		});
		button_1.setBounds(10, 340, 118, 29);
		frame.getContentPane().add(button_1);

		button_2 = new JButton("Apagar");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String id = (String) table.getValueAt(table.getSelectedRow(), 0);
					if (table.getSelectedRow() >= 0) {
						Fachada.apagarEvento(Integer.parseInt(id));
						labelAviso.setText("Apagado o evento: " + id);
						listagem();
					}
				} catch (Exception ex) {
					labelAviso.setText(ex.getMessage());
				}
			}
		});
		button_2.setBounds(10, 379, 118, 29);
		frame.getContentPane().add(button_2);

		button = new JButton("Listar Ingressos");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				List<Evento> lista = Fachada.listarEventos();
				String id = (String) table.getValueAt(table.getSelectedRow(), 0);

				for (Evento ev : lista) {
					if (String.valueOf(ev.getId()).equals(id)) {

						List<Ingresso> ing = ev.getIngressos();
						if (ing.size() == 0) {
							labelAviso.setText("Não há ingressos para esse evento!");
						}

						for (Ingresso i : ing) {
							textArea.append(
									String.format("Código: %s - Telefone: %s%n", i.getCodigo(), i.getTelefone()));
						}

					}
				}
			}
		});
		button.setBounds(729, 403, 118, 29);
		frame.getContentPane().add(button);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(173, 340, 502, 92);
		frame.getContentPane().add(scrollPane_1);

		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
	}

	public void listagem() {
		try {
			List<Evento> lista = Fachada.listarEventos();

			// objeto model contém todas as linhas e colunas da tabela
			DefaultTableModel model = new DefaultTableModel();

			// criar as colunas da tabela
			model.addColumn("Id");
			model.addColumn("Data");
			model.addColumn("Capacidade");
			model.addColumn("Preço");
			model.addColumn("Ingressos");
			model.addColumn("Total");
			model.addColumn("Lotado");

			// criar as linhas da tabela
			for (Evento e : lista) {
				String lotado = "";
				if (e.lotado()) {
					lotado = "Sim";
				} else {
					lotado = "Não";
				}
				model.addRow(new Object[] { e.getId() + "", String.join(",", e.getData()), e.getCapacidade(),
						e.getPreco(), e.quantidadeIngressos(), e.totalArrecadado(), lotado });
			}
			table.setModel(model);
			labelAviso.setText("resultados: " + lista.size() + " linhas   - selecione uma linha");

			// redimensionar a coluna 2
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // desabilita
			table.getColumnModel().getColumn(0).setMaxWidth(50);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); // habilita
		} catch (Exception erro) {
			labelAviso.setText(erro.getMessage());
		}
	}
}
