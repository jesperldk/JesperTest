package jesperl.dk.gwttest.client;

import static javax.ws.rs.HttpMethod.GET;
import static javax.ws.rs.HttpMethod.POST;
import static javax.ws.rs.HttpMethod.PUT;

import com.google.gwt.core.shared.GwtIncompatible;
import com.intendia.gwt.autorest.client.Dispatcher;
import com.intendia.gwt.autorest.client.Resource;
import com.intendia.gwt.autorest.client.RestServiceProxy;
import java.lang.Override;
import java.lang.UnsupportedOperationException;
import java.lang.Void;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import rx.Single;

public class SingleService_RestServiceProxy extends RestServiceProxy implements SingleService {
  public SingleService_RestServiceProxy(Resource resource, Dispatcher dispatcher) {
    super(resource, dispatcher, "single");
  }

  @Override
  @PUT
  public Single<Void> ping() {
    return resolve().method(PUT).single(dispatcher());
  }

  @Override
  @GET
  public Single<Greeting> get() {
    return resolve().method(GET).single(dispatcher());
  }

  @Override
  @POST
  public Single<Greeting> put(Greeting name) {
    return resolve().method(POST).data(name).single(dispatcher());
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
