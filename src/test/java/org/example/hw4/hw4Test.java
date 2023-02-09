package org.example.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class hw4Test {

    @Test
    void test() throws MyException {
        TriangleS triangleS = new TriangleS();
        Assertions.assertEquals(198, triangleS.formulaGerona(20,20,30));
        Assertions.assertThrows(MyException.class,()-> triangleS.formulaGerona(-10,20,0));
    }

    @ParameterizedTest
    @CsvSource({ "20,20,30,198","3,3,3,4","15,20,32,112"})
    void testWithCsvSource(int a, int b, int c, int result) throws MyException {
        TriangleS triangleS = new TriangleS();
        Assertions.assertEquals(result,triangleS.formulaGerona(a,b,c));

    }

    @ParameterizedTest
    @CsvSource({ "-10,20,0","-100,200,25","1,2,-3"})
    void testWithCsvSourceN(int a, int b, int c) {
        TriangleS triangleS = new TriangleS();
        Assertions.assertThrows(MyException.class,()-> triangleS.formulaGerona(a,b,c));
    }
    private static Logger logger =
            LoggerFactory.getLogger(hw4Test.class);
}
