package mins.study.user.config;

public class StringStorage implements Storage<String> {

    @Override
    public Class<String> getType() {
        return String.class;
    }
}
