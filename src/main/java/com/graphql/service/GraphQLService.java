package com.graphql.service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.graphql.model.Address;
import com.graphql.model.Book;
import com.graphql.model.Post;
import com.graphql.model.Sport;
import com.graphql.model.User;
import com.graphql.repository.BookRepository;
import com.graphql.repository.UserRepository;
import com.graphql.service.datafetcher.AllBooksDataFetcher;
import com.graphql.service.datafetcher.AllUsersDataFetcher;
import com.graphql.service.datafetcher.BookDataFetcher;
import com.graphql.service.datafetcher.UserDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

/**
 *	This class will provide a graphQL API with our schema.
 * @author Abhishek Rathore
 */
@Service
public class GraphQLService {

	@Value("classpath:schema.graphql")
	Resource resource;
	@Autowired
	AllBooksDataFetcher allBooksDataFetcher;
	@Autowired
	BookDataFetcher bookDataFetcher;
	@Autowired
	UserDataFetcher userDataFetcher;
	@Autowired
	AllUsersDataFetcher allUsersDataFetcher;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	UserRepository userRepository;
	
	private GraphQL graphQL;
	
	/**
	 * Just after initialization of GraphQL service this method will be invoked
	 * first it'll parse schema file and create typeRegistry
	 * then runtimeWirirng will be generated where we have dataFetcher for each query
	 * and then finally we'll create graphQL from executable graph schema
	 */
	@PostConstruct
	private void loadSchema() throws IOException {
		loadBookData();								//load book data into h2 db
		loadUserData();								//load user data into h2 db
		File schemaFile = resource.getFile();		//get the schema from graphql file
		//parse the schema
		TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile); //parse schema file
		RuntimeWiring runtimeWiring = buildRuntimeWiring();
		GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(registry, runtimeWiring);
		graphQL = GraphQL.newGraphQL(graphQLSchema).build();
		
	}

	/**
	 * this method is attaching dataFetcher for each of our query 
	 */
	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring
					.dataFetcher("allBooks", allBooksDataFetcher)
					.dataFetcher("book", bookDataFetcher)
					.dataFetcher("allUsers", allUsersDataFetcher)
					.dataFetcher("user", userDataFetcher)
				)
				.build();
	}
	
	/**
	 * provide public graphQL API through which we can query
	 */
	public GraphQL getGraphQL() {
		return graphQL;
	}
	
	/**
	 * save dummy user to db
	 */
	private void loadUserData() {
		Stream.of(
				new User("1","User",null,"lastName","Male","22","53kg","5 feet 7 inches","",
						new Sport("1","Cricket","Rohit Sharma"),
						new String[] {
								"Playing Cricket",
								"Solving Rubics Cube"
						},
						new Address("1","Address for user","some landmark","Indore","Indore","Madhya Pradesh","India","452012"),
						"1000","500",
						new Post("1","19-11-2019","300","55","2"))
		).forEach(user -> {
			userRepository.save(user);
		});
	}

	/**
	 * save dummy data for books in db
	 */
	private void loadBookData() {
		Stream.of(
				new Book("1","Harry Potter and the Philosopher's Stone, Book 1",
						new String[] {
								"J.K. Rowling"
						}, "J.K. Rowling", "Nov 2019"),
				new Book("2","Core Java Volume I – Fundamentals",
						new String[] {
								"Cay S. Horstmann"
						}, "Prentice Hall", "Oct 2016"),
				new Book("3","Effective Java",
						new String[] {
								"Joshua Bloch"
						}, "Addison Wesley", "Jan 2017")
		).forEach(book -> {
			bookRepository.save(book);
		});
	}
}
