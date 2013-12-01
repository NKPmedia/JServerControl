package de.nkpmedia.jservercontrol.gui;

import de.nkpmedia.jservercontrol.Controller;
import de.nkpmedia.jservercontrol.UserInterface;
import de.nkpmedia.jservercontrol.gui.handler.MainWindowEventHandler;

public class MainWindow extends MainWindowBasic
{
	private MainWindowEventHandler mainWindowEventHandler;
	public Controller controller;
	public UserInterface userInterface;

	public MainWindow(UserInterface userInterface){
		super();
		this.userInterface = userInterface;
		this.mainWindowEventHandler = new MainWindowEventHandler(this);
		this.addListener();
	}

	private void addListener()
	{
		super.optionAllButton.addActionListener(this.mainWindowEventHandler);
	}
}
