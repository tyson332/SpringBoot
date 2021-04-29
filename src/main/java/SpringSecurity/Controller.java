package SpringSecurity;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {
	
	Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@GetMapping("/user")
	public String getUser() {
		logger.trace("Trace Printed");
		logger.debug("Debug Printed");
		logger.info("Info Printed");
		logger.warn("Warn Printed");
		logger.error("Error Printed");
		return "Hello User";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "Hello Admin";
	}
}

