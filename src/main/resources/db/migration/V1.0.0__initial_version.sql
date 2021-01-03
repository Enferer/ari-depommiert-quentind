
create sequence seq_author;
create table t_author
(
    id               integer         not null  default nextval('seq_author'),
    first_name       varchar(20)     not null,
    last_name        varchar(20)     not null,
    constraint pk_t_author primary key (id)
);

create sequence seq_book;
create table t_book
(
    id               integer         not null  default nextval('seq_book'),
    title            varchar(50)     not null,
    author_id        integer         not null,
    constraint pk_t_book primary key (id),
    constraint fk_t_author_book foreign key (author_id) references t_author(id)
);

create sequence seq_user;
create table t_user
(
    id               integer         not null  default nextval('seq_user'),
    name             varchar(50)     not null,
    password         varchar         not null,
    constraint pk_t_user primary key (id)
);
