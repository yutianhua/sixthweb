  create table tb_subType
  (
     subTypeId int primary key auto_increment,         
     superTypeId int,                              
     subTypeName varchar(50),                    
     foreign key(superTypeId) references tb_superType(superTypeId)      
  );
  
    insert into tb_subType values(null,1,'�������');
  	insert into tb_subType values(null,1,'���缼��');
  	insert into tb_subType values(null,1,'���������');
  	insert into tb_subType values(null,2,'�й���ѧ');
  	insert into tb_subType values(null,2,'�����ѧ');
  	insert into tb_subType values(null,3,'�ͻ�');
  	insert into tb_subType values(null,3,'ˮ��');
  	insert into tb_subType values(null,3,'���');