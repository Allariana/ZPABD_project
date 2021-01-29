package pl.book.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.book.base.BaseController;
import pl.book.entities.Author;
import pl.book.enums.RoleEnum;
import pl.book.manager.AuthorManager;

@Controller
public class AuthorController extends BaseController {
	@Autowired
	private AuthorManager authorManager;
	
	@Autowired
	public AuthorController(AuthorManager authorManager) {
		super();
		this.authorManager = authorManager;
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

}
