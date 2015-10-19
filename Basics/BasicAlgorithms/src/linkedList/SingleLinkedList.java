/**
 * 
 */
package linkedList;

/**
 * @author mandar
 *
 */
public class SingleLinkedList {

	/**
	 * @param args
	 */
	Node head;
	Node tail;
	public SingleLinkedList(){
		head=null;tail=null;
	}
	
	public void add(Node node){
		if(tail==null){
			head=node;
			tail=node;
		}else{
			tail.setNextNode(node);
			tail=node;	
		}		
	}
	
	public void displayElements(){
		Node node=head;
		while(node!=null){
			System.out.println(node.getData());
			node=node.getNextNode();
		}
	}
	
	public void deleteElement(int number){
		Node node=head;
		int count=0;
		Node previousNode=node;
		while(node!=null){
			count++;
			if(node.getData()!=number){
				previousNode=node;
				node=node.getNextNode();
				if(node==null){
					System.out.println(number+" is not present in the list.");
				}
			}else{
				System.out.println("Element deleted at "+count+" location in the list.");
				previousNode.setNextNode(node.getNextNode());
				node.setNextNode(null);
				node=null;
				break;
			}			
		}
		
	}
	
	public void searchElement(int number){
		Node node=head;
		int count=0;
		while(node!=null){
			count++;
			if(node.getData()!=number){
				node=node.getNextNode();
				if(node==null){
					System.out.println(number+" is not present in the list.");
				}
			}else{
				System.out.println("Element found at "+count+" location in the list.");
				break;
			}			
		}
		
	}
	
	public void reverseList() {
	    if(head==null || head.getNextNode() == null) 
	        System.out.println("Empty list.");
	 
	    Node p1 = head;
	    Node p2 = head.getNextNode();
	 
	    head.setNextNode(null);
	    
	    while(p1!= null || p2!= null){
	        Node temp = p2.getNextNode();
	        p2.setNextNode(p1);
	        p1 = p2;
	        if (temp!=null){
	            p2 = temp;
	        }else{
	            break;
	        }
	    }	 
	    head=p2;
	}
	
	public static void main(String[] args) {
		SingleLinkedList list=new SingleLinkedList();
		list.add(new Node(12));
		list.add(new Node(22));
		list.add(new Node(32));
		list.add(new Node(52));
/*		list.displayElements();		
		list.searchElement(52);
		list.deleteElement(32);
		list.deleteElement(52);*/
		list.reverseList();
		list.displayElements();
	}

}
