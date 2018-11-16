package Gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{

	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == Gui.btnBubbleSort) {
			System.out.println("1");
			Gui.mainFrame.requestFocus();
			
		} else if (e.getSource() == Gui.btnSelectionSort) {
			
			System.out.println("2");
			Gui.mainFrame.requestFocus();
			
		} else if (e.getSource() == Gui.btnInsertionSort) {
			
			System.out.println("3");
			Gui.mainFrame.requestFocus();
			
		} else if (e.getSource() == Gui.btnQuickSort) {
			
			System.out.println("4");
			Gui.mainFrame.requestFocus();
			
		}
	}
}