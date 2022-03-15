package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class HoardingData implements Serializable{
	private ArrayList<Hoarding> hoardings =new ArrayList<>();
	
	public void add(Hoarding h) {
		hoardings.add(h);
	}
	
	public void save() {
		File file = new File("data/data.temp");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void load() {
		File file = new File("data/data.temp");
		try {
			
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object ob = ois.readObject();
			HoardingData data = (HoardingData) ob;
			this.hoardings = data.hoardings;
			
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
	
	public ArrayList<Hoarding> getHoardings() {
		return hoardings;
	}

	public void print() {
		for(Hoarding h :hoardings) {
			System.out.println(h.getBrand());
		}
	}
}
