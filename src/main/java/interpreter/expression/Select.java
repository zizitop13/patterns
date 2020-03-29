package interpreter.expression;

import interpreter.context.SqlContext;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Select implements SqlExpression {

    private final String[] columns;

    private SqlExpression where;

    public Select(String... columns){
        this.columns = columns;
    }

    public void setWhere(SqlExpression where) {
        this.where = where;
    }

    @Override
    public String interpret(SqlContext context) {
        SqlExpression from = new From();
        return "SELECT " + Arrays
                .stream(columns)
                .map(x -> context.getAlias() + x.trim())
                .collect(Collectors.joining(", "))
                + from.interpret(context) + where.interpret(context);
    }

}
