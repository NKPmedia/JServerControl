package de.nkpmedia.jservercontrol.gui;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.FileChooserUI;

public class GUIJOptionPanel
{
	public int schowConfirmDialog(Component object, String string)
	{
		return JOptionPane.showConfirmDialog(object, string);
	}
	public File FielChooser(String currentDirectory, int openDialog, int directoriesOnly)
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogType(openDialog);
	    chooser.setFileSelectionMode(directoriesOnly);
	    File file = new File(currentDirectory);
	
	    chooser.setCurrentDirectory(file);
	
	    chooser.setVisible(true);
	    chooser.showOpenDialog(null); 
	    File result = chooser.getSelectedFile();
	return result;
	}
	
	public String showInputDialog(String string)
	{
		return JOptionPane.showInputDialog(string);
	}
}
