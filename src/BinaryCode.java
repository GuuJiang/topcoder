import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class BinaryCode
{
	public String[] decode(String message)
	{
		return new String[] {
			solve(message, '0'),
			solve(message, '1')
		};
	}
	
	private String solve(String q, char init) {
		char[] p = new char[q.length() + 2];
		p[0] = '0';
		p[1] = init;
		for (int i = 0; i < q.length(); ++i) {
			int n = num(q.charAt(i)) - num(p[i]) - num(p[i + 1]);
			if (n != 0 && n != 1) {
				return "NONE";
			}
			p[i + 2] = (char) ('0' + n);
		}
		if (p[p.length - 1] != '0') {
			return "NONE";
		}
		return new String(p, 1, p.length - 2);
	}
	
	private int num(char c) {
		return c - '0';
	}
	
	
}
//Powered by [KawigiEdit] 2.0!
