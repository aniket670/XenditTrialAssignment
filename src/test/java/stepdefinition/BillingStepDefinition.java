package stepdefinition;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import common.utilities.BillingCalculator;
import common.utilities.CsvProcessing;
import common.utilities.Payload;
import io.cucumber.java.en.Given;
import pojo.BillingCsvPojo;

public class BillingStepDefinition {

	CsvProcessing csvProcessing = new CsvProcessing() ;
	BillingCalculator billingcalculator = new BillingCalculator() ;
	Payload payload =new Payload();
	List<BillingCsvPojo> combinedList;

	@Given("the user reads the CSV from the local")
	public void the_user_reads_the_CSV_from_the_local() {
		// Write code here that turns the phrase above into concrete actions
		csvProcessing.getCsvFiles();
		combinedList = csvProcessing.readCsvFiles();

	}

	@Given("the user verify the billed amount for VAA")
	public void the_user_verify_the_billed_amount_for_VAA() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(billingcalculator.processVaaCsvFile(combinedList).get("vaaBilledAmount"),
				payload.readJson("virtual_account_payments_fees_amount")
				);
	}

	@Given("the user verify the count for VAA")
	public void the_user_verify_the_count_for_VAA() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(billingcalculator.processVaaCsvFile(combinedList).get("count"),
				payload.readJson("virtual_account_payments_count"));
	}

	@Given("the user verify the rates for VAA")
	public void the_user_verify_the_rates_for_VAA() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(billingcalculator.processVaaCsvFile(combinedList).get("rate"),
				payload.readJson("virtual_account_rates[0].tier_3_fee")
				);
	}

	@Given("the user verify the volume for VAA")
	public void the_user_verify_the_volume_for_VAA() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(billingcalculator.processVaaCsvFile(combinedList).get("vaaVolume"),
				payload.readJson("virtual_account_payments_total")
				);
	}

	@Given("the user verify the billed amount for EW")
	public void the_user_verify_the_billed_amount_for_EW() throws IOException {
		Assert.assertEquals(billingcalculator.processEwCsvFile(combinedList).get("ewBilledAmount"),
				payload.readJson("ewallet_payments_fees_amount")
				);
	}

	@Given("the user verify the count for EW")
	public void the_user_verify_the_count_for_EW() throws IOException {
		Assert.assertEquals(billingcalculator.processEwCsvFile(combinedList).get("count"),
				payload.readJson("ewallet_payments_stats[0].count")
				);
	}

	@Given("the user verify the rates for EW")
	public void the_user_verify_the_rates_for_EW() throws IOException {
		Assert.assertEquals(billingcalculator.processEwCsvFile(combinedList).get("rate"),
				payload.readJson("ewallet_payments_stats[0].percentage_rate")
				);

	}

	@Given("the user verify the volume for EW")
	public void the_user_verify_the_volume_for_EW() throws IOException {
		Assert.assertEquals(billingcalculator.processEwCsvFile(combinedList).get("ewVolume"),
				payload.readJson("ewallet_payments_total")
				);
	}
	
	@Given("the user verify the subtotal value")
	public void the_user_verify_the_subtotal_value() throws IOException {
		Assert.assertEquals(billingcalculator.getAggregate(combinedList).get("subtotal"),
				payload.readJson("subtotal_fees_amount")
				);
	}
	
	@Given("the user verify the VAT value")
	public void the_user_verify_the_VAT_value() throws IOException {
		Assert.assertEquals(billingcalculator.getAggregate(combinedList).get("vat"),
				payload.readJson("ppn_amount")
				);
	}
	
	@Given("the user verify the total value")
	public void the_user_verify_the_total_value() throws IOException {
		Assert.assertEquals(billingcalculator.getAggregate(combinedList).get("total"),
				payload.readJson("total_fees_amount")
				);
	   
	}



}
