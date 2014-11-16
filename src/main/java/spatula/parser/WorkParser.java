/*package spatula.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spatula.entity.reference.StandartWork;
import spatula.entity.reference.StandartWorkResource;
import spatula.entity.reference.Work;
import spatula.entity.reference.WorkResource;
import spatula.enums.UnitEnum;

public final class WorkParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkParser.class);

    public static List<Work> parse() {
        File file = new File("D:\\k1580.xls");
        List<Work> works = new ArrayList<>();
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            HSSFWorkbook wb = new HSSFWorkbook(is);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> it = sheet.iterator();
            boolean foundFirstRowWithWork = false;
            Integer queueWork = null;
            Work work = null;
            while (it.hasNext()) {
                Row row = it.next();
                Cell cell0 = row.getCell(0);
                Integer value = parseQueueWork(cell0);
                if (value != null) {
                    queueWork = value;
                    work = parseWork(it, row);
                    works.add(work);
                    if (!foundFirstRowWithWork) {
                        foundFirstRowWithWork = true;
                    }
                } else if (foundFirstRowWithWork && isParseQueueWorkResource(cell0, queueWork)) {
                    WorkResource workResource = parseWorkResource(row);
                    work.getResources().add(workResource);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return works;
    }

    private static boolean isParseQueueWorkResource(Cell cell, Integer queueWork) {
        if (cell != null && queueWork != null && cell.getCellType() == Cell.CELL_TYPE_STRING
                && cell.getStringCellValue().startsWith(queueWork.toString())) {
            return true;
        }
        return false;
    }

    private static Integer parseQueueWork(Cell cell) {
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
                return value;
            }
        }
        return null;
    }

    private static Work parseWork(Iterator<Row> it, Row currRow) {
        Work work = new Work();
        work.setStandartWork(new StandartWork());
        work.setResources(new ArrayList<WorkResource>());
        processFirstRowWithWork(currRow, work);
        processSecondRowWithWork(it.next(), work);
        processThirdRowWithWork(it.next(), work);
        return work;
    }

    private static void processFirstRowWithWork(Row row, Work work) {

        work.getStandartWork().setCode(row.getCell(1).getStringCellValue());
        work.getStandartWork().setName(row.getCell(2).getStringCellValue());
        work.setQuantity(getNumericCellValueOrNull(row.getCell(3)));
        work.getStandartWork().setTotalCost(getNumericCellValueOrNull(row.getCell(4)));
        work.getStandartWork().setOperMachinesCost(getNumericCellValueOrNull(row.getCell(5)));

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

        work.getStandartWork().setWagesOfWorkers(getNumericCellValueOrNull(row.getCell(4)));
        work.getStandartWork().setIncludingWagesOfMachinists(getNumericCellValueOrNull(row.getCell(5)));
        work.getStandartWork().setPercent(getIntegerCellValueOrNull(row.getCell(8)));

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
            work.getStandartWork().setUnitId(unitEnum.getId());
        }
    }

    private static WorkResource parseWorkResource(Row row) {
        WorkResource workResource = new WorkResource();

        StandartWorkResource standartWorkResource = new StandartWorkResource();
        standartWorkResource.setCode(row.getCell(1).getStringCellValue());
        standartWorkResource.setName(row.getCell(2).getStringCellValue());
        UnitEnum unitEnum = UnitEnum.getUnitEnumByName(row.getCell(3).getStringCellValue());
        if (unitEnum != null) {
            standartWorkResource.setUnitId(unitEnum.getId());
        }
        workResource.setStandartWorkResource(standartWorkResource);

        workResource.setQuantity(getNumericCellValueOrNull(row.getCell(4)));
        workResource.setCost(getNumericCellValueOrNull(row.getCell(6)));
        workResource.setTotalCost(getNumericCellValueOrNull(row.getCell(7)));

        return workResource;
    }

    private WorkParser() {
        super();
    }

}
*/