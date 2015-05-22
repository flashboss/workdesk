package com.wewebu.ow.server.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 *<p>
 * Represents a static secret key used for encryption.
 *</p>
 *
 *<p><font size="-2">
 * Alfresco Workdesk<br/>
 * Copyright (c) Alfresco Software, Inc.<br/>
 * All rights reserved.<br/>
 * <br/>
 * For licensing information read the license.txt file or<br/>
 * go to: http://wiki.alfresco.com<br/>
 *</font></p>
 */
public class OwSecretKey
{
    /** the used algorithm for encryption */
    private static final String ALGORITHM = "DESede";

    // key is no longer a field to prevent the key from beeing read from the .class file too easy.
    // But everybody with a simple decompiler gets the key anyway. So not a big deal.
    // /** Secret Key generated by createSerializedKey method on: Fri Oct 05 10:03:59 CEST 2007 using: DES algorithm. */
    // private static final byte[] m_keybytes = new byte[]{-84,-19,0,5,115,114,0,30,99,111,109,46,115,117,110,46,99,114,121,112,116,111,46,112,114,111,118,105,100,101,114,46,68,69,83,75,101,121,107,52,-100,53,-38,21,104,-104,2,0,1,91,0,3,107,101,121,116,0,2,91,66,120,112,117,114,0,2,91,66,-84,-13,23,-8,6,8,84,-32,2,0,0,120,112,0,0,0,8,-60,-88,93,-104,100,115,-123,97};

    /** the key */
    private Key m_key;

    /** create a key out of the given serialized byte representation
     */
    public OwSecretKey()
    {
        // deserialize
        /*
        / * * Secret Key generated by createSerializedKey method on: Fri Oct 05 10:03:59 CEST 2007 using: DES algorithm. * /
        byte[] keybytes = new byte[]{-84,-19,0,5,115,114,0,30,99,111,109,46,115,117,110,46,99,114,121,112,116,111,46,112,114,111,118,105,100,101,114,46,68,69,83,75,101,121,107,52,-100,53,-38,21,104,-104,2,0,1,91,0,3,107,101,121,116,0,2,91,66,120,112,117,114,0,2,91,66,-84,-13,23,-8,6,8,84,-32,2,0,0,120,112,0,0,0,8,-60,-88,93,-104,100,115,-123,97};
        ByteArrayInputStream kserin = new ByteArrayInputStream(keybytes); 
        ObjectInputStream seriin = null;
        try 
        {
        	seriin = new ObjectInputStream(kserin);
        } 
        catch (IOException e) 
        {
        	// ignore
        }
        
        try 
        {
        	m_key = (Key)seriin.readObject();
        }
        catch (IOException e) 
        {
        	// ignore
        }
        catch (ClassNotFoundException e) 
        {
        	// ignore
        }
        */
        // get key from passphrase
        String passphrase = "ergAShnj456j$%&gsd&4'*:F_";
        StringBuffer sb = new StringBuffer(passphrase);
        while (sb.length() < 24)
        {
            sb.append(passphrase);
        }
        passphrase = sb.toString().substring(0, 24);
        try
        {
            DESedeKeySpec keyspec = new DESedeKeySpec(passphrase.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            m_key = keyFactory.generateSecret(keyspec);
        }
        catch (Exception e)
        {
            // ignore
        }
    }

    /** get the key
     * 
     * @return a {@link Key}
     */
    public Key getKey()
    {
        return m_key;
    }

    /** get a cipher for the key
     * 
     * @return a {@link Cipher}
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException
    {
        return Cipher.getInstance(ALGORITHM);
    }

    /** get the used algorithm
     * 
     * @return a {@link String}
     */
    public static String getAlgorithm()
    {
        return ALGORITHM;
    }

    /** create a secret key and return it as a serialized byte array
     * 
     * @param algorithm_p
     * @return the serialized byte array representing the secret key
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static byte[] createSerializedKey(String algorithm_p) throws NoSuchAlgorithmException, IOException
    {
        // generate key
        KeyGenerator kgen = KeyGenerator.getInstance(algorithm_p);
        SecretKey k = kgen.generateKey();

        // serialize
        ByteArrayOutputStream kserout = new ByteArrayOutputStream();
        ObjectOutputStream seriout = new ObjectOutputStream(kserout);
        seriout.writeObject(k);

        return kserout.toByteArray();
    }

    /** dump a java code byte array representation of a secret key
     * 
     * @param algorithm_p
     * @return String java code lines
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String createJavaCodeKeyDeclaration(String algorithm_p) throws NoSuchAlgorithmException, IOException
    {
        // create the key
        byte[] keybytes = createSerializedKey(algorithm_p);

        Date gendate = new Date();

        // create java code byte declaration
        StringBuffer ret = new StringBuffer();

        // write comment
        ret.append("/** ");
        ret.append("Secret Key generated by createSerializedKey method on: ");
        ret.append(gendate.toString());
        ret.append(" using: ");
        ret.append(algorithm_p);
        ret.append(" algorithm.");
        ret.append(" */");
        ret.append("\r\n");
        ret.append("private static final byte[] m_keybytes = new byte[]{");

        // write variable statement
        boolean fDelimiter = false;
        for (int i = 0; i < keybytes.length; i++)
        {
            if (fDelimiter)
            {
                ret.append(",");
            }

            ret.append(keybytes[i]);

            fDelimiter = true;
        }

        ret.append("};");

        return ret.toString();
    }

    /** create a new java m_keybytes member
     * @param args_p
     */
    public static void main(String[] args_p)
    {
        try
        {
            System.out.println(createJavaCodeKeyDeclaration(getAlgorithm()));
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}