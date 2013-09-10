package de.nkpmedia.jservercontrol.config;

import java.io.*;
import java.security.Key;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class ReadWriteAES
{
  static void encode( byte[] bytes, OutputStream out, String pass ) throws Exception
  {
    Cipher c = Cipher.getInstance( "AES" );
    Key k = new SecretKeySpec( pass.getBytes(), "AES" );
    c.init( Cipher.ENCRYPT_MODE, k );

    OutputStream cos = new CipherOutputStream( out, c );
    cos.write( bytes );
    cos.close();
  }

  static byte[] decode( InputStream is, String pass ) throws Exception
  {
    Cipher c = Cipher.getInstance( "AES" );
    Key k = new SecretKeySpec( pass.getBytes(), "AES" );
    c.init( Cipher.DECRYPT_MODE, k );

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    CipherInputStream cis = new CipherInputStream( is, c );

    for ( int b; (b = cis.read()) != -1; )
      bos.write( b );

    cis.close();
    return bos.toByteArray();
  }
}