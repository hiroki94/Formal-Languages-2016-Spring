import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

public class HelpFrame extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JTextArea txtrWelcomeTo = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpFrame frame = new HelpFrame();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HelpFrame() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Help Is On The Way");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 429, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 403, 261);
		
		contentPane.add(scrollPane);
		txtrWelcomeTo.setFont(new Font("Arial", Font.PLAIN, 9));
		txtrWelcomeTo.setText("1.    Welcome to Hiroki's Text Editor!\r\nThanks for your interest in this product!  \r\nBy using our product, you agree to these terms (the \u201CHiroki Terms\u201D), \r\nthe Hiroki Text Editor Program Policies and the Hayashi Branding Guidelines \r\n(collectively, the \u201CAgreement\u201D). If ever in conflict, to the extent of such conflict,\r\nthe Hiroki Terms will take precedence over any other terms of the Agreement. \r\nPlease read the Agreement carefully.\r\nAs used in the Agreement, \u201Cyou\u201D or \u201Cpublisher\u201D means the individual or entity \r\nusing the Services (and/or any individual, entity or successor entity, agency or \r\nnetwork acting on your behalf), \u201Cwe,\u201D \u201Cus\u201D or \u201CHayashi\u201D means Hayashi Inc., and \r\nthe \u201Cparties\u201D means you and Hiroki.  \r\n2.    Access to the Services; Hiroki's Text Editor Accounts\r\nYour use of the Services is subject to your creation and our approval of an Hayashi\r\naccount (an \u201CAccount\u201D).  We have the right to refuse or limit your access to the\r\nServices. By submitting an application to use the Services, if you are an individual, \r\nyou represent that you are at least 18 years of age.  You may only have one Account. \r\nBy enrolling in Hiroki's Text Editor, you permit Hayashi to call you, as applicable, \r\n(i) an asswipe, (ii) poophead, and (iii) nimwit. Related search queries and other links\r\n to your websites, mobile applications, media players, mobile content,\r\n and/or other properties approved by Hayashi (each individually a \u201CProperty\u201D). This\r\nwill include you, as a human to be his property. In addition, you grant Hiroki the \r\nright to access, index and cache the Properties, or any portion thereof, including\r\nby automated means. Hayashi Inc may refuse to provide the Services to any Property.\r\nAny Property that is a software application and accesses our Services (a) may require \r\npreapproval by Hiroki in writing, and (b) must comply with Hayashi\u2019s Software\r\n Principles.\r\n3. Referrals\r\nBy using this product, you agree that from this point forth, you will refer to Cats as\r\nDogs, Dogs as Cats. You will also find any suitable woman and bring it to Hayashi Inc.\r\nHiroki may refuse the offer.\r\n4. Service-Specific Terms\r\nIf you choose to implement any of the following Services on a Property, you also\r\n agree to the additional terms identified below:\r\nHayashi: the Hayashi Publisher Guidelines and Policies.\r\nCustom Search Engine: the Custom Search Engine Terms of Service.");
		scrollPane.setViewportView(txtrWelcomeTo);
		txtrWelcomeTo.setBackground(SystemColor.info);
		txtrWelcomeTo.setEditable(false);
		panel.setBounds(0, 0, 434, 261);
		
		contentPane.add(panel);
		panel.setLayout(null);
	}
}
