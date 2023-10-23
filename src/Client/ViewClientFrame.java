package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewClientFrame extends JFrame {


	private JMenuItem DisconnectFileMenu;
	private JMenuItem QuitFileMenu;
	private JMenuItem editAccount;
	private JMenuItem deleteAccount;
	private JMenuItem orderFood;
	private JMenuItem OrderHistory;


	/**
	 * Create the frame.
	 */
	public ViewClientFrame() {
		setTitle("Food Ordering Sofware - Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		DisconnectFileMenu = new JMenuItem("Disconnect");
		FileMenu.add(DisconnectFileMenu);
		
		QuitFileMenu = new JMenuItem("Quit");
		FileMenu.add(QuitFileMenu);
		
		JMenu AccountMenu = new JMenu(" Account");
		menuBar.add(AccountMenu);
		
		editAccount = new JMenuItem("Edit");
		AccountMenu.add(editAccount);
		
		deleteAccount = new JMenuItem("Delete");
		AccountMenu.add(deleteAccount);
		
		JMenu Order = new JMenu("Order ");
		menuBar.add(Order);
		
		orderFood = new JMenuItem("Order Food");
		Order.add(orderFood);
		
		OrderHistory = new JMenuItem("Order History");
		Order.add(OrderHistory);
		

	}

	// Method to set a Panel with the right Frame
	public void setNewPanelClient(JPanel panel) {
		setContentPane(panel);
		revalidate();
		repaint();
	}

	/**
	 * @return the disconnectFileMenu
	 */
	public JMenuItem getDisconnectFileMenu() {
		return DisconnectFileMenu;
	}


	/**
	 * @param disconnectFileMenu the disconnectFileMenu to set
	 */
	public void setDisconnectFileMenu(JMenuItem disconnectFileMenu) {
		DisconnectFileMenu = disconnectFileMenu;
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
	 * @return the editAccount
	 */
	public JMenuItem getEditAccount() {
		return editAccount;
	}


	/**
	 * @param editAccount the editAccount to set
	 */
	public void setEditAccount(JMenuItem editAccount) {
		this.editAccount = editAccount;
	}


	/**
	 * @return the deleteAccount
	 */
	public JMenuItem getDeleteAccount() {
		return deleteAccount;
	}


	/**
	 * @param deleteAccount the deleteAccount to set
	 */
	public void setDeleteAccount(JMenuItem deleteAccount) {
		this.deleteAccount = deleteAccount;
	}


	/**
	 * @return the orderFood
	 */
	public JMenuItem getOrderFood() {
		return orderFood;
	}


	/**
	 * @param orderFood the orderFood to set
	 */
	public void setOrderFood(JMenuItem orderFood) {
		this.orderFood = orderFood;
	}


	/**
	 * @return the orderHistory
	 */
	public JMenuItem getOrderHistory() {
		return OrderHistory;
	}


	/**
	 * @param orderHistory the orderHistory to set
	 */
	public void setOrderHistory(JMenuItem orderHistory) {
		OrderHistory = orderHistory;
	}



}
