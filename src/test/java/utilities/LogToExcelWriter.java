package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.*;

public final class LogToExcelWriter {
    private LogToExcelWriter() {}

    public static Path write(String logPath, String excelPath) {
        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Console");
            int rowIdx = 0;
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(logPath), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Row row = sheet.createRow(rowIdx++);
                    row.createCell(0).setCellValue(line);
                }
            }
            sheet.autoSizeColumn(0);
            try (FileOutputStream fos = new FileOutputStream(excelPath)) {
                wb.write(fos);
            }
            return Paths.get(excelPath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write Excel from log", e);
        }
    }
}