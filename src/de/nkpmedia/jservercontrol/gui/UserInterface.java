package de.nkpmedia.jservercontrol.gui;

import java.awt.Component;
import java.io.File;

import de.nkpmedia.jservercontrol.Controller;

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
}
