import com.mycompany.junitktsnt.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;
public class TestSNT {
    @Test 
    public void TestSNTLe()
    {
        int n=3;
        boolean expected = true;
        boolean actual;
        actual = Utils.ktNt(n);
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void TestSNChan()
    {
        int n=2;
        boolean expected = true;
        boolean actual;
        actual = Utils.ktNt(n);
        Assertions.assertTrue(actual);
    }
    //Test nhieu gia tri giong nhau
    @ParameterizedTest
    @ValueSource(ints ={2,3,5,7,11} )
    public void TestNhieugiatrigiongnhau(int n)
    {
        boolean expected = true;
        boolean actual;
        actual = Utils.ktNt(n);
        Assertions.assertTrue(actual, "Thong bao");
    }
    //Test nhieu gia tri khac nhau
    @ParameterizedTest
    @CsvSource({"1,false, tb1","2,true,tb2","3,true,tb3"} )
    public void TestNhieugiatrikhacnhau(int n, boolean expected, String message)
    {
        boolean actual;
        actual = Utils.ktNt(n);
        Assertions.assertEquals(expected, actual, message);
    }
    //Test nhieu gia tri doc tu file
    @ParameterizedTest
    @CsvFileSource(files="src/main/resource/data.csv",numLinesToSkip=0)
    public void TestAllFiles(int n, boolean expected, String message)
    {
        boolean actual;
        actual = Utils.ktNt(n);
        Assertions.assertEquals(expected, actual, message);
    }
    // Bat exception
     @Test
    public void TestException()
    {
       Assertions.assertThrows(ArithmeticException.class, ()->{Utils.ktNt(-4);});
    }
}
