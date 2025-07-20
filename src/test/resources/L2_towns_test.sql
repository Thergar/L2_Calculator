CREATE TABLE public.aden_castle_town_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


CREATE TABLE public.dark_elven_village_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


CREATE TABLE public.dion_castle_town_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


CREATE TABLE public.goddard_castle_town_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


CREATE TABLE public.elven_village_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


CREATE TABLE public.dwarven_village_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


CREATE TABLE public.town (
    town_id bigint NOT NULL,
    town_name character varying(255) NOT NULL
);


INSERT INTO public.aden_castle_town_teleports (teleport_id, destination_id, price) VALUES
(1,	3,	52000),
(2,	6,	8100);


INSERT INTO public.dark_elven_village_teleports (teleport_id, destination_id, price) VALUES
(1,	4,	22000);


INSERT INTO public.dion_castle_town_teleports (teleport_id, destination_id, price) VALUES
(1,	5,	52000),
(2,	6,	71000);


INSERT INTO public.goddard_castle_town_teleports (teleport_id, destination_id, price) VALUES
(1,	3,	71000),
(2,	5,	8100);


INSERT INTO public.elven_village_teleports (teleport_id, destination_id, price) VALUES
(1,	1,	16000),
(2,	2,	13000),
(3,	4,	38000),
(4,	5,	26000);


INSERT INTO public.town (town_id, town_name) VALUES
(1,	'Elven Village'),
(2,	'Dark Elven Village'),
(3,	'Dion Castle Town'),
(4,	'Dwarven Village'),
(5,	'Aden Castle Town'),
(6,	'Goddard Castle Town');


-- Added sequences and defaults for test compatibility
CREATE SEQUENCE town_id_seq;
ALTER TABLE ONLY town ALTER COLUMN town_id SET DEFAULT nextval('town_id_seq');
CREATE SEQUENCE aden_castle_town_teleports_id_seq;
ALTER TABLE ONLY aden_castle_town_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('aden_castle_town_teleports_id_seq');
CREATE SEQUENCE dark_elven_village_teleports_id_seq;
ALTER TABLE ONLY dark_elven_village_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('dark_elven_village_teleports_id_seq');
CREATE SEQUENCE dion_castle_town_teleports_id_seq;
ALTER TABLE ONLY dion_castle_town_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('dion_castle_town_teleports_id_seq');
