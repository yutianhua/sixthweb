package com.lovo.cq.shopping10_1.dao;

import java.util.List;

import com.lovo.cq.shopping10_1.po.Inform;

public interface InformDao {
	//����ʱ������ʾ��Ӧ�Ĺ���
	public List showInformByInTime();
	//���ݹ����ID�õ��ù�����Ϣ
	public Inform getInformById(int infromId);
}
