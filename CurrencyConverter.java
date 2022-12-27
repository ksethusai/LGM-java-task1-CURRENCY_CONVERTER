import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import java.awt.Point;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
public class CurrencyConverter extends JFrame {
	private JPanel contentPane;
	private JTextField amounttext;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter frame = new CurrencyConverter();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public CurrencyConverter() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sudheer\\Desktop\\LetsGrowMore\\JAVA DEVELOPMENT\\CURRENCY_CONVERTER\\IMAGE.jpeg"));
		setLocationByPlatform(true);
		setTitle("Currency Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 604);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		amounttext = new JTextField();
		amounttext.setForeground(new Color(100, 149, 237));
		amounttext.setToolTipText("Enter the value");
		amounttext.setHorizontalAlignment(SwingConstants.CENTER);
		amounttext.setFont(new Font("Arial Black", Font.PLAIN, 36));
		amounttext.setBounds(470, 120, 425, 77);
		contentPane.add(amounttext);
		amounttext.setColumns(10);
		JLabel lblNewLabel = new JLabel("From:");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(302, 226, 113, 69);
		contentPane.add(lblNewLabel);
		JComboBox fromtext = new JComboBox();
		fromtext.setForeground(new Color(100, 149, 237));
		fromtext.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		fromtext.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "INR", "USD", "EURO", "YEN", "POUND"}));
		fromtext.setBounds(470, 231, 328, 69);
		contentPane.add(fromtext);
		JLabel lblNewLabel_2 = new JLabel("To:");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 32));
		lblNewLabel_2.setBounds(326, 336, 100, 69);
		contentPane.add(lblNewLabel_2);
		JComboBox totext = new JComboBox();
		totext.setForeground(new Color(100, 149, 237));
		totext.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
		totext.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "INR", "USD", "EURO", "YEN", "POUND"}));
		totext.setBounds(470, 341, 328, 69);
		contentPane.add(totext);
		JButton btnNewButton = new JButton("CONVERT");
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 32));
		fromtext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totext.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "USD", "INR", "EURO", "YEN", "POUND"}));
				if(fromtext.getSelectedItem().equals("INR")) {
					totext.removeItem("INR");
				}
				if(fromtext.getSelectedItem().equals("USD")) {
					totext.removeItem("USD");
				}
				if(fromtext.getSelectedItem().equals("EURO")) {
					totext.removeItem("EURO");
				}
				if(fromtext.getSelectedItem().equals("YEN")) {
					totext.removeItem("YEN");
				}
				if(fromtext.getSelectedItem().equals("POUND")) {
					totext.removeItem("POUND");
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double tot;
				Double amount = Double.parseDouble(amounttext.getText());
				if(fromtext.getSelectedItem().equals("SELECT")||totext.getSelectedItem().equals("SELECT")) {
					JOptionPane.showMessageDialog(null,"Invalid conversion.Please select the correct conversions...");
				}
				else if(fromtext.getSelectedItem().toString()=="INR"){
					if(totext.getSelectedItem().toString()=="USD") {
						tot=amount*0.012;
						JOptionPane.showMessageDialog(null,amount+" INR ="+tot.toString()+" USD");
					}
					else if(totext.getSelectedItem().toString()=="EURO") {
						tot=amount*0.011;
						JOptionPane.showMessageDialog(null,amount+" INR ="+tot.toString()+" EURO");
					}
					else if(totext.getSelectedItem().toString()=="YEN") {
						tot=amount*1.660;
						JOptionPane.showMessageDialog(null,amount+" INR ="+tot.toString()+" YEN");
					}
					else if(totext.getSelectedItem().toString()=="POUND") {
						tot=amount*0.010;
						JOptionPane.showMessageDialog(null,amount+" INR ="+tot.toString()+" POUNDS");
					}
				}
				else if(fromtext.getSelectedItem().toString()=="USD"){
					if(totext.getSelectedItem().toString()=="INR") {
						tot=amount*82.530;
						JOptionPane.showMessageDialog(null,amount+" USD ="+tot.toString()+" INR");
					}
					else if(totext.getSelectedItem().toString()=="EURO") {
						tot=amount*0.947;
						JOptionPane.showMessageDialog(null,amount+" USD ="+tot.toString()+" EURO");
					}
					else if(totext.getSelectedItem().toString()=="YEN") {
						tot=amount*137.139;
						JOptionPane.showMessageDialog(null,amount+" USD ="+tot.toString()+" YEN");
					}
					else if(totext.getSelectedItem().toString()=="POUND") {
						tot=amount*0.814;
						JOptionPane.showMessageDialog(null,amount+" USD ="+tot.toString()+" POUNDS");
					}
				}
				else if(fromtext.getSelectedItem().toString()=="EURO"){
					if(totext.getSelectedItem().toString()=="INR") {
						tot=amount*87.210;
						JOptionPane.showMessageDialog(null,amount+" EURO ="+tot.toString()+" INR");
					}
					else if(totext.getSelectedItem().toString()=="USD") {
						tot=amount*1.056;
						JOptionPane.showMessageDialog(null,amount+" EURO ="+tot.toString()+" USD");
					}
					else if(totext.getSelectedItem().toString()=="YEN") {
						tot=amount*144.961;
						JOptionPane.showMessageDialog(null,amount+" EURO ="+tot.toString()+" YEN");
					}
					else if(totext.getSelectedItem().toString()=="POUND") {
						tot=amount*0.858;
						JOptionPane.showMessageDialog(null,amount+" EURO ="+tot.toString()+" POUNDS");
					}
				}
				else if(fromtext.getSelectedItem().toString()=="YEN"){
					if(totext.getSelectedItem().toString()=="INR") {
						tot=amount*0.603;
						JOptionPane.showMessageDialog(null,amount+" YEN ="+tot.toString()+" INR");
					}
					else if(totext.getSelectedItem().toString()=="USD") {
						tot=amount*0.007;
						JOptionPane.showMessageDialog(null,amount+" YEN ="+tot.toString()+" USD");
					}
					else if(totext.getSelectedItem().toString()=="EURO") {
						tot=amount*0.007;
						JOptionPane.showMessageDialog(null,amount+" YEN ="+tot.toString()+" EURO");
					}
					else if(totext.getSelectedItem().toString()=="POUND") {
						tot=amount*0.006;
						JOptionPane.showMessageDialog(null,amount+" YEN ="+tot.toString()+" POUNDS");
					}
				}
				else if(fromtext.getSelectedItem().toString()=="POUND"){
					if(totext.getSelectedItem().toString()=="INR") {
						tot=amount*101.402;
						JOptionPane.showMessageDialog(null,amount+" POUND ="+tot.toString()+" INR");
					}
					else if(totext.getSelectedItem().toString()=="EURO") {
						tot=amount*1.163;
						JOptionPane.showMessageDialog(null,amount+" POUND ="+tot.toString()+" EURO");
					}
					else if(totext.getSelectedItem().toString()=="YEN") {
						tot=amount*168.833;
						JOptionPane.showMessageDialog(null,amount+" POUND ="+tot.toString()+" YEN");
					}
					else if(totext.getSelectedItem().toString()=="USD") {
						tot=amount*1.227;
						JOptionPane.showMessageDialog(null,amount+" POUND ="+tot.toString()+" USD");
					}
				}
			}
		});
		btnNewButton.setBounds(326, 465, 328, 91);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel_1 = new JLabel("Enter the Value:");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 32));
		lblNewLabel_1.setBounds(80, 125, 366, 69);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_3 = new JLabel("CURRENCY CONVERTER");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 36));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(36, 11, 910, 85);
		contentPane.add(lblNewLabel_3);
	}
}