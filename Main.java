import java.io.* ;
import java.util.* ; 



class Main {  

 public static void  main(String[] args)   {   

    if(args.length == 0 ) {  
       System.out.println("Please provide a command");
       return ;
    } 
     

    String command = args[0] ; 

    String filename = "tasks.json" ;  

    TasksObject tasksObject = new TasksObject()   ; 

    Main2 main2 = new Main2(filename); 

 if( command.equals("setup")  ) { 
 Status  status  =  SetUp.start() ;  
} 

 else if ( command.equals("add") ) {    
 
 String title = args[1] ; 

 Task task  = new Task(id,title,Status.NOT_DONE); 

 taskObject.add(task) ; 


	
 } 
  
 else if( command.equals("show"))  {    

 
} 

	else  {  
  System.out.println("invalid number of  arguments passed.") ; 
	} 
 } 


 else if( command.equals("edit") )  {    

 }  
 
 else if(command.equals("delete")) {  

  


 } 






 }   
} 

