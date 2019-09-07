package pkj;

import java.util.Random;
import java.util.ArrayList;

public class MarkovOne {
	
	private Random myRandom;
	private String myText;
	
	public MarkovOne() {
		myRandom = new Random();
	}
	
	public void setRandom(int seed) {// to generate the same sequence of random number help in testing
		myRandom = new Random(seed);
	}
	
	public void setTraining(String text) {
		myText = text.trim();
	}
	
	public String getRandomText(int numChars) {
		
			StringBuilder sb = new StringBuilder();
			int index = myRandom.nextInt(myText.length()-1);//i need to pick any index that allow one character substring
			String key = myText.substring(index,index+1);

			sb.append(key);
			
			for(int i = 0;i<numChars-1;i++) {
				ArrayList<String> follows = getFollows(key);
				if(follows.size() == 0) {
					break;
				}
				index = myRandom.nextInt(follows.size());
				String temp = follows.get(index);
				sb.append(temp);
				key = temp;
			}
		return sb.toString();
	}
	
	public ArrayList<String> getFollows(String key){
		ArrayList<String> follows = new ArrayList<String>();
		int pos = 0;
		if(myText == null) {
			return follows;
		}
		
		for(int i = 0;i<myText.length();i++) {
			int indx = myText.indexOf(key,pos);
			if(indx == myText.length()-1 || indx == -1) {
				break;
			}
			indx = indx + key.length();
			String k = myText.substring(indx,indx+1);
			pos = indx;
			follows.add(k);
		}
		return follows;
	}
	
	public String toString() {
		return "MarkovOne of order 1";
	}
	
}
