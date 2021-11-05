package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	
	
	
	
	public static void saveImage(String fname, byte[] data )throws IOException{
		
		
		File f= new File("/photos/");
		if(!f.exists()) {
			f.mkdir();
		}
		f= new File("/" + fname);
		FileOutputStream output = new FileOutputStream(f);
		output.write(data);
		output.close();
	}
	
	
}
