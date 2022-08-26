package pojo;

public class EwalletPaymentsStat {

	private int fee;
	private int vat;
	private int count;
	private long amount;
	private double percentage_rate;
	private String payment_channel;
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public double getPercentage_rate() {
		return percentage_rate;
	}
	public void setPercentage_rate(double percentage_rate) {
		this.percentage_rate = percentage_rate;
	}
	public String getPayment_channel() {
		return payment_channel;
	}
	public void setPayment_channel(String payment_channel) {
		this.payment_channel = payment_channel;
	}
	
	

}
