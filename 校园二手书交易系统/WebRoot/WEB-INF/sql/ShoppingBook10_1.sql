���ݿ���Ϊ
create database ShoppingBook10_1;

1.�û���tb_user:
create table tb_user
(
	id int primary key auto_increment,   //�û�ID
    	name varchar(30) not null,            //�û���
    	password varchar(16) not null,        //����
	email varchar(50) not null,               //����
	trueName varchar(40) not null,           //�ǳ�
    	sex varchar(30),            //�Ա�
    	birthday varchar(20),        //����
	address varchar(100),           //סַ
	postcode varchar(10),           //�ʱ�
	phone varchar(15),             //�̶��绰
	mphone varchar(15),           //�ֻ�
   	 question varchar(30) not null,         //����
   	 answer varchar(30) not null,         //��
	img varchar(100) ,                  //�û�ͷ��
	 score int default 1000                //���� ��ʼ��Ϊ1000  �����û���д ϵͳ�Զ����
);
create table tb_user
(
	id int primary key auto_increment,  
    name varchar(30) not null,           
    password varchar(16) not null,        
	email varchar(50) not null,              
	trueName varchar(40) not null,           
    sex varchar(30),            
    birthday varchar(20),        
	address varchar(100),           
	postcode varchar(10),          
	phone varchar(15),          
	mphone varchar(15),          
   	question varchar(30) not null,        
   	answer varchar(30) not null,        
	img varchar(100) ,                 
	score int default 1000               
);
2.�����
create table tb_superType
  (
    superTypeId int primary key auto_increment,      //����Id
    typeName varchar(50)                        //������
  );
  
  create table tb_superType
  (
    superTypeId int primary key auto_increment,     
    typeName varchar(50)                       
  );

3.С���

create table tb_subType
  (
     subTypeId int primary key auto_increment,         //С��id
     superTypeId int,                              //����id
     subTypeName varchar(50),                     //С����
     foreign key(superTypeId) references tb_superType(superTypeId)        //�������
  );
  
  create table tb_subType
  (
     subTypeId int primary key auto_increment,         
     superTypeId int,                              
     subTypeName varchar(50),                    
     foreign key(superTypeId) references tb_superType(superTypeId)      
  );


4.���

  create table tb_book                 
(
  bookId int primary key auto_increment,     //���
  superTypeId int,                              //����ID                    
  subTypeId int,                                //С��ID                      
  bookName varchar(200),						//����
  ISBN varchar(20),                             //ISBN��  ��ˮ��
  introduce text,                               //�鱾���                             
  price float,                                  //ԭ��                          
  nowPrice float,                               //�ּ�                     
  picture varchar(200),  						//ͼƬ
  pages int,									//ҳ��
  publisher varchar(40),						//������
  author varchar(20),                           //����              
  inTime timestamp,                             //���ʱ��                         
  newBooks int,                                 //�Ƿ���Ʒ                    
  saleBooks int,                                //�Ƿ����Ʒ                    
  hostBooks int,                                //�Ƿ�����Ʒ  
  specialBooks int,                             //�Ƿ���������
  bookNum  int,                                 //�������                      
  foreign key(subTypeId ) references tb_subType(subTypeId),
  foreign key(superTypeId) references tb_superType (superTypeId)
 );

 create table tb_book                 
(
  bookId int primary key auto_increment,     
  superTypeId int,                                        
  subTypeId int,                                            
  bookName varchar(200),						
  ISBN varchar(20),                           
  introduce text,                                                     
  price float,                                                     
  nowPrice float,                                          
  picture varchar(200),  						
  pages int,									
  publisher varchar(40),						
  author varchar(20),                                  
  inTime timestamp,                                            
  newBooks int,                                          
  saleBooks int,                                               
  hostBooks int,                                
  specialBooks int,                            
  bookNum  int,                                               
  foreign key(subTypeId ) references tb_subType(subTypeId),
  foreign key(superTypeId) references tb_superType (superTypeId)
 );


5.������

  create table tb_order
  (
    orderId int primary key auto_increment,   //����id
name varchar(20),                    //�û���
realName varchar(20),                //��ʵ����
    address varchar(20),                  //��ϸסַ
    postcode varchar(10),                 //�ʱ�
    email varchar(20),                   //����
    orderDate timestamp,                //�¶���ʱ��
    flag int                           //�Ƿ񷢻� 0 δ���� 1 ���� 2 ���ﶳ��
  );
  
    create table tb_order
  (
    orderId int primary key auto_increment,   
	name varchar(20),                 
	realName varchar(20),              
    address varchar(20),                 
    postcode varchar(10),                
    email varchar(20),                   
    orderDate timestamp,                
    flag int                           
  );

6.������ϸ��Ϣ
create table tb_orderItem
  (
    orderItemId int primary key auto_increment,//������id 
    orderId int,                              //����id
    bookId int,                              //���
    bookName varchar(50),                   //����
    price float,                             //�۸�
    bookNum int,                          //�������
    foreign key(orderId) references tb_order(orderId),
    foreign key(bookId) references tb_book(bookId)
  );

create table tb_orderItem
  (
    orderItemId int primary key auto_increment,    
    orderId int,                            
    bookId int,                              
    bookName varchar(50),                 
    price float,                           
    bookNum int,                         
    foreign key(orderId) references tb_order(orderId),
    foreign key(bookId) references tb_book(bookId)
  );
7.���԰�

create table tb_note 
(
  id int primary key auto_increment,        //�û�id
  title varchar(20) not null ,               //����
  author varchar(20) not null ,             //�û���
  content varchar(50) not null ,             //����
  ly_time timestamp,                    //����ʱ��
  imgs varchar(50)                     //�û�ͷ��
);
create table tb_note 
(
  id int primary key auto_increment,       
  title varchar(20) not null ,              
  noteName varchar(20) not null ,            
  content varchar(50) not null ,            
  ly_time timestamp,                    
  imgs varchar(20)                     
);

