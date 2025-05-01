package com.akash.leetcode;

public class ExcelSheetNumber171 {
    
    public static void main(String[] args) {
        
        String str = "ZY";
        titleToNumber(str);
        titleToNumberUsingJava8(str);
        
    }

    private static int titleToNumberUsingJava8(String columnTitle) {
        return columnTitle.chars().mapToObj(ch -> {
            if (ch >= 'A' && ch <= 'Z') {
                return ch - 'A' + 1;
            } else {
                throw new IllegalArgumentException("Invalid character: " + (char) ch);
            }
        }).reduce(0, (res, value) -> res * 26 + value);          
    }

    private static int titleToNumber(String columnTitle) {
        int res = 0;
	    for(char ch : columnTitle.toCharArray()){
		    int value = 0;
		    if(ch>='A' && ch<='Z'){
			    value = ch - 'A' +1;
		    }
		    res = res * 26 + value;
	    }
	    return res;
    }

}
