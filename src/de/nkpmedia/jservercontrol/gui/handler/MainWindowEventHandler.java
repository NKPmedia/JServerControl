package de.nkpmedia.jservercontrol.gui.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.nkpmedia.jservercontrol.gui.MainWindow;
import de.nkpmedia.jservercontrol.gui.ServerOptionWindow;

public class MainWindowEventHandler implements ActionListener
{

	private MainWindow mainWindow;
	
	public MainWindowEventHandler(MainWindow mainWindow){
		this.mainWindow = mainWindow;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.mainWindow.optionAllButton){
			this.mainWindow.userInterface.controller.pressedOptionAllButton();
        } 
	}

}
