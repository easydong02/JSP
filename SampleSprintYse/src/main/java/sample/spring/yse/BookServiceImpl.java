package sample.spring.yse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //각 클래스 연결
public class BookServiceImpl implements BookService{

	@Autowired
	BookDAO bookDAO;
	
	@Override
	public String create(Map<String,Object> map) {
		int affectRowCount =this.bookDAO.insert(map);
		if(affectRowCount ==1) {
			return map.get("book_id").toString();
		}
		return null;
	}
}
