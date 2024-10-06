package com.loan.utility;

import java.io.ByteArrayOutputStream;

import com.loan.app.model.CustomerDetails;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ApplicationPdf {
public static ByteArrayOutputStream getApplicationPdf(CustomerDetails customerDetails) {
	String title = "HomeLoanApplication";
	String text = "Dear "+customerDetails.getCustomerFirstName() + ",\n        Your Loan amount is approved & credited in your account. \n"
			+ " please check your account & confirm";
	
	Document document = new Document();
	
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	
	PdfWriter.getInstance(document, byteArrayOutputStream);
	
	document.open();
	
	Font titleFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 26, CMYKColor.blue);
	
	Paragraph heading = new Paragraph(title, titleFont);
		heading.setAlignment("center");
		document.add(heading);
	
		Paragraph textParagraph = new Paragraph(text);
				textParagraph.setSpacingBefore(30);
			
				document.add(textParagraph);
				
				
			Font phraseFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);	
		
			PdfPTable table = new PdfPTable(2);
			
			table.setSpacingBefore(25);
			
			table.setWidths(new int[]{3,4});
			
			table.setWidthPercentage(100f);
	
			PdfPCell cell1 = new PdfPCell();		
			cell1.setPadding(10);
			cell1.setPaddingLeft(20);
			cell1.setPhrase(new Phrase("Required Amount", phraseFont));
			table.addCell(cell1);
			cell1.setPhrase(new Phrase(String.valueOf(customerDetails.getSanction().getLoanAmountSanctioned())));
			table.addCell(cell1);
					
				PdfPCell cell2 = new PdfPCell();		
				cell2.setPadding(10);
				cell2.setPaddingLeft(20);
				cell2.setPhrase(new Phrase("Rate Of interest", phraseFont));
				table.addCell(cell2);
				cell2.setPhrase(new Phrase(String.valueOf(customerDetails.getSanction().getRateOfInterest())));
				table.addCell(cell2);
					
					PdfPCell cell3 = new PdfPCell();		
					cell3.setPadding(10);
					cell3.setPaddingLeft(20);
					cell3.setPhrase(new Phrase("Loan Tenure", phraseFont));
					table.addCell(cell3);
					cell3.setPhrase(new Phrase(String.valueOf(customerDetails.getSanction().getLoanTenure())));
					table.addCell(cell3);
					
					PdfPCell cell4 = new PdfPCell();		
					cell4.setPadding(10);
					cell4.setPaddingLeft(20);
					cell4.setPhrase(new Phrase("Monthly Emi", phraseFont));
					table.addCell(cell4);
					cell4.setPhrase(new Phrase(String.valueOf(customerDetails.getSanction().getMonthlyEmiAmount())));
					table.addCell(cell4);
					
					
					
				document.add(table);
				
				String icici = "Yours faithfully,";
				String customerName = customerDetails.getCustomerFirstName();	
				
				Font iciciFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 24);
				Paragraph setIcici = new Paragraph(icici, iciciFont);
					setIcici.setAlignment("right");
					
					document.add(setIcici);
					
				Font fontCustomerName = FontFactory.getFont(FontFactory.HELVETICA, 24, CMYKColor.BLACK);
				Paragraph alignCustomer = new Paragraph(customerName, fontCustomerName);
					alignCustomer.setAlignment("right");
				document.add(alignCustomer);
				document.close();
			
			
	
	return byteArrayOutputStream;
}
}