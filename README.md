### Query Books with limit and last evaluated key

Expected time required: 15 min

Building off the `BooksRead` table in the previous question, you want to be able to narrow the scope of your query and see
a maximum of only a certain number of books at a time. 

The `BooksRead` table looks the same as the previous activity:

* `id`: partition key—unique id for each employee
* `asin`: sort key—unique id for each book
* `author`: author of the book
* `title`: title of the book
* `favorited`: boolean value of whether the book was liked by who read it
* `year_published`: the year the book was published

Write the `getBooksReadByEmployee()` method in the `BookDAO` class to return a certain number of books read by a specific
person using the `queryPage()` method.

The `Book` class is already written and annotated for you. The `BookHelperMethods` class includes helper methods that
are used for testing in the `BookApp` class. 

The unit tests in `BookDAOTest` are set-up with a mock database so that you can test your methods offline. The `main()`
method is set-up in `BookApp` so that you can connect to the real BooksRead table and test your methods that way.

HINTS:
* [I can't seem to get the next items that match the query, help!](./hints/hint-01.md)
