create database meuble;
\c meuble;

create table matiere (
    id varchar(10) primary key,
    matiere varchar(50) unique
);

create table style(
    id varchar(10) primary key,
    style varchar(50) unique
);

create table categorie (
    id varchar(10) primary key,
    categorie varchar(50) unique
);

create table details_style (
    id serial,
    idStyle varchar(10),
    idMatiere varchar(10),
    foreign key (idStyle) references style(id),
    foreign key (idMatiere) references matiere(id) 
);


CREATE SEQUENCE seqMatiere
increment by 1
start WITH 1
minValue 1;

CREATE SEQUENCE seqStyle
increment by 1
start WITH 1
minValue 1;

create or replace function nextID(sequence text, prefix text, taille integer) 
returns text AS
$$
    Declare
        nextId int;
        nextIdString text;
        id text;
        i integer;
    BEGIN
        SELECT coalesce(nextval(sequence),1) into nextId;
        nextIdString := nextId::varchar;
        taille := taille - LENGTH(prefix) - LENGTH(nextIdString);
        id := prefix;
        FOR i IN 1..taille LOOP
            id := id || '0'; 
        END LOOP;
        id := id || nextIdString; 
        return id;
    END
$$ LANGUAGE plpgsql;

create view liste_matiere_style as
select idStyle, idMatiere id, matiere from details_style d join matiere m on d.idmatiere = m.id;

