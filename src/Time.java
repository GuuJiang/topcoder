public class Time {
	public String whatTime(int seconds) {
		int h = seconds / 3600;
		seconds %= 3600;
		int m = seconds / 60;
		seconds %= 60;
		return String.format("%d:%d:%d", h, m, seconds);
	}
}
