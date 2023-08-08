
//edited by donovan

public class Fee  {
	private String FeeType;
	private String DueDate;
	private int amount;
	
	public Fee(String feeType, String dueDate, int amount) {
		this.FeeType = feeType;
		this.DueDate = dueDate;
		this.amount = amount;
	}

	public String getFeeType() {
		return FeeType;
	}

	public void setFeeType(String feeType) {
		FeeType = feeType;
	}

	public String getDueDate() {
		return DueDate;
	}

	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
		
	
	
} 