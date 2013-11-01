package de.nkpmedia.jservercontrol;

import de.nkpmedia.jservercontrol.model.config.Config;
import de.nkpmedia.jservercontrol.model.config.Security;

public class Model
{
	private Config config;
	public Security security;
	public Controller controller;

	Model(Controller controller)
	{
		this.controller = controller;
		
		this.security = new Security(this);
		this.config = new Config(this);
		this.config.loadConfig();
	}
}
