package common.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import io.restassured.path.json.JsonPath;
public class Payload {
	//public static String billingPayload() {
	/*
	 * return "{\r\n" + "  \"ppn_amount\": 63397833,\r\n" +
	 * "  \"subtotal_fees_amount\": 633978332,\r\n" +
	 * "  \"total_fees_amount\": 653113450,\r\n" +
	 * "  \"total_transactions_count\": 222601,\r\n" +
	 * "  \"total_transactions_amount\": 233816858689,\r\n" +
	 * "  \"ewallet_payments_count\": 3242,\r\n" +
	 * "  \"ewallet_payments_total\": 2682588846,\r\n" +
	 * "  \"ewallet_payments_fees_amount\": 40238832,\r\n" +
	 * "  \"ewallet_payments_fees_paid_amount\": 44259681,\r\n" +
	 * "  \"ewallet_payments_stats\": [\r\n" + "    {\r\n" +
	 * "      \"fee\": 40238832,\r\n" + "      \"vat\": 4023883,\r\n" +
	 * "      \"count\": 3242,\r\n" + "      \"amount\": 2682588846,\r\n" +
	 * "      \"percentage_rate\": 0.015,\r\n" +
	 * "      \"payment_channel\": \"OVO\"\r\n" + "    }\r\n" + "  ],\r\n" +
	 * "  \"ewallet_rates\": [\r\n" + "    {\r\n" +
	 * "      \"ewallet_type\": \"OVO\",\r\n" +
	 * "      \"ewallet_charge_type\": \"PERCENTAGE\",\r\n" +
	 * "      \"ewallet_fee\": 0.015\r\n" + "    }\r\n" + "  ],\r\n" +
	 * "  \"virtual_account_payments_count\": 50672,\r\n" +
	 * "  \"virtual_account_payments_total\": 61481527224,\r\n" +
	 * "  \"virtual_account_rates\": [\r\n" + "    {\r\n" +
	 * "      \"tier_1_fee\": 3000,\r\n" + "      \"tier_2_fee\": 3000,\r\n" +
	 * "      \"tier_1_end\": 5000,\r\n" + "      \"tier_2_end\": 10000,\r\n" +
	 * "      \"deduction_type\": \"INDIRECT\",\r\n" +
	 * "      \"tier_3_fee\": 3000\r\n" + "    }\r\n" + "  ],\r\n" +
	 * "  \"virtual_account_payments_fees_amount\": 102053000,\r\n" +
	 * "  \"virtual_account_payments_fees_paid_amount\": 0\r\n" + "}"; }
	 */
	
	public String readJson(String key) throws IOException {
		JsonPath js = new JsonPath(new String(Files.readAllBytes(Path.of("src\\test\\resources\\testdata\\ResponsePayload.json"))));
		return  js.getString(key);
	}

	/*
	 * public static void main(String[] args) { Payload p = new Payload();
	 * System.out.println(p.readJson("virtual_account_rates[0].tier_3_fee"));
	 * 
	 * }
	 */
	
	}
