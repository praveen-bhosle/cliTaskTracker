
enum Status {  
 DONE ,  
 NOT_STARTED ,  
 IN_PROGRESS 
} 

public  class Task {  

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
