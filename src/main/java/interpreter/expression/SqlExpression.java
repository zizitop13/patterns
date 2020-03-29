package interpreter.expression;

import interpreter.context.SqlContext;

public interface SqlExpression {
    String interpret(SqlContext context);
}
