package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.AnamneseDAO;
import controle.ConsultaDAO;
import controle.PacienteDAO;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import modelo.TipoUsuario;
import modelo.Usuario;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class TelaHistorico extends JFrame {

	private JPanel contentPane;
	private RoundJPanel panel_4;
	private JButton btnVoltar;
	private RoundJPanel panel_2_1;
	private JTable table;
	private DefaultTableModel modelo;
	private ConsultaDAO cDao = new ConsultaDAO();
	private JLabel lblNewLabel;
	private Consulta consultaSelecionada = null;


	public TelaHistorico(Usuario u, Paciente pacienteSelecionado) {
		setBackground(new Color(0, 81, 81));
		setTitle("Hospital Esmeralda - Histórico");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaHistorico.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 219, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[150.00px,grow][258.00px,grow][207px,grow]", "[39][388px,grow][25][60.00px]"));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(64, 128, 128));
		contentPane.add(panel_1_1, "cell 0 0 3 1,grow");
		
		lblNewLabel = new JLabel("Histórico");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 27));
		panel_1_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 1 3 1,grow");
		panel.setLayout(new MigLayout("", "[2px,grow]", "[2px,grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();

		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel(new Object[][] {}, new String[] {  "Paciente", "Setor", "Médico", "Data"  });
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Paciente", "Setor", "Médico", "Data" }));
		scrollPane.setViewportView(table);
		
		
		panel_2_1 = new RoundJPanel(10, new Color(64, 128, 128));
		panel_2_1.setBackground((Color) null);
		contentPane.add(panel_2_1, "cell 0 2 3 1,grow");
		
		panel_4 = new RoundJPanel(10, new Color(0, 81, 81));
		panel_4.setLayout(null);
		panel_4.setBackground((Color) null);
		contentPane.add(panel_4, "cell 0 3 3 1,grow");
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaPaciente tela = new TelaListaPaciente(u);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setBounds(10, 11, 112, 37);
		panel_4.add(btnVoltar);
		listarConsultas(pacienteSelecionado);
		
		if (u.getTipo() == TipoUsuario.MEDICO) {
			JButton btnAnamnese = new JButton("Anamnese Preenchida");
			btnAnamnese.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (consultaSelecionada == null && consultaSelecionada == null) {
						new DialogMensagemErro("Nenhuma consulta selecionada!").setVisible(true);
						return;
					}
					dispose();
					
					AnamneseDAO aDao = new AnamneseDAO();
					System.out.println(aDao.buscarAnamnesePorIdConsulta(consultaSelecionada.getIdConsulta()));
					System.out.println();
					TelaAnamnese telaAna = new TelaAnamnese(u, aDao.buscarAnamnesePorIdConsulta(consultaSelecionada.getIdConsulta()), rootPaneCheckingEnabled);
					telaAna.setLocationRelativeTo(null);
					telaAna.setVisible(true);
					telaAna.setExtendedState(JFrame.MAXIMIZED_BOTH);		
				}
			});
			btnAnamnese.setIcon(new ImageIcon(TelaHistorico.class.getResource("/img/Trequinhoaindamaiscleareado.png")));
			btnAnamnese.setOpaque(false);
			btnAnamnese.setHorizontalAlignment(SwingConstants.LEFT);
			btnAnamnese.setForeground(Color.WHITE);
			btnAnamnese.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
			btnAnamnese.setFocusPainted(false);
			btnAnamnese.setBorder(null);
			btnAnamnese.setBackground((Color) null);
			btnAnamnese.setBounds(675, 11, 138, 32);
			panel_4.add(btnAnamnese);
		}
	}
	
	private void listarConsultas(Paciente pacienteSelecionado) {
	    modelo.setRowCount(0);
	    for (Consulta consulta : cDao.listarConsultas()) {
	        if (consulta.getEncerrada()==true && consulta.getPaciente().getCpf().equals(pacienteSelecionado.getCpf())) {
	            Object[] rowData;
	            if (consulta.getPaciente().getNomeSocial() == null) {
	                rowData = new Object[]{consulta.getPaciente().getNome(), consulta.getMedico().getEspecialidade().getEspecialidade(), consulta.getMedico().getNome(), consulta.getData()};
	            } else {
	                rowData = new Object[]{consulta.getPaciente().getNomeSocial(), consulta.getMedico().getEspecialidade().getEspecialidade(), consulta.getMedico().getNome(), consulta.getData()};
	            }
	            modelo.addRow(rowData);
	        }
	    }
	    table.setModel(modelo);
	}
}
