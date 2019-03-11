package com.shir.hw.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Car> cars = new ArrayList<>();
		Car c1 = new Car(111, "red", 100);
		Car c2 = new Car(222, "blue", 70);
		Car c3 = new Car(333, "black", 120);
		Car c4 = new Car(444, "pink", 60);
		Car c5 = new Car(555, "grey", 70);

		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		cars.add(c4);
		cars.add(c5);

		File directory = new File("E:/temp");
		System.out.println(directory.exists());
		File file = new File(directory, "letter5.txt");
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
		try (FileWriter out = new FileWriter(file);) {
			for (Car car : cars) {
				String str = car.toString();
				out.write(str);
				out.write("\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
