package de.nkpmedia.jservercontrol.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import de.nkpmedia.jservercontrol.log.Log;

public class Security
{
	private String passphrase = null;

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
			keyFileOutStream.write(secKey.getEncoded());
			keyFileOutStream.flush();
			keyFileOutStream.close();
		} catch (IOException e)
		{
			Log.logError("Can't create the key file", e);
		}
		
	}
	
}
