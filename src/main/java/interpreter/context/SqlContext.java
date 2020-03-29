package interpreter.context;

public class SqlContext {

    private String schema;

    private String table;

    public SqlContext(String schema, String table) {
        this.schema = schema;
        this.table = table;
    }

    public String getAlias(){
        return schema + "." + table + ".";
    }

    public String getSchema() {
        return schema;
    }

    public String getTable() {
        return table;
    }
}
