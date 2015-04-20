import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.BigInteger;

@SuppressWarnings("serial")
public class IntegerFactorization extends JFrame {

	private JPanel contentPane;
	private JTextField ta_output;
	private JLabel lblTimeToComplete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntegerFactorization frame = new IntegerFactorization();
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
	public IntegerFactorization() {
		setTitle("Integer Factorization");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
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

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnPollardP);
		group.add(rdbtnPollardRho);
		group.add(rdbtnPollardRhobig);

		JTextArea ta_input = new JTextArea();
		ta_input.setLineWrap(true);
		ta_input.setBounds(6, 41, 343, 91);
		contentPane.add(ta_input);

		JScrollPane sp = new JScrollPane(ta_input);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setBounds(6, 41, 343, 91);
		contentPane.add(sp);

		ta_output = new JTextField();
		ta_output.setEditable(false);
		ta_output.setBounds(0, 165, 450, 28);
		contentPane.add(ta_output);
		ta_output.setColumns(10);

		JLabel lblFactor = new JLabel("Factor:");
		lblFactor.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblFactor.setBounds(6, 144, 61, 16);
		contentPane.add(lblFactor);

		lblTimeToComplete = new JLabel("Time to Complete: ");
		lblTimeToComplete.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTimeToComplete.setBounds(6, 194, 438, 16);
		contentPane.add(lblTimeToComplete);

		JButton btnFactor = new JButton("Factor");
		btnFactor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Do some stuff based on which radio is selected
				// go();
				double start = 0;
				double end = 0;
				String input = ta_input.getText();
				String output = null;
				if (rdbtnPollardP.isSelected()) {
					if (input.length() < 10 && input.matches("[0-9]+")) {
						PollardP1 p1 = new PollardP1();
						start = System.currentTimeMillis();
						output = p1.factor(Integer.parseInt(input)) + "";
						end = System.currentTimeMillis();
					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"Enter a number that is at most 9 numbers long and contain only numbers",
										"Bad Input", 0);
					}
				} else if (rdbtnPollardRho.isSelected()) {
					if (input.length() < 10&& input.matches("[0-9]+")) {
						PollardRho pRho = new PollardRho();
						start = System.currentTimeMillis();
						output = pRho.factor(Integer.parseInt(input)) + "";
						end = System.currentTimeMillis();
					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"Enter a number that is at most 9 numbers long and contain only numbers",
										"Bad Input", 0);
					}
				} else if (rdbtnPollardRhobig.isSelected()) {
					PollardRhoBigInteger pRhoBig = new PollardRhoBigInteger();
					start = System.currentTimeMillis();
					output = pRhoBig.factor(new BigInteger(input)) + "";
					end = System.currentTimeMillis();
				}
				ta_output.setText(output);
				lblTimeToComplete.setText("Time to Complete: " + (end - start)
						/ 1000 + " s");

			}
		});
		btnFactor.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnFactor.setBounds(361, 41, 83, 91);
		contentPane.add(btnFactor);
	}

	public void go() {
		// this.lblTimeToComplete.setText("Time to Complete: 12390478");
	}
}
