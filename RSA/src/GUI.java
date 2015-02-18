import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.math.BigInteger;

public class GUI extends RSA {

	private JFrame frmSeansRsaEncryption;
	private JTextField tf_cipherText, tf_publicKeyE, tf_publicKeyN;

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
		frmSeansRsaEncryption.setBounds(100, 100, 901, 578);
		frmSeansRsaEncryption.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeansRsaEncryption.getContentPane().setLayout(null);

		JLabel lblInput = new JLabel("Input Text");
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInput.setBounds(10, 33, 350, 36);
		frmSeansRsaEncryption.getContentPane().add(lblInput);

		JLabel lblCharCount = new JLabel();
		lblCharCount.setText("0/100");
		lblCharCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCharCount.setBounds(286, 225, 74, 14);
		frmSeansRsaEncryption.getContentPane().add(lblCharCount);
		
		JTextArea inputTextField = new JTextArea();
		inputTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				lblCharCount.setText(inputTextField.getText().toString().length()+"/100");
			}
		});
		

		
		inputTextField.setBounds(10, 75, 350, 150);
		inputTextField.setLineWrap(true);
		inputTextField.setWrapStyleWord(true);
		frmSeansRsaEncryption.getContentPane().add(inputTextField);

		JTextArea outputTextField = new JTextArea();
		outputTextField.setLineWrap(true);
		outputTextField.setWrapStyleWord(true);
		outputTextField.setBackground(Color.WHITE);
		outputTextField.setEditable(false);
		outputTextField.setBounds(525, 75, 350, 150);
		frmSeansRsaEncryption.getContentPane().add(outputTextField);
		outputTextField.setColumns(10);

		JLabel lblOutputText = new JLabel("Output Text");
		lblOutputText.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOutputText.setBounds(525, 33, 350, 36);
		frmSeansRsaEncryption.getContentPane().add(lblOutputText);

		JButton btnEncrypt = new JButton("Encrypt");
		btnEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				setE(new BigInteger("86148730407763237843547742061985019807142821512709371873112288446663887448663969118408896568216383654241374946654156188189735774465537658022179672598803409019433651686340133348897499626375926363725725"));
