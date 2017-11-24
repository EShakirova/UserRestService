package swagger;

import io.swagger.jaxrs.config.BeanConfig;
import servece.UserRestService;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class SampleApplication extends Application {

    public SampleApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8082");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage(UserRestService.class.getPackage().getName());
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;
    }
}
