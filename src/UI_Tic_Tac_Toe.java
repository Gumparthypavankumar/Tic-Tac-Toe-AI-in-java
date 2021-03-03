import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class UI_Tic_Tac_Toe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private static int xcount = 0;
	private static int ocount = 0;
	private String Player = "X";
	private JTextField Xcount;
	private JTextField Ocount;
	JButton reset = new JButton("RESET");
	/*
	 * we assume X as 0 and O as 1
	*/
	int buttons[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	protected JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Tic_Tac_Toe frame = new UI_Tic_Tac_Toe();
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
	private boolean checkDraw(int gameBoard[]) {
		if(gameBoard[1]!= -1 && gameBoard[2] != -1 && gameBoard[3] != -1 && gameBoard[4] != -1 && gameBoard[5] != -1 && gameBoard[6] != -1 && gameBoard[7] != -1 && gameBoard[8] != -1 && gameBoard[9] != -1) {
			return true;
		}
		return false;
	}
	
	private boolean checkWin(int gameBoard[]) {
		// Row wise 
		if((gameBoard[1]!= -1 && gameBoard[2] != -1 && gameBoard[3] != -1) && (gameBoard[1] == gameBoard[2]) && (gameBoard[2] == gameBoard[3])) {
			return true;
		}
		else if((gameBoard[4] != -1 && gameBoard[5] != -1 && gameBoard[6] != -1) && (gameBoard[4] == gameBoard[5]) && (gameBoard[5] == gameBoard[6])) {
			return true;
		}
		else if((gameBoard[7] != -1 && gameBoard[8] != -1 && gameBoard[9] != -1) && (gameBoard[7] == gameBoard[8]) && (gameBoard[8] == gameBoard[9])) {
			return true;
		}
		// Column wise
		else if((gameBoard[1] != -1 && gameBoard[4] != -1 && gameBoard[7] != -1) && (gameBoard[1] == gameBoard[4]) && (gameBoard[4] == gameBoard[7])) {
			return true;
		}
		else if((gameBoard[2] != -1 && gameBoard[5] != -1 && gameBoard[8] != -1) && (gameBoard[2] == gameBoard[5]) && (gameBoard[5] == gameBoard[8])) {
			return true;
		}
		else if((gameBoard[3] != -1 && gameBoard[6] != -1 && gameBoard[9] != -1) && (gameBoard[3] == gameBoard[6]) && (gameBoard[6] == gameBoard[9])) {
			return true;
		}
		// Diagonally
		else if((gameBoard[1] != -1 && gameBoard[5] != -1 && gameBoard[9] != -1) && (gameBoard[1] == gameBoard[5]) && (gameBoard[5] == gameBoard[9])) {
			return true;
		}
		else if((gameBoard[3] != -1 && gameBoard[5] != -1 && gameBoard[7] != -1) && (gameBoard[3] == gameBoard[5]) && (gameBoard[5] == gameBoard[7])) {
			return true;
		}
		return false;
	}
	
	public void changePlayer() {
		Player = (Player == "X" ? "O" : "X");
	}
	
	public UI_Tic_Tac_Toe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Xcount = new JTextField();
		Xcount.setHorizontalAlignment(SwingConstants.CENTER);
		Xcount.setFont(new Font("Arial", Font.BOLD, 18));
		Xcount.setBounds(630, 125, 132, 34);
		panel.add(Xcount);
		Xcount.setColumns(12);
		
		Ocount = new JTextField();
		Ocount.setFont(new Font("Arial", Font.BOLD, 18));
		Ocount.setHorizontalAlignment(SwingConstants.CENTER);
		Ocount.setBounds(630, 209, 132, 34);
		panel.add(Ocount);
		Ocount.setColumns(10);
		
		JButton btn1 = new JButton(" ");
		btn1.setFont(new Font("Arial", Font.BOLD, 28));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttons[1] == -1) {
					btn1.setText(Player);
				}
				else {
					JOptionPane.showMessageDialog(frame, "This position is already taken");
					return;
				}
				if(Player.equalsIgnoreCase("X")) {
					btn1.setForeground(Color.RED);
					buttons[1] = 0;
					xcount++;
				}else {
					btn1.setForeground(Color.BLUE);
					buttons[1] = 1;
					ocount++;
				}
				Xcount.setText(Integer.toString(xcount));
				Ocount.setText(Integer.toString(ocount));
				if(checkWin(buttons)) {
					JOptionPane.showMessageDialog(frame, Player + " Wins!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				else if(checkDraw(buttons)) {
					JOptionPane.showMessageDialog(frame, " Game is Drawn!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				changePlayer();
			}
		});
		btn1.setBounds(48, 87, 97, 88);
		panel.add(btn1);
		
		JButton btn2 = new JButton(" ");
		btn2.setFont(new Font("Arial", Font.BOLD, 28));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttons[2] == -1) {
					btn2.setText(Player);
				}
				else {
					JOptionPane.showMessageDialog(frame, "This position is already taken");
					return;
				}
				if(Player.equalsIgnoreCase("X")) {
					btn2.setForeground(Color.RED);
					buttons[2] = 0;
					xcount++;
				}else {
					btn2.setForeground(Color.BLUE);
					buttons[2] = 1;
					ocount++;
				}
				Xcount.setText(Integer.toString(xcount));
				Ocount.setText(Integer.toString(ocount));
				if(checkWin(buttons)) {
					JOptionPane.showMessageDialog(frame, Player + " Wins!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				else if(checkDraw(buttons)) {
					JOptionPane.showMessageDialog(frame, " Game is Drawn!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				changePlayer();
			}
		});
		btn2.setBounds(169, 87, 97, 88);
		panel.add(btn2);
		
		JButton btn3 = new JButton(" ");
		btn3.setFont(new Font("Arial", Font.BOLD, 28));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttons[3] == -1) {
					btn3.setText(Player);
				}
				else {
					JOptionPane.showMessageDialog(frame, "This position is already taken");
					return;
				}
				if(Player.equalsIgnoreCase("X")) {
					btn3.setForeground(Color.RED);
					buttons[3] = 0;
					xcount++;
				}else {
					btn3.setForeground(Color.BLUE);
					buttons[3] = 1;
					ocount++;
				}
				Xcount.setText(Integer.toString(xcount));
				Ocount.setText(Integer.toString(ocount));
				if(checkWin(buttons)) {
					JOptionPane.showMessageDialog(frame, Player + " Wins!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				else if(checkDraw(buttons)) {
					JOptionPane.showMessageDialog(frame, " Game is Drawn!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				changePlayer();
			}
		});
		btn3.setBounds(290, 87, 97, 88);
		panel.add(btn3);
		
		JButton btn4 = new JButton(" ");
		btn4.setFont(new Font("Arial", Font.BOLD, 28));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttons[4] == -1) {
					btn4.setText(Player);
				}
				else {
					JOptionPane.showMessageDialog(frame, "This position is already taken");
					return;
				}
				if(Player.equalsIgnoreCase("X")) {
					btn4.setForeground(Color.RED);
					buttons[4] = 0;
					xcount++;
				}else {
					btn4.setForeground(Color.BLUE);
					buttons[4] = 1;
					ocount++;
				}
				Xcount.setText(Integer.toString(xcount));
				Ocount.setText(Integer.toString(ocount));
				if(checkWin(buttons)) {
					JOptionPane.showMessageDialog(frame, Player + " Wins!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				else if(checkDraw(buttons)) {
					JOptionPane.showMessageDialog(frame, " Game is Drawn!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				changePlayer();
			}
		});
		btn4.setBounds(48, 202, 97, 88);
		panel.add(btn4);
		
		JButton btn5 = new JButton(" ");
		btn5.setFont(new Font("Arial", Font.BOLD, 28));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttons[5] == -1) {
					btn5.setText(Player);
				}
				else {
					JOptionPane.showMessageDialog(frame, "This position is already taken");
					return;
				}
				if(Player.equalsIgnoreCase("X")) {
					btn5.setForeground(Color.RED);
					buttons[5] = 0;
					xcount++;
				}else {
					btn5.setForeground(Color.BLUE);
					buttons[5] = 1;
					ocount++;
				}
				Xcount.setText(Integer.toString(xcount));
				Ocount.setText(Integer.toString(ocount));
				if(checkWin(buttons)) {
					JOptionPane.showMessageDialog(frame, Player + " Wins!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				else if(checkDraw(buttons)) {
					JOptionPane.showMessageDialog(frame, " Game is Drawn!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				changePlayer();
			}
		});
		btn5.setBounds(169, 202, 97, 88);
		panel.add(btn5);
		
		JButton btn6 = new JButton(" ");
		btn6.setFont(new Font("Arial", Font.BOLD, 28));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttons[6] == -1) {
					btn6.setText(Player);
				}
				else {
					JOptionPane.showMessageDialog(frame, "This position is already taken");
					return;
				}
				if(Player.equalsIgnoreCase("X")) {
					btn6.setForeground(Color.RED);
					buttons[6] = 0;
					xcount++;
				}else {
					btn6.setForeground(Color.BLUE);
					buttons[6] = 1;
					ocount++;
				}
				Xcount.setText(Integer.toString(xcount));
				Ocount.setText(Integer.toString(ocount));
				if(checkWin(buttons)) {
					JOptionPane.showMessageDialog(frame, Player + " Wins!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				else if(checkDraw(buttons)) {
					JOptionPane.showMessageDialog(frame, " Game is Drawn!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				changePlayer();
			}
		});
		btn6.setBounds(290, 202, 97, 88);
		panel.add(btn6);
		
		JButton btn7 = new JButton(" ");
		btn7.setFont(new Font("Arial", Font.BOLD, 28));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttons[7] == -1) {
					btn7.setText(Player);
				}
				else {
					JOptionPane.showMessageDialog(frame, "This position is already taken");
					return;
				}
				if(Player.equalsIgnoreCase("X")) {
					btn7.setForeground(Color.RED);
					buttons[7] = 0;
					xcount++;
				}else {
					btn7.setForeground(Color.BLUE);
					buttons[7] = 1;
					ocount++;
				}
				Xcount.setText(Integer.toString(xcount));
				Ocount.setText(Integer.toString(ocount));
				if(checkWin(buttons)) {
					JOptionPane.showMessageDialog(frame, Player + " Wins!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				else if(checkDraw(buttons)) {
					JOptionPane.showMessageDialog(frame, " Game is Drawn!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				changePlayer();
			}
		});
		btn7.setBounds(48, 317, 97, 88);
		panel.add(btn7);
		
		JButton btn8 = new JButton(" ");
		btn8.setFont(new Font("Arial", Font.BOLD, 28));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttons[8] == -1) {
					btn8.setText(Player);
				}
				else {
					JOptionPane.showMessageDialog(frame, "This position is already taken");
					return;
				}
				if(Player.equalsIgnoreCase("X")) {
					btn8.setForeground(Color.RED);
					buttons[8] = 0;
					xcount++;
				}else {
					btn8.setForeground(Color.BLUE);
					buttons[8] = 1;
					ocount++;
				}
				Xcount.setText(Integer.toString(xcount));
				Ocount.setText(Integer.toString(ocount));
				if(checkWin(buttons)) {
					JOptionPane.showMessageDialog(frame, Player + " Wins!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				else if(checkDraw(buttons)) {
					JOptionPane.showMessageDialog(frame, " Game is Drawn!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				changePlayer();
			}
		});
		btn8.setBounds(169, 317, 97, 88);
		panel.add(btn8);
		
		JButton btn9 = new JButton(" ");
		btn9.setFont(new Font("Arial", Font.BOLD, 28));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttons[9] == -1) {
					btn9.setText(Player);
				}
				else {
					JOptionPane.showMessageDialog(frame, "This position is already taken");
					return;
				}
				if(Player.equalsIgnoreCase("X")) {
					btn9.setForeground(Color.RED);
					buttons[9] = 0;
					xcount++;
				}else {
					btn9.setForeground(Color.BLUE);
					buttons[9] = 1;
					ocount++;
				}
				Xcount.setText(Integer.toString(xcount));
				Ocount.setText(Integer.toString(ocount));
				if(checkWin(buttons)) {
					JOptionPane.showMessageDialog(frame, Player + " Wins!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				else if(checkDraw(buttons)) {
					JOptionPane.showMessageDialog(frame, " Game is Drawn!");
					// if game is over just reset fields
					reset.doClick();
					return;
				}
				changePlayer();
			}
		});
		btn9.setBounds(290, 317, 97, 88);
		panel.add(btn9);
		
		JLabel GameTitle = new JLabel("TIC-TAC-TOE");
		GameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		GameTitle.setForeground(Color.MAGENTA);
		GameTitle.setFont(new Font("Arial", Font.BOLD, 36));
		GameTitle.setBounds(165, 13, 378, 32);
		panel.add(GameTitle);
		
		JLabel playerx = new JLabel("PlayerX Count : ");
		playerx.setForeground(Color.RED);
		playerx.setFont(new Font("Arial", Font.BOLD, 18));
		playerx.setBounds(463, 112, 155, 47);
		panel.add(playerx);
		
		JLabel playero = new JLabel("PlayerO Count :");
		playero.setForeground(Color.BLUE);
		playero.setFont(new Font("Arial", Font.BOLD, 18));
		playero.setBounds(463, 202, 155, 47);
		panel.add(playero);
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText("");
				btn2.setText("");
				btn3.setText("");
				btn4.setText("");
				btn5.setText("");
				btn6.setText("");
				btn7.setText("");
				btn8.setText("");
				btn9.setText("");
				xcount = 0;
				ocount = 0;
				Player = "X";
				Xcount.setText(Integer.toString(xcount));
				Ocount.setText(Integer.toString(ocount));
				for(int i=0;i<buttons.length;i++) {
					buttons[i] = -1;
				}
			}
		});
		reset.setBackground(Color.WHITE);
		reset.setForeground(Color.BLACK);
		reset.setFont(new Font("Arial", Font.BOLD, 15));
		reset.setBounds(463, 386, 101, 38);
		panel.add(reset);
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				int dialogBox = JOptionPane.showConfirmDialog(frame, "Confirm You Want to Exit?", "TIC-TAC-TOE", JOptionPane.YES_NO_OPTION);
				if(dialogBox == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		exit.setForeground(Color.RED);
		exit.setBackground(Color.WHITE);
		exit.setFont(new Font("Arial", Font.BOLD, 15));
		exit.setBounds(596, 386, 97, 38);
		panel.add(exit);
	}
}
