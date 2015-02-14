package excelParse;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.Country;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Arnaud on 14/02/2015.
 */
public class ExcelFileReader implements FileReader {

    public final static String FILE_NAME = "OCDE_file.xls";

    @Override
    public List<Country> getCountriesData() {
        Map<RateKey, Double> dataMap = generateDataMapFromFile();
        List<Country> dataModel = toModel(dataMap);
        return dataModel;
    }

    private List<Country> toModel(Map<RateKey, Double> dataMap) {
        return null;
    }

    private Map<RateKey, Double> generateDataMapFromFile() {
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File(FILE_NAME));
            Map<RateKey, Double> dataMap = new HashMap<RateKey, Double>();
            for (Sheet eachSheet : workbook.getSheets()) {
                collectDataSheet(dataMap);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
            return new HashMap<RateKey, Double>();
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
    }

    private void collectDataSheet(Map<RateKey, Double> dataMap) {

    }
}
