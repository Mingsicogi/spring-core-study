package mins.study.user.config;

public class RedisProperties {
    private String host;
    private String dbNo;

    public RedisProperties(String host, String dbNo) {
        this.host = host;
        this.dbNo = dbNo;
    }

    public RedisProperties() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDbNo() {
        return dbNo;
    }

    public void setDbNo(String dbNo) {
        this.dbNo = dbNo;
    }
}
