package Restaurateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewRestaurateurFrame extends JFrame {

	private JMenuItem disconnectFileMenu;
	private JMenuItem quitFileMenu;
	private JMenu ordersMenu;
	private JMenuItem markOrderAsReadyMenuItem;
	private JMenuItem acceptOrderMenuItem;

	/**
	 * Create the frame.
	 */
	public ViewRestaurateurFrame() {
		setTitle("Food Ordering Sofware - Restaurateur");
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
		
		quitFileMenu = new JMenuItem("Quit");
		FileMenu.add(quitFileMenu);
		
		ordersMenu = new JMenu("Orders");
		menuBar.add(ordersMenu);
		
		acceptOrderMenuItem = new JMenuItem("Accept order");
		ordersMenu.add(acceptOrderMenuItem);
		
		markOrderAsReadyMenuItem = new JMenuItem("Mark order as ready");
		ordersMenu.add(markOrderAsReadyMenuItem);
		

	}
	
	// Method to set a Panel with the right Frame
	public void setNewPanelRestaurateur(JPanel panel) {
		setContentPane(panel);
		revalidate();
		repaint();
	}
	
	/**
	 * @return the acceptOrderMenuItem
	 */
	public JMenuItem getAcceptOrderMenuItem() {
		return acceptOrderMenuItem;
	}
	/**
	 * @param acceptOrderMenuItem the acceptOrderMenuItem to set
	 */
	public void setAcceptOrderMenuItem(JMenuItem acceptOrderMenuItem) {
		this.acceptOrderMenuItem = acceptOrderMenuItem;
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
		return quitFileMenu;
	}

	/**
	 * @param quitFileMenu the quitFileMenu to set
	 */
	public void setQuitFileMenu(JMenuItem quitFileMenu) {
		this.quitFileMenu = quitFileMenu;
	}

	/**
	 * @return the ordersMenu
	 */
	public JMenu getOrdersMenu() {
		return ordersMenu;
	}

	/**
	 * @param ordersMenu the ordersMenu to set
	 */
	public void setOrdersMenu(JMenu ordersMenu) {
		this.ordersMenu = ordersMenu;
	}

	/**
	 * @return the markOrderAsReadyMenuItem
	 */
	public JMenuItem getMarkOrderAsReadyMenuItem() {
		return markOrderAsReadyMenuItem;
	}

	/**
	 * @param markOrderAsReadyMenuItem the markOrderAsReadyMenuItem to set
	 */
	public void setMarkOrderAsReadyMenuItem(JMenuItem markOrderAsReadyMenuItem) {
		this.markOrderAsReadyMenuItem = markOrderAsReadyMenuItem;
	}
}
