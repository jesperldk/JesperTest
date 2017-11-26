package jesperl.dk.gwttest.client;

import static javax.ws.rs.HttpMethod.GET;
import static javax.ws.rs.HttpMethod.POST;
import static javax.ws.rs.HttpMethod.PUT;

import com.google.gwt.core.shared.GwtIncompatible;
import com.intendia.gwt.autorest.client.Dispatcher;
import com.intendia.gwt.autorest.client.Resource;
import com.intendia.gwt.autorest.client.RestServiceProxy;
import java.lang.Override;
import java.lang.String;
import java.lang.UnsupportedOperationException;
import java.lang.Void;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import rx.Observable;

public class ObservableService_RestServiceProxy extends RestServiceProxy implements ObservableService {
  public ObservableService_RestServiceProxy(Resource resource, Dispatcher dispatcher) {
    super(resource, dispatcher, "observable");
  }

  @Override
  @PUT
  public Observable<Void> ping() {
    return resolve().method(PUT).observe(dispatcher());
  }

  @Override
  @GET
  public Observable<Greeting> get() {
    return resolve().method(GET).observe(dispatcher());
  }

  @Override
  @POST
  public Observable<Greeting> post(Greeting name) {
    return resolve().method(POST).data(name).observe(dispatcher());
  }

  @Override
  @Path("foo")
  @GET
  public Observable<Greeting> getFoo() {
    return resolve("foo").method(GET).observe(dispatcher());
  }

  @Override
  @Path("foo/{foo}")
  @GET
  public Observable<Greeting> getFoo(@PathParam("foo") String foo, @QueryParam("bar") String bar, @QueryParam("unk") String oth) {
    return resolve("foo", foo).param("bar", bar).param("unk", oth).method(GET).observe(dispatcher());
  }

  @Override
  @GwtIncompatible
  public Response gwtIncompatible() {
    throw new UnsupportedOperationException("gwtIncompatible");
  }

  @Override
  @com.google.common.annotations.GwtIncompatible("serverOnly")
  public Response guavaIncompatible() {
    throw new UnsupportedOperationException("guavaIncompatible");
  }
}
