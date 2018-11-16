package Gui;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui {

	static JFrame mainFrame;
	static JButton btnBubbleSort;
	static JButton btnSelectionSort;
	static JButton btnInsertionSort;
	static JButton btnQuickSort;
	static JTextField textfield;
	// public JLabel lblBubbleSort;
	// public JLabel lblSelectionSort;
	// public JLabel lblInsertionSort;
	// public JLabel lblQuickSort;
	static JLabel lblTextField;
	static int width = 640;
	static int height = 480;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// Fenster

		mainFrame = new JFrame();
		mainFrame.setSize(width, height);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setLayout(null);
		mainFrame.setTitle("Sortieralgorithmen");
		mainFrame.setResizable(false);
		mainFrame.requestFocus();

		// Button BubbleSort
		btnBubbleSort = new JButton("Bubblesort");
		btnBubbleSort.setBounds(35, 380, 120, 25);
		btnBubbleSort.setVisible(true);
		btnBubbleSort.addActionListener (new ActionHandler());
		btnBubbleSort.setBackground(new Color(128, 128, 128));
		btnBubbleSort.setFont(new Font("Arial", Font.PLAIN, 18));
		btnBubbleSort.setForeground(Color.WHITE);
		btnBubbleSort.setBorder(null);
		btnBubbleSort.setFocusPainted(false);
		btnBubbleSort.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent evt) {
				btnBubbleSort.setBackground(new Color(169, 169, 169));
				btnBubbleSort.setForeground(Color.WHITE);
			}

			public void mouseExited(MouseEvent evt) {
				btnBubbleSort.setBackground(new Color(128, 128, 128));
				btnBubbleSort.setForeground(Color.WHITE);
			}

		});

		mainFrame.add(btnBubbleSort);

		// Label BubbleSort
		// lblBubbleSort = new JLabel("Bubblesort",SwingConstants.CENTER);
		// lblBubbleSort.setBounds(20, 410, 120, 25);
		// lblBubbleSort.setVisible(true);

		// mainFrame.add(lblBubbleSort);

		// Button SelectionSort
		btnSelectionSort = new JButton("Selectionsort");
		btnSelectionSort.setBounds(180, 380, 120, 25);
		btnSelectionSort.setVisible(true);
		btnSelectionSort.addActionListener (new ActionHandler());
		btnSelectionSort.setBackground(new Color(128, 128, 128));
		btnSelectionSort.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSelectionSort.setForeground(Color.WHITE);
		btnSelectionSort.setBorder(null);
		btnSelectionSort.setFocusPainted(false);
		btnSelectionSort.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent evt) {
				btnSelectionSort.setBackground(new Color(169, 169, 169));
				btnSelectionSort.setForeground(Color.WHITE);
			}

			public void mouseExited(MouseEvent evt) {
				btnSelectionSort.setBackground(new Color(128, 128, 128));
				btnSelectionSort.setForeground(Color.WHITE);
			}

		});

		mainFrame.add(btnSelectionSort);

		// Label SelectionSort
		// lblSelectionSort = new JLabel("Selectionsort",SwingConstants.CENTER);
		// lblSelectionSort.setBounds(160, 400, 120, 25);
		// lblSelectionSort.setVisible(true);

		// mainFrame.add(lblSelectionSort);

		// Button Insertionsort
		btnInsertionSort = new JButton("Insertionsort");
		btnInsertionSort.setBounds(325, 380, 120, 25);
		btnInsertionSort.setVisible(true);
		btnInsertionSort.addActionListener (new ActionHandler());
		btnInsertionSort.setBackground(new Color(128, 128, 128));
		btnInsertionSort.setFont(new Font("Arial", Font.PLAIN, 18));
		btnInsertionSort.setForeground(Color.WHITE);
		btnInsertionSort.setBorder(null);
		btnInsertionSort.setFocusPainted(false);
		btnInsertionSort.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent evt) {
				btnInsertionSort.setBackground(new Color(169, 169, 169));
				btnInsertionSort.setForeground(Color.WHITE);
			}

			public void mouseExited(MouseEvent evt) {
				btnInsertionSort.setBackground(new Color(128, 128, 128));
				btnInsertionSort.setForeground(Color.WHITE);
			}

		});

		mainFrame.add(btnInsertionSort);

		// Label Insertionsort
		// lblInsertionSort = new JLabel("Insertionsort",SwingConstants.CENTER);
		// lblInsertionSort.setBounds(300, 400, 120, 25);
		// lblInsertionSort.setVisible(true);

		// mainFrame.add(lblInsertionSort);

		// Button Insertionsort
		btnQuickSort = new JButton("Quicksort");
		btnQuickSort.setBounds(470, 380, 120, 25);
		btnQuickSort.setVisible(true);
		btnQuickSort.addActionListener (new ActionHandler());
		btnQuickSort.setBackground(new Color(128, 128, 128));
		btnQuickSort.setFont(new Font("Arial", Font.PLAIN, 18));
		btnQuickSort.setForeground(Color.WHITE);
		btnQuickSort.setBorder(null);
		btnQuickSort.setFocusPainted(false);
		btnQuickSort.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent evt) {
				btnQuickSort.setBackground(new Color(169, 169, 169));
				btnQuickSort.setForeground(Color.WHITE);
			}

			public void mouseExited(MouseEvent evt) {
				btnQuickSort.setBackground(new Color(128, 128, 128));
				btnQuickSort.setForeground(Color.WHITE);
			}

		});

		mainFrame.add(btnQuickSort);
		
		//Textfield Anzahl an Plätzen
		textfield = new JTextField("");
		textfield.setBounds(270, 410, 100, 25);
		
		mainFrame.add(textfield);
		
		// Label Textfeld
		lblTextField = new JLabel("Anzahl :");
		lblTextField.setBounds(220, 410, 50, 25);
		lblTextField.setVisible(true);
		
		mainFrame.add(lblTextField);

	}
}
