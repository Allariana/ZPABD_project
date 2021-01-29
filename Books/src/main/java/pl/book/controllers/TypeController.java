package pl.book.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.book.base.BaseController;
import pl.book.entities.Book;
import pl.book.entities.Type;
import pl.book.manager.BookManager;
import pl.book.manager.TypeManager;

@Controller
public class TypeController extends BaseController {
	@Autowired
	private TypeManager typeManager;
	
	@Autowired
	public TypeController(TypeManager typeManager) {
		super();
		this.typeManager = typeManager;
	}
	
	@GetMapping("/allTypesAPI")
	public Iterable<Type> getAll(){
		return typeManager.findAll();
	}

  @RequestMapping(value = "/allTypes", method = RequestMethod.GET)
  public ModelAndView subjects(HttpServletRequest request){
      Iterable<Type> types = typeManager.findAll();
      ModelAndView model = new ModelAndView("/allTypes.html");
      model.addObject("types", types);
      model.addObject("isAdmin", String.valueOf(checkIfAuthenticatedUserIsAdmin()));
      return model;
  }
}
