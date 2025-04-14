
import com.fasterxml.jackson.databind.ObjectMapper; 


public class JsonHandler { 

private  ObjectMapper  objectMapper ; 
 
public JsonHandler() {  
 objectMapper = new ObjectMapper() ; 
} 


public String   convertToJson( Object object ) {  
String jsonified = objectMapper.writeValueAsString(object); 
return jsonified ;
} 

public TasksObject mapFileToObject(File file) {  
try { 
  
	TasksObject tasks = objectMapper.readValue( file ,  TasksObject.class) ; 
    return  tasks ; 
	 } 
catch(Exception e) {   
 System.out.println("An error occured while mapping the file to the object") ; 
}  
} 

}  
