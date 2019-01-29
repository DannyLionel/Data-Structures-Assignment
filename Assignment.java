/**
*This program implements the Oil Well problem for assignment 2
*@author Dhanushga Lionel, Allan Santosh, Mohtasim Siddiqui
*@version 1.0
*@since 2018-03-06
*/
//Declaring libraries to use
import java.util.*;
import java.util.Vector;

public class Oilwell {
	
	ArrayList<String> oillocation = new ArrayList<String>(); //Make a new arraylist for string
	ArrayList<Integer> oillocationsize = new ArrayList<Integer>(); // Arraylist for integers
	ArrayList<Integer> newreserves = new ArrayList<Integer>(); // Arraylist for integers
	
	int x1, x2, y;//Declare variables

	public Oilwell (ArrayList<String> oillocation) {
		this.oillocation = oillocation;
	}
	/** This method checks the integers
	public void execute(int x1, int x2, boolean check) {
		
		for (int i = 0; i < oillocation.size(); i++) {
			Scanner stringtoint = new Scanner (oillocation.get(i));
			x1 = stringtoint.nextInt();
			x2 = stringtoint.nextInt();
			oillocationsize.add(checklayeramount(x1,x2));
		}
	}
	/** This method checks which is lower or which is higher
	public int checklayeramount (int lower, int higher) {
		return higher-lower;
	}
	/** This method checks pairs and returns a<b or it returns false
	public boolean checkpairs(int ax1, int ax2, int bx1, int bx2) {
		
		double a = ax1 * ax2;
		double b = bx1 * bx2;
		 
		if (a != b) {
			return a < b;
		}
		
		else {
			return false;
		}
	}
/**
*We pick a point to start drilling a hole
*Then we sort all other points on the line by the angle of the point we picked
*By iterating on the other points in the order of the slope use a rotating line sweep
*.If we encounter the first point of an oil layer, we add the value of this layer to the current result
*f we encounter the second point, we subtract the value of this layer from the current result
*/
	
	public static void main(String[] args) {
		
		int numlayers = 0;
		Scanner inputnumlayers = new Scanner (System.in);
		Scanner inputlocations = new Scanner (System.in);
		ArrayList<String> oillocation = new ArrayList<String>();
		
		while (numlayers == 0) {
			numlayers = inputnumlayers.nextInt();
		}
		
		for (int i = 0; i<numlayers; i++) {
			oillocation.add(inputlocations.nextLine());
		}
		
		
		Oilwell reserves = new Oilwell (oillocation) ;
		
		int value = 0;
		for (int i = 0; i < numlayers ; i++) {
			int cur = 0;
			for (int j = 0; j< numlayers; j++) {
				if (oillocation.get(i) == oillocation.get(j)) {
					if(oillocation.get(i)) >= oillocation.get(j) && oillocation.get(i) <= oillocation.get(j)){
						cur = cur + oillocation.get(j)-oillocation.get(i);
					} }
					else if (reserves.get(j).y <  reserves.get(i).y) {
						newreserves.add(oillocation.get(j).x2 - oillocation.get(j).x1 , oillocation.get(i).x1 - oillocation.get(i).x2, reserves.get(i).y-reserves.get(j).y);
						newreserves.add(oillocation.get(j).x1 - oillocation.get(j).x2 , oillocation.get(i).x1 - oillocation.get(i).x1, reserves.get(i).y-reserves.get(j).y);
				}
				else {
					newreserves.add(oillocation.get(j).x2 - oillocation.get(j).x1 , oillocation.get(i).x1 - oillocation.get(i).x1, reserves.get(j).y-reserves.get(i).y);
					newreserves.add(oillocation.get(j).x1 - oillocation.get(j).x2 , oillocation.get(i).x2 - oillocation.get(i).x1, reserves.get(j).y-reserves.get(i).y);
				}
				
				
			}
		
			reserves.execute(x1, x2, newreserves.checkpairs(oillocation.get(i).x1,oillocation.get(j).x2,oillocation.get(j).x1,oillocation.get(j).x2));
			for (int i = 0; i < newreserves.size(); j++) {
				cur = reservers.get(j).x1;
				if (cur>value) {
					value = cur;
					System.out.println(value);
				}
			}
			
		}
		
	}

}
