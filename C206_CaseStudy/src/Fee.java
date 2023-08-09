import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

//edited by donovan

public class Fee  {
	private String FeeID;
	private String FeeType;
	private String DueDate;
	private double amount;
	private List<Fee> Feelist;
	
	public Fee(String feeID, String feeType, String dueDate, double amount) {
		this.FeeID = feeID;
		this.FeeType = feeType;
		this.DueDate = dueDate;
		this.amount = amount;
	}

	public List<Fee> getFeelist() {
		return Feelist;
	}

	public void setFeelist(List<Fee> feelist) {
		Feelist = feelist;
	}

	public String getFeeID() {
		return FeeID;
	}

	public void setFeeID(String feeID) {
		FeeID = feeID;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
		
	
	
} 