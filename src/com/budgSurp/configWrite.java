package com.budgSurp;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class configWrite implements Serializable {
	static Scanner input = new Scanner(System.in);
	public static void write() {
		String filename = "config.txt";
		String fromDay, fromMonth, fromYear, toDay, toMonth, toYear;
		Double groceries, other;
		System.out.println("Start day:");
		fromDay = input.next();
		System.out.println("Start month:");
		fromMonth = input.next();
		System.out.println("Start year:");
		fromYear = input.next();
		System.out.println("Finish day:");
		toDay = input.next();
		System.out.println("Finish month:");
		toMonth = input.next();
		System.out.println("Finish year:");
		toYear = input.next();
		System.out.println("Groceries budget:");
		groceries = input.nextDouble();
		System.out.println("Other budget:");
		other = input.nextDouble();
		List list = new ArrayList();
		list.add(fromDay);
		list.add(fromMonth);
		list.add(fromYear);
		list.add(toDay);
		list.add(toMonth);
		list.add(toYear);
		list.add(String.valueOf(groceries));
		list.add(String.valueOf(other));
		System.out.println(""+list);
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
			System.out.println("Config saved");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
