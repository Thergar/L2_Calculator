-- V1__init_schema.sql (Flyway, PostgreSQL)
-- Cleaned: no psql meta-commands, no OWNER changes.
SET search_path = public;

-- === Tables ===
CREATE TABLE public.aden_castle_town_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.dark_elven_village_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.dion_castle_town_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.dwarven_village_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.elven_village_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.giran_castle_town_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.gludin_village_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.gludio_castle_town_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.goddard_castle_town_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.heine_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.hunter_village_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.orc_village_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.rune_castle_town_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.talking_island_village_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

CREATE TABLE public.town (
    town_id   bigint NOT NULL,
    town_name varchar(255) NOT NULL
);

CREATE TABLE public.town_of_oren_teleports (
    teleport_id    integer NOT NULL,
    destination_id integer NOT NULL,
    price          integer NOT NULL
);

-- === Sequences ===
CREATE SEQUENCE public.aden_castle_town_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.dark_elven_village_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.dion_castle_town_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.dwarven_village_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.elven_village_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.giran_castle_town_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.gludin_village_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.gludio_castle_town_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.goddard_castle_town_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.heine_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.hunter_village_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.orc_village_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.rune_castle_town_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.talking_island_village_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.town_of_oren_teleports_teleport_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
CREATE SEQUENCE public.town_town_id_seq AS integer START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;

-- === Sequence ownership ===
ALTER SEQUENCE public.aden_castle_town_teleports_teleport_id_seq OWNED BY public.aden_castle_town_teleports.teleport_id;
ALTER SEQUENCE public.dark_elven_village_teleports_teleport_id_seq OWNED BY public.dark_elven_village_teleports.teleport_id;
ALTER SEQUENCE public.dion_castle_town_teleports_teleport_id_seq OWNED BY public.dion_castle_town_teleports.teleport_id;
ALTER SEQUENCE public.dwarven_village_teleports_teleport_id_seq OWNED BY public.dwarven_village_teleports.teleport_id;
ALTER SEQUENCE public.elven_village_teleports_teleport_id_seq OWNED BY public.elven_village_teleports.teleport_id;
ALTER SEQUENCE public.giran_castle_town_teleports_teleport_id_seq OWNED BY public.giran_castle_town_teleports.teleport_id;
ALTER SEQUENCE public.gludin_village_teleports_teleport_id_seq OWNED BY public.gludin_village_teleports.teleport_id;
ALTER SEQUENCE public.gludio_castle_town_teleports_teleport_id_seq OWNED BY public.gludio_castle_town_teleports.teleport_id;
ALTER SEQUENCE public.goddard_castle_town_teleports_teleport_id_seq OWNED BY public.goddard_castle_town_teleports.teleport_id;
ALTER SEQUENCE public.heine_teleports_teleport_id_seq OWNED BY public.heine_teleports.teleport_id;
ALTER SEQUENCE public.hunter_village_teleports_teleport_id_seq OWNED BY public.hunter_village_teleports.teleport_id;
ALTER SEQUENCE public.orc_village_teleports_teleport_id_seq OWNED BY public.orc_village_teleports.teleport_id;
ALTER SEQUENCE public.rune_castle_town_teleports_teleport_id_seq OWNED BY public.rune_castle_town_teleports.teleport_id;
ALTER SEQUENCE public.talking_island_village_teleports_teleport_id_seq OWNED BY public.talking_island_village_teleports.teleport_id;
ALTER SEQUENCE public.town_of_oren_teleports_teleport_id_seq OWNED BY public.town_of_oren_teleports.teleport_id;
ALTER SEQUENCE public.town_town_id_seq OWNED BY public.town.town_id;

