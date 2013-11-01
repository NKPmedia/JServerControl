package de.nkpmedia.jservercontrol;

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
