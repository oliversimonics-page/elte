package java5.famous.sequence;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

//import java5.famous.sequence.TriangularNumbersStructureTest;
import java5.famous.sequence.TriangularNumbersTest;


@SelectClasses({
    TriangularNumbersTestSuite.StructuralTests.class
  , TriangularNumbersTestSuite.FunctionalTests.class
})
@Suite public class TriangularNumbersTestSuite {
  @SelectClasses({
      TriangularNumbersStructureTest.class
  })
  @Suite public static class StructuralTests {}

  @SelectClasses({
      TriangularNumbersTest.class
  })
  @Suite public static class FunctionalTests {}
}
