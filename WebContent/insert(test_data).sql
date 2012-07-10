use Relater;

insert into Users values(null,'user1','A','ilovedb');
insert into Users values(null,'user2','B','ilovedb');
insert into Users values(null,'user3','C','ilovedb');

insert into friendships values(1,2);
insert into friendships values(1,3);

insert into relations values(null,1,'hello her manto',now());
insert into relations values(null,2,'hello A', now());

