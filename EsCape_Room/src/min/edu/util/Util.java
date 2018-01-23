package min.edu.util;

public class Util {
	
	
	public static long end = 0 ;
	public static long start = 0 ;
	
	public static long getInstance() {
		
		if(end==0) {
			end = System.currentTimeMillis();
			
		}
		
		return end;
	}
	
	public static long getInstance2() {
		
		if(start==0) {
			start = System.currentTimeMillis();
			
		}
		
		return start;
	}
	
	
	
	
			
	
}
