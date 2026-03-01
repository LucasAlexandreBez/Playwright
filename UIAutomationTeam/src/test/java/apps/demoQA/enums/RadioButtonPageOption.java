package apps.demoQA.enums;

public enum RadioButtonPageOption {
    YES("Yes", "yesRadio"),
    IMPRESSIVE("Impressive", "impressiveRadio"),
 	NO("No", "noRadio");

    public final String label;
    public final String id;

    RadioButtonPageOption(String label, String id) {
        this.label = label;
        this.id = id;
    }
    
    public String getLabel() {
		return label;
	}
    
    public String getId() {
		return id;
	}
}
