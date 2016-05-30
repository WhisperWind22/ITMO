package webprogramming;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvBind;

@SuppressWarnings("unused")
public class Java_5 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream in = new FileInputStream("/WiFi.xls");
		HSSFWorkbook wb = new HSSFWorkbook(in);
		List<ArrayList> rows = new ArrayList<ArrayList>();
		List<String> row1 = new ArrayList<String>();
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> it = sheet.iterator();
		String str="";
		while (it.hasNext()) {
			str+=Double.toString(53.365);
			row1.clear();
			Row row = it.next();
			Iterator<Cell> cells = row.iterator();
			while (cells.hasNext()) {
				Cell cell = cells.next();
				int cellType = cell.getCellType();
				switch (cellType) {
				case Cell.CELL_TYPE_STRING:
					row1.add(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					row1.add(Double.toString(cell.getNumericCellValue()));
					break;

				case Cell.CELL_TYPE_FORMULA:
					row1.add(Double.toString(cell.getNumericCellValue()));
					break;
				default:
					break;
				}
				
			}
			rows.add((ArrayList) row1);
		}
		CSVWriter writer;
		writer = new CSVWriter(new BufferedWriter(new
				OutputStreamWriter(
				new FileOutputStream("/result.csv"), "UTF-8")));
				String[] row1 = {};
				writer.writeNext(row1);
				String[] row2 = {};
				writer.writeNext(row2);
				writer.close();
	}

}