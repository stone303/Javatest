package poiexcel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;

public class test_main {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        test_poiexcel testpoi=new test_poiexcel();
        testpoi.CreateExcel();
        testpoi.PoiReadDemo();
    }
}
