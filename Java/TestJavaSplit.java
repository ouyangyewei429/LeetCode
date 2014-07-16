import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class TestJavaSplit {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		final String DELIMITER = new String(new byte[]{1});
		final String DELIMITER = "\t";
		final String INPUT_FILE_PATH = "input/category_level.txt";
		final String OUTPUT_FILE_PATH = "output/category.txt";
		
		BufferedReader br = null;
		try {
			File file = new File(INPUT_FILE_PATH);
			br = new BufferedReader(new FileReader(file));
			
			String line;
			while (null != (line=br.readLine())) {
				String[] strs = line.split(DELIMITER);
				
				long categoryId = Long.parseLong(strs[0]);
				long categoryLevel = Long.parseLong(strs[1]);
				
				System.out.println(categoryId + "," + categoryLevel);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
