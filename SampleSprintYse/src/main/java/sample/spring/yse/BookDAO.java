package sample.spring.yse;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //연결해준다
public class BookDAO {
	
	@Autowired  //자동으로 객체 생성된 애들을 연결, field injection 
	SqlSessionTemplate sqlSessionTemplate;	//new 키워드를 통해 직접 생성하지 않는다. 의존성 주입을 통해 주입 받아 바로 사용한다.
											//개발자가 직접 객체를 생성하지 않고 곧바로 사용할 수 있다.
	
	public int insert (Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("book.insert",map);
	}
	
	
	
}
