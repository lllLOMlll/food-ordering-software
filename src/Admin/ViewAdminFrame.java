package Admin;

import java.awt.EventQueue;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.MainFrame;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class ViewAdminFrame extends MainFrame {


	private JMenuItem mntmDisconnectFile;
	private JMenuItem mntmQuitFile;
	private JMenuItem mntmCreateRestaurant;
	private JMenuItem mntmEditRestaurant;
	private JMenuItem mntmDeleteRestaurant;
	private JMenuItem mntmAddMenu;
	private JMenuItem mntmEditMenu;
	private JMenuItem mntmDeleteMenu;
	private JMenuItem mntmAddDeliveryMan;
	private JMenuItem mntmEditDeliveryMan;
	private JMenuItem mntmDeleteDeliveryMan;


	/**
	 * Create the frame.
	 */
	public ViewAdminFrame() {
		setTitle("Food Ordering Software - Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmDisconnectFile = new JMenuItem("Disconnect");
		mnFile.add(mntmDisconnectFile);
		
		mntmQuitFile = new JMenuItem("Quit");
		mnFile.add(mntmQuitFile);
		
		JMenu mnRestaurant = new JMenu("Restaurant");
		menuBar.add(mnRestaurant);
		
		mntmCreateRestaurant = new JMenuItem("Create");
		mnRestaurant.add(mntmCreateRestaurant);
		
		mntmEditRestaurant = new JMenuItem("Edit");
		mnRestaurant.add(mntmEditRestaurant);
		
		mntmDeleteRestaurant = new JMenuItem("Delete");
		mnRestaurant.add(mntmDeleteRestaurant);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		mntmAddMenu = new JMenuItem("Add");
		mnMenu.add(mntmAddMenu);
		
		mntmEditMenu = new JMenuItem("Edit");
		mnMenu.add(mntmEditMenu);
		
		mntmDeleteMenu = new JMenuItem("Delete");
		mnMenu.add(mntmDeleteMenu);
		
		JMenu mnDeliveryMan = new JMenu("Delivery Man");
		menuBar.add(mnDeliveryMan);
		
		mntmAddDeliveryMan = new JMenuItem("Add");
		mnDeliveryMan.add(mntmAddDeliveryMan);
		
		mntmEditDeliveryMan = new JMenuItem("Edit");
		mnDeliveryMan.add(mntmEditDeliveryMan);
		
		mntmDeleteDeliveryMan = new JMenuItem("Delete");
		mnDeliveryMan.add(mntmDeleteDeliveryMan);
		

	}

	// Method to set a Panel with the right Frame
	public void setNewPanelAdmin(JPanel panel) {
		setContentPane(panel);
		revalidate();
		repaint();
	}

	/**
	 * @return the disconnectFileMenu
	 */
	public JMenuItem getDisconnectFileMenu() {
		return mntmDisconnectFile;
	}


	/**
	 * @param disconnectFileMenu the disconnectFileMenu to set
	 */
	public void setDisconnectFileMenu(JMenuItem disconnectFileMenu) {
		mntmDisconnectFile = disconnectFileMenu;
	}


	/**
	 * @return the quitFileMenu
	 */
	public JMenuItem getQuitFileMenu() {
		return mntmQuitFile;
	}


	/**
	 * @param quitFileMenu the quitFileMenu to set
	 */
	public void setQuitFileMenu(JMenuItem quitFileMenu) {
		mntmQuitFile = quitFileMenu;
	}


	/**
	 * @return the createRestaurantMenuItem
	 */
	public JMenuItem getCreateRestaurantMenuItem() {
		return mntmCreateRestaurant;
	}


	/**
	 * @param createRestaurantMenuItem the createRestaurantMenuItem to set
	 */
	public void setCreateRestaurantMenuItem(JMenuItem createRestaurantMenuItem) {
		mntmCreateRestaurant = createRestaurantMenuItem;
	}


	/**
	 * @return the editRestaurantMenuItem
	 */
	public JMenuItem getEditRestaurantMenuItem() {
		return mntmEditRestaurant;
	}


	/**
	 * @param editRestaurantMenuItem the editRestaurantMenuItem to set
	 */
	public void setEditRestaurantMenuItem(JMenuItem editRestaurantMenuItem) {
		mntmEditRestaurant = editRestaurantMenuItem;
	}


	/**
	 * @return the deleteRestaurantMenuItem
	 */
	public JMenuItem getDeleteRestaurantMenuItem() {
		return mntmDeleteRestaurant;
	}


	/**
	 * @param deleteRestaurantMenuItem the deleteRestaurantMenuItem to set
	 */
	public void setDeleteRestaurantMenuItem(JMenuItem deleteRestaurantMenuItem) {
		mntmDeleteRestaurant = deleteRestaurantMenuItem;
	}


	/**
	 * @return the addMenuMenu
	 */
	public JMenuItem getAddMenuMenu() {
		return mntmAddMenu;
	}


	/**
	 * @param addMenuMenu the addMenuMenu to set
	 */
	public void setAddMenuMenu(JMenuItem addMenuMenu) {
		mntmAddMenu = addMenuMenu;
	}


	/**
	 * @return the editMenuMenu
	 */
	public JMenuItem getEditMenuMenu() {
		return mntmEditMenu;
	}


	/**
	 * @param editMenuMenu the editMenuMenu to set
	 */
	public void setEditMenuMenu(JMenuItem editMenuMenu) {
		mntmEditMenu = editMenuMenu;
	}


	/**
	 * @return the deleteMenuMenu
	 */
	public JMenuItem getDeleteMenuMenu() {
		return mntmDeleteMenu;
	}


	/**
	 * @param deleteMenuMenu the deleteMenuMenu to set
	 */
	public void setDeleteMenuMenu(JMenuItem deleteMenuMenu) {
		mntmDeleteMenu = deleteMenuMenu;
	}


	/**
	 * @return the addDeliveryManMenu
	 */
	public JMenuItem getAddDeliveryManMenu() {
		return mntmAddDeliveryMan;
	}


	/**
	 * @param addDeliveryManMenu the addDeliveryManMenu to set
	 */
	public void setAddDeliveryManMenu(JMenuItem addDeliveryManMenu) {
		mntmAddDeliveryMan = addDeliveryManMenu;
	}


	/**
	 * @return the editDeliveryManMenu
	 */
	public JMenuItem getEditDeliveryManMenu() {
		return mntmEditDeliveryMan;
	}


	/**
	 * @param editDeliveryManMenu the editDeliveryManMenu to set
	 */
	public void setEditDeliveryManMenu(JMenuItem editDeliveryManMenu) {
		mntmEditDeliveryMan = editDeliveryManMenu;
	}


	/**
	 * @return the deleteDeliveryManMenu
	 */
	public JMenuItem getDeleteDeliveryManMenu() {
		return mntmDeleteDeliveryMan;
	}


	/**
	 * @param deleteDeliveryManMenu the deleteDeliveryManMenu to set
	 */
	public void setDeleteDeliveryManMenu(JMenuItem deleteDeliveryManMenu) {
		mntmDeleteDeliveryMan = deleteDeliveryManMenu;
	}
}
