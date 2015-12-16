package cart.infrastructure;

//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//@ContextConfiguration(classes = {SpringApplicationTestContext.class})
//@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
//        DbUnitTestExecutionListener.class})
public class JPAPurchaseRepositoryTest {

//    @Autowired
//    private PurchaseRepository purchaseRepository;

//TODO:fix dbunit problem or uncomment to
//    @Test
//    @DatabaseSetup("/persistence/cart/add-purchase/add-purchase-setup.xml")
//    @ExpectedDatabase("/persistence/cart/add-purchase/add-purchase-expected.xml")
//    public void shouldAddPurchase() {
//        Book book = Book.from("FFFF",
//                "Hibernate in action", new AtomicInteger(400),
//                "Hibernate summary", "Faiez");
//        Customer customer = IntegrationTestCustomerFactory.createCustomer();
//        //TODO:fix date handling
//        Date date = new Date(12, 29, 2014);
//        purchaseRepository.addPurchase(Purchase.from(book, customer,
//                date));
//    }

//    @Test
//    @DatabaseSetup("/persistence/cart/find-purchases/purchase-setup.xml")
//    @ExpectedDatabase("/persistence/cart/find-purchases/purchase-expected.xml")
//    public void shouldFindPurchasesForACustomer() {
//        Book book = Book.from("IIII",
//                "Spring in action", new AtomicInteger(400), "Spring summary", "Faiez");
//        Book secondBook = Book.from("FFFF",
//                "Hibernate in action", new AtomicInteger(400),
//                "Hibernate summary", "Faiez");
//        Customer customer = IntegrationTestCustomerFactory.createCustomer();
//        List<Purchase> expectedPurchases =
//                Stream.of(
//                        IntegrationTestPurchaseFactory.createPurchaseFrom
//                                (4, customer, book),
//                        IntegrationTestPurchaseFactory.createPurchaseFrom
//                                (5, customer, secondBook))
//                        .collect(Collectors.toList());
//
//        List<Purchase> actualPurchases = purchaseRepository.findPurchasesFor
//                (customer);
//        Assert.assertEquals(expectedPurchases.get(1), actualPurchases
//                .get(1));
//    }
}
