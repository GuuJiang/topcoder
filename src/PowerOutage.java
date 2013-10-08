import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class PowerOutage
{
	Map<Integer, Map<Integer, Integer>> map;

	public int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength)
	{
		map = new HashMap<Integer, Map<Integer, Integer>>();
		for (int i = 0; i < fromJunction.length; ++i) {
			Map<Integer, Integer> entry = map.get(fromJunction[i]);
			if (entry == null) {
				entry = new HashMap<Integer, Integer>();
				map.put(fromJunction[i], entry);
			}
			entry.put(toJunction[i], ductLength[i]);
		}
		
		int sum = 0;
		for (int len : ductLength) {
			sum += len;
		}
		
		return sum * 2 - longest(0);
	}
	
	private int longest(int start) {
		int max = 0;
		Map<Integer, Integer> dest = map.get(start);
		if (dest == null) {
			return 0;
		}
		for (Map.Entry<Integer, Integer> entry : dest.entrySet()) {
			int t = entry.getValue() + longest(entry.getKey());
			if (t > max) {
				max = t;
			}
		}
		return max;
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
