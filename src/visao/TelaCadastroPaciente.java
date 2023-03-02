package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;

public class TelaCadastroPaciente extends JFrame {

	private JPanel c;
	private JTextField txtInserir;
	private JTextField txtInserir_6;
	private JTextField txtInserir_1;
	private JTextField txtInserir_5;
	private JTextField txtInserir_4;
	private JTextField txtAdicionarInformaes;
	private JTextField txtAno;


	public TelaCadastroPaciente() {
		setTitle("Hospital Esmeralda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroPaciente.class.getResource("/img/logoHospital.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 750);
		
		BufferedImage bg = null;;
		try {
			bg = ImageIO.read(new File("src/img/Background2.png"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel c = new PanelComBackgroundImage(bg);

		//c = new JPanel();
		c.setBackground(new Color(0, 81, 81));
		c.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(c);
		c.setLayout(new MigLayout("", "[grow][350.00px][grow]", "[479.00px,grow]"));
		
		JButton btnVoltar = new JButton("Voltar");
		c.add(btnVoltar, "cell 0 0,alignx left,aligny bottom");
		btnVoltar.setBackground(new Color(0, 81, 81));
		btnVoltar.setForeground(new Color(255, 255, 255));
		btnVoltar.setCursor(new Cursor (Cursor.HAND_CURSOR));
		
//////////testar arredondamento de botao
		btnVoltar.setBorder(new RoundBorder(Color(0,81,81), 1, 10));
		
		
		btnVoltar.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
		dispose();
		TelaPadrao telaPadrao = new TelaPadrao();
		telaPadrao.setLocationRelativeTo(null);
		telaPadrao.setVisible(true);
		telaPadrao.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(225, 225, 225));
		c.add(panel, "cell 1 0,alignx left,growy");
		panel.setLayout(new MigLayout("", "[grow][58px,grow][11px][32px][5px][121px,grow][10px][69px,grow]", "[36px][191px][grow][23.00px][grow,bottom][19.00px,grow][grow,center][][grow][][18.00,grow][22.00,grow][33.00,grow][21.00px,grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "cell 3 1 4 1,grow");
		panel_1.setLayout(new MigLayout("", "[73.00px,grow]", "[96px,grow]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroPaciente.class.getResource("/img/iconpeople.png")));
		panel_1.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_1, "cell 1 2,alignx left,aligny bottom");
		
		txtInserir = new JTextField();
		txtInserir.setText("Inserir");
		txtInserir.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir.setColumns(10);
		panel.add(txtInserir, "cell 1 3 5 1,growx,aligny bottom");
		
		JLabel lblNewLabel_2 = new JLabel("Nome social");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_2, "cell 1 4,alignx left,aligny bottom");
		
		JLabel lblNewLabel_5 = new JLabel("Telefone");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_5, "cell 1 6,alignx left,aligny bottom");
		
		txtInserir_4 = new JTextField();
		txtInserir_4.setText("Inserir");
		txtInserir_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_4.setColumns(10);
		panel.add(txtInserir_4, "cell 1 7,alignx left,aligny top");
		
		JLabel lblNewLabel_5_1 = new JLabel("CEP");
		lblNewLabel_5_1.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_5_1, "cell 1 8,alignx left,aligny bottom");
		
		txtInserir_5 = new JTextField();
		txtInserir_5.setText("Inserir");
		txtInserir_5.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_5.setColumns(10);
		panel.add(txtInserir_5, "cell 1 9,grow");
		
		JLabel lblNewLabel_7 = new JLabel("E-mail");
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_7, "cell 1 10,alignx left,aligny bottom");
		
		txtInserir_6 = new JTextField();
		txtInserir_6.setText("Inserir");
		txtInserir_6.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_6.setColumns(10);
		panel.add(txtInserir_6, "cell 1 11,growx,aligny top");
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_3, "cell 1 12,alignx left,aligny bottom");
		
		JLabel lblNewLabel_6 = new JLabel("Nascimento");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		panel.add(lblNewLabel_6, "cell 5 12,alignx left,aligny bottom");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(225, 225, 225));
		panel.add(panel_3, "cell 1 13 7 1,grow");
		panel_3.setLayout(null);
		
		JComboBox comboDia = new JComboBox();
		comboDia.setToolTipText("");
		comboDia.setForeground(new Color(0, 81, 81));
		comboDia.setBackground(new Color(255, 255, 255));
		comboDia.setBounds(121, 0, 52, 22);
		panel_3.add(comboDia);
		
		JComboBox comboMes = new JComboBox();
		comboMes.setToolTipText("");
		comboMes.setBackground(new Color(255, 255, 255));
		comboMes.setForeground(new Color(0, 81, 81));
		comboMes.setBounds(183, 0, 68, 22);
		panel_3.add(comboMes);
		
		txtAno = new JTextField();
		txtAno.setBounds(261, 1, 59, 20);
		panel_3.add(txtAno);
		txtAno.setColumns(10);
		
		JComboBox comboSexo = new JComboBox();
		comboSexo.setForeground(new Color(0, 81, 81));
		comboSexo.setBackground(new Color(255, 255, 255));
		comboSexo.setBounds(0, 0, 99, 22);
		panel_3.add(comboSexo);
		
		txtInserir_1 = new JTextField();
		txtInserir_1.setText("Inserir");
		txtInserir_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		txtInserir_1.setColumns(10);
		panel.add(txtInserir_1, "cell 1 5 5 1,growx,aligny bottom");
		
		txtAdicionarInformaes = new JTextField();
		txtAdicionarInformaes.setText("Adicionar Informações");
		txtAdicionarInformaes.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdicionarInformaes.setForeground(Color.WHITE);
		txtAdicionarInformaes.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 14));
		txtAdicionarInformaes.setEditable(false);
		txtAdicionarInformaes.setColumns(10);
		txtAdicionarInformaes.setBackground(new Color(64, 128, 128));
		panel.add(txtAdicionarInformaes, "cell 0 0 8 1,grow");
	}


	private Color Color(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}
}
