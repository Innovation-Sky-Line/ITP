package com.ossms.model;

import java.awt.Color;
import java.io.IOException;
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

public class DiscountExportPDF {
	private List<ProductList> productLists;

	
	public DiscountExportPDF(List<ProductList> productLists) {
		super();
		this.productLists = productLists;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		
		cell.setBackgroundColor(Color.blue);
		cell.setPadding(5);
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
		font.setColor(Color.white);
	
		cell.setPhrase(new Phrase("Product ID",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Product Name",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Price(LKR)",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Discount(%)",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Final Price(LKR)",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Current Stocks",font));
		table.addCell(cell);
		
//		cell.setPhrase(new Phrase("Supplier ID",font));
//		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Supplier Name",font));
		table.addCell(cell);
		
//		cell.setPhrase(new Phrase("Category ID",font));
//		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Category Name",font));
		table.addCell(cell);
	}
	
	private void writeTableData(PdfPTable table) { 
		
		for(ProductList pList : productLists) {
			
			table.addCell(String.valueOf(pList.getProductModel().getIdProduct()));
			table.addCell(pList.getProductModel().getProductName());
			table.addCell(String.valueOf(pList.getProductModel().getPrice()));
			table.addCell(String.valueOf(pList.getProductModel().getDiscount()));
			float fprice = pList.getProductModel().getPrice() - pList.getProductModel().getPrice() * pList.getProductModel().getDiscount()/100;
			table.addCell(String.valueOf(fprice));
			table.addCell(String.valueOf(pList.getProductModel().getCurrentStock()));
			//table.addCell(String.valueOf(pList.getSupplier().getIdSupplier()));
			table.addCell(String.valueOf(pList.getSupplier().getSupplierName()));
			//table.addCell(String.valueOf(pList.getCategoryModel().getIdCategory()));
			table.addCell(String.valueOf(pList.getCategoryModel().getCategoryName()));
		}
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Image image = Image.getInstance("C:\\Users\\Nadun\\git\\ITP\\OSSMS\\src\\main\\webapp\\resources\\images\\logo.jpg");
		image.scaleAbsolute(70f, 70f);
		image.setAlignment(Element.ALIGN_CENTER);
		document.add(image);
		
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 18);
		font1.setColor(Color.black);
		Paragraph Topic = new Paragraph("Athukorala SuperMarket PVT. LTD.",font1);
		Topic.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(Topic);
		
		Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 15);
		font2.setColor(Color.black);
		Paragraph Topic2 = new Paragraph("Discounted Product Report",font2);
		Topic2.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(Topic2);
		
		Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 7);
		font3.setColor(Color.black);
		Paragraph Topic3 = new Paragraph("T.P : +94 68-222 22 54/ +94 76 324 45 66 | FAX : 87686756778 | Email : athukoralasm@gmail.com ",font3);
		Topic3.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(Topic3);
		
		
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 12);
		font.setColor(Color.blue);
		Paragraph title = new Paragraph("List of Discounted Products.",font);
		title.setSpacingBefore(18);
		document.add(title);
		
		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100);
		table.setSpacingBefore(15);
		table.setWidths(new float[] {2.0f, 3.5f, 2.5f, 2.5f, 2.5f, 2.0f, 3.5f, 3.5f  });
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		
		document.close();
	}
}
