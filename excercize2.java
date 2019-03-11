package com.shir.hw.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class excercize2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "E:/temp";
		File directory = new File(path);
		System.out.println(directory.exists());
		File file = new File(directory, "letter3.txt");
		System.err.println(file.exists());
		if (!directory.exists()) {
			directory.mkdir();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try (BufferedReader in = new BufferedReader(new FileReader("E:/temp/letter2.txt"));) {
			String line = in.readLine();
			while (line != null) {

				try (FileWriter out = new FileWriter("E:/temp/letter3.txt", true);) {

					out.write(line);
					out.write("\r\n");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				line = in.readLine();

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
