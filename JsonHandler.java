
import com.fasterxml.jackson.databind.ObjectMapper; 


public class JsonHandler { 

private  ObjectMapper  objectMapper = new ObjectMapper() ;  



 

public String   convertToJson( Object object ) {  

String jsonified = objectMapper.writeValueAsString(object); 

return jsonified ;   } 


public TasksObject 




 




   



}  
