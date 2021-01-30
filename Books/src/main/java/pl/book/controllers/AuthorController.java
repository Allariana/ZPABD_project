package pl.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.book.base.BaseController;
import pl.book.entities.Author;
import pl.book.manager.AuthorManager;
import pl.book.repositories.AuthorRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorController extends BaseController {
	@Autowired
	private AuthorManager authorManager;
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorController(AuthorManager authorManager, AuthorRepository authorRepository) {
		super();
		this.authorManager = authorManager;
		this.authorRepository = authorRepository;
	}
	
	@GetMapping("/allAuthorsAPI")
	public Iterable<Author> getAll(){
		return authorManager.findAll();
	}

  @RequestMapping(value = "/allAuthors", method = RequestMethod.GET)
  public ModelAndView subjects(HttpServletRequest request){
      Iterable<Author> authors = authorManager.findAll();
	  boolean isAdmin = checkIfAuthenticatedUserIsAdmin();
	  logger.info("Is current user admin: " + isAdmin);

      ModelAndView model = new ModelAndView("/allAuthors.html");
      model.addObject("authors", authors);
      model.addObject("isAdmin", String.valueOf(isAdmin));
      return model;
  }

  @RequestMapping(value = "/admin/addAuthor", method = RequestMethod.GET)
	public ModelAndView addMarks(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("/admin/addAuthor.html");
		return model;
	}

	@RequestMapping(value = "/admin/addAuthor", method = RequestMethod.POST)
	public void addAuthor(HttpServletRequest request) {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		
		Author author = new Author();
		author.setFirstName(firstName);
		author.setSurname(lastName);
		
		authorRepository.save(author);
	}

}
