package Util;

public class Utilites {

	
 public static boolean hasValue(String data)
 {
	 if(data==null)
		 return false;
	 if(data.equalsIgnoreCase("undefined"))
		 return false;
	 return true;
 }
}
