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


	private Controler controler;


	private void start()
	{
		this.controler = new Controler();
	}

}
