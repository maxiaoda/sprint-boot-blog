package hello.service;

import hello.dao.BlogDao;
import hello.entity.Blog;
import hello.entity.BlogResult;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BlogService {
    private BlogDao blogDao;

    @Inject
    public BlogService(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    public BlogResult getBlogs(Integer page, Integer pageSize, Integer userId) {
       try {
           List<Blog> blogs = blogDao.getBlogs(page, pageSize, userId);
           int count = blogDao.count(userId);

           int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
           return BlogResult.successMsg(blogs,count,page,totalPage);
       }catch (Exception e){
           return BlogResult.failureMsg("系统异常");
       }
    }
}
