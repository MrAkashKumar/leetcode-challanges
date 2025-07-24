import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    
    //collect of number
    //collection 

    public static void main(String[] args) {
       // List<Integer> list = Arrays.asList(2,4,6,2,6,8,9);
        //frequencyNumber(list);
        


        /*
         * 
         * WAP to find highest mark get by a student(Name) in Mathematics
Student --> roll number , name, List<Subject>
Subject ---> name, marks
List<Student> s
         * 
         */

    }

    static class  Student {

    
      
    }










    private static void frequencyNumber(List<Integer> number){
        Map<Integer, Long> map = number.stream().filter(e-> e % 2==0).
        collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }

    //single core - 
    //multiple core - performance wise good and it will not follow inseration order
//
// A extends B
 // B extends A 

  //Set<Stude
  //  => n+1 problem 


  static class InnerTest1 {

    private Integer id;
    private String name;
    private String dept;

    // if id and depart are same it will duplicate otherwise new record

    

  }

  /*
   * "data": [

        {

            "patientname": "ZZTEST SARANYAA",

            "qid": "29565455454",

            "visitqual": [

                {

                    "visitdate": "20-MAY-2025 10:46",

                    "patienttype": "Outpatient",

                    "orderqual": [

                        {

                            "orderid": "331404657",

                            "name": "Epididymectomy Bilateral - 54861",

                        },

						    {

                            "orderid": "331404658",

                            "name": "Epididymectomy Bilateral - 54861",

                        }

                    ]

                },

                {

                    "visitdate": "20-MAY-2025 10:50",

                    "patienttype": "Outpatient",

                    "orderqual": [

                        {

                            "orderid": "331404633",

                            "name": "Epididymectomy Bilateral - 54861",

                        }

                    ]

                }

            ]

        }

    ]
 
   * 
   */

   static class OrderObject {

    private String orderid;

    private String name;

    public String getOrderid() {
      return orderid;
    }

    public void setOrderid(String orderid) {
      this.orderid = orderid;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public OrderObject(String orderid, String name) {
      this.orderid = orderid;
      this.name = name;
    }

    
    
   
    
   }

   static class Data {

    private String patientId;
    private String qId;
    private List<Visual> visualsList;

    public String getPatientId() {
      return patientId;
    }
    public void setPatientId(String patientId) {
      this.patientId = patientId;
    }
    public String getqId() {
      return qId;
    }
    public void setqId(String qId) {
      this.qId = qId;
    }
    public List<Visual> getVisualsList() {
      return visualsList;
    }
    public void setVisualsList(List<Visual> visualsList) {
      this.visualsList = visualsList;
    }

    
   
    
   }

   static class Visual {

    private String visitdate;
    private List<OrderObject> orderList;

    public String getVisitdate() {
      return visitdate;
    }
    public void setVisitdate(String visitdate) {
      this.visitdate = visitdate;
    }
    public List<OrderObject> getOrderList() {
      return orderList;
    }
    public void setOrderList(List<OrderObject> orderList) {
      this.orderList = orderList;
    }

    

   
    
   }

    
    /*
     * 
     *     
     * k is sub array size
        arr = {2,1,5,1,3,2} k=3
     * 
     */


  private static void findMaxMarkFromStudentInfo(){
    List<Student> list = new ArrayList<>();


    
  }



  

    

}
