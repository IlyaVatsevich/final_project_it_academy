
\connect user_service;

INSERT INTO final_project_user.users (uuid,date_of_create,date_of_update,mail,nick,password,status)
     VALUES ('a454b335-30f4-4542-92d3-664fe4a423cc',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,
             'user@asd.ok',
             'user',
             '$2a$12$/leGWeS4ZaFGUk.eBc5WvuLpIgqx0FPDItU/Djxwlps9iHWd.eOM2',
             'ACTIVATED');


INSERT INTO final_project_user.user_roles (uuid,role)
VALUES ('a454b335-30f4-4542-92d3-664fe4a423cc','USER');


INSERT INTO final_project_user.users (uuid,date_of_create,date_of_update,mail,nick,password,status)
VALUES ('7d360bdb-ecc5-4eb0-9ce4-c5d40136a8dd',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        'admin@asd.ok',
        'admin',
        '$2a$12$JRWLHqqXgKbUDnmPElaPie2syYO/1SMw2RiE/3Ukj.yZrFwPq5KBG',
        'ACTIVATED');


INSERT INTO final_project_user.user_roles (uuid,role)
VALUES ('7d360bdb-ecc5-4eb0-9ce4-c5d40136a8dd','USER');

INSERT INTO final_project_user.user_roles (uuid,role)
VALUES ('7d360bdb-ecc5-4eb0-9ce4-c5d40136a8dd','ADMIN');