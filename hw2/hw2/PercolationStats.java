package hw2;

import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
	private int[] stats;
	private int T;
	private int N;
	
	public PercolationStats(int N, int T, PercolationFactory pf)  {
		if(N <= 0 || T <= 0)  {
			throw new IllegalArgumentException();
		}
		this.N = N;
		this.T = T;
		stats = new int[T];
		for(int i = 0; i < T; i++)  {
			Percolation temp = pf.make(N);
			while(!temp.percolates())  {
				int row = StdRandom.uniform(N);
				int col = StdRandom.uniform(N);
				temp.open(row, col);
			}
			stats[i] = temp.numberOfOpenSites();
		}
	}
	
	public double mean() {
        return StdStats.mean(stats);
    }

    public double stddev() {
        return StdStats.stddev(stats);
    }

    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }

    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }
}
