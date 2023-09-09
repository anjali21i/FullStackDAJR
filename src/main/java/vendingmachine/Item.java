package vendingmachine;

public class Item extends Product{

	Long pNo;
	String pName;
	Long price;
	
	public Item() {
		super();
	}

	public Item(Long pNo, String pName, Long price) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.price = price;
	}

	public Long getpNo() {
		return pNo;
	}

	public void setpNo(Long pNo) {
		this.pNo = pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
}
