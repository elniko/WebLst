package test;

import java.util.List;




import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ubpartner.entity.Guid;
import com.ubpartner.service.IGuidService;

public class Test {

	public static void main(String[] args) {
		
		
		
		 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

	       IGuidService service = (IGuidService) ctx.getBean("guidService");
	       
	       List<Guid> guids = service.getAllGuids();
int i = 0;

	}

}
