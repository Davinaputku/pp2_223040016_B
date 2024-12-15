package model;

import java.util.List;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    void insertUser(User user);  // Tanpa anotasi seperti @Insert
    List<User> getAllUsers();    // Tanpa anotasi seperti @Select
}