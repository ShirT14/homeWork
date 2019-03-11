package com.shir.hw.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class excercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "E:/temp";
		File directory = new File(path);
		System.out.println(directory.exists());
		File file = new File(directory, "letter4.txt");
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
			System.out.println(file + " created");

		}

		Scanner scan = new Scanner(System.in);
		// System.out.println("please enter number");
		// int num = scan.nextInt();

		for (int i = 0; i < 10; i++) {
			try (FileWriter out = new FileWriter(file, true);) {
				System.out.println("please enter number");
				int num = scan.nextInt();
				out.write(num);
				out.write("\r\n");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("end");

	}

}
