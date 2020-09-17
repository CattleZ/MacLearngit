package Service;

public interface LoginInt<T> {
//验证登陆
	public boolean getLogin(T t);
//验证注册
	public boolean getRegist(T t);
//验证修改
	public boolean getUpdate(T t);
//验证删除
	public boolean getDel(T t);
}
