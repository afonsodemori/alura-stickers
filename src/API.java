public enum API {
    IMDB_250_MOVIES(
            "IMDb: Top 250 Movies",
            "https://imdb-api.com/en/API/Top250Movies/" + App.API_TOKEN,
            new ImdbContentExtractor()
    ),
    IMDB_POPULAR_MOVIES(
            "IMDb: Most Popular Movies",
            "https://imdb-api.com/en/API/MostPopularMovies/" + App.API_TOKEN,
            new ImdbContentExtractor()
    ),
    NASA_APOD(
            "NASA: Astronomy Picture of the Day",
            "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14",
            new NasaContentExtractor()
    );

    private final String description;
    private final String url;
    private final ContentExtractor extractor;

    API(String description, String url, ContentExtractor extractor) {
        this.description = description;
        this.url = url;
        this.extractor = extractor;
    }

    public String description() {
        return description;
    }

    public String url() {
        return url;
    }

    public ContentExtractor extractor() {
        return extractor;
    }

}
