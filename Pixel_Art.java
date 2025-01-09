import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



/***************************
*@author: Max Marsland
*@description:  
*	This code allows users to create drawings on a 15x15 grid.
*	The user can either draw from scratch or pick an outline.
*	There are instructions included in the palette frame
****************************/

public class Pixel_Art {

	public static void main(String[] args) {
		new Pixel_Art();
	}

	//creates variables and buttons used in action listeners
	static int height = 15;
	static int width = 15;
	static JButton b[][] = new JButton[width][height];
	JButton colorSelect[] = new JButton[12];
	JButton clear = new JButton("Clear Canvas?");
	JButton draw = new JButton("Draw a ?");
	static Color col[] = new Color[12];
	static Color selColor = Color.WHITE;
	JButton selected;
	JButton watermelon;
	JButton smile;
	JButton tree;
	
	
	public Pixel_Art() {
		JFrame canvas = new JFrame("Canvas");
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame colors = new JFrame("Palette");
		colors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pCan = new JPanel(new GridLayout(height, width));
		JPanel pCol = new JPanel();
		
		//set the colors used into an array
		col[0] = Color.white;
		col[1] = Color.BLACK;
		col[2] = Color.BLUE;
		col[3] = new Color(0, 204, 0);
		col[4] = Color.RED;
		col[5] = Color.MAGENTA;
		col[6] = Color.PINK;
		col[7] = Color.YELLOW;
		col[8] = Color.DARK_GRAY;
		col[9] = Color.ORANGE;
		col[10] = new Color(0, 102, 0);
		col[11] = new Color(150, 75, 0);

		JLabel instruction1 = new JLabel("This is Pixel Art. ");
		JLabel instruction2 = new JLabel("Pick a Color and start drawing!");
		JLabel instruction3 = new JLabel("Or choose a preset!");
		watermelon = new JButton("Watermelon");
		watermelon.addActionListener(new waterListener());
		smile = new JButton("Smile");
		smile.addActionListener(new smileListener());
		tree = new JButton("Tree");
		tree.addActionListener(new treeListener());
		pCol.add(instruction1);
		pCol.add(instruction2);
		pCol.add(instruction3);
		pCol.add(watermelon);
		pCol.add(smile);
		pCol.add(tree);
		
		//initializes the buttons for the pixel grid
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				b[i][j] = new JButton();
				b[i][j].setBackground(selColor); 
				b[i][j].setOpaque(true);
				b[i][j].setBorderPainted(false);
				b[i][j].setBorder(null);
				b[i][j].setFont(new Font("Arial", Font.PLAIN, 12));
				pCan.add(b[i][j]);
				b[i][j].addActionListener(new CanvasListener());
			}
		}

		selected = new JButton("0");
		selected.setBackground(selColor); 
		selected.setOpaque(true);
		selected.setBorderPainted(false);
		clear.setSize(150, 50);
		clear.addActionListener(new ClearListener());
		pCol.add(clear);
		
		for(int i = 0; i < colorSelect.length; i++) {
			colorSelect[i] = new JButton("" + i);
			colorSelect[i].setOpaque(true);
			colorSelect[i].setBorderPainted(false);
			pCol.add(colorSelect[i]);
			colorSelect[i].addActionListener(new ColorListener());
			colorSelect[i].setBackground(col[i]);
		}
		//adds panels to frames
		canvas.setSize(35*width, 35*height);
		canvas.add(pCan);
		canvas.setVisible(true);
		colors.setSize(225, 260);
		colors.add(pCol);
		colors.setVisible(true);
	}
	
	/**
	* Creates the outline
	* @param: dictates the outline
	*/
	public static void setLayout(int art) {
		//Resets canvas
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				b[i][j].setText("");
				b[i][j].setBackground(col[0]);
			}
		}
		if(art == 0) {//Water Melon
			b[1][10].setText("3");
			b[1][11].setText("10");
			b[2][9].setText("4");
			b[2][10].setText("6");
			b[2][11].setText("3");
			b[2][12].setText("10");
			b[3][8].setText("4");
			b[3][9].setText("4");
			b[3][10].setText("6");
			b[3][11].setText("6");
			b[3][12].setText("3");
			b[3][13].setText("10");
			b[4][7].setText("4");
			b[4][8].setText("4");
			b[4][9].setText("1");
			b[4][10].setText("4");
			b[4][11].setText("6");
			b[4][12].setText("3");
			b[4][13].setText("10");
			b[5][6].setText("4");
			b[5][7].setText("4");
			b[5][8].setText("4");
			b[5][9].setText("4");
			b[5][10].setText("4");
			b[5][11].setText("6");
			b[5][12].setText("3");
			b[5][13].setText("10");
			b[6][5].setText("4");
			b[6][6].setText("4");
			b[6][7].setText("4");
			b[6][8].setText("1");
			b[6][9].setText("4");
			b[6][10].setText("4");
			b[6][11].setText("6");
			b[6][12].setText("3");
			b[6][13].setText("10");
			b[7][4].setText("4");
			b[7][5].setText("4");
			b[7][6].setText("4");
			b[7][7].setText("4");
			b[7][8].setText("4");
			b[7][9].setText("4");
			b[7][10].setText("4");
			b[7][11].setText("6");
			b[7][12].setText("3");
			b[7][13].setText("10");
			b[8][3].setText("4");
			b[8][4].setText("4");
			b[8][5].setText("4");
			b[8][6].setText("1");
			b[8][7].setText("4");
			b[8][8].setText("4");
			b[8][9].setText("4");
			b[8][10].setText("6");
			b[8][11].setText("6");
			b[8][12].setText("3");
			b[8][13].setText("10");
			b[9][2].setText("4");
			b[9][3].setText("4");
			b[9][4].setText("1");
			b[9][5].setText("4");
			b[9][6].setText("4");
			b[9][7].setText("4");
			b[9][8].setText("4");
			b[9][9].setText("4");
			b[9][10].setText("6");
			b[9][11].setText("3");
			b[9][12].setText("10");
			b[10][1].setText("3");
			b[10][2].setText("6");
			b[10][3].setText("6");
			b[10][4].setText("4");
			b[10][5].setText("4");
			b[10][6].setText("4");
			b[10][7].setText("4");
			b[10][8].setText("6");
			b[10][9].setText("6");
			b[10][10].setText("3");
			b[10][11].setText("10");
			b[10][12].setText("10");
			b[11][1].setText("10");
			b[11][2].setText("3");
			b[11][3].setText("6");
			b[11][4].setText("6");
			b[11][5].setText("6");
			b[11][6].setText("6");
			b[11][7].setText("6");
			b[11][8].setText("6");
			b[11][9].setText("3");
			b[11][10].setText("10");
			b[11][11].setText("10");
			b[12][2].setText("10");
			b[12][3].setText("3");
			b[12][4].setText("3");
			b[12][5].setText("3");
			b[12][6].setText("3");
			b[12][7].setText("3");
			b[12][8].setText("3");
			b[12][9].setText("10");
			b[12][10].setText("10");
			b[13][3].setText("10");
			b[13][4].setText("10");
			b[13][5].setText("10");
			b[13][6].setText("10");
			b[13][7].setText("10");
			b[13][8].setText("10");
		} else if(art == 1) {//Happy Face
			b[1][6].setText("1");
			b[1][7].setText("1");
			b[1][8].setText("1");
			b[2][4].setText("1");
			b[2][5].setText("1");
			b[2][6].setText("7");
			b[2][7].setText("7");
			b[2][8].setText("7");
			b[2][9].setText("1");
			b[2][10].setText("1");
			b[3][3].setText("1");
			b[3][4].setText("7");
			b[3][5].setText("7");
			b[3][6].setText("7");
			b[3][7].setText("7");
			b[3][8].setText("7");
			b[3][9].setText("7");
			b[3][10].setText("7");
			b[3][11].setText("1");
			b[4][2].setText("1");
			b[4][3].setText("7");
			b[4][4].setText("7");
			b[4][5].setText("7");
			b[4][6].setText("7");
			b[4][7].setText("7");
			b[4][8].setText("7");
			b[4][9].setText("7");
			b[4][10].setText("7");
			b[4][11].setText("7");
			b[4][12].setText("1");
			b[5][2].setText("1");
			b[5][3].setText("7");
			b[5][4].setText("1");
			b[5][5].setText("7");
			b[5][6].setText("7");
			b[5][7].setText("7");
			b[5][8].setText("7");
			b[5][9].setText("7");
			b[5][10].setText("1");
			b[5][11].setText("7");
			b[5][12].setText("1");
			b[6][1].setText("1");
			b[6][2].setText("7");
			b[6][3].setText("1");
			b[6][4].setText("7");
			b[6][5].setText("7");
			b[6][6].setText("7");
			b[6][7].setText("7");
			b[6][8].setText("7");
			b[6][9].setText("7");
			b[6][10].setText("7");
			b[6][11].setText("1");
			b[6][12].setText("7");
			b[6][13].setText("1");
			b[7][1].setText("1");
			b[7][2].setText("1");
			b[7][3].setText("7");
			b[7][4].setText("1");
			b[7][5].setText("1");
			b[7][6].setText("1");
			b[7][7].setText("7");
			b[7][8].setText("1");
			b[7][9].setText("1");
			b[7][10].setText("1");
			b[7][11].setText("7");
			b[7][12].setText("1");
			b[7][13].setText("1");
			b[8][1].setText("1");
			b[8][2].setText("7");
			b[8][3].setText("7");
			b[8][4].setText("2");
			b[8][5].setText("7");
			b[8][6].setText("7");
			b[8][7].setText("7");
			b[8][8].setText("7");
			b[8][9].setText("7");
			b[8][10].setText("2");
			b[8][11].setText("7");
			b[8][12].setText("7");
			b[8][13].setText("1");
			b[9][1].setText("1");
			b[9][2].setText("7");
			b[9][3].setText("2");
			b[9][4].setText("2");
			b[9][5].setText("1");
			b[9][6].setText("1");
			b[9][7].setText("1");
			b[9][8].setText("1");
			b[9][9].setText("1");
			b[9][10].setText("2");
			b[9][11].setText("2");
			b[9][12].setText("7");
			b[9][13].setText("1");
			b[10][1].setText("1");
			b[10][2].setText("2");
			b[10][3].setText("2");
			b[10][4].setText("2");
			b[10][5].setText("0");
			b[10][6].setText("0");
			b[10][7].setText("0");
			b[10][8].setText("0");
			b[10][9].setText("0");
			b[10][10].setText("2");
			b[10][11].setText("2");
			b[10][12].setText("2");
			b[10][13].setText("1");
			b[11][1].setText("2");
			b[11][2].setText("2");
			b[11][3].setText("2");
			b[11][4].setText("7");
			b[11][5].setText("1");
			b[11][6].setText("1");
			b[11][7].setText("1");
			b[11][8].setText("1");
			b[11][9].setText("1");
			b[11][10].setText("1");
			b[11][11].setText("2");
			b[11][12].setText("2");
			b[11][13].setText("2");
			b[12][1].setText("2");
			b[12][2].setText("1");
			b[12][3].setText("7");
			b[12][4].setText("7");
			b[12][5].setText("7");
			b[12][6].setText("1");
			b[12][7].setText("1");
			b[12][8].setText("1");
			b[12][9].setText("1");
			b[12][10].setText("7");
			b[12][11].setText("7");
			b[12][12].setText("1");
			b[12][13].setText("2");
			b[13][3].setText("1");
			b[13][4].setText("7");
			b[13][5].setText("7");
			b[13][6].setText("7");
			b[13][7].setText("7");
			b[13][8].setText("7");
			b[13][9].setText("7");
			b[13][10].setText("7");
			b[13][11].setText("1");
			b[14][4].setText("1");
			b[14][5].setText("1");
			b[14][6].setText("1");
			b[14][7].setText("1");
			b[14][8].setText("1");
			b[14][9].setText("1");
			b[14][10].setText("1");
		}else if(art == 2) {//Tree
			b[0][7].setText("7");
			b[0][8].setText("7");
			b[1][7].setText("10");
			b[1][8].setText("10");
			b[2][6].setText("10");
			b[2][7].setText("10");
			b[2][8].setText("10");
			b[2][9].setText("4");
			b[3][5].setText("10");
			b[3][6].setText("10");
			b[3][7].setText("10");
			b[3][8].setText("4");
			b[3][9].setText("10");
			b[3][10].setText("10");
			b[4][6].setText("10");
			b[4][7].setText("4");
			b[4][8].setText("10");
			b[4][9].setText("10");
			b[5][5].setText("10");
			b[5][6].setText("4");
			b[5][7].setText("10");
			b[5][8].setText("7");
			b[5][9].setText("10");
			b[5][10].setText("10");
			b[6][4].setText("10");
			b[6][5].setText("4");
			b[6][6].setText("10");
			b[6][7].setText("10");
			b[6][8].setText("10");
			b[6][9].setText("10");
			b[6][10].setText("10");
			b[6][11].setText("4");
			b[7][3].setText("10");
			b[7][4].setText("4");
			b[7][5].setText("10");
			b[7][6].setText("10");
			b[7][7].setText("7");
			b[7][8].setText("10");
			b[7][9].setText("10");
			b[7][10].setText("10");
			b[7][11].setText("10");
			b[7][12].setText("10");
			b[8][4].setText("10");
			b[8][5].setText("10");
			b[8][6].setText("10");
			b[8][5].setText("10");
			b[8][6].setText("10");
			b[8][7].setText("10");
			b[8][8].setText("10");
			b[8][9].setText("4");
			b[8][10].setText("10");
			b[8][11].setText("10");
			b[8][12].setText("10");
			b[9][3].setText("10");
			b[9][4].setText("10");
			b[9][5].setText("7");
			b[9][6].setText("10");
			b[9][7].setText("10");
			b[9][8].setText("4");
			b[9][9].setText("10");
			b[9][10].setText("10");
			b[9][11].setText("7");
			b[9][12].setText("10");
			b[10][2].setText("10");
			b[10][3].setText("10");
			b[10][4].setText("10");
			b[10][5].setText("10");
			b[10][6].setText("10");
			b[10][7].setText("4");
			b[10][8].setText("10");
			b[10][9].setText("10");
			b[10][10].setText("10");
			b[10][11].setText("10");
			b[10][12].setText("10");
			b[10][13].setText("10");
			b[11][6].setText("11");
			b[11][7].setText("11");
			b[11][8].setText("11");
			b[11][9].setText("11");
			b[12][4].setText("4");
			b[12][6].setText("11");
			b[12][7].setText("11");
			b[12][8].setText("11");
			b[12][9].setText("11");
			b[12][11].setText("4");
			b[13][4].setText("4");
			b[13][5].setText("4");
			b[13][6].setText("11");
			b[13][7].setText("11");
			b[13][8].setText("11");
			b[13][9].setText("11");
			b[13][10].setText("4");
			b[13][11].setText("4");
			b[14][4].setText("4");
			b[14][5].setText("4");
			b[14][6].setText("4");
			b[14][7].setText("4");
			b[14][8].setText("4");
			b[14][9].setText("4");
			b[14][10].setText("4");
			b[14][11].setText("4");
		}
		//Resizes font
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				b[i][j].setFont(new Font("Arial", Font.PLAIN, 12));
			}
		}
	}

	/**
	* When a button on the canvas is clicked this changes the color
	*/
	public class CanvasListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			button.setBackground(selColor);
			button.setOpaque(true);
			button.setBorderPainted(false);
		}
	}

	/**
	* This changes the selected color
	*/
	public class ColorListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			selColor = button.getBackground();
			selected.setBackground(button.getBackground());
			selected.setText(button.getText());
		}
	}

	/**
	* This clears the canvas
	*/
	public class ClearListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < b.length; i++) {
				for(int j = 0; j < b[i].length; j++) {
					b[i][j].setBackground(col[0]);
					b[i][j].setText("");
				}
			}
		}

	}

	/**
	* sets the water melon outline
	*/
	public class waterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			setLayout(0);
		}

	}

	/**
	* sets the happy face outline
	*/
	public class smileListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			setLayout(1);
		}

	}

	/**
	* sets the tree outline
	*/
	public class treeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			setLayout(2);
		}

	}
}



