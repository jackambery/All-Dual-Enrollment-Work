import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

abstract class Board extends JFrame implements ActionListener {

	private static final long serialVersionUID = -3857627073176871817L;
	private JButton buttons[][];
	private JLabel lblHashCode;
	private JLabel lblWinTitle;

	private String boardString = "";

	/**
	 * Constructor that calls setupFrame, sets title.
	 * 
	 * @param title
	 */
	public Board(String title) {
		super(title);
		setupFrame();
	}

	/**
	 * Sets the hashcode 
	 * 
	 * @param hashcode
	 */
	public void setHashCodeLabel(int hashcode) {
		lblHashCode.setText("" + hashcode);
	}

	/**
	 * Sets string label of winner
	 *  
	 * @param result true or false if winner or not
	 */
	public void setWinner(String result) {
		lblWinTitle.setText(result);
	}
	
	/**
	 * Sets winner status
	 * 
	 * @param result true or false if winner or not
	 */
	public void setWinner(boolean result) {
		if (result)
			setWinner("Winner");
		else
			setWinner("Loser");
	}
	
	/**
	 * This method is required because of abstract method, but not used.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) { }

	JPanel setupPanelOne() {
		JPanel panel = new JPanel();
		JLabel lblHCTitle = new JLabel("Hash Code");;
		lblHashCode = new JLabel("" + myHashCode());
		lblWinTitle = new JLabel(""); // Will say either Winner or Loser 
		setWinner(TicTacToe.isWin(boardString));
		panel.setLayout(new FlowLayout());    
		panel.add(lblHCTitle);
		panel.add(lblHashCode);  
		panel.add(lblWinTitle);  
		return panel;
	}

	private JPanel setupPanelTwo() {
		JButton b;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(TicTacToe.ROWS,TicTacToe.COLS));
		buttons = new JButton[TicTacToe.ROWS][TicTacToe.COLS];

		int count = 1;

		for (int r = 0; r < TicTacToe.ROWS; r++) 
			for (int c = 0; c < TicTacToe.COLS; c++) {
				char ch = randomXO();           
				b = new JButton("" + ch);
				boardString += ch;
				b.setActionCommand("" + r + ", " + c);
				b.addActionListener(
						new ActionListener(){  
							public void actionPerformed(ActionEvent e){  
								JButton btn = (JButton) e.getSource();
								btn.setText("" + cycleValue(btn.getText().charAt(0)));
								resetBoardString();
								lblHashCode.setText("" + myHashCode());
							}  
						});              
				panel.add(b);
				buttons[r][c] = b;           
			}

		return panel;
	}

	/**
	 * Switches character to different character.
	 * 
	 * @param ch character to be switched
	 * @return new x, o, or space
	 */
	private static char cycleValue(char ch) {
		switch (ch) {
		case 'x' : 
			return 'o';
		case 'o' : 
			return ' ';
		default  : 
			return 'x';
		}
	}

	/**
	 * Makes visible and sets properties of the output graphic.
	 * 
	 */
	private void setupFrame() {
		JPanel panel2 = new JPanel();

		// Setup Frame
		super.setSize(250, 200);  
		super.setLocationRelativeTo(null);  
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		super.setLayout(new BoxLayout(getContentPane(),BoxLayout.PAGE_AXIS));  

		// Setup Panels
		panel2 = setupPanelTwo();  //panelOne displays a value that requires panelTwo to be ready
		super.add(setupPanelOne());     
		super.add(panel2);  

		super.setVisible(true);  
	}

	/**
	 * Provides a random x, o, or space
	 * 
	 * @return x, o, or space
	 */
	private char randomXO() {
		int rnd = (int) (Math.random()*TicTacToe.CHAR_POSSIBILITIES);
		switch(rnd) {
		case 1 : 
			return 'x';
		case 2 : 
			return 'o';
		default: 
			return ' ';
		}
	}

	/**
	 * Produces the HashMap index for a Board. Enables the user
	 * to find their board in the HashMap with the returned integer index.
	 * 
	 * @return index for HashCode array
	 */
	abstract int myHashCode();

	/**
	 * Returns the character at a specified position in 2d array
	 * 
	 * @param row row location of char
	 * @param col column location of char
	 * @return
	 */
	public char charAt(int row, int col) {
		String value = buttons[row][col].getText();
		if (value.length() > 0)
			return value.charAt(0);
		else
			return '*';
	}

	/**
	 * Takes a string of numbers, converts them to x's, o's, and spaces, then
	 * sets buttons to new x's, o's, and spaces
	 * 
	 * @param s String of 1's, 2's, and 0's
	 */
	public void show(String s) {
		int pos = 0;
		String letter;
		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++){
				char ch = s.charAt(pos);
				switch (ch) {
				case '1' : letter = "x"; 
				break;
				case '2' : letter = "o"; 
				break;
				case '0'  : letter = " "; 
				break;
				default : letter = "" + ch;
				}

				buttons[r][c].setText(letter);
				pos++;
			}
	}

	/**
	 * Sets boardString to current board values
	 * 
	 */
	public void resetBoardString() {
		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++){
				boardString += buttons[r][c].getText();
			}
	}

	/**
	 * Takes a String of x's, o's, and spaces and sets them to respective numbers.
	 * Calls show method which updates tiles.
	 * 
	 * @param s String of x's, o's, and spaces
	 */
	public void setBoardString(String s) {
		boardString = s;
		String temp = "";
		for (int i = 0; i < boardString.length(); i++) {
			switch (boardString.charAt(i)) {
				case 'x': 
					temp += "1"; 
				break;
				case 'o':
					temp += "2"; 
				break;
				case ' ':
					temp += "0"; 
				break;
				default :
					temp += "*";
				}
		}
		show(temp); //a string with 1s, 2s, and 0s
	}
	
}