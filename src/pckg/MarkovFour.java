package pckg;

import java.util.ArrayList;
import java.util.Random;

public class MarkovFour extends AbstractMarkovModel{
	
	public MarkovFour() {
		myRandom = new Random();
	}
	
	
	public String getRandomText(int numChars) {
		
			StringBuilder sb = new StringBuilder();
			int index = myRandom.nextInt(myText.length() - 4);//i need to pick any index that allow one character substring
			String key = myText.substring(index,index + 4);
			sb.append(key);
			
			for(int i = 0;i<numChars-1;i++) {
				ArrayList<String> follows = getFollows(key);
				if(follows.size() == 0) {
					break;
				}
				index = myRandom.nextInt(follows.size());
				String temp = follows.get(index);
				sb.append(temp);
				key = key.substring(1) + temp;
			}
		return sb.toString();
	}
	
	
	public String toString() {
		return "MarkovFour of order 4";
	}
}
