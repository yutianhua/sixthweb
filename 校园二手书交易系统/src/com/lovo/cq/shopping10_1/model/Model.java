package com.lovo.cq.shopping10_1.model;

import java.util.List;
import com.lovo.cq.shopping10_1.dao.BookDao;
import com.lovo.cq.shopping10_1.dao.OrderDao;
import com.lovo.cq.shopping10_1.dao.SubTypeDao;
import com.lovo.cq.shopping10_1.dao.SuperTypeDao;
import com.lovo.cq.shopping10_1.dao.UserDao;
import com.lovo.cq.shopping10_1.daoimpl.BookDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.OrderDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.SubTypeDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.SuperTypeDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.UserDaoImpl;
import com.lovo.cq.shopping10_1.po.Book;
import com.lovo.cq.shopping10_1.po.Note;
import com.lovo.cq.shopping10_1.po.Order;
import com.lovo.cq.shopping10_1.po.Page;
import com.lovo.cq.shopping10_1.po.User;

import java.util.Map;

import com.lovo.cq.shopping10_1.dao.AdminBookDao;
import com.lovo.cq.shopping10_1.dao.AdminInformDao;
import com.lovo.cq.shopping10_1.dao.AdminLoginDao;
import com.lovo.cq.shopping10_1.dao.AdminNoteDao;
import com.lovo.cq.shopping10_1.dao.AdminOrderDao;
import com.lovo.cq.shopping10_1.dao.AdminSubTypeDao;
import com.lovo.cq.shopping10_1.dao.AdminSuperTypeDao;
import com.lovo.cq.shopping10_1.dao.AdminUserDao;
import com.lovo.cq.shopping10_1.daoimpl.AdminBookDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.AdminInformDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.AdminLoginDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.AdminNoteDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.AdminOrderDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.AdminSubTypeDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.AdminSuperTypeDaoImpl;
import com.lovo.cq.shopping10_1.daoimpl.AdminUserDaoImpl;
import com.lovo.cq.shopping10_1.po.Admin;
import com.lovo.cq.shopping10_1.po.Book;
import com.lovo.cq.shopping10_1.po.BookPager;
import com.lovo.cq.shopping10_1.po.Inform;
import com.lovo.cq.shopping10_1.po.InformPager;
import com.lovo.cq.shopping10_1.po.NotePager;
import com.lovo.cq.shopping10_1.po.Order;
import com.lovo.cq.shopping10_1.po.OrderFreezePager;
import com.lovo.cq.shopping10_1.po.OrderNotSendPager;
import com.lovo.cq.shopping10_1.po.OrderPager;
import com.lovo.cq.shopping10_1.po.OrderSendPager;
import com.lovo.cq.shopping10_1.po.SubType;
import com.lovo.cq.shopping10_1.po.SuperType;
import com.lovo.cq.shopping10_1.po.UserPager;

public class Model {
	private UserDao ud = new UserDaoImpl();
	private BookDao bd = new BookDaoImpl();
	private OrderDao od = new OrderDaoImpl();
	private SuperTypeDao superDao = new SuperTypeDaoImpl();

	private SubTypeDao subDao = new SubTypeDaoImpl();

	public List showAllSuperType() {
		return superDao.showAllSuperType();
	}

