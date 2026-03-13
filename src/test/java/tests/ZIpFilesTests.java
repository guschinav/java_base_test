package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.google.common.io.Files.getFileExtension;

public class ZIpFilesTests {

    private ClassLoader cl = ZIpFilesTests.class.getClassLoader();



    @Test
    void zipFileParsingTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("Files.zip")
        )) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                String extension = getFileExtension(fileName);
                System.out.println("Файл: " + fileName + " | Расширение: " + extension);

                if (extension.equals("pdf")) {
                    PDF pdf = new PDF(zis.readAllBytes());
                    Assertions.assertTrue(pdf.text.contains("тестирования загрузки файлов"));
                }
                if (extension.equals("xlsx")) {
                    XLS xls = new XLS(zis.readAllBytes());
                    String actualValue = xls.excel.getSheetAt(0).getRow(17).getCell(0).getStringCellValue();
                    Assertions.assertTrue(actualValue.contains("Тестовый заказ 15"));
                }
                if (extension.equalsIgnoreCase("csv")) {

                    byte[] bytes = zis.readAllBytes();
                    try (CSVReader csvReader = new CSVReader(new InputStreamReader(new ByteArrayInputStream(bytes), StandardCharsets.UTF_8))) {
                        List<String[]> data = csvReader.readAll();
                        String[] row = data.get(1);
                        String[] expected = {"150000", "2016-01-01", "Chris Riley", "trailhead9.ub20k5i9t8ou@example.com"};
                        Assertions.assertArrayEquals(expected, row);
                    }
                }


            }

        }
    }




}




