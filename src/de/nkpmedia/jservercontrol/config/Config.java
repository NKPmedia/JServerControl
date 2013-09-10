package de.nkpmedia.jservercontrol.config;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import de.nkpmedia.jservercontrol.JServerControl;
import de.nkpmedia.jservercontrol.log.Log;


public class Config
{
	private File workspaceAt = null;
	private JServerControl MainClass;

	public Config(JServerControl jServerControl)
	{
		this.MainClass = jServerControl;
	}

	//Load the configfiles into the RAM
	public void loadConfig(){
		File workspace = getWorkspace();
		
		if(!new File(workspace.getAbsolutePath()+"/JServerControl.conf").exists()){
			int pane = JOptionPane.showConfirmDialog( null, "Wollen sie eine neue Arbeitsumgebung erstellen?" );
			if(pane == 0){
				createNewWorkspace(workspace.getAbsolutePath());
			}
		}
		
		
	}
	
	//Create a new Workspace 
	private void createNewWorkspace(String workspacePath)
	{
		Log.logMessage("Create new workspace");
		try
		{
			new File(workspacePath+"/JServerControl.conf").createNewFile();
		} catch (IOException e)
		{
			Log.logError("Can't write new basic config for the new Workspace", e);
		}
		
		this.MainClass.security.genNewKeys(workspacePath);
		
	}

	//Returns a File with the directory to the workspace
	private File getWorkspace(){
		if(this.workspaceAt == null){
			final JFileChooser chooser = new JFileChooser("Wähle deine Workspace");
	        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
	        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        final File file = new File("/home");
	
	        chooser.setCurrentDirectory(file);
	
	        chooser.setVisible(true);
	        chooser.showOpenDialog(null); 
	        File result = chooser.getSelectedFile();
	        Log.logMessage("Select the workspace: "+result.getPath());
	        this.workspaceAt = result;
	        return result;
		}else{
			return this.workspaceAt;
		}
	}
}
