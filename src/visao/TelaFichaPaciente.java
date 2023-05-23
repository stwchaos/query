package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controle.EnderecoDAO;
import controle.PacienteDAO;
import modelo.Endereco;
import modelo.Paciente;
import modelo.TipoUsuario;
import modelo.Usuario;
import net.miginfocom.swing.MigLayout;

public class TelaFichaPaciente extends JFrame implements InterfaceConfirmacao {

	private JPanel c;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldNomeSocial;
	private JTextField textFieldSexo;
	private JTextField textFieldNascimento;
	private JTextField textFieldCEP;
	private JTextField txtNumCasa;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtRua;
	private JComboBox comboPronome;
	private JTextField txtRegistrosDosPacientes;
	private Paciente pacienteSelecionado;
	private Usuario usuarioAtual;
	private RoundJTextField txtComplemento;

	public TelaFichaPaciente(Usuario usuarioAtual, Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
		this.usuarioAtual = usuarioAtual;
		setTitle("Hospital Esmeralda - Ficha dos Paciente");
		setTitle("Hospital Esmeralda");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaFichaPaciente.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 713);
		BufferedImage bg = null;
		;
		try {
			bg = ImageIO.read(new File("src/img/Background2.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);

		// c = new JPanel();
		c.setBackground(new Color(0, 81, 81));
		c.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(c);
		c.setLayout(new MigLayout("", "[247.00,grow][294.00px,grow][247.00,grow]", "[682px,grow]"));

		JButton btnVoltar = new JButton("Voltar");
		c.add(btnVoltar, "cell 0 0,alignx left,aligny bottom");
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaPaciente telaListaPaciente = new TelaListaPaciente(usuarioAtual);
				telaListaPaciente.setLocationRelativeTo(null);
				telaListaPaciente.setVisible(true);
				telaListaPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		JPanel panel = new RoundJPanel(150);
		c.add(panel, "flowx,cell 1 0,alignx center,growy");
		panel.setLayout(new MigLayout("", "[58.00px,grow][grow][174.00px,grow][-1.00][138.00px,grow]", "[69.00,grow][][116.00px,grow][][][32px][][33px][][33px][14px][20px][14px][20px][][][1px][][21.00px][21.00,grow]"));

		txtRegistrosDosPacientes = new RoundJTextField();
		txtRegistrosDosPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegistrosDosPacientes.setForeground(new Color(255, 255, 255));
		txtRegistrosDosPacientes.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 15));
		txtRegistrosDosPacientes.setEditable(false);
		txtRegistrosDosPacientes.setText("Registro do paciente");
		txtRegistrosDosPacientes.setBackground(new Color(64, 128, 128));
		panel.add(txtRegistrosDosPacientes, "cell 0 0 5 1,grow");
		txtRegistrosDosPacientes.setColumns(10);

		JPanel panel_1 = new RoundJPanel(150, Color.white);
		panel_1.setBackground(null);
		panel_1.setBorder(null);
		// panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "cell 2 2 2 1,grow");
		panel_1.setLayout(new MigLayout("", "[73.00px,grow]", "[96px,grow]"));

		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		lblNewLabel.setIcon(new ImageIcon(TelaFichaPaciente.class.getResource("/img/iconpeople.png")));

		JLabel lblNewLabel_1 = new JLabel("Nome");
		panel.add(lblNewLabel_1, "cell 0 4,alignx left,aligny bottom");

		JLabel lblCPF = new JLabel("CPF");
		panel.add(lblCPF, "cell 4 4");

		textFieldNome = new RoundJTextField();
		textFieldNome.setBackground(new Color(163, 163, 163));
		textFieldNome.setEditable(false);
		textFieldNome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textFieldNome, "cell 0 5 3 1,growx,aligny center");
		textFieldNome.setColumns(10);

		RoundJTextField textFieldCPF = new RoundJTextField();
		textFieldCPF.setBackground(new Color(163, 163, 163));
		textFieldCPF.setText(pacienteSelecionado.getCpf().toString());
		textFieldCPF.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldCPF.setEditable(false);
		textFieldCPF.setColumns(10);
		panel.add(textFieldCPF, "cell 4 5,growx");

