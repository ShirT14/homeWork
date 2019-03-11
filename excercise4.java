package com.shir.hw.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class excercise4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 0;

		try (BufferedReader in = new BufferedReader(new FileReader("E:/temp/letter4.txt"));) {
			int num = in.read();
			in.readLine();
			do {
				sum += num;
				num = in.read();
				in.readLine();

			} while (num != -1);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sum);

	}

}
