package sample.spring.yse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller //어노테이션 있는 클래스는 스프링이 브라우저의 요청을 받아서 처리하는 클래스다라고 인지해서 자바 빈으로 등록해서 관리한다.
public class BookController {

	@RequestMapping(value="/create",method=RequestMethod.GET)  //주소를 , 가져와라
	public ModelAndView create() {
		return new ModelAndView("book/create");
	}
}
