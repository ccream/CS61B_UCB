public class LinkedListDeque <T> {
	
	public class Node  {
		private T value;
		private Node prev;
		private Node next;
	}
	
	private Node sentinel;
	private int size;
	
	public LinkedListDeque()  {
		sentinel = new Node();
		size = 0;
		sentinel.value = null;
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
	}
	
	public void addFirst(T item)  {
		size++;
		if(size == 1)  {
			Node first = new Node();
			first.prev = sentinel;
			first.next = sentinel;
			first.value = item;
			sentinel.next = first;
			sentinel.prev = first;
			return;
		}
		Node first = new Node();
		first.prev = sentinel;
		first.value = item;
		first.next = sentinel.next;
		sentinel.next.prev = first;
		sentinel.next = first;
	}
	
	public void addLast(T item)  {
		size++;
		if(size == 1)  {
			Node last = new Node();
			last.next = sentinel;
			last.prev = sentinel;
			last.value = item;
			sentinel.next = last;
			sentinel.prev = last;
			return;
		}
		Node last = new Node();
		last.next = sentinel;
		last.value = item;
		last.prev = sentinel.prev;
		sentinel.prev.next = last;
		sentinel.prev = last;
	}
	
	public boolean isEmpty()  {
		return size == 0;
	}
	
	public int size()  {
		return size;
	}
	
	public void printDeque()  {
		Node temp = sentinel.next;
		while(temp != null && temp != sentinel)  {
			System.out.print(temp.value+" ");	
			temp = temp.next;	
		}
		System.out.println();
	}
	
	public T removeFirst()  {
		if(size == 0)  {
			return null;
		}
		size--;
		if(size == 0)  {
			T result = sentinel.next.value;
			sentinel.next = sentinel;
			sentinel.prev = sentinel;
			return result;
		}
		T result = sentinel.next.value;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		return result;
	}
	
	public T removeLast()  {
		if(size == 0)  {
			return null;
		}
		size--;
		if(size == 0)  {
			T result = sentinel.prev.value;
			sentinel.next = sentinel;
			sentinel.prev = sentinel;
			return result;
		}
		T result = sentinel.prev.value;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		return result;
	}
	
	public T getRecursive(int index)  {
		if(index >= size || size == 0 || index < 0)  {
			return null;
		}
		int current = 0;
		Node temp = sentinel.next;
		while(current != index)  {
			temp = temp.next;
			current++;
		}
		return temp.value;
	}
	
	public T get(int index)  {
		if(index >= size || size == 0 || index < 0)  {
			return null;
		}
		Node temp = sentinel.next;
		for(int i = 0; i < index; i++)  {
			temp = temp.next;
		}
		return temp.value;
	}
}
