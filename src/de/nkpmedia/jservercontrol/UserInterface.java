package de.nkpmedia.jservercontrol;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;

import de.nkpmedia.jservercontrol.gui.GUIJOptionPanel;
import de.nkpmedia.jservercontrol.gui.MainWindow;
import de.nkpmedia.jservercontrol.model.elements.Host;

public class UserInterface
{
	public GUIJOptionPanel jOptionPanel;
	public Controller controller;
	private MainWindow mainWindow;

	public UserInterface(Controller controller)
	{
		this.controller = controller;
		
		this.jOptionPanel = new GUIJOptionPanel();
	}
	
	public void startMainWindow(){
		//Start the main window
		this.mainWindow = new MainWindow(this);
		this.mainWindow.frame.setVisible(true);
	}
	
	public int schowConfirmDialog(Component object, String string)
	{
		return this.jOptionPanel.schowConfirmDialog(object,string);
	}

	public File fileChooser(String currentDirectory, int openDialog, int directoriesOnly)
	{
		return this.jOptionPanel.FielChooser(currentDirectory,openDialog,directoriesOnly);
	}

	public String showInputDialog(String string)
	{
		return this.jOptionPanel.showInputDialog(string);
		
	}

	public void serverPanelReload()
	{
		ArrayList<Host> serverList = this.controller.getServerList();
		this.mainWindow.reloadServerPanel(serverList);
	}
}
