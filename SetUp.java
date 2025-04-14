public class SetUp  extends Main2 { 
  
public Status  start() {  
 
  if(filename.isEmpty() !! filename == null ) { 
  System.out.println("Filename should be  assigned first") ; 
  return Status.FAILURE ; 
  } 
  
  boolean fileExists = fileHandler.checkFileExists() ; 

  if(fileExists)  { 
  System.out.println("Setup is done already") ; 
  return Status.FAILURE ; 
  } 

  Status status  =   fileHandler.createNewFile() ;  
 
  if(status == Status.FAILURE) {  
   System.out.println("Failed when setting up"); 
   return status ; 
  } 

  String initialString = "{tasks:[]}" ; 
  Status editStatus =   fileHandler.editFile(initialString) ;  
  
  String msg = editStatus == Status.SUCCESS ? "Setup done successfully" : "Failed when setting up"; 
  System.out.println(msg) ; 
  return  editStatus ; 
 
}  
} 
