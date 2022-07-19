[← back to README.md][readme]

# Day 1

This is the summary of the first day of the **Java Immersion Course** by [Alura](https://www.alura.com.br).

## Goal

Use the [IMDb API](https://www.imdb-api.com) to get info from Movies and TV Shows and print its info in the terminal.

## Challenges

1. Consume the most popular movies' endpoint from IMDB API. Also look in the IMDB API documentation for
   the endpoint that returns the best series and the one that returns the most popular series.

   ![](https://github.com/afonsodemori/alura-java-immersion/blob/275676bcb3bf443ecf5902e32ca13a95206fa2a3/docs/day-001-challenge-001.png)

   See implementation
   at [day-1/src/App.java](https://github.com/afonsodemori/alura-java-immersion/blob/275676bcb3bf443ecf5902e32ca13a95206fa2a3/src/App.java)

2. Use your creativity to make the output cuter: use emojis with UTF-8 code, show the movie note as little stars,
   decorate the terminal with colors, bold and italics using ANSI codes, and more!

   ![](https://github.com/afonsodemori/alura-java-immersion/blob/275676bcb3bf443ecf5902e32ca13a95206fa2a3/docs/day-001-challenge-002.png)

   See implementation
   at [day-1/src/App.java](https://github.com/afonsodemori/alura-java-immersion/blob/275676bcb3bf443ecf5902e32ca13a95206fa2a3/src/App.java)

3. Place the IMDB API key somewhere outside the code like a configuration file (eg a .properties file)
   or an environment variable.

   See implementation
   at [day-1/src/App.java](https://github.com/afonsodemori/alura-java-immersion/blob/275676bcb3bf443ecf5902e32ca13a95206fa2a3/src/App.java)

4. Change JsonParser to use a JSON parsing library like Jackson or GSON.

   // TODO

5. Supreme challenge: create some way for you to give a rating to the movie, pulling it from some configuration file or
   asking the user to type the rating in the terminal.

   - [ ] Add menu option to allow the user to rate a movie
   - [ ] List Movie ID and title and ask for a Movie ID
   - [ ] Write a file with `key=value` with the movies ids and the user rate.
   - [ ] Get the user rating for the movies while rendering the movies list

---

[← back to README.md][readme]

[readme]: https://github.com/afonsodemori/alura-java-immersion/blob/main/README.md
