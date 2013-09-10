package de.nkpmedia.jservercontrol;

import de.nkpmedia.jservercontrol.config.Config;
import de.nkpmedia.jservercontrol.config.Security;

public class JServerControl
{

	public static void main(String[] args)
	{
		JServerControl jServerControl = new JServerControl();
		jServerControl.start();

	}

	private Config config;
	public Security security;

	private void start()
	{
		this.security = new Security();
		this.config = new Config(this);
		this.config.loadConfig();
		
	}

}
