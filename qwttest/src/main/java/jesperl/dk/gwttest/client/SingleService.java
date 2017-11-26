package jesperl.dk.gwttest.client;

import com.intendia.gwt.autorest.client.AutoRestGwt;
import com.intendia.gwt.autorest.client.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import rx.Single;

@AutoRestGwt
@Path("single")
public interface SingleService { 

    @PUT Single<Void> ping();

    @GET Single<Greeting> get();

    @POST Single<Greeting> put(Greeting name);

    @com.google.gwt.core.shared.GwtIncompatible Response gwtIncompatible();

    @com.google.common.annotations.GwtIncompatible("serverOnly") Response guavaIncompatible();

    class Factory {
        public static SingleService create(Resource parent) {
            return new SingleService_RestServiceProxy(parent, rb -> {
                rb.setHeader("mode", "single");
                return rb.send();
            });
        }
    }
}
