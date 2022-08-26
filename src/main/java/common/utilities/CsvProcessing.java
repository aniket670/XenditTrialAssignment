package common.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

import constants.Resource;
import pojo.BillingCsvPojo;

public class CsvProcessing {

	List<String> filenames = new LinkedList<>();

	public void getCsvFiles() {
		final File folder = new File(Resource.FOLDER_PATH);
		listFilesForFolder(folder);
	}

	public void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				if (fileEntry.getName().contains(".csv"))
					filenames.add(fileEntry.getAbsolutePath());
			}
		}
	}

	public List<BillingCsvPojo> readCsvFiles() {
		Map<String, String> mapping = new HashMap<>();
		mapping.put("id", "id");
		mapping.put("status", "status");
		mapping.put("type", "type");
		mapping.put("payment_method", "payment_method");
		mapping.put("payment_channel", "payment_channel");
		mapping.put("created_date", "created_date");
		mapping.put("time_zone", "time_zone");
		mapping.put("created_date_iso", "created_date_iso");
		mapping.put("reference", "reference");
		mapping.put("invoice_id", "invoice_id");
		mapping.put("description", "description");
		mapping.put("is_credit", "is_credit");
		mapping.put("amount", "amount");
		mapping.put("balance", "balance");
		mapping.put("name", "name");
		mapping.put("bank_code", "bank_code");
		mapping.put("account_number", "account_number");
		mapping.put("bank_reference", "bank_reference");

		// HeaderColumnNameTranslateMappingStrategy
		// for BillingCsvPojo class
		HeaderColumnNameTranslateMappingStrategy<BillingCsvPojo> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
		strategy.setType(BillingCsvPojo.class);
		strategy.setColumnMapping(mapping);
		List<BillingCsvPojo> combinedList = new ArrayList<>();
		for (String file : filenames) {
			CSVReader csvReader = null;
			try {
				csvReader = new CSVReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			CsvToBean<BillingCsvPojo> csvToBean = new CsvToBean<>();

			// call the parse method of CsvToBean
			// pass strategy, csvReader to parse method

			List<BillingCsvPojo> list = csvToBean.parse(strategy, csvReader);

			combinedList.addAll(list);
		}
		return combinedList;
	}
}
