
public abstract class Player {
	private String nameString;
	
	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		if(nameString != CardGameSystem.CPU_NAME) {
			this.nameString = nameString;
		}
	}
}
