package pckg;

import java.util.Random;
import java.util.ArrayList;

public class MarkovOne extends AbstractMarkovModel{
	
	public MarkovOne() {
		myRandom = new Random();
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
	
	public String toString() {
		return "MarkovOne of order 1";
	}
}
