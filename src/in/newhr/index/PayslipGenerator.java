package in.newhr.index;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import in.newhr.dao.SalaryDAO;
import in.newhr.dao.SalaryDAOImpl;
import in.newhr.dto.Employee;
import in.newhr.dto.Salary;

public class PayslipGenerator {
	public static String generatePdf(Employee e, Salary s) {
		SalaryDAO sdao=new SalaryDAOImpl();
		Document d=new Document();
		
		try {
			FileOutputStream fos=new FileOutputStream(s.getUrl());
			PdfWriter.getInstance(d, fos);
			
			//Logo has been added
			Image logo=Image.getInstance("C:\\JavaPrgmSalarySlipNewHr\\PentagonSpaceGoldenLogo.png"); //we need to pass the path along with it
			logo.scaleAbsolute(80, 100); //we need to mention logo size
			logo.setAlignment(Element.ALIGN_CENTER);
			
			
			d.open();
			d.add(logo);
			// Salary slip title
			Font titleFont=new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
			Paragraph title=new Paragraph("Salary Payslip", titleFont);
			title.setAlignment(Element.ALIGN_CENTER);
			title.setSpacingAfter(20f);
			d.add(title);
			
			//Employee Info Table
			PdfPTable empTable=new PdfPTable(2);
			empTable.setWidthPercentage(100);
			
			empTable.addCell(getCell("Employee ID:", Element.ALIGN_RIGHT));
			empTable.addCell(getCell(String.valueOf(e.getEid()), Element.ALIGN_LEFT));
			
			empTable.addCell(getCell("Name:", Element.ALIGN_RIGHT));
			empTable.addCell(getCell(e.getName(), Element.ALIGN_LEFT));
			empTable.addCell(getCell("Designation:", Element.ALIGN_RIGHT));
			empTable.addCell(getCell(e.getJob(), Element.ALIGN_LEFT));
			
			empTable.setSpacingAfter(30);
			d.add(empTable);
			
			//Salary Info Table
			PdfPTable salTable=new PdfPTable(2);
			salTable.setWidthPercentage(100);
			
			salTable.addCell(getCell("Transaction ID:", Element.ALIGN_RIGHT));
			salTable.addCell(getCell(String.valueOf(s.getId()), Element.ALIGN_LEFT));
			salTable.addCell(getCell("Salary Month:",Element.ALIGN_RIGHT));
			salTable.addCell(getCell(s.getMonth_year(), Element.ALIGN_LEFT));
			salTable.addCell(getCell("Amount:", Element.ALIGN_RIGHT));
			salTable.addCell(getCell(String.valueOf(s.getSal()), Element.ALIGN_LEFT));
			salTable.addCell(getCell("Net Amount:", Element.ALIGN_RIGHT));
			salTable.addCell(getCell(String.valueOf(s.getNetPay()), Element.ALIGN_LEFT));
			
			salTable.setSpacingAfter(30);
			d.add(salTable);
			
			// Footer
			Font footerFont = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC); 
			Paragraph footer = new Paragraph("This is a system-generated payslip. No signature required.", footerFont); 
			footer.setSpacingBefore(250); 
			footer.setAlignment(Element.ALIGN_RIGHT); 
			d.add(footer); 
					              
			d.close();
			
		} catch (IOException | DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return s.getUrl();
	}
	
	 private static PdfPCell getCell(String text, int alignment) { 
	        Font cellFont = new Font(Font.FontFamily.HELVETICA, 12); 
	        PdfPCell cell = new PdfPCell(new Phrase(text, cellFont)); 
	        cell.setPadding(10); 
	        cell.setHorizontalAlignment(alignment); 
	        cell.setBorder(PdfPCell.NO_BORDER); 
	        return cell; 
	    }
}
