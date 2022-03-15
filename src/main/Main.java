package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import model.Hoarding;
import model.HoardingData;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showMenu();
	}
	
	static HoardingData hData = new HoardingData();
	public static void showMenu(){
		System.out.println("Write the option you want to do\n");
		System.out.println("Write 1 if you want import a file");
		System.out.println("Write 2 if you want to add hoarding");
		System.out.println("Write 3 if you want to show all hoardings");
		System.out.println("Write 4 if you want to export report");
		int op = sc.nextInt();
		section(op);
	}
	
	public static void section(int op) {
		switch(op) {
		case 1:
			importAFile();
			break;
		case 2:
			add();
			break;
		case 3:
			show();
			break;
		case 4:
			export();
			break;
		}
		showMenu();
	}
	
	public static void add() {
		System.out.println("Write the info with ++");
		String read = sc.next();
		sc.nextLine();
		String[] split = read.split("\\++");
		hData.add(new Hoarding(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Boolean.parseBoolean(split[2]),split[3]));
	}

	public static void show() {
	for(Hoarding h : hData.getHoardings())
		System.out.println("\n"+h+"\n");
	}
	public static void export() {
		hData.save();
	}
	public static void importAFile() {
		System.out.println("Write the ubication of the file");
		File file = new File(sc.next());
		try {
			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object ob = ois.readObject();
			String data = (String) ob;
			String[] split = data.split("\\|");
			for(String s : split)
			System.out.println(s);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
