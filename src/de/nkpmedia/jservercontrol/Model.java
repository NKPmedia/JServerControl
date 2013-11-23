package de.nkpmedia.jservercontrol;

import de.nkpmedia.jservercontrol.gui.MainWindow;
import de.nkpmedia.jservercontrol.model.EventHandler;
import de.nkpmedia.jservercontrol.model.config.Config;
import de.nkpmedia.jservercontrol.model.config.Security;

public class Model
{
	private Config config;
	public Security security;
	public Controller controller;
	public MainWindow mainWindow;
	public EventHandler eventHandler;

	Model(Controller controller)
	{
		this.controller = controller;
		
		this.security = new Security(this);
		this.config = new Config(this);
		this.config.loadConfig();
		
		this.eventHandler = new EventHandler();
	}
}
