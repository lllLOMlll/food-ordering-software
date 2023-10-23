package DeliveryMan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewDeliveryManFrame extends JFrame {
	private JMenuItem disconnectFileMenu;
	private JMenuItem QuitFileMenu;
	private JMenuItem viewDeliveriesMenuItem;
	private JMenuItem acceptDeliveriesMenuItem;
	private JMenuItem endDeliveriesMenuItem;



	/**
	 * Create the frame.
	 */
	public ViewDeliveryManFrame() {
		setTitle("Food Ordering Sofware - Delivery Man");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		disconnectFileMenu = new JMenuItem("Disconnect");
		FileMenu.add(disconnectFileMenu);
		
		QuitFileMenu = new JMenuItem("Quit");
		FileMenu.add(QuitFileMenu);
		
		JMenu deliveryMenu = new JMenu("Deliveries");
		menuBar.add(deliveryMenu);
		
		viewDeliveriesMenuItem = new JMenuItem("View");
		deliveryMenu.add(viewDeliveriesMenuItem);
		
		acceptDeliveriesMenuItem = new JMenuItem("Accept");
		deliveryMenu.add(acceptDeliveriesMenuItem);
		
		endDeliveriesMenuItem = new JMenuItem("End");
		deliveryMenu.add(endDeliveriesMenuItem);
		
	
	}

	// Method to set a Panel with the right Frame
		public void setNewPanelDeliveryMan(JPanel panel) {
			setContentPane(panel);
			revalidate();
			repaint();
		}

	/**
	 * @return the disconnectFileMenu
	 */
	public JMenuItem getDisconnectFileMenu() {
		return disconnectFileMenu;
	}



	/**
	 * @param disconnectFileMenu the disconnectFileMenu to set
	 */
	public void setDisconnectFileMenu(JMenuItem disconnectFileMenu) {
		this.disconnectFileMenu = disconnectFileMenu;
	}



	/**
	 * @return the quitFileMenu
	 */
	public JMenuItem getQuitFileMenu() {
		return QuitFileMenu;
	}



	/**
	 * @param quitFileMenu the quitFileMenu to set
	 */
	public void setQuitFileMenu(JMenuItem quitFileMenu) {
		QuitFileMenu = quitFileMenu;
	}



	/**
	 * @return the viewDeliveriesMenuItem
	 */
	public JMenuItem getViewDeliveriesMenuItem() {
		return viewDeliveriesMenuItem;
	}



	/**
	 * @param viewDeliveriesMenuItem the viewDeliveriesMenuItem to set
	 */
	public void setViewDeliveriesMenuItem(JMenuItem viewDeliveriesMenuItem) {
		this.viewDeliveriesMenuItem = viewDeliveriesMenuItem;
	}



	/**
	 * @return the acceptDeliveriesMenuItem
	 */
	public JMenuItem getAcceptDeliveriesMenuItem() {
		return acceptDeliveriesMenuItem;
	}



	/**
	 * @param acceptDeliveriesMenuItem the acceptDeliveriesMenuItem to set
	 */
	public void setAcceptDeliveriesMenuItem(JMenuItem acceptDeliveriesMenuItem) {
		this.acceptDeliveriesMenuItem = acceptDeliveriesMenuItem;
	}



	/**
	 * @return the endDeliveriesMenuItem
	 */
	public JMenuItem getEndDeliveriesMenuItem() {
		return endDeliveriesMenuItem;
	}



	/**
	 * @param endDeliveriesMenuItem the endDeliveriesMenuItem to set
	 */
	public void setEndDeliveriesMenuItem(JMenuItem endDeliveriesMenuItem) {
		this.endDeliveriesMenuItem = endDeliveriesMenuItem;
	}

}
