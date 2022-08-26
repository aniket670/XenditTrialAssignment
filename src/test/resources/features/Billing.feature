Feature: To perform Billing audit for Virtual Account and Ewallet products.


Background:
Given the user reads the CSV from the local

Scenario: To verify the virtual account details from the report
And the user verify the count for VAA
And the user verify the rates for VAA
And the user verify the volume for VAA
And the user verify the billed amount for VAA

Scenario: To verify the Ewallet account details from the report
And the user verify the count for EW
And the user verify the rates for EW
And the user verify the volume for EW
And the user verify the billed amount for EW

Scenario: To verify the subtotal VAT and Total for Virtual Account and Ewallet products
And the user verify the subtotal value
And the user verify the VAT value
And the user verify the total value