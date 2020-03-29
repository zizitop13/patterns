package interpreter.expression;

import interpreter.context.SqlContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectTest {

    @Test
    public void selectFromTestTableWithWhere() {
        SqlContext sqlContext = new SqlContext("TEST_SCHEMA", "TEST");
        Select select = new Select("ID", "TYPE");
        select.setWhere(new Where("ID = 1"));
        String selectQuery = select.interpret(sqlContext);
        assertEquals("SELECT TEST_SCHEMA.TEST.ID, TEST_SCHEMA.TEST.TYPE FROM TEST_SCHEMA.TEST WHERE TEST_SCHEMA.TEST.ID = 1",
                selectQuery);
    }
}