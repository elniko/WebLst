package test;

import java.util.List;





import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ubpartner.dto.GuidDto;
import com.ubpartner.service.IGuidService;

public class Test {

	public static void main(String[] args) {
		
		
		
		 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	       IGuidService service = (IGuidService) ctx.getBean("guidService");
	       
	     //  List<Guid> guids = service.getAllGuids();
	       
	       GuidDto g = service.getById("00876ed1-288f-42c5-8ba5-8f0231f464bc", "xct", "1.5.4");
	       
	       if(g == null) {
	    	   
	    	   System.out.println("NULL");
	       }
int i = 0;

	}

}
