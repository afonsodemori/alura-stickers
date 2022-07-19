# Java Immersion Course, by Alura.com.br

Based on the content of the Immersion Course at https://www.alura.com.br/imersao-java

## Day 1: Consuming a Movie API with Java

### CHALLENGE 001

Consume the most popular movies' endpoint from IMDB API. Also look in the IMDB API documentation for
the endpoint that returns the best series and the one that returns the most popular series.

![](/docs/day-001-challenge-001.png)

See implementation at [day-1/src/App.java](https://github.com/afonsodemori/alura-java-immersion/blob/day-1/src/App.java)

### CHALLENGE 002

Use your creativity to make the output cuter: use emojis with UTF-8 code, show the movie note as
little stars, decorate the terminal with colors, bold and italics using ANSI codes, and more!

![](/docs/day-001-challenge-002.png)

See implementation at [day-1/src/App.java](https://github.com/afonsodemori/alura-java-immersion/blob/day-1/src/App.java)

### CHALLENGE 003

Place the IMDB API key somewhere outside the code like a configuration file (eg a .properties file)
or an environment variable.

See implementation at [day-1/src/App.java](https://github.com/afonsodemori/alura-java-immersion/blob/day-1/src/App.java)

### CHALLENGE 004

Change JsonParser to use a JSON parsing library like Jackson or GSON.

// TODO

### CHALLENGE 005

Supreme challenge: create some way for you to give a rating to the movie, pulling it from some configuration file or
asking the user to type the rating in the terminal.

- [ ] Add menu option to allow the user to rate a movie
- [ ] List Movie ID and title and ask for a Movie ID
- [ ] Write a file with `key=value` with the movies ids and the user rate.
- [ ] Get the user rating for the movies while rendering the movies list
