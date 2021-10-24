package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import algoritmi.BubbleSort;
import algoritmi.GnomeSort;
import algoritmi.HeapSort;
import algoritmi.InsertionSort;
import algoritmi.QuickSort;
import algoritmi.SelectionSort;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Display extends JFrame {

	private JPanel contentPane;
	private JArray window;
	

	SelectionSort selectionSort = new SelectionSort();
	InsertionSort insertionSort = new InsertionSort();
	BubbleSort bubbleSort = new BubbleSort();
	QuickSort quickSort = new QuickSort();
	GnomeSort gnomeSort = new GnomeSort();
	HeapSort heapSort = new HeapSort();
	
	public static boolean isSorted(JArray array,int n) {
		if (n == 1 || n == 0)
	        return true;
		if (array.getElemAtIndex(n-1) < array.getElemAtIndex(n-2))
	        return false;
	    return isSorted(array, n - 1);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
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
	public Display() {
		setTitle("Vizuelizacija algoritama za sortiranje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		window = new JArray();
		window.setSize(new Dimension(1000,720));
		contentPane.add(window);
		
		JButton btnShuffle = new JButton("Izmesaj");
		btnShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.shuffle(window.array);
			}
		});
		btnShuffle.setBounds(1010, 464, 243, 31);
		contentPane.add(btnShuffle);
		
		JButton btnExit = new JButton("Izadji");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(1010, 569, 243, 31);
		contentPane.add(btnExit);
		
		JButton btnHelp = new JButton("?");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Pritiskom na neko od dugmeta za sortiranje izvrsice se soritranje odgovarajucim algoritmom gde ce biti prikazan svaki korak\n"+
													"                                                                                      Shuffle dugme mesa niz\n"+
													"                                                                   Pritiskom na dugme Close izlazite iz aplikacije!"
													,"Help"
													, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnHelp.setBounds(1215, 657, 49, 23);
		contentPane.add(btnHelp);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1010, 243, 243, 146);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Centaur", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
		
		textArea.setText( "Bubble Sort\n"
						+ "Best: O(n)\n"
						+ "Average: O(n^2)\n"
						+ "Worst: O(n^2)\n"
						+ "Stable: Yes");
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("Selection Sort")) {
				textArea.setText("");
				textArea.setText( "Selection Sort\n"
								+ "Best: O(n^2)\n"
								+ "Average: O(n^2)\n"
								+ "Worst: O(n^2)\n"
								+ "Stable: No");
				}
				else if(comboBox.getSelectedItem().toString().equals("Bubble Sort")) {
					textArea.setText("");
					textArea.setText( "Bubble Sort\n"
									+ "Best: O(n)\n"
									+ "Average: O(n^2)\n"
									+ "Worst: O(n^2)\n"
									+ "Stable: Yes");
				}
				else if(comboBox.getSelectedItem().toString().equals("Insertion Sort")) {
					textArea.setText("");
					textArea.setText( "Insertion Sort\n"
									+ "Best: O(n)\n"
									+ "Average: O(n^2)\n"
									+ "Worst: O(n^2)\n"
									+ "Stable: Yes");
				}
				else if(comboBox.getSelectedItem().toString().equals("Quick Sort")) {
					textArea.setText("");
					textArea.setText( "Insertion Sort\n"
									+ "Best: O(nlogn)\n"
									+ "Average: O(nlogn)\n"
									+ "Worst: O(n^2)\n"
									+ "Stable: No");
				}
				else if(comboBox.getSelectedItem().toString().equals("Gnome Sort")) {
					textArea.setText("");
					textArea.setText( "Gnome Sort\n"
									+ "Best: O(n)\n"
									+ "Average: O(n^2)\n"
									+ "Worst: O(n^2)\n"
									+ "Stable: Yes");
				}
				else if(comboBox.getSelectedItem().toString().equals("Heap Sort")) {
					textArea.setText("");
					textArea.setText( "Heap Sort\n"
									+ "Best: O(nlogn)\n"
									+ "Average: O(nlogn)\n"
									+ "Worst: O(nlogn)\n"
									+ "Stable: No");
				}
			}
		});
		comboBox.setFont(new Font("Centaur", Font.PLAIN, 18));
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bubble Sort", "Insertion Sort", "Selection Sort", "Quick Sort", "Gnome Sort", "Heap Sort"}));
		comboBox.setBounds(1010, 55, 243, 42);
		//Centriranje teksta u comboboxu
		((JLabel)comboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel)comboBox.getRenderer()).setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(comboBox);
		
		
		
		
		
		JButton btnSort = new JButton("Sortiraj");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString().equals("Selection Sort")) {
					if(!isSorted(window,JArray.NUMBER_OF_BARS))
						selectionSort.sort(window);
					else
						JOptionPane.showMessageDialog(null, "     Niz je vec sortiran!");
				}
				else if(comboBox.getSelectedItem().toString().equals("Bubble Sort")) {
					if(!isSorted(window,JArray.NUMBER_OF_BARS))
						bubbleSort.sort(window);
					else
						JOptionPane.showMessageDialog(null, "     Niz je vec sortiran!");
				}
				else if(comboBox.getSelectedItem().toString().equals("Insertion Sort")) {
					if(!isSorted(window,JArray.NUMBER_OF_BARS))
						insertionSort.sort(window);
					else
						JOptionPane.showMessageDialog(null, "     Niz je vec sortiran!");
				}
				else if(comboBox.getSelectedItem().toString().equals("Quick Sort")) {
					if(!isSorted(window,JArray.NUMBER_OF_BARS))
						quickSort.sort(window);
					else
						JOptionPane.showMessageDialog(null, "     Niz je vec sortiran!");
				}
				else if(comboBox.getSelectedItem().toString().equals("Gnome Sort")) {
					if(!isSorted(window,JArray.NUMBER_OF_BARS))
						gnomeSort.sort(window);
					else
						JOptionPane.showMessageDialog(null, "     Niz je vec sortiran!");
				}
				else if(comboBox.getSelectedItem().toString().equals("Heap Sort")) {
					if(!isSorted(window,JArray.NUMBER_OF_BARS))
						heapSort.sort(window);
					else
						JOptionPane.showMessageDialog(null, "     Niz je vec sortiran!");
				}	
			}
		});//izmenjen pristup statickom polju
		btnSort.setBounds(1010, 422, 243, 31);
		contentPane.add(btnSort);
		

		
		
	}
}
