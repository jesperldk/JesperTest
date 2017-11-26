package jesperl.dk.gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.intendia.gwt.autorest.client.Resource;
import rx.functions.Action1;

public class ExampleEntryPoint implements EntryPoint {
    private Action1<Throwable> err = e -> GWT.log("exception: " + e, e);

    public void onModuleLoad() {
        Resource root = new Resource(GWT.getModuleBaseURL()).resolve("api");

        final ObservableService oService = ObservableService.Factory.create(root);
        final SingleService sService = SingleService.Factory.create(root);

        append("Name:");
        final TextBox nameInput = new TextBox();
        RootPanel.get().add(nameInput);
        nameInput.addValueChangeHandler(e -> getCustomGreeting(oService, nameInput.getValue()));
        nameInput.setValue("ping", true);

        oService.ping().subscribe(n -> append("observable pong"), err);
        sService.ping().subscribe(n -> append("single pong"), err);

        oService.getFoo().subscribe(n -> append("observable.foo response: " + n.getGreeting()), err);
        oService.getFoo("FOO", "BAR", null).subscribe(n -> append("observable.foo response: " + n.getGreeting()), err);
    }

    private void getCustomGreeting(ObservableService service, String name) {
        Greeting greeting = JavaScriptObject.createObject().cast();
        greeting.setGreeting(name);
        service.post(greeting).subscribe(r -> append("server said " + r.getGreeting()), err);
    }

    private static void append(String text) {
        RootPanel.get().add(new Label(text));
    }
}
