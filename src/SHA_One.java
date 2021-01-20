import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA_One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathlocator = FileLocator();
		byte[] FiletoByte = ConvertToByte(pathlocator);
		String HashedFile = Hashing(FiletoByte);
		StoreHashValue(HashedFile); 
	}
	

	private static byte[] ConvertToByte( String filePath) {
		// TODO Auto-generated method stub
		byte[] bytes = null;
		try {
			bytes = Files.readAllBytes(Paths.get(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}

	private static String FileLocator() {
		// TODO Auto-generated method stub
		
		File dir = new File(".");
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith("java SHA_One");
			}
		};
		String[] children = dir.list(filter);
		if (children == null) {
			System.out.println("No file found.");
			return null;
		} else {
			String filename = children[0];
			return filename;
		}
	}
	public static String Hashing(byte[] ByteformOfFile) 
    { 
        try { 
            // getInstance() method is called with algorithm SHA-1 
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(ByteformOfFile); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String HashedText = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (HashedText.length() < 32) { 
            	HashedText = "0" + HashedText; 
            } 
  
            // return the HashText 
            return HashedText; 
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
	private static void StoreHashValue(String hashedFile) {
		// TODO Auto-generated method stub
		// Save cleartext into the cleartext.txt file
		Path HashValue = Path.of("hvalue.txt");

		try {
			Files.writeString(HashValue, hashedFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
