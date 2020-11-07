import java.util.*;

public class AssassinManager {
	
	AssassinNode firstKillNode;
	AssassinNode lastKillNode;
	AssassinNode firstGraveNode;
	AssassinNode lastGraveNode;
	
	public AssassinManager(List<String> names) {
		if (names.size() < 1) {
			throw new IllegalArgumentException("no names given");
		}
		firstKillNode = new AssassinNode(names.get(0));
		lastKillNode = firstKillNode;

		for (int i = 1; i < names.size(); i++) {
			lastKillNode.next = new AssassinNode(names.get(i));
			AssassinNode temp = lastKillNode.next;
			lastKillNode = temp;
		}

	}
	
	//MINE
	public void printGraveyard() {
		String str = "";
		AssassinNode temp = firstGraveNode;
		if (!(temp == null)) {
			str += temp.name + ", ";
			temp = temp.next;
		} 
		System.out.print(str);
			
	}
	
	//luke's
//	public void printGraveyard() {
//		     ArrayList<String> dead = new ArrayList<String>();
//		     //ArrayList<String> killers = new ArrayList<String>();
//		 
//		    for(AssassinNode k = firstGraveNode; k!=null; k = k.next) {
//		       dead.add(k.name);
//		       //killers.add(dead.killer);
//		    }
//		      
//		    for(int n = dead.size() - 1; n > 0; n--) {
//		       System.out.print("    <" + dead.get(n) + ">");
//		       System.out.print(" was killed by ");
//		       //System.out.println("<" + killers.get(n).killer + ">");
//		    }
//		         
//		   }
//		  
	
	public void printKillRing() {
		String str = "";
		AssassinNode temp = firstKillNode;
		for(AssassinNode k = firstGraveNode; k!=null; k = k.next) {
			str += temp.name + ", ";
			temp = temp.next;
		} 
		System.out.print(str);
		
}
		  
	//MINE
	public boolean killRingContains(String name) {
		AssassinNode temp = firstKillNode;
		if (!(temp == null)) {
			if (temp.name.equalsIgnoreCase(name)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public boolean graveyardContains(String name) {
		AssassinNode temp = firstGraveNode;
		if (!(temp == null)) {
			if (temp.name.equalsIgnoreCase(name)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public boolean gameOver() {
		if(firstKillNode.next == null) {
		    return true;
		}
		return false;
	}
	
	public String winner() {
		if(gameOver() == false) {
			return null;
		}
		return firstKillNode.name;
	}

	public void kill(String name) {
		if (gameOver()) {
			throw new IllegalStateException("Game is over");
        }
		
        if(!killRingContains(name)) {
            throw new IllegalArgumentException("Given name not part of the current kill ring");
        }
	
        AssassinNode current = firstKillNode;
        AssassinNode previous = null;
        AssassinNode next = null;

        //iterates through the linked list until it finds the node with the name
        while (!current.name.equalsIgnoreCase(name)) {
        	previous = current;
            current = current.next;
        }
        
        //if the previous is still null meaning that we are at the beginning of the list, set previous to the last node
        if (previous == null) {
            previous = firstKillNode;
            while(!(previous.next == null)) {
                previous = previous.next;
            }
        }
        
        //checks to see if the next node is null, meaning we are at the end of the list
        //if this is true, the next node would be the first node
        //if this is false, the next node would be the next node
        if (current.next == null) {
            next = firstKillNode;
        }
        else {
        	next = current.next;
        }

        previous.next = next;
        current.killer = previous.name;

        //iterates through the grave list until it reaches the end and then adds the current node to it
        //sets the previous lastGrave's "next" to the current node and sets current node's "next" to null
        //indicating that it is add the end of the list
        AssassinNode lastGrave = firstGraveNode;
        while(!(lastGrave.next == null)) {
            lastGrave = lastGrave.next;
        }

        lastGrave.next = current;
        current.next = null;
	
    }
}
