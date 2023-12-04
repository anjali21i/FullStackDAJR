package util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author abhishek.jaiswal@timesgroup.com
 *	 
 */
public class EncDec {   
		private static Logger logger = LoggerFactory.getLogger(EncDec.class);
		private static Cipher ecipher;
		private static Cipher dcipher;
		private static final String KEYGEN_STR = "23435356677";
		private static final String PADDING ="DES/ECB/PKCS5Padding";
		private static final String UTF8 ="UTF-8";
	    public EncDec() {
	    	
	    }
	    private static Key getKey(){
	        try{
	            byte[] bytes = getbytes(KEYGEN_STR);
	            DESKeySpec pass = new DESKeySpec(bytes); 	            
	            SecretKeyFactory sKeyFactory = SecretKeyFactory.getInstance("DES"); 
	            SecretKey sKey = sKeyFactory.generateSecret(pass); 
	            return sKey;
	        }
	        catch(Exception ex){
	        	logger.error("Exception in getKey", ex);
	        }
	        return null;
	    }
	    
	    private static byte[] getbytes(String str){
	        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();	        
	        StringTokenizer sTokenizer = new StringTokenizer(str, "-", false);
	        while(sTokenizer.hasMoreTokens()){
	            try{
	                byteOutputStream.write(sTokenizer.nextToken().getBytes());
	            }
	            catch(IOException ex){
	            	logger.error("IOException in getbytes", ex);
	            }
	        }	        
	        byteOutputStream.toByteArray();
	        return byteOutputStream.toByteArray();
	    }
	    
	    public String encryptNonStatic(String sourceStr){        
	        try{
	            // Get secret key
	            Key key = getKey();
	            byte[] enc ;
	            synchronized (Cipher.class)
	            {
		            Cipher ecipher1 = Cipher.getInstance(PADDING);
		            ecipher1.init(Cipher.ENCRYPT_MODE, key);  
		            enc = ecipher1.doFinal(sourceStr.getBytes(UTF8));
	            }
	             // Encode bytes to base64 to get a string
	            return new String(Base64.encodeBase64(enc));
	        }
	        catch(Exception ex){
	        	logger.error("[Exception [EncDec : while encrypting the string]]");
	        }
	        return null;
	    }

	    public static String encrypt(String sourceStr){        
	        try{
	            // Get secret key
	            Key key = getKey();
	            byte[] enc;
	            synchronized (Cipher.class)
	            {
		            ecipher = Cipher.getInstance(PADDING);
		            ecipher.init(Cipher.ENCRYPT_MODE, key);  
		            enc = ecipher.doFinal(sourceStr.getBytes(UTF8));
	            }
	             // Encode bytes to base64 to get a string
	            Pattern whileSpace = Pattern.compile("\\s+",Pattern.MULTILINE);
	            String encryptedString = new String(Base64.encodeBase64(enc));
	            return whileSpace.matcher(encryptedString).replaceAll("");   	        
	          }catch(Exception ex){
	        	  logger.error("[Exception in encrypt",ex);
	        }
	        return null;
	    }
	    
	    public String decryptNonStatic(String sourceStr){
	    	if(sourceStr == null || "".equals(sourceStr)){
	    		return null;
	    	}
	        try{
	            // Get secret key
	        	sourceStr = sourceStr.replace(' ', '+');
	        	sourceStr = sourceStr.replace("%20", "+");
	        	sourceStr = sourceStr.replaceAll("\n", "");
	        	
	            Key key = getKey();
	            byte[] dec ;
	            synchronized (Cipher.class)
	            {
		            dcipher = Cipher.getInstance(PADDING);                      
		            dcipher.init(Cipher.DECRYPT_MODE, key);  
		            // Decode base64 to get bytes
		            dec = Base64.decodeBase64(sourceStr.getBytes());
	            }
		            //Decrypt data in a single step
	            byte[] utf8 = dcipher.doFinal(dec);
	            // Decode using utf-8
	            return new String(utf8, UTF8);
	        }
	        catch(Exception ex){
	        	logger.error("javax.crypto.IllegalBlockSizeException: Input length must be multiple of 8 when decrypting with padded cipher");
	        }
	        return null;
	    }
	    
	    public static String decrypt(String sourceStr){
	        try{
	            // Get secret key
	        	sourceStr = sourceStr.replace(' ', '+');
	        	sourceStr = sourceStr.replaceAll("\n", "");
	        	sourceStr = sourceStr.replace("%20", "+");
	    		
	            Key key = getKey();
	            byte[] dec;
	            synchronized (Cipher.class)
	            {
		            dcipher = Cipher.getInstance(PADDING);                      
		            dcipher.init(Cipher.DECRYPT_MODE, key);  
		            // Decode base64 to get bytes
		            dec = Base64.decodeBase64(sourceStr.getBytes());
	            }
	            //Decrypt data in a single step
	            byte[] utf8 = dcipher.doFinal(dec);
	            // Decode using utf-8
	            return new String(utf8, UTF8);
	        }
	        catch(Exception ex){
	        	logger.info("Can not decrypt the string ::"+sourceStr+": Exception thrown :"+ex);
	        }
	        return null;
	    }   
	    
	    
	  private static Key getKey(String key){
	        try{
	            byte[] bytes = getbytes(key);
	            DESKeySpec pass = new DESKeySpec(bytes); 	            
	            SecretKeyFactory sKeyFactory = SecretKeyFactory.getInstance("DES"); 
	            SecretKey sKey = sKeyFactory.generateSecret(pass); 
	            return sKey;
	        }
	        catch(Exception ex){
	        	logger.error("Exception in getKey", ex);
	        }
	        return null;
	   }
	    
	    public static String decrypt(String sourceStr,String keyStr) {
			try {
				// Get secret key
				sourceStr = sourceStr.replace(' ', '+');
				sourceStr = sourceStr.replace("%20", "+");
				sourceStr = sourceStr.replaceAll("\n", "");
				Key key = getKey(keyStr);
				byte[] dec;
				synchronized (Cipher.class) {
					dcipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
					dcipher.init(Cipher.DECRYPT_MODE, key);
					dec = java.util.Base64.getDecoder().decode(sourceStr);
				}
			
				byte[] utf8 = dcipher.doFinal(dec);
			
				return new String(utf8, "UTF-8");
			} catch (Exception ex) {
			
				System.out.println("Can not decrypt the string ::" + sourceStr
						+ ": Exception thrown :" + ex);
			}
			return null;
	   }
	    
	    public static String encrypt(String sourceStr, String keyStr) {
			try {
				// Get secret key
				if(sourceStr ==null || sourceStr.length() <2)
				{
					return "";
				}
				Key key = getKey(keyStr);
				byte[] enc; 
				synchronized (Cipher.class) {
					ecipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
					ecipher.init(Cipher.ENCRYPT_MODE, key);
					enc = ecipher.doFinal((new String(sourceStr)).getBytes("UTF-8"));
				}
				// Encode bytes to base64 to get a string
				Pattern REMOVE_WHITE_SPACES = Pattern.compile("\\s+",
						Pattern.MULTILINE);
				String encryptedString = new String(java.util.Base64.getMimeEncoder().encode(enc),
                        StandardCharsets.UTF_8);
				encryptedString=	encryptedString.replaceAll("\\+", "%2B");
				return REMOVE_WHITE_SPACES.matcher(encryptedString).replaceAll("");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return null;
		}
}
