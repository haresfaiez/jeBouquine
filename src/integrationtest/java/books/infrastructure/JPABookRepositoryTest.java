package books.infrastructure;

//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@ContextConfiguration(classes = {SpringApplicationTestContext.class})
//@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
//        DbUnitTestExecutionListener.class})
public class JPABookRepositoryTest {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Test
//    @DatabaseSetup("/persistence/books/search/by-title/find-books-setup.xml")
//    @ExpectedDatabase("/persistence/books/search/by-title/find-books-expected.xml")
//    public void shouldFindBooksByTitle() {
//        final String title = "Hello Spring";
//        List<Book> actualBooksResult = bookRepository.findBooksByTitle(title);
//        List<Book> expectedBooksResult = Stream.of(
//                Book.from("A1", title, new AtomicInteger(400),
//                        "Spring summary",
//                        "Faiez")
//        ).collect(Collectors.toList());
//
//        Assert.assertEquals(expectedBooksResult, actualBooksResult);
//    }
//
//    @Test
//    @DatabaseSetup("/persistence/books/add/add-book-setup.xml")
//    @ExpectedDatabase("/persistence/books/add/add-book-expected.xml")
//    public void shouldAddBook() {
//        final String ISBN = "AAAA";
//        final String title = "Hello spring";
//        final AtomicInteger price = new AtomicInteger(400);
//        final String summary = "Spring summary";
//        final String author = "Faiez";
//
//        Book actualBook = Book.from(ISBN, title, price, summary, author);
//        bookRepository.addBook(actualBook);
//    }
//
//    @Test
//    @DatabaseSetup("/persistence/books/retrieve/retrieve-book-setup.xml")
//    @ExpectedDatabase("/persistence/books/retrieve/retrieve-book-expected.xml")
//    public void shouldRetrieveExistingBookByISBN() {
//        final String ISBN = "AAAA";
//        final String title = "Hello spring";
//        final AtomicInteger price = new AtomicInteger(400);
//        final String summary = "Spring summary";
//        final String author = "Faiez";
//
//        Book expectedBook = Book.from(ISBN, title, price, summary, author);
//        Optional<Book> actualBook = bookRepository.findBookByISBN(ISBN);
//
//        Assert.assertTrue(actualBook.isPresent());
//        Assert.assertEquals(expectedBook, actualBook.get());
//    }
}
