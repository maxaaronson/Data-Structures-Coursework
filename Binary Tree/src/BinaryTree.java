
public class BinaryTree {

	int nodeCount;
	Node root;
	int depthOfTree;
	String deepestWord;
	
	public BinaryTree(){
		nodeCount = 0;
		root = null;
		depthOfTree = 0;
	}
	
	public void add(String word){
		if (nodeCount == 0){
			root = new Node(word);
			nodeCount++;
		}
		else {
			addHelper(root, word);
		}
	}

	private void addHelper(Node current, String word) {
		int a = current.getWord().compareTo(word);
		
		if (a == 0){
			current.setCount(current.getCount() + 1);
		return;
		}
		else if (a > 0){
			if (current.getLeft() != null){
				addHelper(current.getLeft(), word);
			}
			else {
				current.setLeft(new Node(word));
				nodeCount++;
			}
		}
		else {
			if (current.getRight() != null){
				current = current.getRight();
				addHelper(current, word);
			}
			else {
				current.setRight(new Node(word));
				nodeCount++;

			}
		}
		
	}
	
	public void display(){
		displayHelper(root, 0);
	}

	public void displayHelper(Node current, int depth){
		if (current != null){
			displayHelper(current.getLeft(), depth+1);
			System.out.println(depth + " " + current.getWord());
			displayHelper(current.getRight(), depth+1);
		}
	}
	
	public int findDepth(){
		int i = getDepth(root, 0);
		return i;
	}
	
	private int getDepth(Node current, int depth){
		if (current != null){
			depth++;
			int lDepth = getDepth(current.getLeft(), depth);
			
			int rDepth = getDepth(current.getRight(), depth);
			
			if (lDepth > rDepth){
				depth = lDepth;
			}
			else {
				depth = rDepth;
			}
		}
		depthOfTree = depth;  // used to find deepest word
		return depth;
	}	
	
	public String getDeepestWord(Node current, int depth){
		if (current != null){
			depth++;
			if (depth == depthOfTree){
				deepestWord = current.getWord();
				}
			getDeepestWord(current.getLeft(), depth);
			
			getDeepestWord(current.getRight(), depth);
			
		}
		return deepestWord;
	}

	public Node getRoot() {
		return root;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public int getWordFrequency(String word) {
		int i = findFrequency(root, word);
		return i;
	}

	private int findFrequency(Node current, String word) {
		if (current != null){
			
			int a = current.getWord().compareTo(word);
			
			if (a == 0){
				return current.getCount();
			}
			else if (a > 0){
				
				int count = findFrequency(current.getLeft(), word);
				return count;
			}
			else {
				int count = findFrequency(current.getRight(), word);
				return count;
				}
			}
		else {
			return 0;
		}
		
	}

	public void mostFrequentWord() {
		if (nodeCount == 0){
			System.out.println("Tree is empty");
			return;
		}
		Node n = findMostFrequent(root, root, 0);
		System.out.println("Most frequent word is '" + n.getWord() +
				"', occuring " + n.getCount() + " times");
	}

	private Node findMostFrequent(Node current, Node answer, int count) {
		if (current != null){
			int c = current.getCount();
			if (c > count){
				answer = current;
			}
			findMostFrequent(current.getLeft(), answer, count);
			findMostFrequent(current.getRight(), answer, count);
		}
		return answer;
		
	}
	
}
