package com.lovo.cq.shopping10_1.daoimpl;

import com.lovo.cq.shopping10_1.common.DbUtil;
import com.lovo.cq.shopping10_1.dao.OrderDao;
import com.lovo.cq.shopping10_1.po.Order;
import com.lovo.cq.shopping10_1.po.OrderItem;
import com.lovo.cq.shopping10_1.po.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

	/**
	 * ��Ӷ����������ض�һ������
	 * @param order һ������
	 * @return int  ����һ�����͵Ķ�����
	 */
	public int addOrder(Order order) {
		int orderId = 0;
		PreparedStatement pstmt_order = null; //���ڶԶ������в�����Ԥ�������
		PreparedStatement pstmt_item = null; //���ڶԶ�������в�����Ԥ�������
		ResultSet rs = null;
		DbUtil dbUtil = null;
		String sql_order = "insert into tb_order values(null,?,?,?,?,?,null,?)";
		try {
			//���ﴦ��
			dbUtil = new DbUtil();
			dbUtil.getCon().setAutoCommit(false);
			//�������е�����¼�����ݿ�
			pstmt_order = dbUtil.getCon().prepareStatement(sql_order);
			pstmt_order.setString(1, order.getUser().getName());
			pstmt_order.setString(2, order.getUser().getAddress());
			pstmt_order.setString(3, order.getRecvName());
			pstmt_order.setString(4, order.getUser().getPostcode());
			pstmt_order.setString(5, order.getUser().getEmail());
			pstmt_order.setInt(6,order.getFlag() );
			pstmt_order.executeUpdate();
			rs = pstmt_order.getGeneratedKeys();//ȡ������
			rs.next();
			orderId = rs.getInt(1); //����һ��������
			//���������е�����¼�����ݿ�
			String sql_item = "insert into tb_orderItem values(null,?,?,?,?,?)";
			pstmt_item = dbUtil.getCon().prepareStatement(sql_item);
			List orderItem = order.getOrderItem();//�õ����ж�����
			for(int i=0;i<orderItem.size();i++) {
				OrderItem orderItems = (OrderItem)orderItem.get(i);
				pstmt_item.setInt(1, orderId);
				pstmt_item.setInt(2, orderItems.getBookId());
				pstmt_item.setString(3, orderItems.getBookName());
				pstmt_item.setFloat(4, orderItems.getPrice());
				pstmt_item.setInt(5, orderItems.getBookNum());
				pstmt_item.addBatch();
			}
			pstmt_item.executeBatch();
			dbUtil.getCon().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				dbUtil.getCon().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				rs.close();
				pstmt_order.close();
				pstmt_item.close();
				dbUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return orderId;
	}
	//���ݵ�ǰ�û����û����鶩��
	public List selectOrder(String name) {
		List list = new ArrayList();
		Order or = null ;
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		ResultSet re = null;
		String sql = "select * from tb_order where name=?";	
		 try {
			pre = dao.getCon().prepareStatement(sql);
			pre.setString(1, name);
			  re =pre.executeQuery();
			  while(re.next()){
				  or = new Order ();
				  User user = new User();
					or.setOrderId(re.getInt("orderId"));
					user.setName(re.getString("name"));
					or.setRecvName(re.getString("recvName"));
					user.setAddress(re.getString("address"));
					user.setPostcode(re.getString("postcode"));
					user.setEmail(re.getString("email"));
					or.setUser(user);
				  or.setOrderDate(re.getString("orderDate"));
				  or.setFlag(re.getInt("flag"));
				  list.add(or);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// ���ݶ����Ų鶩����
	public List selectOrderItem(int id ) {
		List list = new ArrayList();
		OrderItem ordetrItem = null ;
		DbUtil dao = new DbUtil();
		PreparedStatement pre = null;
		ResultSet re = null;
		String sql = "select * from tb_orderItem where orderId = ? ";
		try{
		pre = dao.getCon().prepareStatement(sql);
		pre.setInt(1, id);
		  re =pre.executeQuery();
		  while(re.next()){
			  ordetrItem = new OrderItem();
			  ordetrItem.setBookId(re.getInt("bookId"));
			  ordetrItem.setBookName(re.getString("bookName"));
			  ordetrItem.setBookNum(re.getInt("bookNum"));
			  ordetrItem.setOrderId(re.getInt("orderId"));
			  ordetrItem.setOrderItemId(re.getInt("orderItemId"));
			  ordetrItem.setPrice(re.getFloat("price"));
			  list.add(ordetrItem);
		  }
		}catch (Exception e) {
		}
		return list;
	}
}
