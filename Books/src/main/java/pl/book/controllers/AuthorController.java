package pl.book.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.book.entities.Author;
import pl.book.manager.AuthorManager;

@Controller
public class AuthorController {
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
      ModelAndView model = new ModelAndView("/allAuthors.html");
      model.addObject("authors", authors);
      return model;
  }
}
