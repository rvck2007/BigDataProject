import excelParse.ExcelReaderImpl;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by alexandre on 05/02/2015.
 * */


public class ExcelReaderTest {

    @Test
    public void shouldTakeWorkbook(){
        try {
            ExcelReaderImpl excelReader = new ExcelReaderImpl("Nofile.xls");
            assertThat(false).isTrue();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            assertThat(true).isTrue();
            e.printStackTrace();
        }
    }


    @Test
    public void shouldTakeALineWithSheetAndRowInString(){
        try {
            ExcelReaderImpl excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<String> ligne = new ArrayList<String>();
            ligne = excelReader.takeLineString(0, 1);
            assertThat(ligne).containsOnly("5,0","6,2","4,9","4,7","4,9","5,5","5,6","6,0","6,7","7,0","3,4","4,7","4,8","3,7","2,7","2,4","2,5");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeALineWithSheetAndRowInStringWithoutNull(){
        try {
            ExcelReaderImpl excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<String> ligne = new ArrayList<String>();
            ligne = excelReader.takeLineString(0, 2);
            assertThat(ligne).containsOnly("...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeALineWithSheetAndRowInDouble(){
        try {
            ExcelReaderImpl excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<Double> ligne = new ArrayList<Double>();
            ligne = excelReader.takeLineDouble(0,1);
            assertThat(ligne).contains(5.0,6.2,4.9,4.7,4.9,5.5,5.6,6.0,6.7,2.4,2.5);
            assertThat(ligne).doesNotContain(-1.0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeCountryFromFirstSheet(){
        try {
            ExcelReaderImpl excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<String> country = new ArrayList<String>();
            country = excelReader.takePays();
            assertThat(country).contains("Australie", "Autriche", "Belgique", "Etats-Unis");
            assertThat(country).doesNotContain("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeYearsFromFirstSheet(){
        try {
            ExcelReaderImpl excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<String> years = new ArrayList<String>();
            years = excelReader.takeYears();
            assertThat(years).contains("1999","2000","2002","2015");
            assertThat(years).doesNotContain("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeNumberOfLineForSheet(){
        try {
            ExcelReaderImpl excelReader = new ExcelReaderImpl("OCDE_file.xls");
            int allLine;
            allLine = excelReader.takeNumberOfLine(0);
            assertThat(allLine).isEqualTo(34);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeAllLineFromASheetInString(){
        try {
            ExcelReaderImpl excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<ArrayList<String>> allLine = new ArrayList<ArrayList<String>>();
            allLine = excelReader.takeAllLineString(0);
            for (ArrayList<String> collect : allLine) {
                System.out.println("collect = " + collect);
                assertThat(collect).doesNotContain("");
            }
            assertThat(allLine.size()).isEqualTo(34);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldTakeSheetLineInString() {
        try {
            ExcelReaderImpl excelReader = new ExcelReaderImpl("OCDE_file.xls");
            Collection<ArrayList<ArrayList<String>>> allSheetLine = new ArrayList<ArrayList<ArrayList<String>>>();
            allSheetLine = excelReader.takeAllSheetLineString();
            for (ArrayList<ArrayList<String>> sheetLists : allSheetLine) {
                System.out.println("NewSheet!");
                for (ArrayList<String> LineList : sheetLists) {
                    System.out.println("LineList = " + LineList);
                    assertThat(LineList).doesNotContain("");
                }
            }
            assertThat(allSheetLine.size()).isEqualTo(4);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
}