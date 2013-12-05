package de.nkpmedia.jservercontrol.gui;

import java.util.ArrayList;

import de.nkpmedia.jservercontrol.Controller;
import de.nkpmedia.jservercontrol.UserInterface;
import de.nkpmedia.jservercontrol.gui.handler.MainWindowEventHandler;
import de.nkpmedia.jservercontrol.log.Log;
import de.nkpmedia.jservercontrol.model.elements.Host;

public class MainWindow extends MainWindowBasic
{
	private MainWindowEventHandler mainWindowEventHandler;
	public Controller controller;
	public UserInterface userInterface;
	private ArrayList jServerMonitorPanelList = new ArrayList();

	public MainWindow(UserInterface userInterface)
	{
		super();
		this.userInterface = userInterface;
		this.mainWindowEventHandler = new MainWindowEventHandler(this);
		this.addListener();
	}

	//Adds the listener for the Buttons and other interactiv stuff
	private void addListener()
	{
		super.optionAllButton.addActionListener(this.mainWindowEventHandler);
	}

	//Loada all JServerMonitorPanels in the centerPanel
	public void reloadServerPanel(ArrayList<Host> serverList)
	{
		//Clean the centerPanel and the List with the panels
		Log.log("Clear the centerPanel");
		this.centerPanel.removeAll();
		this.centerPanel.validate();
		this.jServerMonitorPanelList.clear();
		
		Log.log("Add the new MonitorPanels");
		for(Host host : serverList){
			JServerMonitorPanel newPanel = makeJServerMonitoPanel(host);
			this.centerPanel.add(newPanel);
			this.jServerMonitorPanelList.add(newPanel);
			Log.log("Added the Host :"+host.name);
		}
		
	}

	//Produces a new JServerMonitorPanel with a host
	private JServerMonitorPanel makeJServerMonitoPanel(Host host)
	{
		JServerMonitorPanel tmpPanel = new JServerMonitorPanel();
		tmpPanel.nameLabel.setText(host.name);
		tmpPanel.domainLabel.setText(host.ip);
		tmpPanel.portLabel.setText(host.port);
		tmpPanel.setStatusLabel(host.status);
		return tmpPanel;
	}

	public void pressedOptionAllButton()
	{
		// TODO Auto-generated method stub
		
	}
}
