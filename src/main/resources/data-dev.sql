insert into product values(101,'Shopping Kurti','ABCH4729499D','A',999.99,100);
insert into product values(102,'Darzi Top','JWOSJX7281JSX','B',566.79,200);
insert into product values(103,'Naritva Kurti','JJAU788829AS','C',789.99,300);
insert into product values(104,'Sassfras Maxi','HQWUS88822SA','C',433.89,100);
insert into product values(105,'Max Skirt','AGVEOW2231JM','A',743.99,150);
insert into product values(106,'Queen dress','KLOQU3829SD','B',343.46,250);
insert into product values(107,'Pinkriti Kurti','NSDW7102NS','C',444.44,350);

insert into bill values(10001,2789.97,199.998,2989.968);
-- Product - qty -  cost   -   tax
--   101   -  2  - 1999.98 - 199.998
--   103   -  1  - 789.99  - 0

insert into bill values(10002,1087.45,143.091,1230.541);
-- Product - qty -  cost    -   tax
--   105   -  1  -  743.99  - 199.998
--   106   -  1  -  343.46  - 68.692

insert into purchase values(1001,101,2,10001);
insert into purchase values(1002,103,1,10001);
insert into purchase values(1003,105,1,10002);
insert into purchase values(1004,106,1,10002);