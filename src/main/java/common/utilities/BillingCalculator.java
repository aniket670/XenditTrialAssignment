package common.utilities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import constants.Resource;
import pojo.BillingCsvPojo;

public class BillingCalculator {
	/* Virtual Account Aggregator */
	public Map<String, String> processVaaCsvFile(List<BillingCsvPojo> combinedList) {

		// Product list - VAA
		List<BillingCsvPojo> filteredListVAA = combinedList.stream()
				.filter(trx -> trx.getPayment_method().equalsIgnoreCase("VIRTUAL_ACCOUNT_AGGREGATOR")
						&& trx.getStatus().equals("COMPLETED"))
				.collect(Collectors.toList());
		return vaaCalculator(filteredListVAA);
	}

	/* Ewallet */
	public Map<String, String> processEwCsvFile(List<BillingCsvPojo> combinedList) {
		// Product list - EW
		List<BillingCsvPojo> filteredListEW = combinedList.stream()
				.filter(trx -> trx.getPayment_method().equalsIgnoreCase("EWALLET")
						&& (trx.getType().equalsIgnoreCase("DIRECT_EWALLET_SETTLEMENT")
								|| trx.getType().equalsIgnoreCase("INCOMING_PAYMENT"))
						&& trx.getStatus().equals("COMPLETED"))
				.collect(Collectors.toList());
		return ewCalculator(filteredListEW);
	}
	
	private Map<String, String> ewCalculator(List<BillingCsvPojo> filteredListEW) {
		// 1. Count
		long countEW = filteredListEW.stream().count();
		// 2. Rate
		float ewRates = 0.015f;
		// 3. Volume of transactions
		Double sumEW = filteredListEW.stream().map(BillingCsvPojo::getAmount).reduce((double) 0, Double::sum);
		String ewVolume = BigDecimal.valueOf(sumEW).toPlainString();
		// 4.Billed Amount = Unit Price * Volume
		double billedAmountTotalEW = sumEW * ewRates;
		String ewBilledAmount = new BigDecimal(Math.round(billedAmountTotalEW)).toPlainString();

		Map<String, String> ewResult = new HashMap<>();
		ewResult.put("count", String.valueOf(countEW));
		ewResult.put("rate", String.valueOf(ewRates));
		ewResult.put("ewVolume", ewVolume);
		ewResult.put("ewBilledAmount", ewBilledAmount);

		return ewResult;
	}

	
	private Map<String, String> vaaCalculator(List<BillingCsvPojo> filteredListVAA) {
		// 1. Count
		long countVAA = filteredListVAA.stream().count();
		// 2. Rate
		int vaaRates = 3000;
		// 3. Volume of transactions
		Double sumVAA = filteredListVAA.stream().map(x -> x.getAmount()).reduce((double) 0, Double::sum);
		String vaaVolume = BigDecimal.valueOf(sumVAA).toPlainString();
		
		// 4. Billed amount (Unit price * Count)
		Set<String> paymentChannelsVAA;
		paymentChannelsVAA = filteredListVAA.stream().map(x -> x.getPayment_channel()).collect(Collectors.toSet());

		double billedAmountTotal = 0;
		for (String paymentChannel : paymentChannelsVAA) {
			int count = 0;
			double billedAmount = 0;
			for (BillingCsvPojo obj : filteredListVAA) {
				if (paymentChannel.equalsIgnoreCase(obj.getPayment_channel())) {
					count++;
				}
			}
			if (count <= 5000)
				billedAmount = count * vaaRates;
			else if (count <= 10000)
				billedAmount = count * vaaRates;
			else
				billedAmount = count * vaaRates;

			billedAmountTotal = billedAmountTotal + billedAmount;
		}
		String vaaBilledAmount = BigDecimal.valueOf(billedAmountTotal).toPlainString();

		Map<String, String> vaaResult = new HashMap<>();
		vaaResult.put("count", String.valueOf(countVAA));
		vaaResult.put("rate", String.valueOf(vaaRates));
		vaaResult.put("vaaVolume", vaaVolume);
		vaaResult.put("vaaBilledAmount", vaaBilledAmount);
		
		return vaaResult;
	
	}
	
	public Map<String, String> getAggregate(List<BillingCsvPojo> combinedList) {
		String billedAmtVaa = processVaaCsvFile(combinedList).get("vaaBilledAmount");
		String billedAmtEw = processEwCsvFile(combinedList).get("ewBilledAmount");
		
		double subTotal = Double.parseDouble(billedAmtVaa) + Double.parseDouble(billedAmtEw);
		String subTotalFinal = BigDecimal.valueOf(subTotal).toPlainString();
		double vatAmt = subTotal * (Resource.VAT_RATE/100); 
		String vatAmtFinal = BigDecimal.valueOf(vatAmt).toPlainString();
				
		Map<String, String> aggResult = new HashMap<>();
		aggResult.put("subtotal", String.valueOf(subTotalFinal));
		aggResult.put("vat", String.valueOf(vatAmtFinal));
		aggResult.put("total", BigDecimal.valueOf(subTotal+vatAmt).toPlainString());
		return aggResult;
		
	}
}
