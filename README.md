# Java Immersion Course, by [Alura](https;//www.alura.com.br)

"Imersão Java" is a 5-days intensive programming course (from 19/jul/2022 to 22/jul/2022) where students can take their
first steps with Java language, developing an application from scratch and start or grow their portfolio.

About the course: https://www.alura.com.br/imersao-java _(in Portuguese)_

## Day 1: Consuming a Movie API with Java

### During the class...

* Learned how to use `java.net.http.HttpClient` to make requests;
* Use regular expressions to parse the Response (json).

### Challenges

- [x] Consume the most popular movies' endpoint from IMDB API. Also look in the IMDB API documentation for
  the endpoint that returns the best series and the one that returns the most popular series.

  ![](https://github.com/afonsodemori/alura-java-immersion/blob/275676bcb3bf443ecf5902e32ca13a95206fa2a3/docs/day-001-challenge-001.png)

- [x] Use your creativity to make the output cuter: use emojis with UTF-8 code, show the movie note as little stars,
  decorate the terminal with colors, bold and italics using ANSI codes, and more!

  ![](https://github.com/afonsodemori/alura-java-immersion/blob/275676bcb3bf443ecf5902e32ca13a95206fa2a3/docs/day-001-challenge-002.png)

- [x] Place the IMDB API key somewhere outside the code like a configuration file (eg a .properties file)
  or an environment variable.

- [ ] Change JsonParser to use a JSON parsing library like Jackson or GSON.

- [ ] Supreme challenge: create some way for you to give a rating to the movie, pulling it from some configuration file
  or asking the user to type the rating in the terminal.
    * How I think I should implement it... soon...
        - [ ] Add menu option to allow the user to rate a movie
        - [ ] List Movie ID and title and ask for a Movie ID
        - [ ] Write a file with `key=value` with the movies ids and the user rate.
        - [ ] Get the user rating for the movies while rendering the movies list

## Day 2: Generating stickers for WhatsApp

### During the class...

* Learned how to read, manipulate and write image files;
* Editing images with Graphics2D to generate stickers to be sent via WhatsApp.

### Challenges

- [ ] Read the documentation of `InputStream`: https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html.
- [x] Center the text on the sticker.
- [ ] Make a WhatsApp and/or Telegram package with your own stickers!
- [x] Create output directory for images if it does not already exist.
- [x] Use another font like Comic Sans or Impact, the font used in memes.
- [x] Put a picture of yourself smiling, giving a thumbs up! _(used a star instead of my photo)_
- [ ] Add an outline to the text of the image.
- [x] Edit the image URL returned by the IMDB API to get a larger image instead of the thumbnails.
- [x] Customize sticker text according to IMDB ratings.
- [ ] Ultimate challenge: use some image manipulation library like OpenCV to extract the main image and contour it.

#### Some generated stickers

![](https://github.com/afonsodemori/alura-stickers/blob/day-3/docs/images/day-002-stickers.png)

![](https://github.com/afonsodemori/alura-stickers/blob/day-3/docs/images/day-002-whatsapp.png)

All generated stickers available at https://drive.google.com/drive/folders/1ma6OVllvqcLmkgeZ6AbCfPpQlvyHWCZe

## Day 3: Refactoring and object orientation

### During the class...

* Refactoring;
* Using Enums;
* Using Interface to make the code more reusable;
* Consume Nasa's api to generate stickers.

### Challenges

- [ ] Transform the class that represents the contents into a Record, available from Java 16;
- [ ] Create your own exceptions and use them in the class that implements the HTTP client;
- [ ] Use Java 8 and later features such as Streams and Lambdas to map one list to another;
- [x] Create an Enum that combines, as settings, the API URL and the extractor used;
- [ ] Ultimate challenge: consuming other APIs that contain images, like Marvel's, which is quite different. Repository
  with public APIs: [click here](https://github.com/public-apis/public-apis).

## Day 4: Creating our own API with Spring

### During the class...

* Learned how to start a project using [Spring Boot](https://start.spring.io/) and its "Spring Web" and "Spring Data
  MongoDB" dependencies;
* Used [MongoDB Cloud Services](https://www.mongodb.com/cloud) to create a NoSQL database to connect to our app;
* Implementation of GET and POST endpoints to create and retrieve records.

### Challenges

- [ ] Finish the CRUD (Create, Read, Update and Delete) so that you can update and delete a registered language;
- [ ] Return the list sorted by ranking;
- [ ] Create in your API an entity model with different names than title and image and create your own extractor custom
  information OR, keep with title and image name and translate so that it is returned as title and image through the use
  of DTO (Data Transfer Object);
- [ ] Return status 201 when a resource (language, in our case) is registered through POST;
- [ ] Supreme Challenge: Apply partial modifications to the resource via the PATCH method, for example, modifying the
  number of votes or people using each programming language.
