package com.maggioni.ReadWriteExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * http://java67.blogspot.de/2014/09/how-to-read-write-xlsx-file-in-java-apache-poi-example.html
 */
public class XLSXReaderWriter
{

    public static void main(String[] args)
    {
        File myFile = new File("Employee.xlsx");
        try {
            FileInputStream fis = new FileInputStream(myFile);

            // Finds the workbook instance for XLSX file
            XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

            // Return first Sheet from Workbook
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);

            // Get Iterator to all the rows in the current sheet
            Iterator<Row> rowIterator = mySheet.iterator();

            // Traversing over each row
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // For each Row Iterate for each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                    }
                }
                System.out.println("");

            }
            
            // Now, Let's write some data into our XLSX File
            
            Map<String, Object[]> data = new HashMap<String, Object[]>();
            data.put("7", new Object[] {7d, "Sonya", "75K", "SALES", "Rupert"});
            data.put("8", new Object[] {8d, "Kris", "85K", "SALES", "Rupert"});
            data.put("9", new Object[] {9d, "Dave", "90K", "SALES", "Rupert"});
            
            // Set to iterate and add rows to XLS file
            Set<String> newRows = data.keySet();
            
            // get the last Row number to append new data
            int rownum = mySheet.getLastRowNum();
            
            for (String key : newRows) {
                
                // Creating new row in existing XLSC file
                Row row = mySheet.createRow(rownum++);
                Object[] objarr = data.get(key);
                int cellnum=0;
                for (Object obj : objarr) {
                    Cell cell = row.createCell(cellnum++);
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Boolean) {
                        cell.setCellValue((boolean) obj);
                    } else if (obj instanceof  Double) {
                        cell.setCellValue((double) obj);
                    } else if (obj instanceof Date) {
                        cell.setCellValue((Date) obj);
                        
                    }
                }
            }
            
            // Open outputstream to save written data
            FileOutputStream os = new FileOutputStream(myFile);
            myWorkBook.write(os);
            System.out.println("Writing on XLSX file Finisched ....");
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("File not found");;
        }

    }

}
