public class  Main2 {  
  
  protected  String filename ;
  protected  FileHandler fileHandler ; 


  public Main2(String filename) {  
  this.filename= filename ; 
  fileHandler = new FileHandler(filename) ; 
  } 

} 
