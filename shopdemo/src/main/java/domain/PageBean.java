package domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageBean<T> {

	//当前页
	private int currentPage;
	//当前页显示的条数
	private int currentCount;
	//总条数
	private int totalCount;
	//总页数
	private int totalPage;
	//显示的集合
	private List<T> list;
	
}
