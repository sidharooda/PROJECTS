package filetasks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData {

	public static void main(String[] args) {
		 // 1️⃣ Define the file path as a string
        String path = "sample.txt";

        // 2️⃣ Create a File object using the path
        File file = new File(path);

        try {
            // 3️⃣ Create a FileWriter object (true = append mode, false = overwrite)
            FileWriter fileWriter = new FileWriter(file, true);

            // 4️⃣ Wrap the FileWriter with BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // 5️⃣ Write data using write() and add a new line using newLine()
            bufferedWriter.write("Hello , this is line 1");
            bufferedWriter.newLine();
            bufferedWriter.write("This is line 2");

            // 6️⃣ Always close the BufferedWriter to save and release resources
            bufferedWriter.close();

            System.out.println("✅ Data written to file successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
