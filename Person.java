package commands;

public class Person extends Container
{	// --------------------------------------------------- Data Fields
	private int health;    // Range 0 - 100
	
	
	// --------------------------------------------------- Constructor
	public Person(String name, Location location, int maxMass, int mass)
	{	super(name, location, maxMass, mass);
		this.health = 100;
	}
	
	@Override
	public Location getLocation()
	{	return super.getLocation();	
	}
	
	
}
