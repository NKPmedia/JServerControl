package de.nkpmedia.jservercontrol;

import de.nkpmedia.jservercontrol.model.config.Config;
import de.nkpmedia.jservercontrol.model.config.Security;

public class JServerControl
{

	public static void main(String[] args)
	{
		JServerControl jServerControl = new JServerControl();
		jServerControl.start();

	}


	private Controller controller;


	private void start()
	{
		this.controller = new Controller();
	}

}
