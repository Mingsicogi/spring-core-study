package mins.study.user.service;

import mins.study.user.config.Genre;
import mins.study.user.config.MovieQualifier;
import mins.study.user.config.MultipleSameTypeBeanConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

public class MultipleSameTypeBeanService {

    @Autowired
    MultipleSameTypeBeanConfiguration.MovieCategory movieCategory;

    @Autowired
    @Genre
    MultipleSameTypeBeanConfiguration.MovieCategory defaultMovieCategory;

    @Autowired
    @MovieQualifier(genre = "fourth")
    MultipleSameTypeBeanConfiguration.MovieCategory fourthMovieCategory;

    @Autowired
    @MovieQualifier(genre = "fifth")
    MultipleSameTypeBeanConfiguration.MovieCategory fifthMovieCategory;

    public MultipleSameTypeBeanConfiguration.MovieCategory getMovieCategory() {
        return this.movieCategory;
    }

    public MultipleSameTypeBeanConfiguration.MovieCategory getDefaultMovieCategory() {
        return this.defaultMovieCategory;
    }

    public MultipleSameTypeBeanConfiguration.MovieCategory getFourthMovieCategory() {
        return this.fourthMovieCategory;
    }

    public MultipleSameTypeBeanConfiguration.MovieCategory getFifthMovieCategory() {
        return this.fifthMovieCategory;
    }
}
