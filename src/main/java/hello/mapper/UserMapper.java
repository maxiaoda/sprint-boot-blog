package hello.mapper;

import hello.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username}")
    User findUserByUsername(@Param("username") String username);

    @Insert("insert into user(username, encrypted_password, created_at, updated_at)\n" +
            "values( #{username}, #{encryptedPassword}, now(), now()) ")
    void save(@Param("username") String username,
              @Param("encryptedPassword") String encryptedPassword);
}
