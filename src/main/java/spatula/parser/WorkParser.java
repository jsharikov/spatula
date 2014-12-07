package spatula.parser;

import java.io.ByteArrayInputStream;
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
import org.springframework.stereotype.Component;

import spatula.entity.smeta.WorkSmeta;
import spatula.entity.standart.Resource;
import spatula.entity.standart.ResourceWork;
import spatula.entity.standart.Standart;
import spatula.entity.standart.Work;
import spatula.enums.UnitEnum;
@Component
public final class WorkParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkParser.class);

    public static List<WorkSmeta> parse(byte [] file) {
        List<WorkSmeta> workSmetaList = new ArrayList<>();
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(file);
            HSSFWorkbook wb = new HSSFWorkbook(is);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> it = sheet.iterator();
            boolean foundFirstRowWithWork = false;
            Integer queueWork = null;
            WorkSmeta workSmeta = null;
            while (it.hasNext()) {
                Row row = it.next();
                Cell cell0 = row.getCell(0);
                Integer value = parseQueueWork(cell0);
                if (value != null) {
                    queueWork = value;
                    workSmeta = parseWorkSmeta(it, row);
                    workSmetaList.add(workSmeta);
                    if (!foundFirstRowWithWork) {
                        foundFirstRowWithWork = true;
                    }
                } else if (foundFirstRowWithWork && isParseQueueWorkResource(cell0, queueWork)) {
                    ResourceWork resourceWork = parseResourceWork(row);
                    workSmeta.getWork().getResources().add(resourceWork);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workSmetaList;
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

    private static WorkSmeta parseWorkSmeta(Iterator<Row> it, Row currRow) {
        WorkSmeta workSmeta = new WorkSmeta();
        workSmeta.setWork(new Work());
        workSmeta.getWork().setStandart(new Standart());
        workSmeta.getWork().setResources(new ArrayList<ResourceWork>());
        processFirstRowWithWork(currRow, workSmeta);
        processSecondRowWithWork(it.next(), workSmeta.getWork());
        processThirdRowWithWork(it.next(), workSmeta.getWork());
        return workSmeta;
    }

    private static void processFirstRowWithWork(Row row, WorkSmeta workSmeta) {

        workSmeta.getWork().getStandart().setCode(row.getCell(1).getStringCellValue());
        workSmeta.getWork().getStandart().setName(row.getCell(2).getStringCellValue());
        workSmeta.setQuantity(getNumericCellValueOrNull(row.getCell(3)));
        workSmeta.getWork().setTotalCost(getNumericCellValueOrNull(row.getCell(4)));
        workSmeta.getWork().setOperMachinesCost(getNumericCellValueOrNull(row.getCell(5)));

        /*CostWork totalCost = work.getTotalCost();
        totalCost.setTotal(getNumericCellValueOrNull(row.getCell(6)));
        totalCost.setOperMachines(getNumericCellValueOrNull(row.getCell(7)));*/

        /*Overhead overhead = work.getOverhead();
        overhead.setValue(getNumericCellValueOrNull(row.getCell(8)));*/

        /*LaborCost workers = work.getWorkers();
        workers.setItem(getNumericCellValueOrNull(row.getCell(9)));
        workers.setTotal(getNumericCellValueOrNull(row.getCell(10)));*/
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

        work.setWagesOfWorkers(getNumericCellValueOrNull(row.getCell(4)));
        work.setIncludingWagesOfMachinists(getNumericCellValueOrNull(row.getCell(5)));
        work.setPercent(getIntegerCellValueOrNull(row.getCell(8)));

        /*CostWork totalCost = work.getTotalCost();
        totalCost.setWagesOfWorkers(getNumericCellValueOrNull(row.getCell(6)));
        totalCost.setIncludingWagesOfMachinists(getNumericCellValueOrNull(row.getCell(7)));

        Overhead overhead = work.getOverhead();
        overhead.setPercent(getIntegerCellValueOrNull(row.getCell(8)));

        LaborCost machinists = work.getMachinists();
        machinists.setItem(getNumericCellValueOrNull(row.getCell(9)));
        machinists.setTotal(getNumericCellValueOrNull(row.getCell(10)));*/
    }

    private static void processThirdRowWithWork(Row row, Work work) {
        UnitEnum unitEnum = UnitEnum.getUnitEnumByName(row.getCell(2).getStringCellValue());
        if (unitEnum != null) {
            work.getStandart().setUnitId(unitEnum.getId());
        }
    }

    private static ResourceWork parseResourceWork(Row row) {
        ResourceWork resourceWork = new ResourceWork();

        resourceWork.setResource(new Resource());
        resourceWork.getResource().setStandart(new Standart());
        resourceWork.getResource().getStandart().setCode(row.getCell(1).getStringCellValue());
        resourceWork.getResource().getStandart().setName(row.getCell(2).getStringCellValue());
        UnitEnum unitEnum = UnitEnum.getUnitEnumByName(row.getCell(3).getStringCellValue());
        if (unitEnum != null) {
            resourceWork.getResource().getStandart().setUnitId(unitEnum.getId());
        }

        resourceWork.setQuantity(getNumericCellValueOrNull(row.getCell(4)));
        resourceWork.getResource().setCost(getNumericCellValueOrNull(row.getCell(6)));
        //resourceWork.getResource().setTotalCost(getNumericCellValueOrNull(row.getCell(7)));

        return resourceWork;
    }

    private WorkParser() {
        super();
    }

}
