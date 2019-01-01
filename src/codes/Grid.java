package codes;

public class Grid {

	private Node first;
	private int dimension;
	
	public Grid(int dimension) { // making a square, so xy not necessary
		this.dimension = dimension;
		
		if(dimension == 1)
			first = new Node();
		else if (dimension <= 0)
			first = null;
		else {
			first = new Node();
			Node temp = null;
			Node columnMarker = first;
			Node rowMarker = first;
			
			for(int x = 0; x < dimension-1; x++) {
				temp = new Node();
				
				columnMarker.setRight(temp);
				temp.setLeft(columnMarker);
				
				columnMarker = temp;
			}
			
			for(int w = 0; w < dimension-1; w++) {
				temp = new Node();
				rowMarker.setDown(temp);
				temp.setUp(rowMarker);
				rowMarker = temp;
				
				columnMarker = rowMarker;
				
				
				for(int x = 0; x < dimension-1; x++) {
					temp = new Node();
					temp.setLeft(columnMarker);
					columnMarker.setRight(temp);
					temp.setUp(temp.getLeft().getUp().getRight());
					temp.getUp().setDown(temp);
					
					columnMarker = temp;
				}
			}
		}
	}
	
	public void display() {
		Node temp = first;
		Node rowMarker = first;
		
		while(temp != null) { // down
			while(temp != null) { // across
				if(temp.getData() > 99)
					System.out.print(temp.getData() + " ");
				else if(temp.getData() > 9)
					System.out.print(temp.getData() + "  ");
				else
					System.out.print(temp.getData() + "   ");
				
				temp = temp.getRight();
			}
			
			System.out.println();
			rowMarker = rowMarker.getDown();
			temp = rowMarker;
		}
	}
}
