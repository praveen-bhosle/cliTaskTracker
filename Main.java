import java.io.* ;
import com.fasterxml.jackson.databind.ObjectMapper ;  
import java.util.* ; 

enum Status {  
 DONE ,  
 NOT_STARTED ,  
 IN_PROGRESS 
} 


 class Task {  
 public  int id ; 
 public   String title ;  
 public   Status status ; 

 public Task() { }   
 public Task(int  id , String title , Status status ) {  
  this.id = id  ; 
  this.title = title ; 
  this.status = status ; 
 }   
}

 class  TasksObject {  
  public ArrayList<Task>  tasks ; 
  public TasksObject() {  
   this.tasks = new  ArrayList<Task>() ;  
  } 
} 

class Main {  
 public static void  main(String[] args)   {   

 if(args.length == 0 ) {  
 System.out.println("Please provide a command");
 return ;
 } 
     
 String command = args[0] ; 

 String filename = "tasks.json" ;  

 File fileObj = new File(filename) ; 

 
 ObjectMapper  objectMapper = new ObjectMapper() ;  
 
 TasksObject tasksObject = new TasksObject()   ; 

 int start  = 0  ; 

 ArrayList<Task> tasks = new ArrayList<Task>() ;  

 if(fileObj.exists() ) {  
  
  try { 
 
  tasksObject = objectMapper.readValue( fileObj  ,  TasksObject.class ) ;  

	 int lastIndex  = tasksObject.tasks.size() - 1  ;    
  if (lastIndex >= 0 )   {
	 start = tasksObject.tasks.get(lastIndex).id ; } 

	 tasks.addAll( tasksObject.tasks  ) ;  
    

	 } 

	 catch(Exception e) {   
    System.out.println("Error reading the file") ; 
    e.printStackTrace() ; 
	 } 

 }  


 if( command.equals("setup")  ) { 

	
	 if(fileObj.exists() ) {  
		 System.out.println("Setup is already done.") ; 
	 }     
	 else  {  
  System.out.println("setting up things" ) ; 

		 try { 
			 fileObj.createNewFile() ; 

			 FileWriter fileWriterObj = new FileWriter(filename) ; 

			 String initial = "{\"tasks\":[]}" ; 


			 fileWriterObj.write( initial ) ; 

			 fileWriterObj.close() ; 
             System.out.println("Setup done successfully") ; 
			 } 

		 catch(Exception e   ) {  
			 System.out.println("an error occured: " + e.getMessage() ) ; 
			 e.printStackTrace() ; 
		 } 
	 } 
 } 

 else if ( command.equals("add") ) {   

	 for ( int  i = 1 ; i<args.length ; i++) {     
		 Task newTask =  new Task( i+start  , args[i] , Status.NOT_STARTED ) ;   
		 tasks.add(newTask);   
	 }  

     
	 tasksObject.tasks.clear() ; 

	 tasksObject.tasks.addAll(tasks); 


	
	 try { 
         String jsonified = objectMapper.writeValueAsString(tasksObject)  ;  

		 FileWriter fileWriter = new FileWriter( filename  )  ;  

		 fileWriter.write(jsonified) ; 

		 fileWriter.close() ; 
          System.out.println("Tasks added successfully") ;  
		 } 

	 catch(Exception e ) {  
		 System.out.println("Some error occured") ; 
		 e.printStackTrace() ; 
	 } 
 } 
  
 else if( command.equals("show"))  {    

if(args.length == 1 ) { 

 System.out.printf("%-10s %-10s %-10s%n" , "Id" ,  "Task" ,  "Status" ) ; 

 for( Task task : tasks ) {   
    
	System.out.printf("%-10d %-10s %-10s%n" ,  task.id ,  task.title  ,  task.status ) ;  

 }    } 

else  if(args.length == 2 ) {  

String flag = args[1] ;  

  ArrayList<Task> currTasks = (ArrayList)  tasks.clone() ;  



    
   if (flag.equals("completed")) { 
  
   currTasks.removeIf( task ->   task.status != Status.DONE ) ;  

     if(currTasks.size() == 0 ) {  
   System.out.println("No tasks completed yet") ; 
   return ; 
	 } 
    
	System.out.printf("%-10s %-10s%n" ,  "Id" ,  "Task"  )  ;  

	for(Task task:currTasks) {  
     
           System.out.printf("%-10d %-10s%n"  ,  task.id , task.title   ) ; 
	}  

  }  

  
 else if(flag.equals("not_started") ) {   

    currTasks.removeIf(  task -> task.status != Status.NOT_STARTED   ) ;  

   if(currTasks.size() == 0 )  {  
     System.out.println("All the tasks have been started") ;  
	 return ; 
	} 
    
	System.out.printf("%-10s %-10s%n" ,  "Id" ,  "Task"  )  ; 


	for(Task task:currTasks) {       
	           System.out.printf("%-10d %-10s%n"  ,  task.id , task.title  ) ; 
	}  
 } 

 else if(flag.equals("in_progress") ) {  
    
   currTasks.removeIf(  task -> task.status != Status.IN_PROGRESS  ) ;  

   if(currTasks.size() == 0 )  {  
     System.out.println("No task in progress.") ;  
	 return ; 
	} 

	System.out.printf("%-10s %-10s%n" ,  "Id" ,  "Task"  )  ; 

	for(Task task:currTasks) {  
       System.out.printf("%-10d %-10s%n"  ,  task.id , task.title  ) ; 

	 } 
	} 
else  {  
System.out.println("invalid flag passed") ;
} 
 
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

