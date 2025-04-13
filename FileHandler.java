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
 


} 




public String   createFile() {   
try { 
  if(file.createNewFile()) {  
  String msg = "File created "; 
  return  msg ; 
  } 
  else {   
   String msg = "File already exists. "; 
  return  msg ; 
  } 
 } 
 catch(IOException e) {  
   String msg = "Error occured while creating the file" ; 
   return  msg ; 
  } 
 }

  public File  getFileObject() {  
       return  file ;  
 } 

 public String editFile( String content) {  
   
  try { 

 
   fileWriter.write(content) ; 

   myWriter.close() ; 
   String msg = "File edited." 
   return  msg ; 
  } 

  catch(IOException e) { 
   String msg = "Error occured while editing the file" 
   return  msg ;     
  } 
 } 

}

