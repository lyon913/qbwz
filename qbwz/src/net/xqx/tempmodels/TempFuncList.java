package net.xqx.tempmodels;

import java.io.Serializable;
import java.util.List;

import net.xqx.models.TFuncList;

/**
 * 该类为输出权限提供临时表
 * 该类不映射到表
 * @author siyi
 *
 */
public class TempFuncList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 父类权限
	 */
	private TFuncList funcList;
	
	/**
	 * 由父类权限得到的子类权限
	 */
	private List<TFuncList> funcLists;
	
	public TFuncList getFuncList() {
		return funcList;
	}
	public void setFuncList(TFuncList funcList) {
		this.funcList = funcList;
	}
	public List<TFuncList> getFuncLists() {
		return funcLists;
	}
	public void setFuncLists(List<TFuncList> funcLists) {
		this.funcLists = funcLists;
	}
	
	
}
