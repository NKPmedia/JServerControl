package de.nkpmedia.jservercontrol.gui.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import de.nkpmedia.jservercontrol.gui.MainWindow;
import de.nkpmedia.jservercontrol.gui.ServerOptionWindow;

public class MainWindowEventHandler implements ActionListener, ChangeListener
{

	private MainWindow mainWindow;
	
	public MainWindowEventHandler(MainWindow mainWindow){
		this.mainWindow = mainWindow;
	}
	
	//Handels the events but does no more than give some tasks back to the model
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.mainWindow.optionAllButton)
		{
			this.mainWindow.userInterface.controller.pressedOptionAllButton();
        } 
	}

	@Override
	public void stateChanged(ChangeEvent arg0)
	{
		AbstractButton abstractButton = (AbstractButton)arg0.getSource();
		ButtonModel buttonModel = abstractButton.getModel();
		boolean selected = buttonModel.isSelected();
		if(buttonModel.isPressed())
		{
			this.mainWindow.changedSelectAllButton(selected);   
		}
	}

}
