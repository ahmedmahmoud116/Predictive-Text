package pckg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovModel extends AbstractMarkovModel{

	private int Num;
	private HashMap<String,ArrayList<String>> myMap;
	
	public EfficientMarkovModel(int N) {
		Num = N;
		myRandom = new Random();
		myMap = new HashMap<String,ArrayList<String>>();
		
	}
	
	public void setTraining(String text) {
		myText = text.trim();
		buildMap();
		printHashMapInfo();
		
	}
	
	public String getRandomText(int numChars) {
			
			StringBuilder sb = new StringBuilder();
			int index = myRandom.nextInt(myText.length() - Num);//i need to pick any index that allow one character substring
			String key = myText.substring(index,index + Num);
			sb.append(key);

			ArrayList<String> follows;
			for(int i = 0;i<numChars-Num;i++) {
				
				if(myMap.containsKey(key))
				follows = myMap.get(key);
				else {
					System.out.println(i);
					System.out.println("heree");
					System.out.println(key);
					follows = getFollows(key);
					myMap.put(key,follows);
				}
				if(follows.size() == 0) {
					break;
				}
				index = myRandom.nextInt(follows.size());

				String temp = follows.get(index);
				sb.append(temp);
				key = key.substring(1) + temp;
			}
			System.out.println("Map Final: " + myMap.size());
			int max = 0;
			for(String s:myMap.keySet()) {
				if(max<myMap.get(s).size()) {
					max = myMap.get(s).size();
				}
			}
			System.out.println("Maximum final: " + max);
		return sb.toString();
	}
	
	public void buildMap(){
		int index;
		String key;
	
		
		for(int i = 0;i < myText.length() + 1000000;i++) {
		 index = myRandom.nextInt(myText.length() - Num);//i need to pick any index that allow one character substring
		 key = myText.substring(index,index + Num);
		 if(myMap.containsKey(key)) {
			 continue;
		 }
		 ArrayList<String> follows = getFollows(key);
		 myMap.put(key, follows);
		}
		
		
		 index = myRandom.nextInt(myText.length() - Num);//i need to pick any index that allow one character substring
		 key = myText.substring(index,index + Num);

		for(int i = 0;i < myText.length() + 1000000;i++) {
			
			if(myMap.containsKey(key)) {
				if(myMap.get(key).size()==0) {
					 index = myRandom.nextInt(myText.length() - Num);//i need to pick any index that allow one character substring
					 key = myText.substring(index,index + Num);
					 continue;
				}
				index = myRandom.nextInt(myMap.get(key).size());
				String temp = myMap.get(key).get(index);
				key = key.substring(1) + temp;
				continue;
			}
			
			
			ArrayList<String> follows = getFollows(key);
			myMap.put(key, follows);
			
			if(follows.size() == 0) {
				 index = myRandom.nextInt(myText.length() - Num);//i need to pick any index that allow one character substring
				 key = myText.substring(index,index + Num);
				 continue;
			}
			index = myRandom.nextInt(follows.size());
			String temp = follows.get(index);
			key = key.substring(1) + temp;
			
		}
	}
	
	public void printHashMapInfo() {

		int max = 0;
		for(String s:myMap.keySet()) {
//			System.out.println("KEY , Follows Character: " + s + ", " + myMap.get(s).toString());
			if(max<myMap.get(s).size()) {
				max = myMap.get(s).size();
			}
		}
		System.out.println("Number of keys in the map: " + myMap.size());
		
		System.out.println("The maximum size of ararylist: " + max);
		
		int counter = 0;
		System.out.println("The keys with maximum size: ");
		for(String s:myMap.keySet()) {
			if(max == myMap.get(s).size())
			{
				System.out.println(s);
				counter++;
			}
		}
		System.out.println("Number of keys with max size: " + counter);
		System.out.println();
	}
	
	public String toString() {
		return "EfficientMarkovModel of order " + Num;
	}
	
	
	public ArrayList<String> getFollows(String key){
		
		
		ArrayList<String> follows = new ArrayList<String>();
		int pos = 0;
		if(myText == null) {
			return follows;
		}
	
	
		//	st = "“yes-this-is-a-thin-pretty-pink-thistle";
		for(int i = 0;i<myText.length();i++) {
			int indx = myText.indexOf(key,pos);
			if(indx + key.length() == myText.length() || indx == -1) {
				break;
			}
			int new_indx = indx + key.length();
			String k = myText.substring(new_indx,new_indx+1);
			pos = indx + 1;
			follows.add(k);
		}
	
		return follows;
	}
}
