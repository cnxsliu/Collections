package cnxsliu.collections;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/18 12:23
 * @strategy
 */
public class RegisterServiceImpl implements IRegisterService {
    @Override
    public void register(String username, String password) {
        System.out.println("username : " + username + ", password : " + password);
    }
}
