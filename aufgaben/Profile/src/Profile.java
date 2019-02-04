
public class Profile {
	String name;
	String color;
	String sport;
	
	public void setName(String userName) {
		this.name=userName;
	}
	
	public void setColor(String userColor) {
		this.color=userColor;
	}
	
	public void setSport(String userSport) {
		this.sport=userSport;
	}
	
	public String getName() {
		return this.name;
	}

	public String getColor( ) {
		return this.color;
	}
	
	public String getSport() {
		return this.sport;
	}
}
