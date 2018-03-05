package encoder_decoder;

import java.awt.image.ConvolveOp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConfigurationException;

public class FileDecoder {

	
	
	private String path;

	public FileDecoder () {
		
	} 

	public String encodeToBase64 (){
		
		File file = new File (this.path);
		String cover_64 = null;
		try {
			FileInputStream fi = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fi.read(bytes);
			cover_64 = Base64.getEncoder().encodeToString(bytes);
			fi.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cover_64;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void encodetoFile (String str_64){
		
		File output = new File("/home/spellzito/converted_file.jpeg");
		try {
			FileOutputStream fo = new FileOutputStream(output);
			byte[] image = Base64.getDecoder().decode(str_64);
			fo.write(image);
			fo.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String hashToMD5 (String path){
		File f = new File (path);
		String hash;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			FileInputStream fi = new FileInputStream(f);
			byte[] bytes = new byte[1024];
			int bytesRead = -1;
			 
	        while ((bytesRead = fi.read(bytes)) != -1) {
	            md.update(bytes, 0, bytesRead);
	        }
	 
	        byte[] hashedBytes = md.digest();
	 
//	        StringBuffer stringBuffer = new StringBuffer();
//	        for (int i = 0; i < bytes.length; i++) {
//	            stringBuffer.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
//	                    .substring(1));
//	        }
//	        hash = stringBuffer.toString();
	        hash = DatatypeConverter.printHexBinary(hashedBytes);
	        return hash;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}
	
	

//	String digestInHex = DatatypeConverter.printHexBinary(digest).toUpperCase();
//	System.out.println(digestInHex)
	
	
}
