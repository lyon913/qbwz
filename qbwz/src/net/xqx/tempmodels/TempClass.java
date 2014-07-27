package net.xqx.tempmodels;

import java.io.Serializable;
import java.util.List;

import net.xqx.models.TClass;

/**
 * 该类不映射到表
 * @author siyi
 *
 */
public class TempClass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 父类权限
	 */
	private TClass classList;
	
	/**
	 * 由父类权限得到的子类权限
	 */
	private List<TClass> classLists;

	public TClass getClassList() {
		return classList;
	}

	public void setClassList(TClass classList) {
		this.classList = classList;
	}

	public List<TClass> getClassLists() {
		return classLists;
	}

	public void setClassLists(List<TClass> classLists) {
		this.classLists = classLists;
	}
	
	
	
}
