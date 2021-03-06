package de.nkpmedia.jservercontrol;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;

import de.nkpmedia.jservercontrol.model.elements.Host;

public class Controller
{	
	private Model model;
	private UserInterface userInterface;

	Controller()
	{
		this.userInterface = new UserInterface(this);
		
		this.model = new Model(this);
		
		this.userInterface.startMainWindow();
		this.userInterface.serverPanelReload();
	}


	public int showConfirmDialog(Component object, String string)
	{
		return this.userInterface.schowConfirmDialog(object, string);
	}

	public File fileChooser(String string, int openDialog, int directoriesOnly)
	{
		return this.userInterface.fileChooser(string, openDialog, directoriesOnly);
	}

	public String showInputDialog(String string)
	{
		return this.userInterface.showInputDialog(string);
	}

	public void pressedOptionAllButton()
	{
		this.model.eventHandler.pressedOptionAllButton();
		
	}


	public ArrayList<Host> getServerList()
	{
		return this.model.getServerList();
	}
}
