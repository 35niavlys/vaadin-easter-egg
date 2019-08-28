package org.vaadin.sylvainm;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.router.Route;

import elemental.events.KeyboardEvent.KeyCode;

@Route("")
public class View extends Div {

    public View() {
    	EasterEgg konamiEgg = new EasterEgg(
    			e -> Notification.show("konami", 2000, Position.MIDDLE)
    	);
    	EasterEgg vaadinEgg = new EasterEgg(
    			e -> Notification.show("vaadin", 2000, Position.MIDDLE),
    			KeyCode.V, KeyCode.A, KeyCode.A, KeyCode.D, KeyCode.I, KeyCode.N
    	);
    	add(new Button("add konami", e -> UI.getCurrent().add(konamiEgg)));
    	add(new Button("remove konami", e -> UI.getCurrent().remove(konamiEgg)));
    	add(new Button("add vaadin", e -> UI.getCurrent().add(vaadinEgg)));
    	add(new Button("remove vaadin", e -> UI.getCurrent().remove(vaadinEgg)));
    }
}
