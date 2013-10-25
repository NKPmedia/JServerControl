package de.nkpmedia.jservercontrol.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

import org.jdom2.Document;

import de.nkpmedia.jservercontrol.log.Log;

public class Security
{
	private String passphrase = null;
	private byte[] secKey = null;

	//Gen a new Key for encryption of the workspace and a passphrase
	public void genNewKeys(String workspacePath)
	{
		KeyGenerator kg = null;
		try
		{
			kg = KeyGenerator.getInstance( "AES" );
		} catch (NoSuchAlgorithmException e)
		{
			Log.logError("Can't find this algorithem", e);
		}
		kg.init(256);
		SecretKey secKey = kg.generateKey();
		
		File secKeyFile = new File(workspacePath+"/sec.key");
		try
		{
			secKeyFile.createNewFile();
			FileOutputStream keyFileOutStream = new FileOutputStream(secKeyFile); 
			
			String pass = JOptionPane.showInputDialog("Enter your new passphrase.");
			this.passphrase = pass;
			ReadWriteAES.encode(secKey.getEncoded(), keyFileOutStream, pass);
			
			keyFileOutStream.flush();
			keyFileOutStream.close();
			
			this.secKey = secKey.getEncoded();
		} catch (IOException e)
		{
			Log.logError("Can't create the key file", e);
		} catch (Exception e)
		{
			Log.logError("Can't encode the key", e);
		}
		
	}

	public void writeConfig(InputStream resourceAsStream, File configFile) throws Exception
	{
		InputStreamReader inputStream = new InputStreamReader(resourceAsStream);
		BufferedReader configStringReader =  new BufferedReader(inputStream);
		String configString = "";
		
		//Reads the whole file
		StringBuilder sb = new StringBuilder();
		char[] readerContent = new char[1];
	      while (configStringReader.read(readerContent) != -1)
	      {
	        sb.append(readerContent[0]);
	      }
	    configStringReader.close();
	    configString = sb.toString();
	    
		ReadWriteAES.encode( configString.getBytes(),new FileOutputStream(configFile), this.secKey);
	}
	public void writeConfig(Document doc, File configFile){
		
	}

	public byte[] getSecKey(Config config)
	{
		if(this.secKey == null)
		{
			String pass = JOptionPane.showInputDialog("Enter your passphrase.");
			try
			{
				Log.log("Reading sec key at "+config.workspaceAt+"/sec.key");
				this.secKey = ReadWriteAES.decode(new FileInputStream(config.workspaceAt+"/sec.key"), pass);
			} 
			catch (Exception e)
			{
				Log.logError("Can't read/decode the saved secret key file", e);
			}
		}
		return secKey;
	}
}
