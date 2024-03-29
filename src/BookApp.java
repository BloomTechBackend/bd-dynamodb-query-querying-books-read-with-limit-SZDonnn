import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import java.util.List;

public class BookApp {

    /**
     * Test your methods on a real database connection. This makes three query calls—to show the effect of using the
     * lastEvaluatedKey. The first call returns the first 2 books with titles 'The Book Thief' and 'To Kill a
     * Mockingbird.' The second call returns the only book left that meets the query condition (id = '5b2ccd28'), with
     * title 'My Side of the Mountain.' The third call returns the original 2 books, since lastEvaluatedKey is 'null'
     * again, with title 'The Book Thief' and 'To Kill a Mockingbird'.
     * @param args main method arguments
     */
    public static void main(String[] args) {
        //GIVEN (1st query call)
        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        String employeeId = "5b2ccd28";
        String exclusiveStartAsin = null;
        int limit = 2;

        //WHEN (1st query call)
        BookDAO bookDAO = new BookDAO(mapper);
        BookHelperMethods helperMethods = new BookHelperMethods();
        List<Book> queryBookList = bookDAO.getBooksReadByEmployee(employeeId, exclusiveStartAsin, limit);

        //THEN (1st query call)
        System.out.println("The first query call when limit = 2 retrieves the 2 books with titles The Book Thief and " +
                "To Kill a Mockingbird: " + helperMethods.getTitlesFromList(queryBookList).toString());

        //GIVEN (2nd query call)
        exclusiveStartAsin = "A456HGF872";

        //WHEN (2nd query call)
        queryBookList = bookDAO.getBooksReadByEmployee(employeeId, exclusiveStartAsin, limit);

        //THEN (2nd query call)
        System.out.println("The second query call when limit = 2 retrieves the book with title My Side of the " +
                "Mountain: " + helperMethods.getTitlesFromList(queryBookList).toString());
    }
}
