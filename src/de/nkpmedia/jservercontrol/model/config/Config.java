package de.nkpmedia.jservercontrol.model.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.InputSource;

import de.nkpmedia.jservercontrol.Controller;
import de.nkpmedia.jservercontrol.JServerControl;
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
	public void loadConfig(){
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
			Element rootElement = doc.getRootElement();
			XMLOutputter out = new XMLOutputter();
			out.output( doc, System.out );
			
		} catch (JDOMException | IOException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException e)
		{
			Log.logError("Cant't load the configfile.", e);
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
		
		this.model.security.genNewKeys(workspacePath);
		this.genNewConfig(workspacePath);
		
	}

	private void genNewConfig(String workspacePath)
	{
		File configFile = new File(workspacePath + "/config.xml");
		try
		{
			this.model.security.writeConfig(getClass().getClassLoader().getResourceAsStream("de/nkpmedia/jservercontrol/config/basicConfig.xml"),configFile);
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
