drop table Product if exists;
drop table Bill if exists;
drop table Purchase if exists;

-- Product table has details of all the available products in online retail store.
create table Product
(
   Id integer primary key,                              -- Unique Id of the Product
   ProductName varchar(25) not null,                    -- Name of Product
   ScannedId varchar(25) not null,                      -- Scan Number while scanning the Product
   ProductCategory varchar(1) not null,                 -- Category of the Product
   ProductRate double not null,                         -- Rate of Product
   TotalQty integer not null                            -- Total available quantity of Product on online store
);

-- Bill table has billing details for purchased items.
create table Bill
(
   Id integer primary key,                              -- Unique bill id generated o counter
   TotalCost float not null,                          -- Total Cost on purchased items
   TotalTax float not null,                           -- Total Tax on purchased items
   TotalValuation float not null                      -- Total Valuation = Total Cost + Total Tax
);

-- Purchase table stores product details and quantity purchased in item.
create table Purchase
(
   Id integer primary key,                              -- Unique Id oof purchase
   PurchasedId integer references Product(Id),          -- Product Id, which product is purchased from all the products
   PurchasedQty integer not null,                       -- Product Quantity
   BillId integer references Bill(Id)                   -- As ProductId is associated with bill id
);