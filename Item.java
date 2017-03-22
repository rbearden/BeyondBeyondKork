package commands;

import java.util.ArrayList;

public class Item
{	// --------------------------------------------- Data Fields
	protected String itemName;
	protected String altItemName;
	protected String description;
	protected Location location;
	
	// Item actionList
	protected ArrayList<Action> actionList = new ArrayList<>();
	protected int mass;
	
	// -------------------------------------------- Constructors
	public Item(String itemName, Location location, int mass)
	{	this.itemName = itemName;
		this.mass = mass;
	}
	
	public Item(String itemName, Location location, int mass, String description)
	{	this(itemName, location, mass);
		this.description = description;
	}
	
	public Item(String itemName, String altItemName, Location location, int mass)
	{	this(itemName, location, mass);
		this.altItemName  = altItemName;
	}
	
	public Item(String itemName, String altItemName, Location location, int mass, String description)
	{	this(itemName, location, mass, description);
		this.altItemName = altItemName;
	}
	
	// -------------------------------------------- Getter & Setters
	public void setName(String itemName)
	{	this.itemName = itemName;		
	}
	
	public void setName(String itemName, String altItemName)
	{	setName(itemName);
		this.altItemName = altItemName;
	}
	
	public String getName()
	{	return this.itemName;
	}
	
	public String getAltName()
	{	return this.altItemName;		
	}
	
	public void setDescription(String description)
	{	this.description = description;		
	}
	
	public String getDescription()
	{	return this.description;		
	}
	
	public void setMass(int mass)
	{	this.mass = mass;
	}
	
	public int getMass()
	{	return this.mass;
	}
	
	// -------------------------------------------- Other Methods
	// Add a property to an item
	public void addAction(Action c)
	{	if(this.hasAction(c) == false)
			actionList.add(c);		
	}
	
	// Remove an existing property
	public void removeAction(Action c)
	{	if(this.hasAction(c) == true)
			actionList.remove(c);		
	}
	
	// Determine whether item has a property
	public boolean hasAction(Action c)
	{	boolean itemhasAction = false;
		if(actionList.contains(c))
			itemhasAction = true;
		return itemhasAction;
	}
	
	// Retrieve the item's current location
	public Object getLocation()
	{	Object location;
		
		// Assign location to correct location type
		if(this.location.getLocation() instanceof Room)
			location = (Room)this.location.getLocation();
		else
			location = (Container)this.location.getLocation();
		
		return location;
	}
	
	// Change the item's current location
	public boolean setLocation(Object newLocation) throws InvalidSetValueException
	{	boolean setSuccessful = false;
	
		// Remove item from previous location
		if(this.location.isRoom())
		{	this.location.getRoom().removeItem(this);
		
		}
		else if(this.location.isContainer())
		{	this.location.getContainer().removeItem(this);
			
		}
		
		// Add item to new location
		if(((Location)newLocation).isRoom())
		{	((Location)newLocation).getRoom().addItem(this);
			
		}
		else if(((Location)newLocation).isContainer())
		{	((Location)newLocation).getContainer().addItem(this);
			
		}
	
		return setSuccessful;
	}
	
} // end Item
