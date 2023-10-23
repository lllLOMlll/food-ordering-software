package Manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewManagerFrame extends JFrame {
	private JMenuItem disconnectFileMenu;
	private JMenuItem quitFileMenu;
	private JMenuItem viewRestaurantOrdersMenuItem;
	private JMenuItem createMenuMenuyItem;
	private JMenuItem editMenuMenuMenuItem;
	private JMenuItem deleteMenuMenuItem;
	private JMenu mnDeliveryMan;
	private JMenuItem mntmEditDeliveryMan;

	


	/**
	 * Create the frame.
	 */
	public ViewManagerFrame() {
		setTitle("Food Ordering Sofware - Manager");
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
		
		JMenu restaurantMenu = new JMenu("Order");
		menuBar.add(restaurantMenu);
		
		viewRestaurantOrdersMenuItem = new JMenuItem("View restaurant's orders");
		restaurantMenu.add(viewRestaurantOrdersMenuItem);
		
		JMenu MenuMenu = new JMenu("Menu");
		menuBar.add(MenuMenu);
		
		createMenuMenuyItem = new JMenuItem("Create");
		MenuMenu.add(createMenuMenuyItem);
		
		editMenuMenuMenuItem = new JMenuItem("Edit");
		MenuMenu.add(editMenuMenuMenuItem);
		
		deleteMenuMenuItem = new JMenuItem("Delete");
		MenuMenu.add(deleteMenuMenuItem);
		
		mnDeliveryMan = new JMenu("Delivery Man");
		menuBar.add(mnDeliveryMan);
		
		mntmEditDeliveryMan = new JMenuItem("Edit Delivery Man");
		mnDeliveryMan.add(mntmEditDeliveryMan);
		

	}


	// Method to set a Panel with the right Frame
	public void setNewPanelManager(JPanel panel) {
		setContentPane(panel);
		revalidate();
		repaint();
	}

	/**
	 * @return the viewRestaurantOrdersMenuItem
	 */
	public JMenuItem getViewRestaurantOrdersMenuItem() {
		return viewRestaurantOrdersMenuItem;
	}




	/**
	 * @param viewRestaurantOrdersMenuItem the viewRestaurantOrdersMenuItem to set
	 */
	public void setViewRestaurantOrdersMenuItem(JMenuItem viewRestaurantOrdersMenuItem) {
		this.viewRestaurantOrdersMenuItem = viewRestaurantOrdersMenuItem;
	}




	/**
	 * @return the createMenuMenuyItem
	 */
	public JMenuItem getCreateMenuMenuyItem() {
		return createMenuMenuyItem;
	}




	/**
	 * @param createMenuMenuyItem the createMenuMenuyItem to set
	 */
	public void setCreateMenuMenuyItem(JMenuItem createMenuMenuyItem) {
		this.createMenuMenuyItem = createMenuMenuyItem;
	}




	/**
	 * @return the editMenuMenuMenuItem
	 */
	public JMenuItem getEditMenuMenuMenuItem() {
		return editMenuMenuMenuItem;
	}




	/**
	 * @param editMenuMenuMenuItem the editMenuMenuMenuItem to set
	 */
	public void setEditMenuMenuMenuItem(JMenuItem editMenuMenuMenuItem) {
		this.editMenuMenuMenuItem = editMenuMenuMenuItem;
	}




	/**
	 * @return the deleteMenuMenuItem
	 */
	public JMenuItem getDeleteMenuMenuItem() {
		return deleteMenuMenuItem;
	}




	/**
	 * @param deleteMenuMenuItem the deleteMenuMenuItem to set
	 */
	public void setDeleteMenuMenuItem(JMenuItem deleteMenuMenuItem) {
		this.deleteMenuMenuItem = deleteMenuMenuItem;
	}




	/**
	 * @return the mnDeliveryMan
	 */
	public JMenu getMnDeliveryMan() {
		return mnDeliveryMan;
	}




	/**
	 * @param mnDeliveryMan the mnDeliveryMan to set
	 */
	public void setMnDeliveryMan(JMenu mnDeliveryMan) {
		this.mnDeliveryMan = mnDeliveryMan;
	}




	/**
	 * @return the mntmEditDeliveryMan
	 */
	public JMenuItem getMntmEditDeliveryMan() {
		return mntmEditDeliveryMan;
	}




	/**
	 * @param mntmEditDeliveryMan the mntmEditDeliveryMan to set
	 */
	public void setMntmEditDeliveryMan(JMenuItem mntmEditDeliveryMan) {
		this.mntmEditDeliveryMan = mntmEditDeliveryMan;
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





}
