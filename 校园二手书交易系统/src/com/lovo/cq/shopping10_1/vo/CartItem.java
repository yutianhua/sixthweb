package com.lovo.cq.shopping10_1.vo;

import com.lovo.cq.shopping10_1.po.Book;

/**
 * ���ﳵ�еĹ������������Ʒ����Ʒ����
 */
public class CartItem {
	
	private Book book;
	
	private int count;//�������
	
	public CartItem(Book book){		
		this.book=book;
		count++;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	//����ĳһ��������ܼ�
	public float getItemPrice(){
		
		float price = book.getNowPrice()*count;
		return price;
	}
}
