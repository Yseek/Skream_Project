//MEMBER

insert into MEMBER values('abc1@naver.com', '�����1', '1990/01/01','010-1111-1111','1234',now(),now());
insert into MEMBER values('abc2@naver.com', '�����2', '1991/01/01','010-2222-2222','1234',now(),now());
insert into MEMBER values('abc3@naver.com', '�����3', '1992/01/01','010-3333-3333','1234',now(),now());

//CATEGORY

insert into CATEGORY values(1, '����Ű');
insert into CATEGORY values(2, '�Ƶ�ٽ�');
insert into CATEGORY values(3, '���߶���');

//BOARD

insert into BOARD values(null,'����1','����1',now(),now(),1,1,1,'abc1@naver.com');
insert into BOARD values(null,'����2','����2',now(),now(),1,1,1,'abc1@naver.com');
insert into BOARD values(null,'����3','����3',now(),now(),1,1,2,'abc2@naver.com');
insert into BOARD values(null,'����4','����4',now(),now(),1,1,2,'abc2@naver.com');
insert into BOARD values(null,'����5','����5',now(),now(),1,1,3,'abc3@naver.com');
insert into BOARD values(null,'����6','����6',now(),now(),1,1,3,'abc3@naver.com');

//FILEUP

insert into FILEUP values(null,'�������ϸ�1','�������ϸ�1','������1');
insert into FILEUP values(null,'�������ϸ�2','�������ϸ�2','������2');
insert into FILEUP values(null,'�������ϸ�3','�������ϸ�3','������3');
insert into FILEUP values(null,'�������ϸ�4','�������ϸ�4','������4');
insert into FILEUP values(null,'�������ϸ�5','�������ϸ�5','������5');
insert into FILEUP values(null,'�������ϸ�6','�������ϸ�6','������6');


//BOARDFILE

insert into BOARDFILE values(1,1,null);
insert into BOARDFILE values(2,2,null);
insert into BOARDFILE values(3,3,null);
insert into BOARDFILE values(4,4,null);
insert into BOARDFILE values(5,5,null);
insert into BOARDFILE values(6,6,null);