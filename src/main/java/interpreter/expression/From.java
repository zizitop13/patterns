package interpreter.expression;

import interpreter.context.SqlContext;

public class From implements SqlExpression {

    @Override
    public String interpret(SqlContext context) {
        return " FROM " + context.getSchema() + "." + context.getTable();
    }
}
