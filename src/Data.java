
public class Data {
	private String name;
	private int quantity;
	public Data(String name, int quan)
	{
		this.name = name;
		this.quantity = quan;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setQuan(int quan)
	{
		this.quantity = quan;
	}
	public String getName()
	{
		return name;
	}
	public int getQuan()
	{
		return quantity;
	}
	public String toString()
	{
		return String.format("%s,%d\n", name, quantity);
	}
}
