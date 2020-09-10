package lv.ozo.webapp.bootstrap;

import lv.ozo.webapp.domain.Author;
import lv.ozo.webapp.domain.Book;
import lv.ozo.webapp.domain.Publisher;
import lv.ozo.webapp.repositories.AuthorRepository;
import lv.ozo.webapp.repositories.BookRepository;
import lv.ozo.webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    //    in dependencies injection
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Lielvards");
        publisher.setCity("Riga");
        publisher.setState("teika");

        publisherRepository.save(publisher);

        Author ozo = new Author("Reinis", "Ozo");
        Book firstBook = new Book("Just Book", "123123");
        ozo.getBooks().add(firstBook);
        firstBook.getAuthors().add(ozo);

        firstBook.setPublisher(publisher);
        publisher.getBooks().add(firstBook);


        authorRepository.save(ozo);
        bookRepository.save(firstBook);
        publisherRepository.save(publisher);

        Author oz = new Author("Re", "Oz");
        Book firstBo = new Book("Jut Bok", "123");
        oz.getBooks().add(firstBo);
        firstBo.getAuthors().add(oz);

        firstBo.setPublisher(publisher);
        publisher.getBooks().add(firstBo);

        authorRepository.save(oz);
        bookRepository.save(firstBo);
        publisherRepository.save(publisher);


        Publisher bitite =new Publisher();
        bitite.setName("Bitite");
        bitite.setCity("Medemciems");
        bitite.setState("nav");

        publisherRepository.save(bitite);

        Author anete = new Author("Anete", "AAA");
        Book pasakasParVilkiem = new Book("Pasakas par vilkiem", "123789");
        anete.getBooks().add(pasakasParVilkiem);
        pasakasParVilkiem.getAuthors().add(anete);

        pasakasParVilkiem.setPublisher(bitite);
        bitite.getBooks().add(pasakasParVilkiem);

        authorRepository.save(anete);
        bookRepository.save(pasakasParVilkiem);
        publisherRepository.save(bitite);
        
//        System.out.println("Publisher Count: " + publisherRepository.count());
//        System.out.println(bitite);
        System.out.println("Number of books : " + bookRepository.count());
//        System.out.println("Publisher Number of books : "+ bitite.getBooks().size());

    }
}
