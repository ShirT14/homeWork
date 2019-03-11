package com.shir.hw.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class excercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean flag = true;
		String path = "E:/temp";
		File derectory = new File(path);
		File file = new File(derectory, "letter2.txt");

		System.err.println(file.exists());
		if (!derectory.exists()) {
			derectory.mkdir();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println(file + " created");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Scanner scan = new Scanner(System.in);
		System.out.println("please enter text");
		String text = scan.nextLine();
		if (text.equals("quit")) {
			flag = false;
		}

		while (flag == true) {

			try (FileWriter out = new FileWriter(file, true);) {
				out.write(text);
				out.write("\r\n");
				System.out.println("pls enter text");
				text = scan.nextLine();
				if (text.equals("quit")) {
					flag = false;
				}

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		System.out.println("end");
	}

}
