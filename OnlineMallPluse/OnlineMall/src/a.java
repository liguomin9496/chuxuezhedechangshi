import java.util.List;

import mall.dao.brandDao;
import mall.domain.brand;

public class a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		brandDao sBrandDao = new brandDao();
		List<brand> list = sBrandDao.find('A');
		for(int i = 0; i <list.size(); i++){
			brand brands = list.get(i);
			System.out.println(brands.getBrandName());
		}
	}

}
