


public class Debugger {

	private static String mode;

	
	public static String getMode(){
		return mode;
	}
	
	public static void init(String m){
		if(m==null)
			mode = "n";
		else
			mode=m;
	}
	public static void print(String s){  
		System.out.println(s);
		
	} 
	
	public static void debug(String s){ 
		if(mode.equals("d")|| mode.equals("v"))
			System.out.println(s);
		
	} 
	
	public static void verbose(String s ){
		//String d=System.getProperty("debug");
		if(mode.equals("v"))
			System.out.println(s);
	} 
}
