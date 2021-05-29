package protocolsupport.api.chat.modifiers;

import java.net.MalformedURLException;
import java.net.URL;

import protocolsupport.utils.Utils;

public class ClickAction {

	private final Type type;
	private final String value;

	public ClickAction(Type action, String value) {
		this.type = action;
		this.value = value;
	}

	public ClickAction(URL url) {
		this.type = Type.OPEN_URL;
		this.value = url.toString();
	}

	public Type getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public URL getUrl() throws MalformedURLException {
		if (type == Type.OPEN_URL) {
			return new URL(value);
		}
		throw new IllegalStateException(type + " is not an " + Type.OPEN_URL);
	}

	@Override
	public ClickAction clone() {
		return new ClickAction(type, value);
	}

	@Override
	public String toString() {
		return Utils.toStringAllFields(this);
	}

	public enum Type {
		OPEN_URL, OPEN_FILE, RUN_COMMAND, SUGGEST_COMMAND, CHANGE_PAGE, COPY_TO_CLIPBOARD;
	}

}
