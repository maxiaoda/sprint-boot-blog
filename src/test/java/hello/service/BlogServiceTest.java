package hello.service;

import hello.dao.BlogDao;
import hello.entity.BlogResult;
import hello.entity.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {
    @Mock
    BlogDao blogDao;
    @InjectMocks
    BlogService blogService;

    @Test
    public void getBlogsFromDB() {
        blogService.getBlogs(1, 10, null);

        Mockito.verify(blogDao).getBlogs(1, 10, null);

    }

    @Test
    public void returnFailureWhenExceptionThrown() {
        Mockito.when(blogDao.getBlogs(Mockito.anyInt(), Mockito.anyInt(), Mockito.any())).thenThrow(new RuntimeException());

        BlogResult result = blogService.getBlogs(1, 10, null);
        Assertions.assertEquals("fail", result.getStatus());
        Assertions.assertEquals("系统异常", result.getMsg());
    }

}
