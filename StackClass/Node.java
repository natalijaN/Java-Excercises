public class Node<T> {			
	public Node<T> next = null;
	public T data = null;

	public Node() {}
		
	public Node(T value) {
		this.data = value;
	}
}