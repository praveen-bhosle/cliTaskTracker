import java.util.ArrayList ; 

public class TasksObject { 
   
private ArrayList<Task> tasks ;  

public TasksObject( )  { 
 this.tasks =  new ArrayList<Task>()   ; 
} 

public addTask( Task task   ) { 
 tasks.add(Task) ; 
} 

public removeTask(int id) {  
  for( Iterator<Task> it = tasks.iterator() ; it.hasNext() ) {  
  if(it.next().getId()  ===  id ) {  
   it.remove() ; 
  }  
  } 
} 

public editTask(int id ,  String title ,  TaskStatus status ) {  
  for ( task : tasks)  { 
	if(task.getId() === id) {  
	  task.edit(title,status) ;  
	} 
  } 
} 


public editTask(int id , TaskStatus status ) {  
  for ( task : tasks)  { 
	if(task.getId() === id) {  
	  String title = task.getTitle(); 
	  task.edit(title,status) ;  
	} 
  } 
} 


public editTask(int id ,  String title ) {  
  for ( task : tasks)  { 
	if(task.getId() === id) {  
	TaskStatus status  = task.getStatus() ; 
	  task.edit(title,status) ;  
	} 
  } 
} 

} 
