package org.vaadin.sylvainm;

import java.util.Arrays;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

/**
 * EasterEgg component watching the user's key strokes to trigger event 
 * &lt;p&gt;&lt;code&gt;UI.getCurrent().add(new EasterEgg(egg -&gt; System.out.println("konami")));&lt;/code&gt;&lt;/p&gt;
 */
@Tag("easter-egg")
@JsModule("./easter-egg.js")
public class EasterEgg extends Component {

	private static final int[] KONAMI = { 38, 38, 40, 40, 37, 39, 37, 39, 66, 65 };

	private final EasterEggEventListener listener;
	private final int[] keys;

	/**
	 * Creates a new easter-egg.
	 * 
	 * @param listener
	 *            the event listener
	 * @param keys
	 *            konami code is defined if not set
	 */
	public EasterEgg(EasterEggEventListener listener, int... keys) {
		this.listener = listener;
		this.keys = keys.length == 0 ? KONAMI : keys;

		this.getElement().setAttribute("style", "display: none");
	}

	@ClientCallable
	public void onEasterEggCode() {
		listener.onEasterEggCode(this);
	}

	/**
	 * Get the easter egg code
	 */
	public int[] getKeys() {
		return keys;
	}

	@Override
	protected void onAttach(AttachEvent attachEvent) {
		getElement().executeJs("EasterEggs.addSequence($0, " + Arrays.toString(keys)
				+ ", function() { $1.$server.onEasterEggCode(); })", hashCode(), getElement());
	}

	@Override
	protected void onDetach(DetachEvent detachEvent) {
		getElement().executeJs("EasterEggs.removeSequence($0)", hashCode());
	}

}