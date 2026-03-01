package apps.demoQA.enums;

public enum CheckboxPageTreeItems {
	    HOME("Home", "tree-node-home"),
	    DESKTOP("Desktop", "tree-node-desktop"),
	    NOTES("Notes", "tree-node-notes"),
	    COMMANDS("Commands", "tree-node-commands"),
	    DOCUMENTS("Documents", "tree-node-documents"),
	    WORKSPACE("WorkSpace", "tree-node-workspace"),
	    REACT("React", "tree-node-react"),
	    ANGULAR("Angular", "tree-node-angular"),
	    VEU("Veu", "tree-node-veu"),
	    OFFICE("Office", "tree-node-office"),
	    PUBLIC("Public", "tree-node-public"),
	    PRIVATE("Private", "tree-node-private"),
	    CLASSIFIED("Classified", "tree-node-classified"),
	    GENERAL("General", "tree-node-general"),
	    DOWNLOADS("Downloads", "tree-node-downloads"),
	    WORD("Word File.doc", "tree-node-wordFile"),
	 	EXCEL("Excel File.doc", "tree-node-excelFile");

	    public final String label;
	    public final String id;
	    
	    CheckboxPageTreeItems(String label, String id) {
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
