package pl.book.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import pl.book.entities.Mark;
import pl.book.entities.Reviewer;
import pl.book.manager.MarkManager;
import pl.book.manager.ReviewerManager;

@Controller
public class ReviewerController {

	@Autowired
	private ReviewerManager reviewerManager;
	
	@Autowired
	public ReviewerController(ReviewerManager reviewerManager) {
		super();
		this.reviewerManager = reviewerManager;
	}
	
	@GetMapping("/allreviewers")
	public Iterable<Reviewer> getAll(){
		return reviewerManager.findAll();
	}

  @RequestMapping(value = "/reviewer", method = RequestMethod.GET)
  public ModelAndView subjects(HttpServletRequest request){
      Iterable<Reviewer> reviewer = reviewerManager.findAllWhereId(Long.valueOf(request.getParameter("reviewerId")));
      ModelAndView model = new ModelAndView("/reviewer.html");
      model.addObject("reviewers", reviewer);
      return model;
  }
}
