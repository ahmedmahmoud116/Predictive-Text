package pckg;

import java.util.Random;

public class MarkovZero extends AbstractMarkovModel{

	public MarkovZero() {
		myRandom = new Random();
	}
	
	public String getRandomText(int numChars) {
		if(myText == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<numChars;i++) {
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));
		}
		return sb.toString();
	}
	
	public String toString() {
		return "MarkovZero of order 0";
	}
}
