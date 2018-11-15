create table car(
  id int identity primary key,
  brand varchar(255) NOT NULL,
  model varchar(255) NOT NULL,
  prod_date date NOT NULL,
  model_details varchar(255) NOT NULL
);

insert into car (brand, model, prod_date, model_details) values
  ('BMW', 'SUV', '2017-07-10', 'Blue X3 2017'),
  ('Sunny', 'Sedan', '2014-05-05', 'Red Sunny 2014'),
  ('Jeep', 'FourXFour', '2018-01-01', 'Grey Jeep 2013'),
  ('Honda', 'Sedan', '2016-01-01', 'Blue Honda 2008');
  
  