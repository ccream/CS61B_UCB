import static org.junit.Assert.*;
import org.junit.Test;
import edu.princeton.cs.algs4.*;

public class TestArrayDequeGold {
	@Test
	public void testStudentArray()  {
		StudentArrayDeque<Integer> student = new StudentArrayDeque();
		ArrayDequeSolution<Integer> solution = new ArrayDequeSolution();
		String msg = "";
		for(int attempt = 0; attempt < 1000; attempt++)  {
			int addOrRemove = StdRandom.uniform(2);
			int firstOrLast = StdRandom.uniform(2);
			Integer stuR = 0;
			Integer solR = 0;
			int next = StdRandom.uniform(100);
			if(student.size() == 0)  {
				addOrRemove = 0;
			}
			if(addOrRemove == 0)  {
				if(firstOrLast == 0)  {
					msg += "addFirst("+next+")\n";
					student.addFirst(next);
					solution.addFirst(next);
				}
				else  {
					msg += "addLast("+next+")\n";
					student.addLast(next);
					solution.addLast(next);
				}
			}
			else  {
				if(firstOrLast == 0)  {
					msg += "removeFirst()\n";
					stuR = student.removeFirst();
					solR = solution.removeFirst();
				}
				else  {
					msg += "removeLast()\n";
					stuR = student.removeLast();
					solR = solution.removeLast();
				}
			}
			assertEquals(msg, stuR, solR);
		}	
	}
}
