import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class GUI {

	private JFrame frmSeansRsaEncryption;
	private JTextField tf_rsa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmSeansRsaEncryption.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeansRsaEncryption = new JFrame();
		frmSeansRsaEncryption.setFont(new Font("Courier New", Font.PLAIN, 12));
		frmSeansRsaEncryption.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GUI.class.getResource("/resources/rsa_icon.png")));
		frmSeansRsaEncryption.setBackground(Color.BLACK);
		frmSeansRsaEncryption.setTitle("Sean's RSA Encryption Application");
		frmSeansRsaEncryption.setForeground(Color.BLACK);
		frmSeansRsaEncryption.setBounds(100, 100, 901, 600);
		frmSeansRsaEncryption.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeansRsaEncryption.getContentPane().setLayout(null);

		JLabel lblInput = new JLabel("Input Text");
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInput.setBounds(10, 33, 375, 36);
		frmSeansRsaEncryption.getContentPane().add(lblInput);

		JTextArea inputTextField = new JTextArea();
		inputTextField.setBounds(10, 75, 375, 150);
		frmSeansRsaEncryption.getContentPane().add(inputTextField);

		JTextArea outputTextField = new JTextArea();
		outputTextField.setBackground(Color.WHITE);
		outputTextField.setEditable(false);
		outputTextField.setBounds(475, 75, 400, 150);
		frmSeansRsaEncryption.getContentPane().add(outputTextField);
		outputTextField.setColumns(10);
		outputTextField.setText("This is where the message will appear");

		JLabel lblOutputText = new JLabel("Output Text");
		lblOutputText.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOutputText.setBounds(475, 33, 375, 36);
		frmSeansRsaEncryption.getContentPane().add(lblOutputText);

		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RSA rsa = new RSA();
				String message = inputTextField.getText();

				String ascii = rsa.toascii(message);

				String blocks = rsa.breakIntoBlocks(ascii);

				System.out.println(blocks);
				String code2 = rsa.encipher(new BigInteger(blocks));
				System.out.println(code2);

				String decipheredCode2 = rsa.decipher(new BigInteger(code2));
				System.out.println(decipheredCode2);

				// System.out.println(rsa.valueToAscii(decipheredCode2));
				outputTextField.setText(rsa.valueToAscii(decipheredCode2));
			}
		});
		btnEncrypt.setBounds(393, 75, 75, 150);
		frmSeansRsaEncryption.getContentPane().add(btnEncrypt);
		
		tf_rsa = new JTextField();
		tf_rsa.setBounds(10, 267, 865, 36);
		frmSeansRsaEncryption.getContentPane().add(tf_rsa);
		tf_rsa.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		frmSeansRsaEncryption.setJMenuBar(menuBar);
		
		JMenu m_file = new JMenu("File");
		menuBar.add(m_file);
		
		JMenuItem mi_saveOutput = new JMenuItem("Save Output");
		m_file.add(mi_saveOutput);
		
		JMenuItem mi_exit = new JMenuItem("Exit");
		m_file.add(mi_exit);
		
		JMenu m_edit = new JMenu("Edit");
		menuBar.add(m_edit);
		
		JMenuItem mi_changePublicKey = new JMenuItem("Change Public Key");
		m_edit.add(mi_changePublicKey);
		
		JMenuItem mi_changePrivateKey = new JMenuItem("Change Private Key");
		m_edit.add(mi_changePrivateKey);

	}
}
