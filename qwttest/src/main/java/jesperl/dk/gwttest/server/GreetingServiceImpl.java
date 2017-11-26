package jesperl.dk.gwttest.server;

import java.time.*;

import com.google.gwt.user.server.rpc.*;

import jesperl.dk.gwttest.client.*;
import jesperl.dk.gwttest.shared.*;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException("Name must be at least 4 characters long");
		}

//		Flowable.fromCallable(() -> {
//		    Thread.sleep(1000); //  imitate expensive computation
//		    return "Done";
//		})
////				.subscribeOn(Schedulers.io())
//		.repeat(5)
//		.parallel().runOn(Schedulers.computation())
//		.sequential()
////				.observeOn(Schedulers.single())
//				.subscribe(System.out::println, Throwable::printStackTrace);

//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);
		
		Model model = new Model();
		model.a = 1; model.setB(2); model.setLocalTime(LocalTime.of(10, 12));

		return "Hello, " + input + "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are using:<br>"
				+ userAgent + " test"+model.a+" "+model.getB()+" "+model.getLocalTime();
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
}
