package pckg;

import java.util.ArrayList;
import java.util.Random;

public class MarkovModel extends AbstractMarkovModel{
	
	private int Num;
	
	public MarkovModel(int N) {
		Num = N;
		myRandom = new Random();
	}

	
	public String getRandomText(int numChars) {
		
			StringBuilder sb = new StringBuilder();
			int index = myRandom.nextInt(myText.length()-Num);//i need to pick any index that allow one character substring
			String key = myText.substring(index,index+Num);
			sb.append(key);
			
			for(int i = 0;i<numChars-Num;i++) {
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
		return "MarkovModel of order " + Num;
	}
}
