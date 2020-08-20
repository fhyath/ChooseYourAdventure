
public class ChooseYourAdventure {
	
	Elements root;
	Elements firstEnd;
	Elements secondEnd;
	Elements thirdEnd; 
	Elements fourthEnd;
	int counter = 1;
	String choicehistory = "";
	
	/* Constructor that takes an int to be the root node to be able to add left or right based on value. 

	*/
	public ChooseYourAdventure(int first, String end[], String beginningString ) {
		root = new Elements(first, false, beginningString);
		firstEnd  = new Elements(-1 , true , end[0]);
		secondEnd  = new Elements(-1 , true , end[1]);
		thirdEnd  = new Elements(-1 , true , end[2]);
		fourthEnd  = new Elements(-1 , true , end[3]);	
	}
	
	public int numberOfElements(Elements current) {
		
		if (current.right != null) {
		        counter += numberOfElements(current.right);
		    }
		if (current.left != null) {
		       counter += numberOfElements(current.left);
		    }
		   
		    return counter;	
	}
	
	public void addElement(Elements newElement, Elements current) {
			
			if(newElement.key <= current.key) {
				if(current.left ==null) {
					current.left = newElement;
					return;
				}
				else {
				addElement(newElement, current.left);
				}
			}	
			else {
				if(current.right==null) {
					current.right = newElement;
					return;
				}
				else {
				addElement(newElement, current.right);
				}
		}
	}
	
	public String choiceHistory(Elements input) {
		Elements current = root;
		while(current.key != input.key) {
			if(input.key > current.key) {
				current = current.right;
				choicehistory= choicehistory+"You have chosen R\n";
			}
			else {
				current = current.left;
				choicehistory= choicehistory+"You have chosen L\n";
			}	
		}
		return choicehistory;
		
	}
	
	public void addLink(Elements e1, Elements e2, int newkey) {
		Elements current = root;
	
		e2 = new Elements(newkey, e2.Ending, e2.storyline[0]);
		while(true) {
			if(e1.key >current.key) {	
				current = current.right;
				//System.out.println(current.key);
				if(e1.key == current.key) {
					
					if(e2.key > current.key) {
					
					}
					else {
						current.left = e2;
					}
					return;
				}
				else {
					current = current.right;
					
					if(e1.key == current.key) {
						if(e2.key > current.key) {
							current.right = e2;
						}
						else {
							current.left = e2;
						}
						return;
					}
				}
			}	
			else if(e1.key < current.key) {
				current = current.left;
				if(e1.key == current.key) {
					if(e2.key > current.key) {
						current.right = e2;
					}
					else {
						current.left = e2;
					}
					return;
				}
			}
			else {
				if(e2.key > current.key) {
					current.right = e2;
				}
				else {
					current.left = e2;
				}
				return;
			}
		}
	}

}
