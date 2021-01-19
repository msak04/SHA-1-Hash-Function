import java.io.File;
import java.io.FilenameFilter;

public class SHA_One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathlocator = FileLocator();
		
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

}