		JLabel lblNewLabel_2 = new JLabel("Nome social (se houver)");
		panel.add(lblNewLabel_2, "cell 0 6,alignx left,aligny bottom");

		JLabel lblNewLabel_2_1 = new JLabel("Pronome");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		panel.add(lblNewLabel_2_1, "cell 4 6,alignx left,aligny bottom");

		comboPronome = new RoundComboBox();
		comboPronome.setEditable(true);
		comboPronome.setForeground(Color.BLACK);
		comboPronome.setBackground(new Color(255, 255, 255));
		comboPronome.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		String[] listaPronome = {"Ele/Dele", "Ela/Dela", "Qualquer pronome"};
		for (String string : listaPronome) {
			comboPronome.addItem(string);
		}
		panel.add(comboPronome, "cell 4 7,growx");

		JLabel lblNewLabel_3 = new JLabel("Sexo");
		panel.add(lblNewLabel_3, "cell 0 8,alignx left,aligny bottom");

		JLabel lblNewLabel_6 = new JLabel("Nascimento");
		panel.add(lblNewLabel_6, "cell 2 8,alignx left,aligny bottom");

		JLabel lblNewLabel_5_1_1 = new JLabel("N\u00FAmero da casa");
		panel.add(lblNewLabel_5_1_1, "cell 2 12");

		JLabel lblNewLabel_5_1_1_1 = new JLabel("Bairro");
		panel.add(lblNewLabel_5_1_1_1, "cell 4 12");

		txtNumCasa = new RoundJTextField();
		txtNumCasa.setText((String) null);
		txtNumCasa.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtNumCasa.setColumns(10);
		panel.add(txtNumCasa, "cell 2 13,growx");

		txtBairro = new RoundJTextField();
		txtBairro.setText((String) null);
		txtBairro.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtBairro.setColumns(10);
		panel.add(txtBairro, "cell 4 13,growx");

		JLabel lblNewLabel_5_1_2 = new JLabel("Cidade");
		panel.add(lblNewLabel_5_1_2, "cell 0 14");

		JLabel Rua = new JLabel("Rua");
		panel.add(Rua, "cell 2 14");
		
		JLabel complemento = new JLabel("Complemento");
		panel.add(complemento, "cell 4 14");

		txtCidade = new RoundJTextField();
		txtCidade.setText((String) null);
		txtCidade.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtCidade.setColumns(10);
		panel.add(txtCidade, "cell 0 15,growx");

		txtRua = new RoundJTextField();
		txtRua.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtRua.setColumns(10);
		panel.add(txtRua, "cell 2 15,growx,aligny center");
		
		txtComplemento = new RoundJTextField();
		txtComplemento.setText((String) null);
		txtComplemento.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtComplemento.setColumns(10);
		panel.add(txtComplemento, "cell 4 15,growx");

		JLabel lblNewLabel_7 = new JLabel("E-mail");
		panel.add(lblNewLabel_7, "cell 0 17,growx,aligny bottom");

