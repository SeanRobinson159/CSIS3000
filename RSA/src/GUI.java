import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigInteger;


public class GUI {

	private JFrame frmSeansRsaEncryption;
	private JTextField tf_rsa;
	private JTextField tf_publicKey;

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
		lblInput.setBounds(10, 33, 350, 36);
		frmSeansRsaEncryption.getContentPane().add(lblInput);

		JTextArea inputTextField = new JTextArea();
		inputTextField.setBounds(10, 75, 350, 150);
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
				RSA rsa = new RSA();
				String message = inputTextField.getText();

				String ascii = rsa.toascii(message);

				String blocks = rsa.breakIntoBlocks(ascii);

				System.out.println(blocks);
				String code2 = rsa.encipher(new BigInteger(blocks));
				System.out.println(code2);
				tf_rsa.setText(rsa.valueToAscii(code2));

				String decipheredCode2 = rsa.decipher(new BigInteger(code2));
				System.out.println(decipheredCode2);

				// System.out.println(rsa.valueToAscii(decipheredCode2));
				outputTextField.setText(rsa.valueToAscii(decipheredCode2));
			}
		});
		btnEncrypt.setBounds(392, 75, 100, 150);
		frmSeansRsaEncryption.getContentPane().add(btnEncrypt);
		
		tf_rsa = new JTextField();
		tf_rsa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RSA rsa = new RSA();
				String decipheredCode2 = rsa.decipher(new BigInteger(tf_rsa.getText()));
				outputTextField.setText(rsa.valueToAscii(decipheredCode2));
			}
		});
		tf_rsa.setBounds(10, 267, 865, 40);
		frmSeansRsaEncryption.getContentPane().add(tf_rsa);
		tf_rsa.setColumns(10);
		
		JLabel lblCiphertext = new JLabel("CipherText");
		lblCiphertext.setBounds(10, 239, 100, 16);
		frmSeansRsaEncryption.getContentPane().add(lblCiphertext);
		
		tf_publicKey = new JTextField();
		tf_publicKey.setEditable(false);
		tf_publicKey.setBounds(10, 358, 865, 40);
		frmSeansRsaEncryption.getContentPane().add(tf_publicKey);
		tf_publicKey.setColumns(10);
		
		JLabel lblPublicKey = new JLabel("Public Key");
		lblPublicKey.setBounds(10, 330, 203, 16);
		frmSeansRsaEncryption.getContentPane().add(lblPublicKey);
		
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

	}
}
