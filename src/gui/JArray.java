package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class JArray extends JPanel {

	private static final int WINDOW_HEIGHT =680;
	private static final int WINDOW_WIDTH = 1000;
	private static final int BAR_WIDTH = 4;
	private static final Color WINDOW_BACKGROUND = Color.BLACK;
	public static final int NUMBER_OF_BARS = 250;
	private static final Color GRAPHICS_COLOR = Color.WHITE;
	public int[] array;
			
	public JArray() {
		array = new int[NUMBER_OF_BARS];
		for(int i=0;i<NUMBER_OF_BARS;i++)
			array[i]=i+1;
		shuffle(array);
		setBackground(Color.BLACK);
	}
	
	public int arraySize() {
        return array.length;
    }
	
	public int getElemAtIndex(int index) {
		return array[index];
	}
	public void setElemAtIndex(int index,int value) {
		array[index]=value;
	}


	public void shuffle(int[] array) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		for(int i=0; i<NUMBER_OF_BARS; i++)
		{
		    x.add(i);
		}
		Collections.shuffle(x);
		for (int i = 0; i < x.size(); i++) {
		    array[i] = x.get(i);
		  }    
		 repaint();
	}

	 public void swap(int firstIndex, int secondIndex, long delay) {
	        int temp = array[firstIndex];
	        array[firstIndex] = array[secondIndex];
	        array[secondIndex] = temp;
	        sleep(delay);
	        removeAll();
	        paintImmediately(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);;
	    }

	public static void sleep(long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null, "Error");
		}
	}
	

	@Override public void paintComponent(Graphics g) { 
        Graphics2D graphics = (Graphics2D)g;
		super.paintComponents(graphics);
		graphics.setColor(WINDOW_BACKGROUND);
		graphics.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
		graphics.setColor(GRAPHICS_COLOR);
		for(int i = 0;i<NUMBER_OF_BARS;i++) {
			int height = array[i]*2;
			int x = i*(BAR_WIDTH);
			int y = WINDOW_HEIGHT - height;
			graphics.fillRect(x, y, BAR_WIDTH, height);
		}
	}
}
