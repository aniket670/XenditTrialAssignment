package pojo;

import java.util.ArrayList;

public class BillingProcess {
	
	private int ppn_amount;
	private int subtotal_fees_amount;
	private int total_fees_amount;
	private int total_transactions_count;
	
	private long total_transactions_amount;
	private int ewallet_payments_count;
	private long ewallet_payments_total;
	private int ewallet_payments_fees_amount;
	private int ewallet_payments_fees_paid_amount;
	private ArrayList<EwalletPaymentsStat> ewallet_payments_stats;
	private ArrayList<EwalletRate> ewallet_rates;
	private int virtual_account_payments_count;
	private long virtual_account_payments_total;
	private ArrayList<VirtualAccountRate> virtual_account_rates;
	private int virtual_account_payments_fees_amount;
	private int virtual_account_payments_fees_paid_amount;
	
	public int getPpn_amount() {
		return ppn_amount;
	}
	public void setPpn_amount(int ppn_amount) {
		this.ppn_amount = ppn_amount;
	}
	public int getSubtotal_fees_amount() {
		return subtotal_fees_amount;
	}
	public void setSubtotal_fees_amount(int subtotal_fees_amount) {
		this.subtotal_fees_amount = subtotal_fees_amount;
	}
	public int getTotal_fees_amount() {
		return total_fees_amount;
	}
	public void setTotal_fees_amount(int total_fees_amount) {
		this.total_fees_amount = total_fees_amount;
	}
	public int getTotal_transactions_count() {
		return total_transactions_count;
	}
	public void setTotal_transactions_count(int total_transactions_count) {
		this.total_transactions_count = total_transactions_count;
	}
	public long getTotal_transactions_amount() {
		return total_transactions_amount;
	}
	public void setTotal_transactions_amount(long total_transactions_amount) {
		this.total_transactions_amount = total_transactions_amount;
	}
	public int getEwallet_payments_count() {
		return ewallet_payments_count;
	}
	public void setEwallet_payments_count(int ewallet_payments_count) {
		this.ewallet_payments_count = ewallet_payments_count;
	}
	public long getEwallet_payments_total() {
		return ewallet_payments_total;
	}
	public void setEwallet_payments_total(long ewallet_payments_total) {
		this.ewallet_payments_total = ewallet_payments_total;
	}
	public int getEwallet_payments_fees_amount() {
		return ewallet_payments_fees_amount;
	}
	public void setEwallet_payments_fees_amount(int ewallet_payments_fees_amount) {
		this.ewallet_payments_fees_amount = ewallet_payments_fees_amount;
	}
	public int getEwallet_payments_fees_paid_amount() {
		return ewallet_payments_fees_paid_amount;
	}
	public void setEwallet_payments_fees_paid_amount(int ewallet_payments_fees_paid_amount) {
		this.ewallet_payments_fees_paid_amount = ewallet_payments_fees_paid_amount;
	}
	public ArrayList<EwalletPaymentsStat> getEwallet_payments_stats() {
		return ewallet_payments_stats;
	}
	public void setEwallet_payments_stats(ArrayList<EwalletPaymentsStat> ewallet_payments_stats) {
		this.ewallet_payments_stats = ewallet_payments_stats;
	}
	public ArrayList<EwalletRate> getEwallet_rates() {
		return ewallet_rates;
	}
	public void setEwallet_rates(ArrayList<EwalletRate> ewallet_rates) {
		this.ewallet_rates = ewallet_rates;
	}
	public int getVirtual_account_payments_count() {
		return virtual_account_payments_count;
	}
	public void setVirtual_account_payments_count(int virtual_account_payments_count) {
		this.virtual_account_payments_count = virtual_account_payments_count;
	}
	public long getVirtual_account_payments_total() {
		return virtual_account_payments_total;
	}
	public void setVirtual_account_payments_total(long virtual_account_payments_total) {
		this.virtual_account_payments_total = virtual_account_payments_total;
	}
	public ArrayList<VirtualAccountRate> getVirtual_account_rates() {
		return virtual_account_rates;
	}
	public void setVirtual_account_rates(ArrayList<VirtualAccountRate> virtual_account_rates) {
		this.virtual_account_rates = virtual_account_rates;
	}
	public int getVirtual_account_payments_fees_amount() {
		return virtual_account_payments_fees_amount;
	}
	public void setVirtual_account_payments_fees_amount(int virtual_account_payments_fees_amount) {
		this.virtual_account_payments_fees_amount = virtual_account_payments_fees_amount;
	}
	public int getVirtual_account_payments_fees_paid_amount() {
		return virtual_account_payments_fees_paid_amount;
	}
	public void setVirtual_account_payments_fees_paid_amount(int virtual_account_payments_fees_paid_amount) {
		this.virtual_account_payments_fees_paid_amount = virtual_account_payments_fees_paid_amount;
	}
	

}