		textFieldEmail = new RoundJTextField();
		textFieldEmail.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textFieldEmail, "cell 0 18 3 1,growx,aligny center");
		textFieldEmail.setColumns(10);

		textFieldNomeSocial = new RoundJTextField();
		textFieldNomeSocial.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textFieldNomeSocial, "cell 0 7 3 1,growx,aligny center");
		textFieldNomeSocial.setColumns(10);

		textFieldSexo = new RoundJTextField();
		textFieldSexo.setBackground(new Color(163, 163, 163));
		textFieldSexo.setEditable(false);
		textFieldSexo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textFieldSexo, "cell 0 9,growx,aligny center");
		textFieldSexo.setColumns(10);

		textFieldNascimento = new RoundJTextField();
		textFieldNascimento.setBackground(new Color(163, 163, 163));
		textFieldNascimento.setEditable(false);
		textFieldNascimento.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		panel.add(textFieldNascimento, "cell 2 9 3 1,growx,aligny center");
		textFieldNascimento.setColumns(10);

		textFieldCEP = new RoundJTextField();
		textFieldCEP.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldCEP.setColumns(10);
		panel.add(textFieldCEP, "cell 0 13 2 1,growx,aligny center");

		JLabel lblNewLabel_5_1 = new JLabel("CEP");
		panel.add(lblNewLabel_5_1, "cell 0 12,growx,aligny bottom");

		textFieldTelefone = new RoundJTextField();
		panel.add(textFieldTelefone, "cell 0 11 3 1,growx,aligny center");
		textFieldTelefone.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		textFieldTelefone.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Telefone");
		panel.add(lblNewLabel_5, "cell 0 10,growx,aligny bottom");

		JButton btnDeletar = new JButton("Deletar Paciente");
		btnDeletar.setForeground(new Color(255, 255, 255));
		btnDeletar.setBackground(new Color(240, 240, 240));
		btnDeletar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		TelaFichaPaciente tela = this;
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DialogConfirmacao("O paciente será deletado.", tela).setVisible(true);
			}
		});

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String numCep = textFieldCEP.getText();
				String email = textFieldEmail.getText();
				String numTel = textFieldTelefone.getText();
				String nomeSoc = textFieldNomeSocial.getText();
				String numCasa = txtNumCasa.getText();
				String bairro = txtBairro.getText();
				String cidade = txtCidade.getText();
				String rua = txtRua.getText();
				String complemento = txtComplemento.getText();

				Long cep, telefone;
				Integer casa;

				Paciente p = pacienteSelecionado;
				PacienteDAO pDao = new PacienteDAO();
				Endereco en = pacienteSelecionado.getEndereco();
				EnderecoDAO eDao = new EnderecoDAO();

				if (numCep.trim().isEmpty()) {
					new DialogMensagemErro("CEP Vazio").setVisible(true);
					return;
				} else {
					try {
						cep = Long.valueOf(textFieldCEP.getText());
					} catch (NumberFormatException e2) {
						new DialogMensagemErro("Informação inválida no campo CEP!").setVisible(true);
						return;
					}
				}
				if (numTel.trim().isEmpty()) {
					new DialogMensagemErro("Telefone Vazio").setVisible(true);
					return;
				} else {
					try {
						telefone = Long.valueOf(textFieldTelefone.getText());
					} catch (NumberFormatException e2) {
						new DialogMensagemErro("Informação inválida no campo telefone!").setVisible(true);
						return;
					}
				}
				if (email.trim().isEmpty()) {
					new DialogMensagemErro("Email Vazio").setVisible(true);
					return;
				}
				
				if (nomeSoc.trim().isEmpty()) {
					nomeSoc = null;
				}
				
				if (complemento.trim().isEmpty()) {
					complemento = null;
				}
				
				if (numCasa.trim().isEmpty()) {
					new DialogMensagemErro("Numero d/ Casa Vazio").setVisible(true);
					return;
				} else {
					try {
						casa = Integer.valueOf(numCasa);
					} catch (NumberFormatException e2) {
						new DialogMensagemErro("Informação inválida no campo numero d/ casa!").setVisible(true);
						return;
					}
				}
				
				if (bairro.trim().isEmpty()) {
					new DialogMensagemErro("Bairro Vazio").setVisible(true);
					return;
				}
				
				if (cidade.trim().isEmpty()) {
					new DialogMensagemErro("Cidade Vazio").setVisible(true);
					return;
				}
				
				if (rua.trim().isEmpty()) {
					new DialogMensagemErro("Rua Vazio").setVisible(true);
					return;
				}

				p.setPronome(comboPronome.getSelectedItem().toString());
				p.setCep(cep);
				p.setEmail(email);
				p.setNomeSocial(nomeSoc);
				p.setNumCasa(casa);
				p.setTelefone(telefone);
				
				en.setBairro(bairro);
				en.setCidade(cidade);
				en.setComplemento(rua);
				en.setComplemento(complemento);
				en.setRua(rua);
				eDao.alterar(en);
				p.setEndereco(en);
				
				if(pDao.alterar(p)) {
					JOptionPane.showMessageDialog(null, "Sim");
					dispose();
					TelaListaPaciente telaListaPaciente = new TelaListaPaciente(usuarioAtual);
					telaListaPaciente.setLocationRelativeTo(null);
					telaListaPaciente.setVisible(true);
					telaListaPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} else {
					JOptionPane.showMessageDialog(null, "Nao");
				}
			}
		});
		btnConfirmar.setBackground(new Color(64, 128, 128));
		btnConfirmar.setIcon(null);
		btnConfirmar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.add(btnConfirmar, "cell 0 19,growx,aligny center");
		btnDeletar.setForeground(new Color(255, 255, 255));
		btnDeletar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		btnDeletar.setBackground(new Color(191, 0, 0));
		btnDeletar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDeletar.setBorderPainted(false);
		btnDeletar.setFocusPainted(false);
		panel.add(btnDeletar, "cell 4 19,growx,aligny center");
		// }

		JButton btnHistorico = new JButton("Acessar histórico de consultas");
		c.add(btnHistorico, "flowx,cell 2 0,alignx right,aligny bottom");
		btnHistorico.setForeground(new Color(255, 255, 255));
		btnHistorico.setBackground(new Color(0, 81, 81));
		btnHistorico.setCursor(new Cursor(Cursor.HAND_CURSOR));

		if (usuarioAtual.getTipo() == TipoUsuario.MEDICO) {
			JButton btnAnamnese = new JButton("Anamnese");
			btnAnamnese.setForeground(new Color(255, 255, 255));
			btnAnamnese.setBackground(new Color(0, 81, 81));
			btnAnamnese.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					TelaConsultaPendente telaAnterior = new TelaConsultaPendente(usuarioAtual);
					telaAnterior.setLocationRelativeTo(null);
					telaAnterior.setVisible(true);
					telaAnterior.setExtendedState(JFrame.MAXIMIZED_BOTH);
				}
			});
			btnAnamnese.setIcon(
					new ImageIcon(TelaFichaPaciente.class.getResource("/img/Trequinhoaindamaiscleareado.png")));
			c.add(btnAnamnese, "cell 2 0,alignx right,aligny bottom");
		}

		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaHistorico telaHistorico = new TelaHistorico(usuarioAtual, pacienteSelecionado);
				telaHistorico.setLocationRelativeTo(null);
				telaHistorico.setVisible(true);
				telaHistorico.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
		receberDados(pacienteSelecionado);
	}

	private void receberDados(Paciente pacienteSelecionado) {
		textFieldNome.setText(pacienteSelecionado.getNome());
		textFieldNomeSocial.setText(pacienteSelecionado.getNomeSocial());
		comboPronome.setSelectedItem(pacienteSelecionado.getPronome());
		textFieldSexo.setText(pacienteSelecionado.getSexo());
		textFieldNascimento.setText(Date.valueOf(pacienteSelecionado.getNascimento()).toString());
		textFieldTelefone.setText(String.valueOf(pacienteSelecionado.getTelefone()));
		textFieldCEP.setText(String.valueOf(pacienteSelecionado.getCep()));
		txtNumCasa.setText(String.valueOf(pacienteSelecionado.getNumCasa()));
		txtBairro.setText(pacienteSelecionado.getEndereco().getBairro());
		txtCidade.setText(pacienteSelecionado.getEndereco().getCidade());
		txtRua.setText(pacienteSelecionado.getEndereco().getRua());
		textFieldEmail.setText(pacienteSelecionado.getEmail());
		txtComplemento.setText(pacienteSelecionado.getEndereco().getComplemento());
	}

	@Override
	public void btnConfirmacao() {
		PacienteDAO pDao = new PacienteDAO();
		System.out.println(pacienteSelecionado.getNome());
		if (pDao.deletar(pacienteSelecionado)) {
			new DialogMensagemSucesso("Paciente deletado!").setVisible(true);
		} else {
			new DialogMensagemErro("Paciente já possui registros cadastrados!").setVisible(true);
		}
		dispose();
		TelaListaPaciente telaListaPaciente = new TelaListaPaciente(usuarioAtual);
		telaListaPaciente.setLocationRelativeTo(null);
		telaListaPaciente.setVisible(true);
		telaListaPaciente.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	@Override
	public void bntCancelar() {
		// TODO Auto-generated method stub

	}
}