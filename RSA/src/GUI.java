import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.math.BigInteger;

public class GUI extends RSA {

	private JFrame frmSeansRsaEncryption;
	private JTextField tf_cipherText,tf_publicKey;

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
		readKeys();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeansRsaEncryption = new JFrame();
		frmSeansRsaEncryption.setResizable(false);
		frmSeansRsaEncryption.setFont(new Font("Courier New", Font.PLAIN, 12));
		frmSeansRsaEncryption.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(GUI.class.getResource("/resources/rsa_icon.png")));
		frmSeansRsaEncryption.setBackground(Color.BLACK);
		frmSeansRsaEncryption.setTitle("Sean's RSA Encryption");
		frmSeansRsaEncryption.setForeground(Color.BLACK);
		frmSeansRsaEncryption.setBounds(100, 100, 901, 600);
		frmSeansRsaEncryption.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeansRsaEncryption.getContentPane().setLayout(null);

		JLabel lblInput = new JLabel("Input Text");
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInput.setBounds(10, 33, 350, 36);
		frmSeansRsaEncryption.getContentPane().add(lblInput);

		JTextArea inputTextField = new JTextArea();
		inputTextField.setBounds(10, 75, 350, 150);
		inputTextField.setLineWrap(true);
		inputTextField.setWrapStyleWord(true);
		frmSeansRsaEncryption.getContentPane().add(inputTextField);

		JTextArea outputTextField = new JTextArea();
		outputTextField.setBackground(Color.WHITE);
		outputTextField.setEditable(false);
		outputTextField.setBounds(525, 75, 350, 150);
		frmSeansRsaEncryption.getContentPane().add(outputTextField);
		outputTextField.setColumns(10);
		outputTextField.setText("This is where the message will appear");

		JLabel lblOutputText = new JLabel("Output Text");
		lblOutputText.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOutputText.setBounds(525, 33, 350, 36);
		frmSeansRsaEncryption.getContentPane().add(lblOutputText);

		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = inputTextField.getText();
				String plainText = toascii(message);

				String cipherText = encipher(new BigInteger(plainText));
				tf_cipherText.setText(cipherText);

				String decipheredText = decipher(new BigInteger(cipherText));
				outputTextField.setText(valueToAscii(decipheredText));
				tf_publicKey.setText(getE() + "\n" + getN());

			}
		});
		btnEncrypt.setBounds(392, 75, 100, 63);
		frmSeansRsaEncryption.getContentPane().add(btnEncrypt);

		tf_cipherText = new JTextField();
		tf_cipherText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // CIPHER TEXT FIELD
				toascii("");
				inputTextField.setText("");
				String decipheredText = decipher(new BigInteger(tf_cipherText
						.getText()));
				outputTextField.setText(valueToAscii(decipheredText));
				tf_publicKey.setText(getE() + "," + getN());
			}
		});
		tf_cipherText.setBounds(10, 267, 865, 40);
		frmSeansRsaEncryption.getContentPane().add(tf_cipherText);
		tf_cipherText.setColumns(10);

		JLabel lblCiphertext = new JLabel("CipherText");
		lblCiphertext.setBounds(10, 239, 100, 16);
		frmSeansRsaEncryption.getContentPane().add(lblCiphertext);

		JScrollBar scrollBar_cipherText = new JScrollBar();
		scrollBar_cipherText.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_cipherText.setBounds(10, 304, 865, 16);
		BoundedRangeModel brm = tf_cipherText.getHorizontalVisibility();
		scrollBar_cipherText.setModel(brm);
		frmSeansRsaEncryption.getContentPane().add(scrollBar_cipherText);

		tf_publicKey = new JTextField();
		tf_publicKey.setEditable(false);
		tf_publicKey.setBounds(10, 358, 865, 40);
		frmSeansRsaEncryption.getContentPane().add(tf_publicKey);
		tf_publicKey.setColumns(10);

		JLabel lblPublicKey = new JLabel("Public Key");
		lblPublicKey.setBounds(10, 330, 203, 16);
		frmSeansRsaEncryption.getContentPane().add(lblPublicKey);

		JScrollBar scrollBar_publicKey = new JScrollBar();
		scrollBar_publicKey.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_publicKey.setBounds(10, 399, 865, 16);
		brm = tf_publicKey.getHorizontalVisibility();
		scrollBar_publicKey.setModel(brm);
		frmSeansRsaEncryption.getContentPane().add(scrollBar_publicKey);

		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toascii("");
				inputTextField.setText("");

				String decipheredText = decipher(new BigInteger(tf_cipherText
						.getText()));
				outputTextField.setText(valueToAscii(decipheredText));
				tf_publicKey.setText(getE() + "," + getN());
			}
		});
		btnDecrypt.setBounds(392, 162, 100, 63);
		frmSeansRsaEncryption.getContentPane().add(btnDecrypt);

		JMenuBar menuBar = new JMenuBar();
		frmSeansRsaEncryption.setJMenuBar(menuBar);

		JMenu m_file = new JMenu("File");
		menuBar.add(m_file);

		JMenuItem mi_saveOutput = new JMenuItem("Save Output");
		m_file.add(mi_saveOutput);

		JMenuItem mi_exit = new JMenuItem("Exit");
		mi_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		m_file.add(mi_exit);

		JMenu m_edit = new JMenu("Edit");
		menuBar.add(m_edit);

		JMenuItem mi_changePublicKey = new JMenuItem("Change Public Key");
		m_edit.add(mi_changePublicKey);

		JMenuItem mi_changePrivateKey = new JMenuItem("Change Private Key");
		m_edit.add(mi_changePrivateKey);

		JMenuItem mntmGenerateNewKeys = new JMenuItem("Generate New Keys");
		mntmGenerateNewKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generateNewKeys();
				JOptionPane.showMessageDialog(null,
						"The new keys were generated successfully",
						"Generate New Keys", 1);
			}
		});
		m_edit.add(mntmGenerateNewKeys);
	}
}
