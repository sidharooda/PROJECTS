package filetasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFiles {
	public static void main(String[] args) {
		
		 // 1️⃣ Define the file path as a string
        String path = "result.txt";

        // 2️⃣ Create a File object using the path
        File file = new File(path);

        try {
            // 3️⃣ Create a FileReader to read from the file
            FileReader fileReader = new FileReader(file);

            // 4️⃣ Wrap FileReader with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // 5️⃣ Read each line one by one in a loop
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("📄 " + line);
            }

            // 6️⃣ Close the BufferedReader
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
