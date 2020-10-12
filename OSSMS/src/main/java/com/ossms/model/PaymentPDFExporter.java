package com.ossms.model;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PaymentPDFExporter {
	List<Paymentss> pay = new ArrayList<Paymentss>();

	public PaymentPDFExporter(List<Paymentss> pay) {
		super();
		this.pay = pay;
	}
	
	private void writeTableHeader( PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		
		
		cell.setPhrase(new Phrase("Payment ID" , font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Product ID" , font));
		table.addCell(cell);
		
		
		cell.setPhrase(new Phrase("Payment Date", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Amount", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Type", font));
		table.addCell(cell);
		
	} 
	
	private void writeTableData(PdfPTable table) {
		
		for(Paymentss p : pay) {
			table.addCell(String.valueOf(p.getIdPayment()));
			table.addCell(String.valueOf(p.getProdId()));
			table.addCell(String.valueOf(p.getPaymentDate()));
			table.addCell(String.valueOf(p.getAmount()));
			table.addCell(String.valueOf(p.getType()));
		}
		
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Image image = Image.getInstance("C:\\Users\\Manujaya\\git\\ITP\\OSSMS\\src\\main\\webapp\\WEB-INF\\views\\logo.jpg");
		image.scaleAbsolute(70f, 70f);
		image.setAlignment(Element.ALIGN_CENTER);
		document.add(image);
		
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE,18);
		font1.setColor(Color.black);
		Paragraph Topic = new Paragraph("Athukorala Super Market PVT.LTD." , font1);
		Topic.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(Topic);
		
		Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE,15);
		font2.setColor(Color.black);
		Paragraph Topic2 = new Paragraph("Supplier Payment Report" , font2);
		Topic2.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(Topic2);
		
		Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE,7);
		font1.setColor(Color.black);
		Paragraph Topic3 = new Paragraph("T.P : +94 68-222 22 54/ +94 76 324 45 66 | FAX : 87686756778 | Email : athukoralasm@gmail.com" , font3);
		Topic3.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(Topic3);
		
	
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
		table.setWidths(new float[] {3.5f,3.5f,2.0f,2.0f,2.0f});
		
		
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		document.close();
		
	}
}
