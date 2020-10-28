package eci.ieti;

import eci.ieti.data.CustomerRepository;
import eci.ieti.data.ProductRepository;
import eci.ieti.data.TodoRepository;
import eci.ieti.data.UserRepository;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;
import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");

        customerRepository.findAll().stream().forEach(System.out::println);
        System.out.println();

        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));

        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");

        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 2)).stream()
                .forEach(System.out::println);

        System.out.println();

        todoRepository.deleteAll();

        todoRepository.save(new Todo("Travel to Galapagos", 10, "Jan - 10 - 2019", "charles@natural.com", "pending"));
        todoRepository.save(new Todo("Travel to Bogotá", 11, "Feb - 12 - 2019", "juan@natural.com", "done"));
        todoRepository.save(new Todo("Travel to Medellin", 12, "Mar - 24 - 2019", "jose@natural.com", "in progress"));
        todoRepository.save(new Todo("Eat a bread", 13, "Apr 15 - 2021", "albert@natural.com", "pending"));
        todoRepository.save(new Todo("Drink a coffe", 14, "Apr 15 - 2021", "andrea@natural.com", "done"));
        todoRepository.save(new Todo("Sing a song", 15, "May - 20 - 2020", "jonatan@natural.com", "in progress"));
        todoRepository.save(new Todo("Eat a eggs", 16, "Jun - 22 - 2020", "sebas@natural.com", "pending"));
        todoRepository.save(new Todo("Drink a tea", 17, "Jul - 1 - 2020", "luis@natural.com", "done"));
        todoRepository.save(new Todo("Drink a juice", 18, "Aug - 2 - 2020", "pedro@natural.com", "in progress"));
        todoRepository.save(new Todo("Watch to TV", 19, "Sep - 3 - 2020", "liss@natural.com", "pending"));
        todoRepository.save(new Todo("Watch a film", 20, "Oct - 4 - 2020", "nick@natural.com", "done"));
        todoRepository.save(new Todo("Watch a picture", 21, "Nov - 5 - 2020", "alice@natural.com", "in progress"));
        todoRepository.save(new Todo("Dance for me", 22, "Dec - 6 - 2020", "bob@natural.com", "pending"));
        todoRepository.save(new Todo("Drop tables", 23, "Jan - 7 - 2020", "jimmmy@natural.com", "done"));
        todoRepository.save(new Todo("Drop rows", 24, "Feb - 8 - 2020", "freddy@natural.com", "in progress"));
        todoRepository.save(new Todo("View Login", 25, "Mar - 9 - 2020", "michael@natural.com", "pending"));
        todoRepository.save(new Todo("View Logout", 26, "Apr - 10 - 2020", "crack@natural.com", "done"));
        todoRepository.save(new Todo("View Admin", 27, "May - 11 - 2020", "gottam@natural.com", "in progress"));
        todoRepository.save(new Todo("View User", 28, "Jun - 12 - 2020", "street@natural.com", "pending"));
        todoRepository.save(new Todo("View Todo", 29, "Jul - 13 - 2020", "eddie@natural.com", "done"));
        todoRepository.save(new Todo("View Task", 30, "Aug - 14 - 2020", "wolf@natural.com", "in progress"));
        todoRepository.save(new Todo("View Planner", 31, "Sep - 15 - 2020", "teto@natural.com", "pending"));
        todoRepository.save(new Todo("View Show", 1, "Oct - 16 - 2020", "jobs@natural.com", "done"));
        todoRepository.save(new Todo("View Close", 2, "Nov - 17 - 2020", "steve@natural.com", "in progress"));
        todoRepository.save(new Todo("View Story - Esta descripcion contiene mas de treinta caracateres, para la prueba de la ultima consulta", 3, "Dec - 18 - 2020", "rouse@natural.com", "pending"));
        todoRepository.save(new Todo("Travel to Galapagos", 4, "Jan - 10 - 2019", "charles@natural.com", "done"));

        System.out.println("Users found with findByResponsible():");
        System.out.println("-------------------------------");

        todoRepository.findByResponsibleContaining("charles", PageRequest.of(0, 2)).stream()
                .forEach(System.out::println);
        System.out.println();

        userRepository.deleteAll();

        userRepository.save(new User("1a", "Jonatan", "jonatan@mail.com"));
        userRepository.save(new User("2a", "Andrea", "andrea@mail.com"));
        userRepository.save(new User("3a", "Bob", "bob@mail.com"));
        userRepository.save(new User("4a", "Alice", "alice@mail.com"));
        userRepository.save(new User("5a", "Freddy", "freddy@mail.com"));
        userRepository.save(new User("6a", "Michael", "michael@mail.com"));
        userRepository.save(new User("7a", "Steve", "steve@mail.com"));
        userRepository.save(new User("8a", "Charles", "charles@mail.com"));
        userRepository.save(new User("9a", "Albert", "albert@mail.com"));
        userRepository.save(new User("10a", "Jose", "jose@mail.com"));

        System.out.println("Users found with findAll():");
        System.out.println("-------------------------------");

        userRepository.findAll().stream().forEach(System.out::println);
        System.out.println();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);

        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is("Alice"));
        List<Customer> customer = mongoOperation.find(query, Customer.class);

        //Todos where the dueDate has expired
        Query query1 = new Query();
        query1.addCriteria(Criteria.where("dueDate").lte(new String("Mar - 24 - 2019")));
        List<Todo> task_Expired = mongoOperation.find(query1, Todo.class);

        //Todos that are assigned to given user and have priority greater equal to 5
        Query query2 = new Query(); 
        query2.addCriteria(Criteria.where("responsible").exists(true).and("priority").gte(5));
        List<Todo> tasksAssignedPriority = mongoOperation.find(query2, Todo.class);

        //Users that have assigned more than 2 Todos.
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.group("responsible").count().as("count"),
                Aggregation.match(Criteria.where("count").gt(2)),
                Aggregation.project("_id"));
        List<Todo> moreAssignes = mongoOperation.aggregate(agg, "todo", Todo.class).getMappedResults();

        //Todos that contains a description with a length greater than 30 characters
        agg = Aggregation.newAggregation(
                Aggregation.project("_id", "description", "priority", "dueDate", "responsible", "status").andExpression("strLenCP(description)").as("strLength"),
                Aggregation.match(Criteria.where("strLength").gt(30)));
        List<Todo> greaterDescription = mongoOperation.aggregate(agg, "todo", Todo.class).getMappedResults();


        /* System.out.println("Number of customers = " + customer.size());
        System.out.println("Number of tasks expired = " + task_Expired.size());
        System.out.println("Number of tasks assigned and priority > 5 = " + tasksAssignedPriority.size());
        System.out.println("Users that have assigned more than 2 Todos = " + moreAssignes.size());
        System.out.println("Users that have assigned more than 2 Todos = " + greaterDescription.size()); */
        
    }

}