import java.util.*;

public class Hello {    

    static class Spreadsheet {

        Map<String, Cell> map = new HashMap<>();

 
        public Spreadsheet(int rows) {
            
        }
        
        public void setCell(String cell, int value) {
            Cell c = new Cell();
            c.setValue(value);
            map.put(cell, c);
        }
        
        public void resetCell(String cell) {
            if(map.containsKey(cell)){
               Cell c = map.get(cell);
               c.setValue(0);
            }
        }
        
        public int getValue(String formula) {

            if(formula.contains("=")){
                
            }


            return 0;
        }
    }

    public static void main(String[] args) {

        Spreadsheet spreadsheet = new Spreadsheet(3); // Initializes a spreadsheet with 3 rows and 26 columns
    
        spreadsheet.getValue("=5+7"); // returns 12 (5+7)
    
        spreadsheet.setCell("A1", 10); // sets A1 to 10 // done 
    
        spreadsheet.getValue("=A1+6"); // returns 16 (10+6)
    
        spreadsheet.setCell("B2", 15); // sets B2 to 15 // done 
    
        spreadsheet.getValue("=A1+B2"); // returns 25 (10+15) 
    
        spreadsheet.resetCell("A1"); // resets A1 to 0 // done
    
        spreadsheet.getValue("=A1+B2"); // returns 15 (0+15) =  25 

       


        /*
         * 
         * 1. Initializes a spreadsheet with 3 rows and 26 columns - A-Z 
         * 2. Set cell example 29 example
         * 3. reset insead addition of 2 number
         * 4. 
         * 
         * 
         */
        
    }

    static class Cell {

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
        
    }
    
     

}
