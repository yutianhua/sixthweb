package com.lovo.cq.shopping10_1.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lovo.cq.shopping10_1.common.DbUtil;
import com.lovo.cq.shopping10_1.dao.BookDao;
import com.lovo.cq.shopping10_1.po.Book;
import com.lovo.cq.shopping10_1.po.Page;
import com.lovo.cq.shopping10_1.po.User;

public class BookDaoImpl implements BookDao {
	/**
	 * ��ʾ�鼮
	 * @param type ��ʾ������������飬����,�ر��Ƽ���
	 * @param flag ��ʾ�Ƿ��ǣ����������飬���ۣ�
	 */
	public List showBooks(int type,int flag){
		List all = new ArrayList();
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		ResultSet rs = null;
		String sql = null;
		if(type==0){
			//��ʾ�����鼮
			sql = "select * from tb_book";
			try {
				dbUtil = new DbUtil();
				pstmt = dbUtil.getCon().prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Book book = new Book();
					book.setBookId(rs.getInt("bookId"));
					book.setBookName(rs.getString("bookName"));
					book.setISBN(rs.getString("ISBN"));
					book.setPages(rs.getInt("pages"));
					book.setAuthor(rs.getString("author"));
					book.setPublisher(rs.getString("publisher"));
					book.setIntroduce(rs.getString("introduce"));
					book.setPrice(rs.getFloat("price"));
					book.setNowPrice(rs.getFloat("nowPrice"));
					book.setPicture(rs.getString("picture"));
					all.add(book);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();
					dbUtil.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else {
		if(type==1) {
			//�����鼮
		    sql = "select * from tb_book where hostBooks=?";
		}
		if(type==2){
			//�µ��鼮
			sql = "select * from tb_book where newBooks=?";
		}
		if(type==3){
			//�����鼮
			sql = "select * from tb_book where saleBooks=?";
		}
		if(type==4){
			//�ر��Ƽ�
			sql = "select * from tb_book where specialBooks=?";
		}
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setInt(1, flag);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setISBN(rs.getString("ISBN"));
				book.setPages(rs.getInt("pages"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setIntroduce(rs.getString("introduce"));
				book.setPrice(rs.getFloat("price"));
				book.setNowPrice(rs.getFloat("nowPrice"));
				book.setPicture(rs.getString("picture"));
				all.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
		return all;
	}
	/**
	 * �������BookId����չʾ�������ϸ��Ϣ
	 * @param bookId �鼮��
	 * @return Book
	 */
	public Book showBookById(int bookId){
		Book book = new Book();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from tb_book where bookId=?";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setInt(1, bookId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setIntroduce(rs.getString("introduce"));
				book.setISBN(rs.getString("ISBN"));
				book.setAuthor(rs.getString("author"));
				book.setPages(rs.getInt("pages"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getFloat("price"));
				book.setNowPrice(rs.getFloat("nowPrice"));
				book.setPicture(rs.getString("picture"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;
	}
	/**
	 *	���鱾��Ϣ¼�����ݿ� 
	 */
	public boolean addBook(Book book){
		boolean flag = false;
		PreparedStatement pstmt = null;
		DbUtil dbUtil = null;
		String sql = "insert into tb_book values(null,?,?,?,?,?,?,?,?,?,?,?,null,?,?,?,?)";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			pstmt.setInt(1, book.getSuperTypeId());
			pstmt.setInt(2, book.getSubTypeId());
			pstmt.setString(3, book.getBookName());
			pstmt.setString(4, book.getISBN());
			pstmt.setString(5, book.getIntroduce());
			pstmt.setFloat(6, book.getPrice());
			pstmt.setFloat(7, book.getNowPrice());
			pstmt.setString(8, book.getPicture());
			pstmt.setInt(9, book.getPages());
			pstmt.setString(10, book.getPublisher());
			pstmt.setString(11, book.getAuthor());
			pstmt.setInt(12, book.getNewBooks());
			pstmt.setInt(13, book.getSaleBooks());
			pstmt.setInt(14, book.getHostBooks());
			pstmt.setInt(15, book.getBookNum());
			int i = pstmt.executeUpdate();
			if(i != 0){
				//�����鼮�ɹ�
				return flag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * ��ҳ��ʾ�鼮
	 * @param type ��Ҫ����ʾ��Ӧ���鼮
	 * @param currentPage ��ʾ�����ĵ�ǰҳ��
	 * @param pageSize ÿҳ��ʾ��Ŀ
	 * @return Page
	 */
	public Page doPage(int type,int currentPage,int pageSize){
		Page page = new Page();
		System.out.println("pagetype="+type);
		int totalNum = showBooks(type,1).size();
		System.out.println("totalNum"+totalNum);
		List pageList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = null;
		if(type==0){//��ʾ�����鼮
			sql = "select * from tb_book limit "+currentPage+","+pageSize;
		}
		if(type==1) {
			//�����鼮
		    sql = "select * from tb_book where hostBooks=1 limit "+currentPage+","+pageSize;
		}
		if(type==2){
			//�µ��鼮
			sql = "select * from tb_book where newBooks=1 limit "+currentPage+","+pageSize;
		}
		if(type==3){
			//�����鼮
			sql = "select * from tb_book where saleBooks=1 limit "+currentPage+","+pageSize;
		}
		if(type==4){
			//�ر��Ƽ�
			sql = "select * from tb_book where specialBooks=1 limit "+currentPage+","+pageSize;
		}
		System.out.println("sql="+sql);
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
			    book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setPicture(rs.getString("picture"));
				book.setPrice(rs.getFloat("price"));
				book.setNowPrice(rs.getFloat("nowPrice"));
				pageList.add(book);
			}
			System.out.println("pageList="+pageList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		page.setPageList(pageList);
		page.setTotalNum(totalNum);
		return page;
	}
	/**
	 * �����û�����Ĺؼ�����������鼮
	 * @param keywords �û�����Ĺؼ��� 
	 */
	public List searchBooks(String keywords){
		List searchList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from tb_book where bookName like '%"+keywords+"%'";
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				//������鼮
				while(rs.next()){
					Book book = new Book();
					book.setBookName(rs.getString("bookName"));
					book.setPicture(rs.getString("picture"));
					searchList.add(book);
				}	
			}else{
				//û���ҵ�����鼮
				throw new NoRelativeBooksException("û�������������ҵ�����鼮����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;
	}
	/**
	 * ��ҳ��ʾ�鼮
	 * @param currentPage ��ʾ�����ĵ�ǰҳ��
	 * @param pageSize ÿҳ��ʾ��Ŀ
	 * @return Page
	 */
	public Page doPage(String keywords,int currentPage,int pageSize){
		Page page = new Page();
		int totalNum = searchBooks(keywords).size();
		System.out.println("totalNum="+totalNum);
		List pageList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = "select * from tb_book where bookName like '%"+keywords+"%' limit "+currentPage+","+pageSize;
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setPicture(rs.getString("picture"));
				book.setPrice(rs.getFloat("price"));
				book.setNowPrice(rs.getFloat("nowPrice"));
				pageList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		page.setPageList(pageList);
		page.setTotalNum(totalNum);
		return page;
	}
	/**
	 * �����û�ѡ�������������������鼮
	 * @param superTypeId ���������ID
	 * @param subTypeId ����С���ID
	 * @param searchMethod �������ǰ����ߡ������������硢ISBN���۸��е�һ����
	 * @param upLoadTime �鼮�ϼ�ʱ��
	 * @return List
	 */
	public List searchBooksByConditions(int superTypeId,int subTypeId,String searchMethod,String upLoadTime){
		List bookList = new ArrayList();
		String str[] = searchMethod.split("=");
		System.out.println("str[0]="+str[0]+",str[1]="+str[1]);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = null;
		String upLoadDate = null;//��ֹ����
		String nowDate = null;//��������
		float priceLow = 0l;//�۸���ͼ�
		int dateLow = 0;//�ʱ��
		float priceLower = 0l;//�۸��½�
		float priceTop = 0l;//�۸��Ͻ�
		if(str[0].equals("price")){//ѡ���˰��۸��ѯ��ʽ
			if(str[1].equals("����200")){
				priceLow = 200l;
				if(upLoadTime.equals("����30")){
					dateLow = 30;
					upLoadDate = this.getDate(dateLow);
					nowDate = this.getNowDate();
					System.out.println("nowDate="+nowDate);
					System.out.println("upLoadDate"+upLoadDate);
					//�۸����200��ʱ�����һ����
					sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+" >?";
				}else {
					//�۸����200��ʱ��û��һ����
					dateLow = Integer.parseInt(upLoadTime);
					upLoadDate = this.getDate(dateLow);
					nowDate = this.getNowDate();
					System.out.println("nowDate="+nowDate);
					System.out.println("upLoadDate"+upLoadDate);
					sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+" >? and inTime between ? and ?";
				}
			}else{
				priceLower = Float.parseFloat(str[1].split("-")[0]);
				priceTop = Float.parseFloat(str[1].split("-")[1]);
				if(upLoadTime.equals("����30")){
					//�۸�С��200��ʱ�����30
					dateLow = 30;
					upLoadDate = this.getDate(dateLow);
					nowDate = this.getNowDate();
					System.out.println("nowDate="+nowDate);
					sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+" between ? and ?";
				}else {
					//�۸�С��200��ʱ��û��һ����
					dateLow = Integer.parseInt(upLoadTime);
					upLoadDate = this.getDate(dateLow);
					nowDate = this.getNowDate();
					System.out.println("nowDate="+nowDate);
					System.out.println("upLoadDate"+upLoadDate);
					sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+" between ? and ? and inTime between ? and ?";
				}
			}	
		}else {//ѡ�����������ѯ��ʽ
			if(upLoadTime.equals("����30")){
				dateLow = 30;
				upLoadDate = this.getDate(dateLow);
				nowDate = this.getNowDate();
				System.out.println("nowDate="+nowDate);
				//ʱ�����һ����
				sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+"=?";
			}else {
				//ʱ��û��һ����
				dateLow = Integer.parseInt(upLoadTime);
				upLoadDate = this.getDate(dateLow);
				nowDate = this.getNowDate();
				System.out.println("nowDate="+nowDate);
				System.out.println("upLoadDate="+upLoadDate);
				sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+"=? and inTime between ? and ?";
			}
		}
		System.out.println("sql="+sql);
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			if(str[0].equals("price")&& str[1].equals("����200")&&upLoadTime.equals("����30")){//���۸��ѯ���۸����200��ʱ�����һ����
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setFloat(3, priceLow);
			}
			if(str[0].equals("price")&& str[1].equals("����200")&&!upLoadTime.equals("����30")){//���۸��ѯ���۸����200��ʱ��С��һ����
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setFloat(3, priceLow);
				pstmt.setString(4, upLoadDate);
				pstmt.setString(5, nowDate);
			}
			if(str[0].equals("price")&& !str[1].equals("����200")&&upLoadTime.equals("����30")){//���۸��ѯ���۸�С��200��ʱ�����һ����
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setFloat(3, priceLower);
				pstmt.setFloat(4, priceTop);
			}
			if(str[0].equals("price")&& !str[1].equals("����200")&&!upLoadTime.equals("����30")){//���۸��ѯ���۸�С��200��ʱ��С��һ����
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setFloat(3, priceLower);
				pstmt.setFloat(4, priceTop);
				pstmt.setString(5, upLoadDate);
				pstmt.setString(6, nowDate);
			}
			if(!str[0].equals("price")&& upLoadTime.equals("����30")){//���Ǽ۸�ʽ��ѯ��ʱ�����30��
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setString(3, str[1]);
			}
			if(!str[0].equals("price")&& !upLoadTime.equals("����30")){//���Ǽ۸�ʽ��ѯ��ʱ��С��30��
				System.out.println("���Ǽ۸�ʽ��ѯ��ʱ��С��30��");
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setString(3, str[1]);
				pstmt.setString(4, upLoadDate);
				pstmt.setString(5, nowDate);
			}
			rs = pstmt.executeQuery();
			if(rs.next()){
				//������鼮
				while(rs.next()){
					Book book = new Book();
					book.setBookName(rs.getString("bookName"));
					book.setPicture(rs.getString("picture"));
					bookList.add(book);
				}	
			}else{
				//û���ҵ�����鼮
				throw new NoRelativeBooksException("û�������������ҵ�����鼮����");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookList;
	}
	/**
	 * �����û�ѡ�������������������鼮
	 * @param superTypeId ���������ID
	 * @param subTypeId ����С���ID
	 * @param searchMethod �������ǰ����ߡ������������硢ISBN���۸��е�һ����
	 * @param upLoadTime �鼮�ϼ�ʱ��
	 */
	public Page doPageByConditons(int superTypeId,int subTypeId,String searchMethod,String upLoadTime,int currentPage,int pageSize){
		Page page = new Page();
		String str[] = searchMethod.split("=");
		int totalNum = searchBooksByConditions(superTypeId,subTypeId,searchMethod,upLoadTime).size();
		System.out.println("totalNum"+totalNum);
		List pageList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql = null;
		String upLoadDate = null;//��ֹ����
		String nowDate = null;//��������
		float priceLow = 0l;//�۸���ͼ�
		int dateLow = 0;//�ʱ��
		float priceLower = 0l;//�۸��½�
		float priceTop = 0l;//�۸��Ͻ�
		if(str[0].equals("price")){//ѡ���˰��۸��ѯ��ʽ
			if(str[1].equals("����200")){
				priceLow = 200l;
				if(upLoadTime.equals("����30")){
					dateLow = 30;
					upLoadDate = this.getDate(dateLow);
					nowDate = this.getNowDate();
					System.out.println("nowDate="+nowDate);
					System.out.println("upLoadDate"+upLoadDate);
					//�۸����200��ʱ�����һ����
					sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+" >?";
				}else {
					//�۸����200��ʱ��û��һ����
					dateLow = Integer.parseInt(upLoadTime);
					upLoadDate = this.getDate(dateLow);
					nowDate = this.getNowDate();
					System.out.println("nowDate="+nowDate);
					System.out.println("upLoadDate"+upLoadDate);
					sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+" >? and inTime between ? and ?";
				}
			}else{
				priceLower = Float.parseFloat(str[1].split("-")[0]);
				priceTop = Float.parseFloat(str[1].split("-")[1]);
				if(upLoadTime.equals("����30")){
					//�۸�С��200��ʱ�����30
					dateLow = 30;
					upLoadDate = this.getDate(dateLow);
					nowDate = this.getNowDate();
					System.out.println("nowDate="+nowDate);
					sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+" between ? and ?";
				}else {
					//�۸�С��200��ʱ��û��һ����
					dateLow = Integer.parseInt(upLoadTime);
					upLoadDate = this.getDate(dateLow);
					nowDate = this.getNowDate();
					System.out.println("nowDate="+nowDate);
					System.out.println("upLoadDate"+upLoadDate);
					sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+" between ? and ? and inTime between ? and ?";
				}
			}	
		}else {//ѡ�����������ѯ��ʽ
			if(upLoadTime.equals("����30")){
				dateLow = 30;
				upLoadDate = this.getDate(dateLow);
				nowDate = this.getNowDate();
				System.out.println("nowDate="+nowDate);
				//ʱ�����һ����
				sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+"=?";
			}else {
				//ʱ��û��һ����
				dateLow = Integer.parseInt(upLoadTime);
				upLoadDate = this.getDate(dateLow);
				nowDate = this.getNowDate();
				System.out.println("nowDate="+nowDate);
				System.out.println("upLoadDate"+upLoadDate);
				sql = "select * from tb_book where superTypeId=? and subTypeId=? and "+str[0]+"=? and inTime between ? and ?";
			}
		}
		System.out.println("sql="+sql);
		try {
			dbUtil = new DbUtil();
			pstmt = dbUtil.getCon().prepareStatement(sql);
			if(str[0].equals("price")&& str[1].equals("����200")&&upLoadTime.equals("����30")){//���۸��ѯ���۸����200��ʱ�����һ����
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setFloat(3, priceLow);
			}
			if(str[0].equals("price")&& str[1].equals("����200")&&!upLoadTime.equals("����30")){//���۸��ѯ���۸����200��ʱ��С��һ����
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setFloat(3, priceLow);
				pstmt.setString(4, upLoadDate);
				pstmt.setString(5, nowDate);
			}
			if(str[0].equals("price")&& !str[1].equals("����200")&&upLoadTime.equals("����30")){//���۸��ѯ���۸�С��200��ʱ�����һ����
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setFloat(3, priceLower);
				pstmt.setFloat(4, priceTop);
			}
			if(str[0].equals("price")&& !str[1].equals("����200")&&!upLoadTime.equals("����30")){//���۸��ѯ���۸�С��200��ʱ��С��һ����
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setFloat(3, priceLower);
				pstmt.setFloat(4, priceTop);
				pstmt.setString(5, upLoadDate);
				pstmt.setString(6, nowDate);
			}
			if(!str[0].equals("price")&& upLoadTime.equals("����30")){//���Ǽ۸�ʽ��ѯ��ʱ�����30��
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setString(3, str[1]);
			}
			if(!str[0].equals("price")&& !upLoadTime.equals("����30")){//���Ǽ۸�ʽ��ѯ��ʱ��С��30��
				pstmt.setInt(1, superTypeId);
				pstmt.setInt(2, subTypeId);
				pstmt.setString(3, str[1]);
				pstmt.setString(4, upLoadDate);
				pstmt.setString(5, nowDate);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setPicture(rs.getString("picture"));
				book.setPrice(rs.getFloat("price"));
				book.setNowPrice(rs.getFloat("nowPrice"));
				book.setInTime(rs.getString("inTime"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				pageList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		page.setPageList(pageList);
		page.setTotalNum(totalNum);
		return page;
	}
	
	//��ȡҪ��ѯ�Ľ�ֹ����
	public String getDate(int days){
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		long dates = new Date().getTime()-days*24*60*60*1000;
		String date = myFormatter.format(dates);
		return date;
	}
	//��ȡ���ڵ�����
	public String getNowDate(){
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String date = myFormatter.format(new Date());
		return date;
	}
}
