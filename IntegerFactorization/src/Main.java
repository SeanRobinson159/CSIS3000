import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 268);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JRadioButton rdbtnPollardP = new JRadioButton("Pollard P-1");
		rdbtnPollardP.setSelected(true);
		rdbtnPollardP.setBounds(6, 6, 108, 23);
		contentPane.add(rdbtnPollardP);

		JRadioButton rdbtnPollardRho = new JRadioButton("Pollard Rho");
		rdbtnPollardRho.setBounds(126, 6, 108, 23);
		contentPane.add(rdbtnPollardRho);

		JRadioButton rdbtnPollardRhobig = new JRadioButton(
				"Pollard Rho (Big Integer)");
		rdbtnPollardRhobig.setBounds(246, 6, 198, 23);
		contentPane.add(rdbtnPollardRhobig);

		JButton btnFactor = new JButton("Factor");
		btnFactor.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnFactor.setBounds(361, 41, 83, 91);
		contentPane.add(btnFactor);

		JTextArea ta_input = new JTextArea();
		ta_input.setLineWrap(true);
		ta_input.setBounds(6, 41, 343, 91);
		contentPane.add(ta_input);

		JScrollPane sp = new JScrollPane(ta_input);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setBounds(6, 41, 343, 91);
		contentPane.add(sp);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(0, 165, 450, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblFactor = new JLabel("Factor:");
		lblFactor.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblFactor.setBounds(6, 144, 61, 16);
		contentPane.add(lblFactor);

		JLabel lblTimeToComplete = new JLabel("Time to Complete: ");
		lblTimeToComplete.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTimeToComplete.setBounds(189, 194, 255, 16);
		contentPane.add(lblTimeToComplete);
	}
}
