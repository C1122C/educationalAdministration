package mapper;

import po.CourseCustom;
import po.PagingVO;

import java.util.List;

public interface CourseMapperCustom {

    List<CourseCustom> findByPaging(PagingVO pagingVO) throws Exception;

}
