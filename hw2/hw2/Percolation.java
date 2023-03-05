package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean[] open;
	private int N;
	private int count = 0;
	private WeightedQuickUnionUF record;
	private WeightedQuickUnionUF recordNoBot;
	
	public Percolation(int N)  {
		open = new boolean[N*N+2];
		record = new WeightedQuickUnionUF(N*N+2);
		recordNoBot = new WeightedQuickUnionUF(N*N+1);
		this.N = N;
	}
	
	private boolean validPos(int row, int col)  {
		if(row < 0 || col < 0 || row >= N || col >= N)  {
			return false;
		}
		return true;
	}
	
	public void open(int row, int col)  {
		if(!validPos(row, col))  {
			throw new IndexOutOfBoundsException();
		}
		if(open[row*N+col])  {
			return;
		}
		open[row*N+col] = true;
		count++;
		if(row != 0 && open[row*N+col-N])  {
			record.union(row*N+col-N, row*N+col);
			recordNoBot.union(row*N+col-N, row*N+col);
		}
		if(col != 0 && open[row*N+col-1])  {
			record.union(row*N+col-1, row*N+col);
			recordNoBot.union(row*N+col-1, row*N+col);
		}
		if(row != N-1 && open[row*N+col+N])  {
			record.union(row*N+col+N, row*N+col);
			recordNoBot.union(row*N+col+N, row*N+col);
		}
		if(col != N-1 && open[row*N+col+1])  {
			record.union(row*N+col+1, row*N+col);
			recordNoBot.union(row*N+col+1, row*N+col);
		}
		if(row == 0)  {
			record.union(col, N*N);
			recordNoBot.union(col, N*N);
		}
		else if(row == N-1)  {
			record.union(row*N+col, N*N+1);
		}
	}
	
	public boolean isOpen(int row, int col)  {
		if(!validPos(row, col))  {
			throw new IndexOutOfBoundsException();
		}
		return open[row*N+col];
	}
	
	public boolean isFull(int row, int col)  {
		if(!validPos(row, col))  {
			throw new IndexOutOfBoundsException();
		}
		return recordNoBot.connected(row*N+col, N*N);
	}
	
	public int numberOfOpenSites()  {
		return count;
	}
	
	public boolean percolates()  {
		return record.connected(N*N, N*N+1);
	}
	
	public static void main(String[] args)  {
		Percolation percolation = new Percolation(5);
		percolation.open(0, 0);
		percolation.open(1, 0);
		percolation.open(2, 0);
		percolation.open(3, 0);
		percolation.open(4, 0);
		percolation.open(4, 2);
		percolation.open(3, 2);
		percolation.open(2, 2);
		System.out.println(percolation.isFull(2, 2));
	}
}
