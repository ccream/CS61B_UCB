public class ArrayDeque <T>{
	private T[] node;
	private int size;
	private int front;
	private int back;
	public ArrayDeque()  {
		node = (T[]) new Object[8];
		size = 0;
		front = 4;
		back = 4;
	}
	
	public int next(int num)  {
		if(num == node.length-1)  {
			return 0;
		}
		return num+1;
	}
	
	public int prev(int num)  {
		if(num == 0)  {
			return node.length-1;
		}
		return num-1;
	}
	
	public int size()  {
		return size;
	}
	
	public boolean isEmpty()  {
		return size == 0;
	}
	
	private void grow()  {
		T[] temp = (T[]) new Object[2*node.length];
		int ptr = 0;
		for(int i = front; i != back; i = next(i))  {
			temp[ptr] = node[i];
			ptr++;
		}
		front = 0;
		back = ptr;
		node = temp;
	}
	
	private void shrink()  {
		T[] temp = (T[]) new Object[node.length/2];
		int ptr = 0;
		for(int i = front; i != back; i = next(i))  {
			temp[ptr] = node[i];
			ptr++;
		}
		front = 0;
		back = ptr;
		node = temp;
	}

	public void addFirst(T item)  {
		if(size == node.length-1)  {
			grow();
		}
		front = prev(front);
		node[front] = item;
		size++;
	}
	
	public void addLast(T item)  {
		if(size == node.length-1)  {
			grow();
		}
		node[back] = item;
		back = next(back);
		size++;
	}
	
	public T removeFirst()  {
		if(size == 0)  {
			return null;
		}
		if(size <= node.length/4)  {
			shrink();
		}
		T temp = node[front];
		node[front] = null;
		front = next(front);
		size--;
		return temp;
	}
	
	public T removeLast()  {
		if(size == 0)  {
			return null;
		}
		if(size <= node.length/4)  {
			shrink();
		}
		T temp = node[prev(back)];
		node[prev(back)] = null;
		back = prev(back);
		size--;
		return temp;
	}
	
	public void printDeque()  {
		for(int i = front; i != back; i = next(i))  {
			System.out.print(node[i]+" ");
		}
		System.out.println();
	}
	
	public T get(int index)  {
		if(index >= size)  {
			return null;
		}
		int ptr = 0;
		for(int i = front; i != back; i = next(i))  {
			if(ptr == index)  {
				return node[i];
			}
			ptr++;
		}
		return null;
	}
}
