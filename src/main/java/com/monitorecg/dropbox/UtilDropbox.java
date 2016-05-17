/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorecg.dropbox;

import com.dropbox.core.DbxAccountInfo;
import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import javax.servlet.ServletOutputStream;

/**
 *
 * @author trianaandaluciaprietogalvan
 */
public class UtilDropbox {
    DbxClient dbxClient; 
    
    public static String KEY = "ul8yc1ray34l5mf";
    public static String SECRET = "i1nejtkneok133q";

    public UtilDropbox() {
        DbxRequestConfig dbxRequestConfig = new DbxRequestConfig(
                    "JavaDropboxTutorial/1.0", Locale.getDefault().toString());
        dbxClient = new DbxClient(dbxRequestConfig,"29s8ds85cvIAAAAAAAABpmb23CH0skltJqBFdhFoW3q9FOFTW5J1zFOYiJSVTMef");
        
    }
    
    
    /*public DbxClient authDropbox(String dropBoxAppKey, String dropBoxAppSecret)
			throws IOException, DbxException {
        DbxAppInfo dbxAppInfo = new DbxAppInfo(dropBoxAppKey, dropBoxAppSecret);
        DbxRequestConfig dbxRequestConfig = new DbxRequestConfig(
                        "JavaDropboxTutorial/1.0", Locale.getDefault().toString());
        DbxWebAuthNoRedirect dbxWebAuthNoRedirect = new DbxWebAuthNoRedirect(
                        dbxRequestConfig, dbxAppInfo);
        String authorizeUrl = dbxWebAuthNoRedirect.start();
        System.out.println("1. Authorize: Go to URL and click Allow : "
                        + authorizeUrl);
        System.out
                        .println("2. Auth Code: Copy authorization code and input here ");
        String dropboxAuthCode = new BufferedReader(new InputStreamReader(
                        System.in)).readLine().trim();
        DbxAuthFinish authFinish = dbxWebAuthNoRedirect.finish(dropboxAuthCode);
        String authAccessToken = authFinish.accessToken;
        dbxClient = new DbxClient(dbxRequestConfig,"29s8ds85cvIAAAAAAAABogk9td41jD-3GXTy8_R7I24MKlNY4eLcaj12xGTXRGeJ");
        
        System.out.println("Dropbox Account Name: "
                        + dbxClient.getAccountInfo().displayName);

        return dbxClient;
    }*/
    
    /* returns Dropbox size in GB */
    public long getDropboxSize() throws DbxException {
            long dropboxSize = 0;
            DbxAccountInfo dbxAccountInfo = dbxClient.getAccountInfo();
            // in GB :)
            dropboxSize = dbxAccountInfo.quota.total / 1024 / 1024 / 1024;
            return dropboxSize;
    }
    
    public void uploadToDropbox(String fileName) throws DbxException,
			IOException {
        File inputFile = new File(fileName);
        String name = inputFile.getName();
        FileInputStream fis = new FileInputStream(inputFile);
        try {
                DbxEntry.File uploadedFile = dbxClient.uploadFile("/" + name,
                                DbxWriteMode.add(), inputFile.length(), fis);
                String sharedUrl = dbxClient.createShareableUrl("/" + name);
                System.out.println("Uploaded: " + uploadedFile.toString() + " URL "
                                + sharedUrl);
        } finally {
                fis.close();
        }
    }
    
    public void createFolder(String folderName) throws DbxException {
        dbxClient.createFolder("/" + folderName);
    }
   
    
    public void listDropboxFolders(String folderPath) throws DbxException {
        DbxEntry.WithChildren listing = dbxClient
                        .getMetadataWithChildren(folderPath);
        System.out.println("Files List:");
        for (DbxEntry child : listing.children) {
                System.out.println("	" + child.name + ": " + child.toString());
        }
    }
    
    public void downloadFromDropbox(String fileName,ServletOutputStream os) throws DbxException,
			IOException {
        //FileOutputStream outputStream = new FileOutputStream("/tmp/2016-04-27_1233_22_3.txt");
        try {
            DbxEntry.File downloadedFile = dbxClient.getFile("/"+fileName,null,os);
            System.out.println("Metadata: " + downloadedFile.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            os.close();
        }
    }  
    
    public void downloadFromDropboxVerECG(String fileName,String ruta)  throws DbxException,
			IOException {
        FileOutputStream outputStream = new FileOutputStream(ruta+"/"+fileName);
        try {
            DbxEntry.File downloadedFile = dbxClient.getFile("/"+fileName,null,outputStream);
            System.out.println("Metadata: " + downloadedFile.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            outputStream.close();
        }
    } 
}