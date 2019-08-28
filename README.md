# EasterEgg

Vaadin 14 Java integration of easter-eggs

## Getting started

```
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
```

## Development instructions

Starting the test/demo server:
1. Run `mvn jetty:run`.
2. Open http://localhost:8080 in the browser.

## Publishing to Vaadin Directory

You can create the zip package needed for [Vaadin Directory](https://vaadin.com/directory/) using
```
mvn versions:set -DnewVersion=1.0.0 # You cannot publish snapshot versions 
mvn install -Pdirectory
```

The package is created as `target/easter-eggs-1.0.0.zip`

For more information or to upload the package, visit https://vaadin.com/directory/my-components?uploadNewComponent
