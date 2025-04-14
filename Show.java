
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
