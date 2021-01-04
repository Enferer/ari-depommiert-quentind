
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
    name             varchar(50)     unique not null,
    password         varchar         not null,
    constraint pk_t_user primary key (id)
);

create table t_rented
(
    user_id         integer         not null,
    book_id         integer         not null,
    constraint pk_t_rented primary key (user_id, book_id),
    constraint fk_t_rented_user foreign key (user_id) references t_user(id),
    constraint fk_t_rented_book foreign key (book_id) references t_book(id)
)
