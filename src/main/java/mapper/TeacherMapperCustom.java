package mapper;

import po.PagingVO;
import po.TeacherCustom;

import java.util.List;

public interface TeacherMapperCustom {
    List<TeacherCustom> findByPaging(PagingVO pagingVO) throws Exception;
}
