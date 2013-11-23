package de.nkpmedia.jservercontrol.model.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;
import javax.swing.JFileChooser;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import de.nkpmedia.jservercontrol.Model;
import de.nkpmedia.jservercontrol.log.Log;


public class Config
{
	public File workspaceAt = null;
	private Model model;

	public Config(Model model)
	{
		this.model= model;
	}

	//Load the configfiles into the RAM
	public ConfigHandler loadConfig(){
		File workspace = getWorkspace();
		
		if(!new File(workspace.getAbsolutePath()+"/JServerControl.conf").exists()){
			int pane = this.model.controller.showConfirmDialog( null, "Wollen sie eine neue Arbeitsumgebung erstellen?" );
			if(pane == 0){
				createNewWorkspace(workspace.getAbsolutePath());
			}
		}
		
		Log.log("Reading configfile");
		SAXBuilder builder = new SAXBuilder();
		try
		{
			String xmlFile = new String(ReadWriteAES.decode(new FileInputStream(workspace.getAbsolutePath()+"/config.xml"), this.model.security.getSecKey(this)));
			Document doc = builder.build(new StringReader(xmlFile));
			Log.log("Configfile has been read.");
			ConfigLoader configLoader = new ConfigLoader(doc);
			return new ConfigHandler(configLoader);
			
		} catch (JDOMException | IOException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException e)
		{
			Log.logError("Cant't load the configfile.", e);
		}
		return null;
		
		
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
		
		this.model.security.genNewKeys(workspacePath);
		this.genNewConfig(workspacePath);
		
	}
	
	//Generat new Config at a special path
	private void genNewConfig(String workspacePath)
	{
		File configFile = new File(workspacePath + "/config.xml");
		try
		{
			this.model.security.writeConfig(getClass().getClassLoader().getResourceAsStream("de/nkpmedia/jservercontrol/model/config/basicConfig.xml"),configFile);
		} catch (Exception e)
		{
			Log.logError("Can't write basic configfile", e);
		}
		
	}

	//Returns a File with the directory to the workspace
	private File getWorkspace(){
		if(this.workspaceAt == null){
			
	        File result = this.model.controller.fileChooser("/home",JFileChooser.OPEN_DIALOG,JFileChooser.DIRECTORIES_ONLY);
	        Log.logMessage("Select the workspace: "+result.getPath());
	        this.workspaceAt = result;
	        return result;
		}else{
			return this.workspaceAt;
		}
	}
}
