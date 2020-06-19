insert into product values(1,'test 1','1','A',1.00,100);
insert into product values(2,'test 2','2','B',2.00,200);
insert into product values(3,'test 3','3','C',3.00,300);
insert into product values(4,'test 4','4','A',4.00,100);
insert into product values(5,'test 5','5','B',5.00,150);
insert into product values(6,'test 6','6','C',6.00,250);
insert into product values(7,'test 7','7','A',7.00,350);

insert into bill values(11,5.00,0.2,5.2);
-- Product - qty -  cost   -   tax
--   1   -  2  -  2.00   -   0.2
--   3   -  1  -  3.00   -   0

insert into bill values(12,11.00,1.00,12.00);
-- Product - qty -  cost    -   tax
--   5   -  1  -  5.00  -   1.00
--   6   -  1  -  6.00  -   0

insert into purchase values(101,1,2,11);
insert into purchase values(102,3,1,11);
insert into purchase values(103,5,1,12);
insert into purchase values(104,6,1,12);