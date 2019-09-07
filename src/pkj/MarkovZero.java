package pkj;

import java.util.Random;

public class MarkovZero {

	private Random myRandom;
	private String myText;
	
	public MarkovZero() {
		myRandom = new Random();
	}
	
	public void setRandom(int seed) {// to generate the same sequence of random number help in testing
		myRandom = new Random(seed);
	}
	
	public void setTraining(String text) {
		myText = text.trim();
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
}
