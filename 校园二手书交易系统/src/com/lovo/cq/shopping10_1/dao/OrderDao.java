package com.lovo.cq.shopping10_1.dao;

import java.util.List;

import com.lovo.cq.shopping10_1.po.Order;

/**
 * �Զ������в����Ľӿ� 
 */
public interface OrderDao {
	
	//��Ӷ����������ض�һ������
	public int addOrder(Order order);
	//���ݵ�ǰ�û����û����鶩��
	public List selectOrder(String name);
	//�鶩����
	public List selectOrderItem(int id);
}
