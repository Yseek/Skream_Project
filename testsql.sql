//MEMBER

insert into MEMBER values('abc1@naver.com', '사용자1', '1990/01/01','010-1111-1111','1234',now(),now());
insert into MEMBER values('abc2@naver.com', '사용자2', '1991/01/01','010-2222-2222','1234',now(),now());
insert into MEMBER values('abc3@naver.com', '사용자3', '1992/01/01','010-3333-3333','1234',now(),now());

//CATEGORY

insert into CATEGORY values(1, '나이키');
insert into CATEGORY values(2, '아디다스');
insert into CATEGORY values(3, '뉴발란스');

//BOARD

insert into BOARD values(null,'제목1','내용1',now(),now(),1,1,1,'abc1@naver.com');
insert into BOARD values(null,'제목2','내용2',now(),now(),1,1,1,'abc1@naver.com');
insert into BOARD values(null,'제목3','내용3',now(),now(),1,1,2,'abc2@naver.com');
insert into BOARD values(null,'제목4','내용4',now(),now(),1,1,2,'abc2@naver.com');
insert into BOARD values(null,'제목5','내용5',now(),now(),1,1,3,'abc3@naver.com');
insert into BOARD values(null,'제목6','내용6',now(),now(),1,1,3,'abc3@naver.com');

//FILEUP

insert into FILEUP values(null,'원본파일명1','저장파일명1','저장경로1');
insert into FILEUP values(null,'원본파일명2','저장파일명2','저장경로2');
insert into FILEUP values(null,'원본파일명3','저장파일명3','저장경로3');
insert into FILEUP values(null,'원본파일명4','저장파일명4','저장경로4');
insert into FILEUP values(null,'원본파일명5','저장파일명5','저장경로5');
insert into FILEUP values(null,'원본파일명6','저장파일명6','저장경로6');


//BOARDFILE

insert into BOARDFILE values(1,1,null);
insert into BOARDFILE values(2,2,null);
insert into BOARDFILE values(3,3,null);
insert into BOARDFILE values(4,4,null);
insert into BOARDFILE values(5,5,null);
insert into BOARDFILE values(6,6,null);