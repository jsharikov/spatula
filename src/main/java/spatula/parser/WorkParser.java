package spatula.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spatula.entity.reference.CostWork;
import spatula.entity.reference.LaborCost;
import spatula.entity.reference.Overhead;
import spatula.entity.reference.Work;
import spatula.enums.UnitEnum;

public final class WorkParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkParser.class);

    public static void parse() {
        File file = new File("D:\\k1580.xls");
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            HSSFWorkbook wb = new HSSFWorkbook(is);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> it = sheet.iterator();
            while (it.hasNext()) {
                Row row = it.next();
                Cell cell0 = row.getCell(0);
                if (isConsecutiveNumberWork(cell0)) {
                    processRowWithWork(it, row);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isConsecutiveNumberWork(Cell cell) {
        if (cell != null && cell.getCellType() == Cell.CELL_TYPE_STRING) {
            Integer value = null;
            try {
                value = Integer.parseInt(cell.getStringCellValue());
            } catch (NumberFormatException e) {
                LOGGER.debug("Значение первой ячейки " + cell.getRowIndex()
                        + "-строки невозможно преобразовать в целое число");
            }
            if (value != null) {
                LOGGER.debug("Значение первой ячейки " + cell.getRowIndex()
                        + "-строки удалось преобразовать в число " + value);
                return true;
            }
        }
        return false;
    }

    private static void processRowWithWork(Iterator<Row> it, Row currRow) {
        Work work = new Work();
        processFirstRowWithWork(currRow, work);
        processSecondRowWithWork(it.next(), work);
        processThirdRowWithWork(it.next(), work);
    }

    private static void processFirstRowWithWork(Row row, Work work) {

        work.setCode(row.getCell(1).getStringCellValue());
        work.setName(row.getCell(2).getStringCellValue());

        CostWork costPerUnit = work.getCostPerUnit();
        costPerUnit.setTotal(getNumericCellValueOrNull(row.getCell(4)));
        costPerUnit.setOperMachines(getNumericCellValueOrNull(row.getCell(5)));

        CostWork totalCost = work.getTotalCost();
        totalCost.setTotal(getNumericCellValueOrNull(row.getCell(6)));
        totalCost.setOperMachines(getNumericCellValueOrNull(row.getCell(7)));

        Overhead overhead = work.getOverhead();
        overhead.setValue(getNumericCellValueOrNull(row.getCell(8)));

        LaborCost workers = work.getWorkers();
        workers.setItem(getNumericCellValueOrNull(row.getCell(9)));
        workers.setTotal(getNumericCellValueOrNull(row.getCell(10)));
    }

    private static BigDecimal getNumericCellValueOrNull(Cell cell) {
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return new BigDecimal(cell.getNumericCellValue());
        }
        return null;
    }

    private static Integer getIntegerCellValueOrNull(Cell cell) {
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return (int) cell.getNumericCellValue();
        }
        return null;
    }

    private static void processSecondRowWithWork(Row row, Work work) {

        CostWork costPerUnit = work.getCostPerUnit();
        costPerUnit.setWagesOfWorkers(getNumericCellValueOrNull(row.getCell(4)));
        costPerUnit.setIncludingWagesOfMachinists(getNumericCellValueOrNull(row.getCell(5)));

        CostWork totalCost = work.getTotalCost();
        totalCost.setWagesOfWorkers(getNumericCellValueOrNull(row.getCell(6)));
        totalCost.setIncludingWagesOfMachinists(getNumericCellValueOrNull(row.getCell(7)));

        Overhead overhead = work.getOverhead();
        overhead.setPercent(getIntegerCellValueOrNull(row.getCell(8)));

        LaborCost machinists = work.getMachinists();
        machinists.setItem(getNumericCellValueOrNull(row.getCell(9)));
        machinists.setTotal(getNumericCellValueOrNull(row.getCell(10)));
    }

    private static void processThirdRowWithWork(Row row, Work work) {
        UnitEnum unitEnum = UnitEnum.getUnitEnumByName(row.getCell(2).getStringCellValue());
        if (unitEnum != null) {
            work.setUnitId(unitEnum.getId());
        }
    }

    private WorkParser() {
        super();
    }

}
