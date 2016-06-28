/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/6/28 9:46:59                            */
/*==============================================================*/


drop table if exists mood;

drop table if exists user;

drop table if exists userInfo;

/*==============================================================*/
/* Table: mood                                                  */
/*==============================================================*/
create table mood
(
   id                   char(12) not null,
   mood                 char(20),
   reasontag            char(30),
   dateandtime          datetime,
   moodimage            char(60),
   reasondesc           char(255),
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   char(12) not null,
   password             char(32),
   headimage            char(60),
   email                char(30),
   primary key (id)
);

/*==============================================================*/
/* Table: userInfo                                              */
/*==============================================================*/
create table userInfo
(
   id                   char(12) not null,
   name                 char(20),
   sex                  char(2),
   location             char(30),
   primary key (id)
);

alter table mood add constraint FK_user_mood foreign key (id)
      references user (id) on delete restrict on update restrict;

alter table userInfo add constraint FK_user_userinfo foreign key (id)
      references user (id) on delete restrict on update restrict;

