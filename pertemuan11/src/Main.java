import model.MyBatisUtil;
import model.UserMapper;
import org.apache.ibatis.session.SqlSession;
import view.UserView;
import controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Main {
    public static void main(String[] args) {
        // Membuka sesi MyBatis
        SqlSession session = MyBatisUtil.getSqlSession();

        // Mendapatkan mapper dari sesi MyBatis
        UserMapper mapper = session.getMapper(UserMapper.class);

        // Membuat instance UserView dan UserController
        UserView view = new UserView();
        new UserController(view, mapper);

        // Menampilkan UserView
        view.setVisible(true);
    }
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

}