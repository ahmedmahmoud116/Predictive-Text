package pkj;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MarkovRunner {

	public MarkovRunner() {
		
	}
	
	public void runMarkovZero() throws IOException{
		System.out.println("run zero");
		DirectoryResource dr = new DirectoryResource();
		Scanner sc;
		StringBuilder sb = new StringBuilder();
		
		File f = new File("confucius.txt");
		sc = new Scanner(f);
		while(sc.hasNext()) {
			String s = sc.nextLine();
			s = s + " ";
			sb.append(s);
		}
		sc.close();
		
//		for(File f:dr.selectedFiles()) {
//			sc = new Scanner(f);
//			while(sc.hasNext()) {
//				sb.append(sc.next());
//			}
//		}
//		sc.close();

		String st = sb.toString();
		
		MarkovZero mz = new MarkovZero();
		mz.setRandom(1024);
		mz.setTraining(st);
		for(int i = 0;i<3;i++) {
			String text = mz.getRandomText(500);
			printOut(text);
		}
	}
	
	public void runMarkovOne() throws IOException{
		
		DirectoryResource dr = new DirectoryResource();
		Scanner sc;
		StringBuilder sb = new StringBuilder();
		
		File f = new File("romeo.txt");
		sc = new Scanner(f);
		while(sc.hasNext()) {
			String s = sc.nextLine();
//			if(s.equals(""))
//				continue;
			
			s = s + " ";
			
			sb.append(s);
		}
		sc.close();
		
//		for(File f:dr.selectedFiles()) {
//			sc = new Scanner(f);
//			while(sc.hasNext()) {
//				sb.append(sc.next());
//			}
//		}
//		sc.close();
		String st = sb.toString();
		
		MarkovOne mo = new MarkovOne();
		mo.setRandom(365);
		mo.setTraining(st);
		for(int i = 0;i<3;i++) {
			String text = mo.getRandomText(500);
			printOut(text);
		}
	}
	
	
	public void runMarkovFour() throws IOException{
		
		DirectoryResource dr = new DirectoryResource();
		Scanner sc;
		StringBuilder sb = new StringBuilder();
		
		File f = new File("romeo.txt");
		sc = new Scanner(f);
		while(sc.hasNext()) {
			String s = sc.nextLine();
//			if(s.equals(""))
//				continue;
			s = s + " ";
			sb.append(s);
		}
		sc.close();
		
//		for(File f:dr.selectedFiles()) {
//			sc = new Scanner(f);
//			while(sc.hasNext()) {
//				sb.append(sc.next());
//			}
//		}
//		sc.close();
		String st = sb.toString();

		MarkovFour mo = new MarkovFour();
		mo.setRandom(715);
		mo.setTraining(st);
		for(int i = 0;i<3;i++) {
			String text = mo.getRandomText(500);
			printOut(text);
		}
	}
	
	public void runMarkovModel() throws IOException{
		
		DirectoryResource dr = new DirectoryResource();
		Scanner sc;
		StringBuilder sb = new StringBuilder();
		
		File f = new File("romeo.txt");
		sc = new Scanner(f);
		while(sc.hasNext()) {
			String s = sc.nextLine();
//			if(s.equals(""))
//				continue;
			s = s + " ";
			sb.append(s);
		}
		sc.close();
		
//		for(File f:dr.selectedFiles()) {
//			sc = new Scanner(f);
//			while(sc.hasNext()) {
//				sb.append(sc.next());
//			}
//		}
//		sc.close();
		String st = sb.toString();

		MarkovModel mo = new MarkovModel(7);
		mo.setRandom(953);
		mo.setTraining(st);
		for(int i = 0;i<3;i++) {
			String text = mo.getRandomText(500);
			printOut(text);
		}
	}

	private void printOut(String s) {
		String[] words = s.split("\\s+");
		int linesize = 0;
		System.out.println("---------------------------------------------------------");
		for(int i = 0;i<words.length;i++) {
			System.out.print(words[i] + " ");
			linesize += words[i].length() + 1;
			if(linesize>60) { //range of line size
				System.out.println();
				linesize = 0;
			}
		}
		System.out.println("\n---------------------------------------------------------");
	}
}
