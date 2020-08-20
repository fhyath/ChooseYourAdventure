
public class Elements {
	Elements left,right;
	boolean Ending;
	int visits;
	int key;
	int counter = 0;
	int links = 0;
	
	String [] storyline = new String[4];    
	
	/* Constructor for elements which is an O(1) operation. Takes in a key to be sorted by, a boolean to represent whether it is at one of the ends
	 * and a string.
	*/
	public Elements(int key, boolean Ending, String string) {
		this.key = key;
		this.Ending = Ending;
		storyline[0] = string;	
	}
	/*

	*/
	public void addStoryLine (String string, int visit) {
		storyline[visit] = string;
	}
	
	public void updatetStoryLine(String string, int visit) {
		storyline[visit] = string;
	}
	
	/* A O(1) space and time complexity operation to return the times visited a node.
	*/
	
	public int timesVisited() {
		return visits;
	}

	
	public void removeStoryLine(int visit) {
		int count = 0;
		int i =0;
		while(i<storyline.length) {
			i++;
			if(count > 1) {
				storyline[visit] = null;
				break;
			}
			if (storyline[i]!=null) {
			count++;
			}
		}
	}
	
	/* Boolean operation that runs in O(1) operation that returns whether it at the end or not.
	*/
	public boolean isEnding() {
		return Ending;
	}
	
	
	public int numberOfStoryLine() {
		int i = 0;
		while(i<storyline.length-1) {
			if(storyline[i]!=null) {
			i++;
			counter++;
			}
		}
		return counter;
	}
	
	/* An O(1) operation that increments based on if a node is connected to another node.
	*/
	public int links() {
		if(right != null || left!=null) {
			links++;
		}
		return links;
	}

}

