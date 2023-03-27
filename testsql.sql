
insert into MEMBER values('abc1@naver.com', '사용자1', '1990/01/01','010-1111-1111','1234',now(),now());
insert into MEMBER values('abc2@naver.com', '사용자2', '1991/01/01','010-2222-2222','1234',now(),now());
insert into MEMBER values('abc3@naver.com', '사용자3', '1992/01/01','010-3333-3333','1234',now(),now()); 


insert into CATEGORY values(1, '나이키');
insert into CATEGORY values(2, '아디다스');
insert into CATEGORY values(3, '뉴발란스');


insert into BOARD values(null,'제목1','내용1',now(),now(),1,1,1,'abc1@naver.com');
insert into BOARD values(null,'제목2','내용2',now(),now(),1,1,1,'abc1@naver.com');
insert into BOARD values(null,'제목3','내용3',now(),now(),1,1,2,'abc2@naver.com');
insert into BOARD values(null,'제목4','내용4',now(),now(),1,1,2,'abc2@naver.com');
insert into BOARD values(null,'제목5','내용5',now(),now(),1,1,3,'abc3@naver.com');
insert into BOARD values(null,'제목6','내용6',now(),now(),1,1,3,'abc3@naver.com');
insert into BOARD values(null,'제목7','내용7',now(),now(),4,4,3,'abc3@naver.com');
insert into BOARD values(null,'제목8','내용8',now(),now(),3,2,3,'abc3@naver.com');
insert into BOARD values(null,'제목9','내용9',now(),now(),2,4,3,'abc3@naver.com');
insert into BOARD values(null,'제목10','내용10',now(),now(),5,6,3,'abc3@naver.com');
insert into BOARD values(null,'제목1','내용1',now(),now(),10,2,1,'abc1@naver.com');
insert into BOARD values(null,'제목1','내용1',now(),now(),2,4,3,'abc1@naver.com');
insert into BOARD values(null,'제목1','내용1',now(),now(),40,10,2,'abc1@naver.com');
insert into BOARD values(null,'제목1','내용1',now(),now(),20,5,1,'abc1@naver.com');


insert into FILEUP values(null,'원본파일명1','저장파일명1','저장경로1');
insert into FILEUP values(null,'원본파일명2','저장파일명2','저장경로2');
insert into FILEUP values(null,'원본파일명3','저장파일명3','저장경로3');
insert into FILEUP values(null,'원본파일명4','저장파일명4','저장경로4');
insert into FILEUP values(null,'원본파일명5','저장파일명5','저장경로5');
insert into FILEUP values(null,'원본파일명6','저장파일명6','저장경로6');
insert into FILEUP values(null,'원본파일명7','저장파일명7','저장경로7');
insert into FILEUP values(null,'원본파일명8','저장파일명8','저장경로8');
insert into FILEUP values(null,'원본파일명9','저장파일명9','저장경로9');
insert into FILEUP values(null,'원본파일명10','저장파일명10','저장경로10');
insert into FILEUP values(null,'원본파일명11','저장파일명11','저장경로11');
insert into FILEUP values(null,'원본파일명12','저장파일명12','저장경로12');
insert into FILEUP values(null,'원본파일명13','저장파일명13','저장경로13');
insert into FILEUP values(null,'원본파일명14','저장파일명14','저장경로14');
insert into FILEUP values(null,'원본파일명15','저장파일명15','저장경로15');



insert into BOARDFILE values(1,1,null);
insert into BOARDFILE values(2,2,null);
insert into BOARDFILE values(3,3,null);
insert into BOARDFILE values(4,4,null);
insert into BOARDFILE values(5,5,null);
insert into BOARDFILE values(6,6,null);
insert into BOARDFILE values(7,7,null);
insert into BOARDFILE values(8,8,null);
insert into BOARDFILE values(9,9,null);
insert into BOARDFILE values(10,10,null);
insert into BOARDFILE values(11,11,null);
insert into BOARDFILE values(12,12,null);
insert into BOARDFILE values(13,13,null);
insert into BOARDFILE values(14,14,null);
insert into BOARDFILE values(15,14,null);


insert into COMMENT values(1,'abc1@naver.com',now(),now(),null,'첫번째 댓글')
insert into COMMENT values(1,'abc1@naver.com',now(),now(),null,'두번째 댓글')

insert into RECOMMENT values(1,'abc3@naver.com','첫번째 대댓글',now(),now(),null);
insert into RECOMMENT values(1,'abc2@naver.com','두번째 대댓글',now(),now(),null);
insert into RECOMMENT values(2,'abc3@naver.com','세번째 대댓글',now(),now(),null);
insert into RECOMMENT values(2,'abc2@naver.com','네번째 대댓글',now(),now(),null);