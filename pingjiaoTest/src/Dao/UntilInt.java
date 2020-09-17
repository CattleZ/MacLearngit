package Dao;

import java.util.List;

public interface UntilInt<T> {
	//增加实体对象
public int addEntity(T t);
//删除实体对象
public int deleEntity(T t);
//查找实体对象
public List<T> searchEntity(T t);
//修改实体对象的信息
public int  updataEntity(T t);

}
