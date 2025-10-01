package java7.text.to.numbers;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;
import java7.text.to.numbers.SingleLineFile;

public class SingleLineFileStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("java7.text.to.numbers.SingleLineFile")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void constructor() {
        it.has(DEFAULT_CONSTRUCTOR);
    }

    @Test
    public void methodAddNumbers() {
        it.hasMethod("addNumbers", withParams("String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("int");
    }
}

