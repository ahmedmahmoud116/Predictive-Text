package pkj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	public Tester() {
		
	}
	
	public static void main(String[] args) throws IOException {
		MarkovRunner mr = new MarkovRunner();
//		mr.runMarkovZero();
//		testGetFollows();
//		testGetFollowsWithFile();
//		mr.runMarkovZero();
//		mr.runMarkovOne();
//		mr.runMarkovFour();
		mr.runMarkovModel();
	}

	
	public static void testGetFollows() {
		MarkovOne mo = new MarkovOne();
		mo.setTraining("this is a test yes this is a test.");
		ArrayList<String> list = mo.getFollows("t");
		System.out.println("List size " + list.size());
		System.out.println(list.toString());
	}
	
	public static void testGetFollowsWithFile() throws FileNotFoundException {
		
		StringBuilder sb = new StringBuilder();
		File f = new File("melville.txt");
		Scanner sc = new Scanner(f);
		while(sc.hasNext()) {
			String s = sc.nextLine();
			s = s + " ";
			sb.append(s);
		}
		sc.close();
		
		String st = sb.toString();
		
		MarkovOne mo = new MarkovOne();
		mo.setTraining(st);
		ArrayList<String> list = mo.getFollows("th");
		System.out.println("List size " + list.size());
		System.out.println(list.toString());
	}
}