	public List showAllSubTypeBySuperId(int superId) {
		return subDao.showAllSubTypeBySuperId(superId);
	}
	//�û�ע��
	public boolean addUser(User user) {
		return ud.addUser(user);
	}
	//�û���¼
	public User userLogin(String name,String password) {
		return ud.userLogin(name,password);
	}
	//����û����Ƿ����
	public boolean checkNameExist(String name){
		return ud.checkNameExist(name);
	}
	//�û�����ҳ��
	public List listUser() {
		return ud.listUser();
	}
	//��ҳ��ʾ�û�
//	public Page doPage(int currentPage,int pageSize){
//		return ud.doPage(currentPage, pageSize);
//	}
	//����IDɾ���û�
	public boolean delete(int id,String powerType){
		return ud.delete(id,powerType);
	}
	//����ID�����û�Ȩ��
	public boolean changePower(int id,String powerType){
		return ud.changePower(id,powerType);
	}
	//	 �����û�������ȡ��Ȩ��
	public String getPower(String name){
		return ud.getPower(name);
	}
	//�����û������ҵ����û�
	public User getUser(String name){
		return ud.getUser(name);
	}
	//��ʾ�鼮
	public List showBooks(int type,int flag) {
		return bd.showBooks(type, flag);
	}
	//�����鼮��bookId����ʾ�鼮����ϸ��Ϣ
	public Book showBookById(int bookId){
		return bd.showBookById(bookId);
	}
	//��Ӷ����������ض�һ������
	public int addOrder(Order order){
		return od.addOrder(order);
	}
	//��ҳ��ʾ�鼮
	public Page doPage(int type,int currentPage,int pageSize){
		return bd.doPage(type,currentPage, pageSize);
	}
	//����������Ĺؼ�����������鼮
	public List searchBooks(String keywords){
		return bd.searchBooks(keywords);
	}
	/**
	 * ��ҳ��ʾ�鼮
	 * @param currentPage ��ʾ�����ĵ�ǰҳ��
	 * @param pageSize ÿҳ��ʾ��Ŀ
	 * @return Page
	 */
	public Page doPage(String keywords,int currentPage,int pageSize){
		return bd.doPage(keywords, currentPage, pageSize);
	}
	//��ʾ�����û�����
	public List showNote(){
		return ud.showNote();
	}
	/**
	 * ��ҳ��ʾ�����û�����
	 * @param currentPage ��ʾ�����ĵ�ǰҳ��
	 * @param pageSize ÿҳ��ʾ��Ŀ
	 * @return Page
	 */
	public Page doNotePage(int currentPage,int pageSize){
		return ud.doNotePage(currentPage, pageSize);
	}
	//�û��������
	public boolean addNote(Note note){
		return ud.addNote(note);
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
		return bd.searchBooksByConditions(superTypeId, subTypeId, searchMethod, upLoadTime);
	}
	/**
	 * �����û�ѡ�������������������鼮
	 * @param superTypeId ���������ID
	 * @param subTypeId ����С���ID
	 * @param searchMethod �������ǰ����ߡ������������硢ISBN���۸��е�һ����
	 * @param upLoadTime �鼮�ϼ�ʱ��
	 */
	public Page doPageByConditons(int superTypeId,int subTypeId,String searchMethod,String upLoadTime,int currentPage,int pageSize){
		return bd.doPageByConditons(superTypeId, subTypeId, searchMethod, upLoadTime, currentPage, pageSize);
	}
	
	
	
	/**
	 * 
	 * ��̨����
	 */


	private AdminUserDao userDao = new AdminUserDaoImpl();
	private AdminSubTypeDao subTypeDao = new AdminSubTypeDaoImpl();
	private AdminSuperTypeDao superTypeDao = new AdminSuperTypeDaoImpl();
	private AdminBookDao bookDao = new AdminBookDaoImpl();
	private AdminNoteDao noteDao = new AdminNoteDaoImpl();
	private AdminLoginDao adminLoginDao = new AdminLoginDaoImpl();
	private AdminInformDao adminInformDao = new AdminInformDaoImpl();
	private AdminOrderDao adminOrderDao = new AdminOrderDaoImpl();
	
