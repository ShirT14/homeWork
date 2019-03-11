package com.shir.hw.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CarDemoReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (BufferedReader in = new BufferedReader(new FileReader("E:/temp/letter5.txt"));) {
			String car = in.readLine();
			while (car != null) {
				System.out.println(car);
				car = in.readLine();
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
