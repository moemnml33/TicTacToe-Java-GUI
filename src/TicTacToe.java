import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe extends JFrame implements ActionListener {
	private Random random = new Random();
	private JPanel title_panel;
	private JPanel button_panel;
	private JLabel textField;
	private JButton[]buttons = new JButton[9];
	private boolean player1_Turn;
	public TicTacToe() {
		this.setLayout(new BorderLayout());
		textField = new JLabel();
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.MAGENTA);
		textField.setText("Tic Tac Toe");
		textField.setFont(new Font("Arial", Font.PLAIN, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setOpaque(true);
		
		title_panel = new JPanel();
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 785, 100);
		title_panel.setBackground(Color.BLACK);
		title_panel.setForeground(Color.MAGENTA);
		title_panel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		
		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(3, 3));
		button_panel.setBackground(Color.BLACK);
		button_panel.setForeground(Color.MAGENTA);
		button_panel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		
		for(int i=0; i<9; i++) {
			buttons[i]= new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setBackground(Color.BLACK);
			buttons[i].setForeground(new Color(255-i*20, 0, 255));
			buttons[i].setBorder(BorderFactory.createLineBorder(new Color(255-i*20, 0, 255)));
			buttons[i].setFont(new Font("Arial", Font.BOLD, 100));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textField);
		this.add(title_panel, BorderLayout.NORTH);
		this.add(button_panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.getContentPane().setBackground(Color.BLACK);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		firstTurn();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_Turn) {
					if (buttons[i].getText()=="") {
						buttons[i].setText("X");
						player1_Turn = false;
						textField.setText("O TURN");
						check();
					}
				}
				else {
					if (buttons[i].getText()=="") {
						buttons[i].setText("O");
						player1_Turn = true;
						textField.setText("X TURN");
						check();
					}
				}
			}
		}
	}
	public void firstTurn() {
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) { e.printStackTrace(); }
		
		if(random.nextInt(2)==0) {
			player1_Turn = true;
			textField.setText("X TURN");
		}
		else {
			player1_Turn = false;
			textField.setText("O TURN");
		}
	}
	public void check() {
		//X wins
		if (buttons[0].getText()=="X" &&
			buttons[1].getText()=="X" &&
			buttons[2].getText()=="X" ) {
				xWins(0, 1, 2);
		    }
		if (buttons[3].getText()=="X" &&
			buttons[4].getText()=="X" &&
			buttons[5].getText()=="X" ) {
				xWins(3, 4, 5);
			}
		if (buttons[6].getText()=="X" &&
			buttons[7].getText()=="X" &&
			buttons[8].getText()=="X" ) {
				xWins(6, 7, 8);
			}
		if (buttons[0].getText()=="X" &&
			buttons[3].getText()=="X" &&
			buttons[6].getText()=="X" ) {
				xWins(0, 3, 6);
			}
		if (buttons[1].getText()=="X" &&
			buttons[4].getText()=="X" &&
			buttons[7].getText()=="X" ) {
				xWins(1, 4, 7);
			}
		if (buttons[2].getText()=="X" &&
			buttons[5].getText()=="X" &&
			buttons[8].getText()=="X" ) {
				xWins(2, 5, 8);
			}
		if (buttons[0].getText()=="X" &&
			buttons[4].getText()=="X" &&
			buttons[8].getText()=="X" ) {
				xWins(0, 4, 8);
			}
		if (buttons[2].getText()=="X" &&
			buttons[4].getText()=="X" &&
			buttons[6].getText()=="X" ) {
				xWins(2, 4, 6);
			}
		//O wins
		if (buttons[0].getText()=="O" &&
			buttons[1].getText()=="O" &&
			buttons[2].getText()=="O" ) {
			 	oWins(0, 1, 2);
			}
		if (buttons[3].getText()=="O" &&
			buttons[4].getText()=="O" &&
			buttons[5].getText()=="O" ) {
				oWins(3, 4, 5);
			}
		if (buttons[6].getText()=="O" &&
		    buttons[7].getText()=="O" &&
			buttons[8].getText()=="O" ) {
				oWins(6, 7, 8);
			}
		if (buttons[0].getText()=="O" &&
			buttons[3].getText()=="O" &&
			buttons[6].getText()=="O" ) {
				oWins(0, 3, 6);
			}
		if (buttons[1].getText()=="O" &&
			buttons[4].getText()=="O" &&
			buttons[7].getText()=="O" ) {
				oWins(1, 4, 7);
			}
		if (buttons[2].getText()=="O" &&
			buttons[5].getText()=="O" &&
			buttons[8].getText()=="O" ) {
				oWins(2, 5, 8);
			}
		if (buttons[0].getText()=="O" &&
			buttons[4].getText()=="O" &&
			buttons[8].getText()=="O" ) {
				oWins(0, 4, 8);
			}
		if (buttons[2].getText()=="O" &&
			buttons[4].getText()=="O" &&
			buttons[6].getText()=="O" ) {
				oWins(2, 4, 6);
			}

	}
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(buttons[a].getForeground());
		buttons[b].setBackground(buttons[b].getForeground());
		buttons[c].setBackground(buttons[c].getForeground());
		for (int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
			textField.setText("X WINS");
		}
	}
	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(buttons[a].getForeground());
		buttons[b].setBackground(buttons[b].getForeground());
		buttons[c].setBackground(buttons[c].getForeground());
		for (int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
			textField.setText("O WINS");
		}

	}
}
