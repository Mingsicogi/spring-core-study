package mins.study.user.config;

public class IntegerStorage implements Storage<Integer> {
    @Override
    public Class<Integer> getType() {
        return Integer.class;
    }
}
