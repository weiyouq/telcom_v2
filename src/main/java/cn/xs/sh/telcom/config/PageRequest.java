package cn.xs.sh.telcom.config;

import javassist.bytecode.stackmap.TypeData;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * 分页控制类
 * @author kenny_peng
 * @created 2019/7/18 13:43
 */
public class PageRequest implements Serializable {

	private static final long serialVersionUID = -4869594085374385813L;

	private int pageSize;
	private int pageNum;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", TypeData.ClassName.class.getSimpleName() + "[", "]")
				.add("pageSize=" + pageSize)
				.add("pageNum=" + pageNum)
				.toString();
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
