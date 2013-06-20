package com.lovo.cq.shopping10_1.dao;

import java.util.List;

import com.lovo.cq.shopping10_1.po.Note;
import com.lovo.cq.shopping10_1.po.Page;
import com.lovo.cq.shopping10_1.po.User;

public interface UserDao {
	//�û�ע��
	public boolean addUser(User user);
	//�û���¼
	public User userLogin(String name,String password);
	//����û��Ƿ����
	public boolean checkNameExist(String name);
	//��ʾ�����û�
	public List listUser();
	//��ҳ��ʾ�û�
	public Page doPage(int currentPage,int pageSize);
	
	
	//����IDɾ���û�
	public boolean delete(int id,String powerType);
	//����ID�����û�Ȩ��
	public boolean changePower(int id,String powerType);
	//�����û�������ȡ��Ȩ��
	public String getPower(String name);
	//�����û������ҵ����û�
	public User getUser(String name);
	//��ʾ�����û�������
	public List showNote();
	//��ҳ��ʾ�û�����
	public Page doNotePage(int currentPage,int pageSize);
	//�û��������
	public boolean addNote(Note note);
	
	

	/*���ڲ�ѯ��Ա�ĸ�����Ϣ���� */
	public User SelectOneUser(String name);
	
	/*�����޸��û��ĸ������� */
	public Boolean updatePassword(String name, String password);
	
	/*�������ƻ�Ա�� ��������*/
	public Boolean updateUser(User user);
	/* �û������� */
	public Boolean loggin(String name, String password);
	
	
}
