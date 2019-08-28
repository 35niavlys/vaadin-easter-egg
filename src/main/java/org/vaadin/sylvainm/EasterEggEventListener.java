package org.vaadin.sylvainm;

import java.io.Serializable;
import java.util.EventListener;

@FunctionalInterface
public interface EasterEggEventListener extends EventListener, Serializable {
	void onEasterEggCode(EasterEgg easterEgg);
}