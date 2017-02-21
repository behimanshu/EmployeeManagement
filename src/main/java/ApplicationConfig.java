import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("webapi")
public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig()
	{
	packages("org.freedom.activity.EmployeeManagement.resources;org.freedom.activity.EmployeeManagement.exception");
	}
}
