package jxlexcel;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

public class Test_Excel  {

    //创建excel
    public void CreateExcel() {
        //创建工作簿
        WritableWorkbook workbook;

        {
            try {
                workbook = Workbook.createWorkbook(new File("test.xls"));
                //创建工作区
                //Sheet sheet=workbook.createSheet("testxls",0);
                //Sheet sheet=workbook.getSheet(0);
                WritableSheet sheet = workbook.createSheet("sheet1", 0);

                for (int row = 0; row < 10; row++) {
                    for (int col = 0; col < 10; col++) {
                        sheet.addCell(new Label(col, row, "data" + row + col));
                    }
                }

                workbook.write();
                workbook.close();

            } catch (IOException | WriteException e) {
                e.printStackTrace();
            }

        }
    }

    //读取表格
    public void JxlReadDemo() throws BiffException, IOException {

        File xlsFile = new File("test.xls");
        // 获得工作簿对象
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        // 获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        // 遍历工作表

        if(sheets != null)
        {
            for (Sheet sheet : sheets) {
                // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                // 读取数据

                for (int row = 0; row < rows; row++)
                {
                    for (int col = 0; col < cols; col++)
                    {
                        System.out.printf("%10s", sheet.getCell(col, row)
                                .getContents());
                    }
                    System.out.println();
                }

            }
        }
        workbook.close();
    }
}