-- === Defaults ===
ALTER TABLE ONLY public.aden_castle_town_teleports       ALTER COLUMN teleport_id SET DEFAULT nextval('public.aden_castle_town_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.dark_elven_village_teleports      ALTER COLUMN teleport_id SET DEFAULT nextval('public.dark_elven_village_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.dion_castle_town_teleports        ALTER COLUMN teleport_id SET DEFAULT nextval('public.dion_castle_town_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.dwarven_village_teleports         ALTER COLUMN teleport_id SET DEFAULT nextval('public.dwarven_village_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.elven_village_teleports           ALTER COLUMN teleport_id SET DEFAULT nextval('public.elven_village_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.giran_castle_town_teleports       ALTER COLUMN teleport_id SET DEFAULT nextval('public.giran_castle_town_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.gludin_village_teleports          ALTER COLUMN teleport_id SET DEFAULT nextval('public.gludin_village_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.gludio_castle_town_teleports      ALTER COLUMN teleport_id SET DEFAULT nextval('public.gludio_castle_town_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.goddard_castle_town_teleports     ALTER COLUMN teleport_id SET DEFAULT nextval('public.goddard_castle_town_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.heine_teleports                   ALTER COLUMN teleport_id SET DEFAULT nextval('public.heine_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.hunter_village_teleports          ALTER COLUMN teleport_id SET DEFAULT nextval('public.hunter_village_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.orc_village_teleports             ALTER COLUMN teleport_id SET DEFAULT nextval('public.orc_village_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.rune_castle_town_teleports        ALTER COLUMN teleport_id SET DEFAULT nextval('public.rune_castle_town_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.talking_island_village_teleports  ALTER COLUMN teleport_id SET DEFAULT nextval('public.talking_island_village_teleports_teleport_id_seq'::regclass);
ALTER TABLE ONLY public.town                              ALTER COLUMN town_id     SET DEFAULT nextval('public.town_town_id_seq'::regclass);
ALTER TABLE ONLY public.town_of_oren_teleports            ALTER COLUMN teleport_id SET DEFAULT nextval('public.town_of_oren_teleports_teleport_id_seq'::regclass);

-- === Primary keys ===
ALTER TABLE ONLY public.aden_castle_town_teleports         ADD CONSTRAINT aden_castle_town_teleports_pkey          PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.dark_elven_village_teleports       ADD CONSTRAINT dark_elven_village_teleports_pkey        PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.dion_castle_town_teleports         ADD CONSTRAINT dion_castle_town_teleports_pkey          PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.dwarven_village_teleports          ADD CONSTRAINT dwarven_village_teleports_pkey           PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.elven_village_teleports            ADD CONSTRAINT elven_village_teleports_pkey             PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.giran_castle_town_teleports        ADD CONSTRAINT giran_castle_town_teleports_pkey         PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.gludin_village_teleports           ADD CONSTRAINT gludin_village_teleports_pkey            PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.gludio_castle_town_teleports       ADD CONSTRAINT gludio_castle_town_teleports_pkey        PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.goddard_castle_town_teleports      ADD CONSTRAINT goddard_castle_town_teleports_pkey       PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.heine_teleports                    ADD CONSTRAINT heine_teleports_pkey                     PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.hunter_village_teleports           ADD CONSTRAINT hunter_village_teleports_pkey            PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.orc_village_teleports              ADD CONSTRAINT orc_village_teleports_pkey               PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.rune_castle_town_teleports         ADD CONSTRAINT rune_castle_town_teleports_pkey          PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.talking_island_village_teleports   ADD CONSTRAINT talking_island_village_teleports_pkey    PRIMARY KEY (teleport_id);
ALTER TABLE ONLY public.town                               ADD CONSTRAINT town_pkey                                 PRIMARY KEY (town_id);
ALTER TABLE ONLY public.town_of_oren_teleports             ADD CONSTRAINT town_of_oren_teleports_pkey              PRIMARY KEY (teleport_id);

-- === Foreign keys ===
ALTER TABLE ONLY public.aden_castle_town_teleports           ADD CONSTRAINT aden_castle_town_teleports_destination_id_fkey        FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.dark_elven_village_teleports         ADD CONSTRAINT dark_elven_village_teleports_destination_id_fkey      FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.dion_castle_town_teleports           ADD CONSTRAINT dion_castle_town_teleports_destination_id_fkey        FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.dwarven_village_teleports            ADD CONSTRAINT dwarven_village_teleports_destination_id_fkey         FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.elven_village_teleports              ADD CONSTRAINT elven_village_teleports_destination_id_fkey           FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.giran_castle_town_teleports          ADD CONSTRAINT giran_castle_town_teleports_destination_id_fkey       FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.gludin_village_teleports             ADD CONSTRAINT gludin_village_teleports_destination_id_fkey          FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.gludio_castle_town_teleports         ADD CONSTRAINT gludio_castle_town_teleports_destination_id_fkey      FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.goddard_castle_town_teleports        ADD CONSTRAINT goddard_castle_town_teleports_destination_id_fkey     FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.heine_teleports                      ADD CONSTRAINT heine_teleports_destination_id_fkey                    FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.hunter_village_teleports             ADD CONSTRAINT hunter_village_teleports_destination_id_fkey           FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.orc_village_teleports                ADD CONSTRAINT orc_village_teleports_destination_id_fkey              FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.rune_castle_town_teleports           ADD CONSTRAINT rune_castle_town_teleports_destination_id_fkey         FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.talking_island_village_teleports     ADD CONSTRAINT talking_island_village_teleports_destination_id_fkey   FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
ALTER TABLE ONLY public.town_of_oren_teleports               ADD CONSTRAINT town_of_oren_teleports_destination_id_fkey             FOREIGN KEY (destination_id) REFERENCES public.town(town_id);
