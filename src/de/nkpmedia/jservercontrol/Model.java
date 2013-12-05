package de.nkpmedia.jservercontrol;

import java.util.ArrayList;

import de.nkpmedia.jservercontrol.gui.MainWindow;
import de.nkpmedia.jservercontrol.model.EventHandler;
import de.nkpmedia.jservercontrol.model.config.Config;
import de.nkpmedia.jservercontrol.model.config.ConfigHandler;
import de.nkpmedia.jservercontrol.model.config.Security;
import de.nkpmedia.jservercontrol.model.elements.Host;

public class Model
{
	private Config config;
	public Security security;
	public Controller controller;
	public MainWindow mainWindow;
	public EventHandler eventHandler;
	private ConfigHandler configHandler;

	Model(Controller controller)
	{
		this.controller = controller;
		
		this.security = new Security(this);
		this.config = new Config(this);
		this.configHandler = this.config.loadConfig();
		
		this.eventHandler = new EventHandler();
	}

	public ArrayList<Host> getServerList()
	{
		return this.configHandler.getServerList();
	}
}
