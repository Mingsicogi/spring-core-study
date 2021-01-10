package mins.study.user.service;

import mins.study.user.config.MultipleSameTypeBeanConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

public class MultipleSameTypeBeanService {

    @Autowired
    MultipleSameTypeBeanConfiguration.MovieCategory movieCategory;

    public MultipleSameTypeBeanConfiguration.MovieCategory getMovieCategory() {
        return this.movieCategory;
    }
}
