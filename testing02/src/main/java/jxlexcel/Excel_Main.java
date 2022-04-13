package jxlexcel;

import jxl.read.biff.BiffException;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Excel_Main {
    private static Logger logger = Logger.getLogger(Excel_Main.class);
    public static void main(String[] args) throws BiffException, IOException {


        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");

        Test_Excel test_excel=new Test_Excel();
        test_excel.CreateExcel();
        test_excel.JxlReadDemo();


    }
}
