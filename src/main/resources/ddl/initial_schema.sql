create table if not exists exam_templates
(
    id               bigint auto_increment primary key,
    answer           varchar(2048) null,
    author_id        bigint       null,
    creation_date    date         null,
    text             varchar(2048) null,
    time_restriction int          null
);

create table if not exists exams
(
    id               bigint auto_increment primary key,
    answer           varchar(2048) null,
    author_id        bigint       null,
    creation_date    date         null,
    text             varchar(2048) null,
    time_restriction bigint       null,
    template_id      bigint       null,
    constraint exam_to_template
        foreign key (template_id) references exam_templates (id) on DELETE set null
);

create table if not exists lecture_templates
(
    id            bigint auto_increment primary key,
    author_id     bigint       null,
    creation_date date         null,
    text          varchar(2048) null
);

create table if not exists lectures
(
    id            bigint auto_increment primary key,
    author_id     bigint       null,
    creation_date date         null,
    text          varchar(4096) null,
    template_id   bigint       null,
    constraint lecture_to_template
        foreign key (template_id) references lecture_templates (id) on delete set null
);

create table if not exists practice_templates
(
    id            bigint auto_increment primary key,
    answer        varchar(2048) null,
    author_id     bigint       null,
    creation_date date         null,
    text          varchar(2048) null
);

create table if not exists practices
(
    id            bigint auto_increment primary key,
    answer        varchar(2048) null,
    author_id     bigint       null,
    creation_date date         null,
    text          varchar(2048) null,
    template_id   bigint       null,
    constraint practice_to_template
        foreign key (template_id) references practice_templates (id) on delete set null
);