	public Map getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public boolean deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}
	
	public boolean deleteUsers(int[] ids) {
		return userDao.deleteUsers(ids);
	}
	
	public UserPager getUserPager(int index, int pageSize) {
		return userDao.getUserPager(index, pageSize);
	}
	
	public List getSubTypeBySuperTypeId(int superTypeId) {
		return subTypeDao.getSubTypeBySuperTypeId(superTypeId);
	}
	
	public boolean addSubType(SubType type) {
		return subTypeDao.addSubType(type);
	}
	public boolean checkSubTypeIsExist(String subTypeName) {
		return subTypeDao.checkSubTypeIsExist(subTypeName);
	}
	
	public List getSuperType() {
		return superTypeDao.getSuperType();
	}
	
	public boolean addSuperType(SuperType type) {
		return superTypeDao.addSuperType(type);
	}
	public boolean checkSuperTypeIsExist(String superTypeName) {
		return superTypeDao.checkSuperTypeIsExist(superTypeName);
	}
	
	public List getAllBooks() {
		return bookDao.getAllBooks();
	}
	
	public boolean addBook(Book book) {
		return bookDao.addBook(book);
	}
	
	public boolean checkBookNameIsExist(String bookName) {
		return bookDao.checkBookNameIsExist(bookName);
	}

	public boolean checkISBNIsExist(String ISBN) {
		return bookDao.checkISBNIsExist(ISBN);
	}
	
	public BookPager searchBook(String bookName) {
		return bookDao.searchBook(bookName);
	}

	public List getAllBookName() {
		return bookDao.getAllBookName();
	}
	public BookPager getBookPager(int index,int pageSize) {
		return bookDao.getBookPager(index, pageSize);
	}
	public boolean deleteBook(int[] bookIds) {
		return bookDao.deleteBook(bookIds);
	}
	
	public List getAllNotes() {
		return noteDao.getAllNotes();
	}
	public boolean deleteNote(int[] ids) {
		return noteDao.deleteNote(ids);
	}
	public NotePager getNotePager(int index, int pageSize) {
		return noteDao.getNotePager(index, pageSize);
	}
	
	public boolean login(Admin admin) {
		return adminLoginDao.login(admin);
	}
	public boolean updatePassword(Admin admin) {
		return adminLoginDao.updatePassword(admin);
	}
	
	public boolean addInform(Inform inform) {
		return adminInformDao.addInform(inform);
	}
	
	public List getAllInform() {
		return adminInformDao.getAllInform();
	}
	
	public boolean deleteInform(int[] ids) {
		return adminInformDao.deleteInform(ids);
	}
	
	public Inform getOneInform(int id) {
		return adminInformDao.getOneInform(id);
	}
	public InformPager getInformPager(int index, int pageSize) {
		return adminInformDao.getInformPager(index, pageSize);
	}
	
	public List getAllOrder() {
		return adminOrderDao.getAllOrder();
	}
	public Order getOneOrder(int id) {
		return adminOrderDao.getOneOrder(id);
	}
	
	public List getNotSendOrder(int flag) {
		return adminOrderDao.getNotSendOrder(flag);
	}

	public List getSendOrder(int flag) {
		return adminOrderDao.getSendOrder(flag);
	}

	public boolean SendOrder(int[] orderids) {
		return adminOrderDao.SendOrder(orderids);
	}
	public OrderPager getOrderPager(int index, int pageSize) {
		return adminOrderDao.getOrderPager(index, pageSize);
	}
	public OrderSendPager getOrderSendPager(int index, int pageSize) {
		return adminOrderDao.getOrderSendPager(index, pageSize);
	}
	public boolean deleteOrder(int[] ids) {
		return adminOrderDao.deleteOrder(ids);
	}
	public OrderNotSendPager getOrderNotSendPager(int index, int pageSize) 

	{
		return adminOrderDao.getOrderNotSendPager(index, pageSize);
	}
	public OrderFreezePager getOrderFreezePager(int index,int pageSize) {
		return adminOrderDao.getOrderFreezePager(index, pageSize);
	}
	public boolean freezeOrder(int[] orderids) {
		return adminOrderDao.freezeOrder(orderids);
	}
	
	//���ݵ�ǰ�û����û����鶩��
	public List selectOrder(String name){
		return od.selectOrder(name);
	}
	//���ݶ����Ų鶩����
	public List selectOrderItem(int id ){
		return od.selectOrderItem(id);
	}
	/* �û������� */
	public Boolean loggin(String name, String password){
		return ud.loggin(name, password);
	}
	/* ���ڲ�ѯ��Ա�ĸ�����Ϣ���� */
	public User SelectOneUser(String name){
		return ud.SelectOneUser(name);
	}
	 /* �����޸��û��ĸ������� */
	public Boolean updatePassword(String name, String password){
		return ud.updatePassword(name, password);
	}

	/* �������ƻ�Ա�� �������� */
	public Boolean updateUser(User user) {
		return ud.updateUser(user);
	}
}
