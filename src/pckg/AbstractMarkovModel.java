package pckg;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractMarkovModel implements IMarkovModel{
	
	protected String myText;
	protected Random myRandom;
	
	public AbstractMarkovModel() {
		myRandom = new Random();
	}
	
	public void setRandom(int seed) {// to generate the same sequence of random number help in testing
		myRandom = new Random(seed);
	}
	
	public void setTraining(String text) {
		myText = text.trim();
	}
	
	abstract public String getRandomText(int numChars);
		
	
	public ArrayList<String> getFollows(String key){
		ArrayList<String> follows = new ArrayList<String>();
		int pos = 0;
		if(myText == null) {
			return follows;
		}
		
		for(int i = 0;i<myText.length();i++) {
			int indx = myText.indexOf(key,pos);
			if(indx == myText.length() - 1 || indx == -1) {
				break;
			}
			indx = indx + key.length();
			String k = myText.substring(indx,indx+1);
			pos = indx;
			follows.add(k);
		}
		return follows;
	}
	
}
