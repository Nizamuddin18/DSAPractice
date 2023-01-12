package interview.Strings;

public class StringCompression {

	public static void main(String[] args) {
		String str = "aaaabbbccdee";
		System.out.println(compressed1(str));
	}

	public static String compressed(String s)
	    {
	        String str = new String();
	        int len = s.length();     
	        // loop to traverse the string and
	        // check for repeating chars using
	        // IndexOf() method in Java
	        for (int i = 0; i < len; i++) 
	        {
	            // character at i'th index of s
	            char c = s.charAt(i);
	              
	            // if c is present in str, it returns
	            // the index of c, else it returns -1
	            if (str.indexOf(c) < 0)
	            {
	                // adding c to str if -1 is returned
	                str += c;
	            }
	        }
	        return str;
	    }
	public static String compressed1(String s)
    {
        String str = "";
        str = str + s.charAt(0);
        int count = 1;
        
        for (int i = 1; i < s.length() ; i++) 
        {
        	if(s.charAt(i) != s.charAt(i-1)){
        		if(count > 1){
        			str = str + count;
        		}
        		
        		str = str + s.charAt(i);
        		count = 1;
        	}else{
        		count++;
        	}
        }
        if(count > 1){
			str = str + count;
		}
        return str;
    }
}
