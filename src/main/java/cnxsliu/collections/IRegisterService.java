package cnxsliu.collections;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/18 12:23
 * @strategy
 */
public interface IRegisterService {
    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     */
    void register(String username, String password);
}
