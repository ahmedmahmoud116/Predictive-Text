package pckg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MarkovRunnerWithInterface {

	public MarkovRunnerWithInterface() {
		
	}
	
	public void runModel(IMarkovModel markov,String text, int size,int seed) {
		markov.setRandom(seed);
		markov.setTraining(text);
	    System.out.println("running with " + markov);
		for(int i = 0;i<3;i++) {
			String st = markov.getRandomText(size);
			printOut(st);
		}
	}
	
	public void runMarkov() throws FileNotFoundException {
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
//		st = "yes-this-is-a-thin-pretty-pink-thistle";
		int size = 500;
		int seed = 792;
		
//		MarkovZero mz = new MarkovZero();
//		runModel(mz, st, size, seed);
//		
		MarkovOne mo = new MarkovOne();
//		runModel(mo, st, size, seed);
//		
//		MarkovFour mf = new MarkovFour();
//		runModel(mf, st, size, seed);
//		
		MarkovModel mm = new MarkovModel(7);
//		runModel(mm, st, size, seed);
		
		EfficientMarkovModel em = new EfficientMarkovModel(6);
		runModel(em, st, size, seed);
	}
	
	public void testHashMap() throws FileNotFoundException {
		
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
		
		st = "“yes-this-is-a-thin-pretty-pink-thistle";
		
		int seed = 42;
		int size = 50;
		
		EfficientMarkovModel em = new EfficientMarkovModel(2);
		runModel(em, st, size, seed);
	}
	
	public void compareMethods() throws FileNotFoundException {
		
		DirectoryResource dr = new DirectoryResource();
		Scanner sc;
		StringBuilder sb = new StringBuilder();
		
		File f = new File("hawthorne.txt");
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
		
		int seed = 42;
		int size = 1000;
		
		double begin = System.nanoTime();
		for(int i = 0 ; i < 3 ; i++) {
		MarkovModel mm = new MarkovModel(2);
		runModel(mm, st, size, seed);
		}
		double end = System.nanoTime();
		double stime = (end-begin)/1e9;
		
		
		begin = System.nanoTime();
		for(int i = 0 ; i < 3 ; i++) {
	
		EfficientMarkovModel em = new EfficientMarkovModel(2);
		runModel(em, st, size, seed);
		}
		end = System.nanoTime();
		double ttime = (end-begin)/1e9;
		
		System.out.printf("Normal:Efficient\t%3.2f\t%3.2f\n",stime,ttime);
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