//				setN(new BigInteger("841895894136924755178127317930614901753490859659409516751447385829882714829561864710270531665245191027072572146521017874698711992384074865942647654781605169644552367356922747387275955355386106500960780002669670153047823977236824999030655729127114379754071982712719045225543499627938838027229670637711"));
				
				
				String message = inputTextField.getText();
				String plainText = toascii(message);

				String cipherText = encipher(new BigInteger(plainText));
				tf_cipherText.setText(cipherText);

				String decipheredText = decipher(new BigInteger(cipherText));
				outputTextField.setText(valueToAscii(decipheredText));
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

			}
		});
		tf_cipherText.setBounds(10, 267, 865, 40);
		frmSeansRsaEncryption.getContentPane().add(tf_cipherText);
		tf_cipherText.setColumns(10);

		JLabel lblCiphertext = new JLabel("Cipher Text:");
		lblCiphertext.setBounds(10, 239, 100, 16);
		frmSeansRsaEncryption.getContentPane().add(lblCiphertext);

		JScrollBar scrollBar_cipherText = new JScrollBar();
		scrollBar_cipherText.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_cipherText.setBounds(10, 304, 865, 16);
		BoundedRangeModel brm = tf_cipherText.getHorizontalVisibility();
		scrollBar_cipherText.setModel(brm);
		frmSeansRsaEncryption.getContentPane().add(scrollBar_cipherText);

		tf_publicKeyE = new JTextField();
		tf_publicKeyE.setEditable(false);
		tf_publicKeyE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setE(new BigInteger(tf_publicKeyE.getText()));
				JOptionPane.showMessageDialog(null, "Public Key E has been set");
			}
		});
		tf_publicKeyE.setBounds(10, 358, 865, 40);
		frmSeansRsaEncryption.getContentPane().add(tf_publicKeyE);
		tf_publicKeyE.setText(getE()+"");
		tf_publicKeyE.setColumns(10);

		JLabel lblPublicKey = new JLabel("Public Key E:");
		lblPublicKey.setBounds(10, 330, 203, 16);
		frmSeansRsaEncryption.getContentPane().add(lblPublicKey);

		JScrollBar scrollBar_publicKeyE = new JScrollBar();
		scrollBar_publicKeyE.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_publicKeyE.setBounds(10, 399, 865, 16);
		brm = tf_publicKeyE.getHorizontalVisibility();
		scrollBar_publicKeyE.setModel(brm);
		frmSeansRsaEncryption.getContentPane().add(scrollBar_publicKeyE);

		JButton btnDecrypt = new JButton("Decrypt");
		btnDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toascii("");
				inputTextField.setText("");

				String decipheredText = decipher(new BigInteger(tf_cipherText
						.getText()));
				outputTextField.setText(valueToAscii(decipheredText));
			}
		});
		btnDecrypt.setBounds(392, 162, 100, 63);
		frmSeansRsaEncryption.getContentPane().add(btnDecrypt);
		
		JLabel lblPublicKeyN = new JLabel("Public Key N:");
		lblPublicKeyN.setBounds(10, 426, 203, 16);
		frmSeansRsaEncryption.getContentPane().add(lblPublicKeyN);
		
		tf_publicKeyN = new JTextField();
		tf_publicKeyN.setEditable(false);
		tf_publicKeyN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setN(new BigInteger(tf_publicKeyN.getText()));
				JOptionPane.showMessageDialog(null, "Public Key N has been set");

			}
		});
		tf_publicKeyN.setText(getN()+"");
		tf_publicKeyN.setColumns(10);
		tf_publicKeyN.setBounds(10, 454, 865, 40);
		frmSeansRsaEncryption.getContentPane().add(tf_publicKeyN);
		
		JScrollBar scrollBar_publicKeyN = new JScrollBar();
		scrollBar_publicKeyN.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_publicKeyN.setBounds(10, 495, 865, 16);
		brm = tf_publicKeyN.getHorizontalVisibility();
		scrollBar_publicKeyN.setModel(brm);
		frmSeansRsaEncryption.getContentPane().add(scrollBar_publicKeyN);
		


		
		//-----------------------MenuBar---------------------//
		
		JMenuBar menuBar = new JMenuBar();
		frmSeansRsaEncryption.setJMenuBar(menuBar);

		JMenu m_file = new JMenu("File");
		menuBar.add(m_file);

		JMenuItem mi_saveOutput = new JMenuItem("Save Output");
		mi_saveOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser saveFile = new JFileChooser();
				saveFile.showSaveDialog(mi_saveOutput);
				File file = saveFile.getSelectedFile();
				try {
					PrintStream writer = new PrintStream(file);
					writer.println("Public Key E: " + getE());
					writer.println("Public Key N: " + getN());
					writer.println("Cipher Text:  " + tf_cipherText.getText());
					writer.println("Output Text:  " + outputTextField.getText());

					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
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
		mi_changePublicKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tf_publicKeyE.setEditable(true);
				tf_publicKeyN.setEditable(true);
			}
		});
		m_edit.add(mi_changePublicKey);

		JMenuItem mi_changePrivateKey = new JMenuItem("Change Private Key");
		mi_changePrivateKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(mi_changePublicKey);
			}
		});
		m_edit.add(mi_changePrivateKey);

		JMenuItem mntmGenerateNewKeys = new JMenuItem("Generate New Keys");
		mntmGenerateNewKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generateNewKeys();
				JOptionPane.showMessageDialog(null,
						"The new keys were generated successfully and saved to a file",
						"Generate New Keys", 1);
				tf_publicKeyE.setText(getE()+"");
				tf_publicKeyN.setText(getN()+"");
			}
		});
		m_edit.add(mntmGenerateNewKeys);
	}
}
