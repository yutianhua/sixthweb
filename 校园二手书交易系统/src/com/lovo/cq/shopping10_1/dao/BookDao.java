package com.lovo.cq.shopping10_1.dao;

import java.util.List;

import com.lovo.cq.shopping10_1.po.Book;
import com.lovo.cq.shopping10_1.po.Page;

public interface BookDao {
	/**
	 * ��ʾ�鼮
	 * @param type ��ʾ������������飬���ۣ�
	 * @param flag ��ʾ�Ƿ��ǣ����������飬���ۣ�
	 * @return List
	 */
	public List showBooks(int type,int flag);
	
	/**
	 * �������BookId����չʾ�������ϸ��Ϣ
	 * @param bookId �鼮��
	 * @return Book
	 */
	public Book showBookById(int bookId);
	/**
	 *	���鱾��Ϣ¼�����ݿ� 
	 */
	public boolean addBook(Book book);
	/**
	 * ��ҳ��ʾ�鼮
	 */
	public Page doPage(int type,int currentPage,int pageSize);
	/**
	 * �����û�����Ĺؼ�����������鼮
	 * @param keywords �û�����Ĺؼ��� 
	 */
	public List searchBooks(String keywords);
	/**
	 * ��ҳ��ʾ�鼮
	 * @param currentPage ��ʾ�����ĵ�ǰҳ��
	 * @param pageSize ÿҳ��ʾ��Ŀ
	 * @return Page
	 */
	public Page doPage(String keywords,int currentPage,int pageSize);
	/**
	 * �����û�ѡ�������������������鼮
	 * @param superTypeId ���������ID
	 * @param subTypeId ����С���ID
	 * @param searchMethod �������ǰ����ߡ������������硢ISBN���۸��е�һ����
	 * @param upLoadTime �鼮�ϼ�ʱ��
	 * @return List
	 */
	public List searchBooksByConditions(int superTypeId,int subTypeId,String searchMethod,String upLoadTime);
	/**
	 * �����û�ѡ�����������������ҳ��ʾ����鼮
	 * @param superTypeId ���������ID
	 * @param subTypeId ����С���ID
	 * @param searchMethod �������ǰ����ߡ������������硢ISBN���۸��е�һ����
	 * @param upLoadTime �鼮�ϼ�ʱ��
	 * @param currentPage ��ʾ�����ĵ�ǰҳ��
	 * @param pageSize ÿҳ��ʾ��Ŀ
	 * @return Page
	 */
	public Page doPageByConditons(int superTypeId,int subTypeId,String searchMethod,String upLoadTime,int currentPage,int pageSize);
}
