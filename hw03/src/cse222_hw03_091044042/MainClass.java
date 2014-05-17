package cse222_hw03_091044042;

/**
 *
 * @author AAnılApaydın
 */

// Main Class definition
public class MainClass {

    /**
     * @param args the command line arguments
     */
    // Main functions
    public static void main(String[] args) {
        
        //List Variables
        GITList<Integer> myIntArrayList = new GITArrayList<Integer>();
        GITList<Integer> myIntLinkedList = new GITLinkedList<Integer>();
         
        
        //GITArrayList Testing
        {
            System.out.println("==========GITArrayList Testing==========");
            // Adding some variables to GITArrayList object
            myIntArrayList.add(0,1);
            myIntArrayList.add(1,2);
            myIntArrayList.addFirst(3);
            myIntArrayList.addLast(4);
            myIntArrayList.add(1,5);

            // Printing GITArrayList
            for(int i = 0 ; i < myIntArrayList.size() ; ++i) 
                System.out.println(myIntArrayList.get(i));

            System.out.println("ListSize:"+myIntArrayList.size()); 

            // Get methods testing
            int listItem = myIntArrayList.get(2);
            int firstItem = myIntArrayList.getFirst(); 
            int lastItem = myIntArrayList.getLast();
            // Printing gotten values
            System.out.println("listItem index2: " +listItem + 
                               "\nfirstItem: " +firstItem +
                               "\nlastItem: " +lastItem);

            // For addAll,containAll,removeAll,retainAll
            GITList<Integer> mySecondIntList = new GITLinkedList<Integer>();
            mySecondIntList.add(0,3);
            mySecondIntList.add(1,6);
            // addAll testing
            myIntArrayList.addAll(mySecondIntList); 
            System.out.println("\nAfter AddAll method:");
            for(int i = 0 ; i < myIntArrayList.size() ; ++i) 
                System.out.println(myIntArrayList.get(i));
        
            System.out.println("ListSize:"+myIntArrayList.size());
            //containAll testing
            System.out.println("\nContains All Metod Testing");
            if(!myIntArrayList.containsAll(mySecondIntList)) 
                System.out.println("GITArrayList does not constains items");
            else
                System.out.println("GITArrayList constains mySecondList items");
            
            System.out.println("GITArrayList:"); 
            for(int i = 0 ; i < myIntArrayList.size() ; ++i) 
                System.out.println(myIntArrayList.get(i));
        
            System.out.println("ListSize:"+myIntArrayList.size());
            
            System.out.println("mySecondList:"); 
            for(int i = 0 ; i < mySecondIntList.size() ; ++i) 
                System.out.println(mySecondIntList.get(i));
        
            System.out.println("ListSize:"+mySecondIntList.size());
            
            // removeAll testing
            System.out.println("\nRemove All Method Testing");
            
            myIntArrayList.removeAll(mySecondIntList);
            System.out.println("GITArrayList:");
            for(int i = 0 ; i < myIntArrayList.size() ; ++i) 
                System.out.println(myIntArrayList.get(i));
        
            System.out.println("ListSize:"+myIntArrayList.size());
            
            System.out.println("mySecondList:");
            for(int i = 0 ; i < mySecondIntList.size() ; ++i) 
                System.out.println(mySecondIntList.get(i));
        
            System.out.println("ListSize:"+mySecondIntList.size());
            
            // retainAll testing
            System.out.println("\nRetain All Method Testing");
            System.out.println("\nAt first adding some variables to List");
            
            myIntArrayList.addLast(6);
            myIntArrayList.addLast(6);
            myIntArrayList.addLast(3);
            myIntArrayList.addLast(7);
            
            System.out.println("GITArrayList:");
            for(int i = 0 ; i < myIntArrayList.size() ; ++i) 
                System.out.println(myIntArrayList.get(i));
        
            System.out.println("ListSize:"+myIntArrayList.size());
            
            System.out.println("After retainAll method:");
            myIntArrayList.retainAll(mySecondIntList);
            System.out.println("GITArrayList:");
            for(int i = 0 ; i < myIntArrayList.size() ; ++i) 
                System.out.println(myIntArrayList.get(i));
        
            System.out.println("ListSize:"+myIntArrayList.size());
            
            System.out.println("mySecondList:");
            for(int i = 0 ; i < mySecondIntList.size() ; ++i) 
                System.out.println(mySecondIntList.get(i));
        
            System.out.println("ListSize:"+mySecondIntList.size());
            
        }// End of GITArrayList testing
        
        // GITLinkedList testing
        {
            System.out.println("==========GITLinkedList Testing==========");
            // Adding some variables to the GITLinkedList
            myIntLinkedList.add(0,1);
            myIntLinkedList.add(1,2);
            myIntLinkedList.addFirst(3);
            myIntLinkedList.addLast(4);
            myIntLinkedList.add(1,5);

            // Printing GITLinkedList
            for(int i = 0 ; i < myIntLinkedList.size() ; ++i) 
                System.out.println(myIntLinkedList.get(i));

            System.out.println("ListSize:"+myIntLinkedList.size());

            // Get methods testing
            int listItem = myIntLinkedList.get(2);
            int firstItem = myIntLinkedList.getFirst(); 
            int lastItem = myIntLinkedList.getLast();

            System.out.println("listItem index2: " +listItem + 
                               "\nfirstItem: " +firstItem +
                               "\nlastItem: " +lastItem);

            // For addAll,containAll,removeAll,retainAll testing
            GITList<Integer> mySecondIntList = new GITArrayList<Integer>();
            mySecondIntList.add(0,3);
            mySecondIntList.add(1,6);
            // addAll testing
            myIntLinkedList.addAll(mySecondIntList); 
            System.out.println("\nAfter AddAll method:");
            for(int i = 0 ; i < myIntLinkedList.size() ; ++i) 
                System.out.println(myIntLinkedList.get(i));

            System.out.println("ListSize:"+myIntLinkedList.size());
            // containAll testing
            System.out.println("\nContains All Method Testing");
            mySecondIntList.addLast(7); 
            if(!myIntLinkedList.containsAll(mySecondIntList)) 
                System.out.println("GITLinkedList does not constains mySecondList items");
            else
                System.out.println("GITLinkedList constains items");
            
            System.out.println("GITLinkedList:"); 
            for(int i = 0 ; i < myIntLinkedList.size() ; ++i) 
                System.out.println(myIntLinkedList.get(i));
        
            System.out.println("ListSize:"+myIntLinkedList.size());
            
            System.out.println("mySecondList:");
            for(int i = 0 ; i < mySecondIntList.size() ; ++i) 
                System.out.println(mySecondIntList.get(i));
        
            System.out.println("ListSize:"+mySecondIntList.size());
            // removeAll testing
            System.out.println("\nRemove All Method Testing");
            
            myIntLinkedList.removeAll(mySecondIntList);
            System.out.println("GITLinkedList:");
            for(int i = 0 ; i < myIntLinkedList.size() ; ++i) 
                System.out.println(myIntLinkedList.get(i));
        
            System.out.println("ListSize:"+myIntLinkedList.size());
            
            System.out.println("mySecondList:");
            for(int i = 0 ; i < mySecondIntList.size() ; ++i) 
                System.out.println(mySecondIntList.get(i));
        
            System.out.println("ListSize:"+mySecondIntList.size());
            // retainAll testing
            System.out.println("\nRetain All Method Testing");
            System.out.println("\nAt first adding some variables to List");
            
            myIntLinkedList.addLast(6);
            myIntLinkedList.addLast(5);
            myIntLinkedList.addLast(3);
            myIntLinkedList.addLast(7);
            
            System.out.println("GITLinkedList:");
            for(int i = 0 ; i < myIntLinkedList.size() ; ++i) 
                System.out.println(myIntLinkedList.get(i));
        
            System.out.println("ListSize:"+myIntLinkedList.size());
            
            System.out.println("After retainAll method:");
            myIntLinkedList.retainAll(mySecondIntList);
            System.out.println("GITLinkedList:");
            for(int i = 0 ; i < myIntLinkedList.size() ; ++i) 
                System.out.println(myIntLinkedList.get(i));
        
            System.out.println("ListSize:"+myIntLinkedList.size());
            
            System.out.println("mySecondList:");
            for(int i = 0 ; i < mySecondIntList.size() ; ++i) 
                System.out.println(mySecondIntList.get(i));
        
            System.out.println("ListSize:"+mySecondIntList.size());
            
        }//end of GITLinkedList testing
   
    }  //End of main
    
} //End of MainClass
