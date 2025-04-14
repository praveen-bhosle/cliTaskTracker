// this class will take read the file.

import java.util.io.File ;  
import java.util.io.FileWriter ;
import java.util.io.IOException ; 
import java.util.Scanner ; 



public class FileHandler {   
 
 private String filename ; 
 
 private File file ; 

 private FileWriter fileWriter ; 

 public  FileReaderWriter(String filename) { 
 this.filename = filename ; 
 
 file = new File(filename) ; 
 
 fileWriter = new FileWriter(filename) ; 

 } 


public boolean  checkFileExists() { 
if(file.isFile() ) {  
 return true ; 
} 
return false ;
} 




public Status createFile() {   
try { 
  if(file.createNewFile()) {  
  System.out.println("File created"); 
  return  Status.SUCCESS  ; 
  } 
  else {   
  System.out.println("File already exists.") ;  
  return Status.FAILURE ;  
  } 
 } 
 catch(IOException e) {  
   System.out.println("Error occured while creating the file") ;  
   return Success.FAILURE ; 
  } 
 }

 public File  getFileObject() {  
    return  file ;  
 } 

 public Status editFile( String content) {  
   
  try { 
   fileWriter.write(content) ; 
   String msg = "File edited." 
   return Status.SUCCESS ; 
  } 
  catch(IOException e) { 
   System.out.println("Error occured while editing the file") ; 

   return STATUS.FAILURE  ;     
  } 
 } 

}

