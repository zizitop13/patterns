package interpreter.expression;

import interpreter.context.SqlContext;

public class Where implements SqlExpression {

    private String condition;

    public Where(String condition) {
        this.condition = condition;
    }

    @Override
    public String interpret(SqlContext context) {
        return " WHERE " + context.getAlias() + condition;
    }
}
