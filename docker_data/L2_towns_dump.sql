--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2 (Debian 17.2-1.pgdg120+1)
-- Dumped by pg_dump version 17.2 (Debian 17.2-1.pgdg120+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: aden_castle_town_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.aden_castle_town_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.aden_castle_town_teleports OWNER TO postgres;

--
-- Name: aden_castle_town_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.aden_castle_town_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.aden_castle_town_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: aden_castle_town_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.aden_castle_town_teleports_teleport_id_seq OWNED BY public.aden_castle_town_teleports.teleport_id;


--
-- Name: dark_elven_village_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dark_elven_village_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.dark_elven_village_teleports OWNER TO postgres;

--
-- Name: dark_elven_village_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dark_elven_village_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.dark_elven_village_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: dark_elven_village_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dark_elven_village_teleports_teleport_id_seq OWNED BY public.dark_elven_village_teleports.teleport_id;


--
-- Name: dion_castle_town_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dion_castle_town_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.dion_castle_town_teleports OWNER TO postgres;

--
-- Name: dion_castle_town_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dion_castle_town_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.dion_castle_town_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: dion_castle_town_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dion_castle_town_teleports_teleport_id_seq OWNED BY public.dion_castle_town_teleports.teleport_id;


--
-- Name: dwarven_village_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.dwarven_village_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.dwarven_village_teleports OWNER TO postgres;

--
-- Name: dwarven_village_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.dwarven_village_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.dwarven_village_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: dwarven_village_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.dwarven_village_teleports_teleport_id_seq OWNED BY public.dwarven_village_teleports.teleport_id;


--
-- Name: elven_village_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.elven_village_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.elven_village_teleports OWNER TO postgres;

--
-- Name: elven_village_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.elven_village_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.elven_village_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: elven_village_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.elven_village_teleports_teleport_id_seq OWNED BY public.elven_village_teleports.teleport_id;


--
-- Name: giran_castle_town_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.giran_castle_town_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.giran_castle_town_teleports OWNER TO postgres;

--
-- Name: giran_castle_town_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.giran_castle_town_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.giran_castle_town_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: giran_castle_town_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.giran_castle_town_teleports_teleport_id_seq OWNED BY public.giran_castle_town_teleports.teleport_id;


--
-- Name: gludin_village_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gludin_village_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.gludin_village_teleports OWNER TO postgres;

--
-- Name: gludin_village_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gludin_village_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.gludin_village_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: gludin_village_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.gludin_village_teleports_teleport_id_seq OWNED BY public.gludin_village_teleports.teleport_id;


--
-- Name: gludio_castle_town_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gludio_castle_town_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.gludio_castle_town_teleports OWNER TO postgres;

--
-- Name: gludio_castle_town_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gludio_castle_town_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.gludio_castle_town_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: gludio_castle_town_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.gludio_castle_town_teleports_teleport_id_seq OWNED BY public.gludio_castle_town_teleports.teleport_id;


--
-- Name: goddard_castle_town_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.goddard_castle_town_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.goddard_castle_town_teleports OWNER TO postgres;

--
-- Name: goddard_castle_town_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.goddard_castle_town_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.goddard_castle_town_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: goddard_castle_town_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.goddard_castle_town_teleports_teleport_id_seq OWNED BY public.goddard_castle_town_teleports.teleport_id;


--
-- Name: heine_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.heine_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.heine_teleports OWNER TO postgres;

--
-- Name: heine_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.heine_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.heine_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: heine_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.heine_teleports_teleport_id_seq OWNED BY public.heine_teleports.teleport_id;


--
-- Name: hunter_village_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hunter_village_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.hunter_village_teleports OWNER TO postgres;

--
-- Name: hunter_village_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hunter_village_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.hunter_village_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: hunter_village_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hunter_village_teleports_teleport_id_seq OWNED BY public.hunter_village_teleports.teleport_id;


--
-- Name: orc_village_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orc_village_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.orc_village_teleports OWNER TO postgres;

--
-- Name: orc_village_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orc_village_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.orc_village_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: orc_village_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orc_village_teleports_teleport_id_seq OWNED BY public.orc_village_teleports.teleport_id;


--
-- Name: rune_castle_town_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rune_castle_town_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.rune_castle_town_teleports OWNER TO postgres;

--
-- Name: rune_castle_town_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rune_castle_town_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.rune_castle_town_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: rune_castle_town_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rune_castle_town_teleports_teleport_id_seq OWNED BY public.rune_castle_town_teleports.teleport_id;


--
-- Name: talking_island_village_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.talking_island_village_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.talking_island_village_teleports OWNER TO postgres;

--
-- Name: talking_island_village_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.talking_island_village_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.talking_island_village_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: talking_island_village_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.talking_island_village_teleports_teleport_id_seq OWNED BY public.talking_island_village_teleports.teleport_id;


--
-- Name: town; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.town (
    town_id bigint NOT NULL,
    town_name character varying(255) NOT NULL
);


ALTER TABLE public.town OWNER TO postgres;

--
-- Name: town_of_oren_teleports; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.town_of_oren_teleports (
    teleport_id integer NOT NULL,
    destination_id integer NOT NULL,
    price integer NOT NULL
);


ALTER TABLE public.town_of_oren_teleports OWNER TO postgres;

--
-- Name: town_of_oren_teleports_teleport_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.town_of_oren_teleports_teleport_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.town_of_oren_teleports_teleport_id_seq OWNER TO postgres;

--
-- Name: town_of_oren_teleports_teleport_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.town_of_oren_teleports_teleport_id_seq OWNED BY public.town_of_oren_teleports.teleport_id;


--
-- Name: town_town_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.town_town_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.town_town_id_seq OWNER TO postgres;

--
-- Name: town_town_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.town_town_id_seq OWNED BY public.town.town_id;


--
-- Name: aden_castle_town_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aden_castle_town_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.aden_castle_town_teleports_teleport_id_seq'::regclass);


--
-- Name: dark_elven_village_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dark_elven_village_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.dark_elven_village_teleports_teleport_id_seq'::regclass);


--
-- Name: dion_castle_town_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dion_castle_town_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.dion_castle_town_teleports_teleport_id_seq'::regclass);


--
-- Name: dwarven_village_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dwarven_village_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.dwarven_village_teleports_teleport_id_seq'::regclass);


--
-- Name: elven_village_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.elven_village_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.elven_village_teleports_teleport_id_seq'::regclass);


--
-- Name: giran_castle_town_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.giran_castle_town_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.giran_castle_town_teleports_teleport_id_seq'::regclass);


--
-- Name: gludin_village_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gludin_village_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.gludin_village_teleports_teleport_id_seq'::regclass);


--
-- Name: gludio_castle_town_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gludio_castle_town_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.gludio_castle_town_teleports_teleport_id_seq'::regclass);


--
-- Name: goddard_castle_town_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.goddard_castle_town_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.goddard_castle_town_teleports_teleport_id_seq'::regclass);


--
-- Name: heine_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.heine_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.heine_teleports_teleport_id_seq'::regclass);


--
-- Name: hunter_village_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hunter_village_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.hunter_village_teleports_teleport_id_seq'::regclass);


--
-- Name: orc_village_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orc_village_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.orc_village_teleports_teleport_id_seq'::regclass);


--
-- Name: rune_castle_town_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rune_castle_town_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.rune_castle_town_teleports_teleport_id_seq'::regclass);


--
-- Name: talking_island_village_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.talking_island_village_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.talking_island_village_teleports_teleport_id_seq'::regclass);


--
-- Name: town town_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.town ALTER COLUMN town_id SET DEFAULT nextval('public.town_town_id_seq'::regclass);


--
-- Name: town_of_oren_teleports teleport_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.town_of_oren_teleports ALTER COLUMN teleport_id SET DEFAULT nextval('public.town_of_oren_teleports_teleport_id_seq'::regclass);


--
-- Data for Name: aden_castle_town_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.aden_castle_town_teleports (teleport_id, destination_id, price) FROM stdin;
1	5	52000
2	8	56000
3	9	13000
4	10	6900
5	12	8100
6	13	37000
7	14	59000
8	15	5900
\.


--
-- Data for Name: dark_elven_village_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dark_elven_village_teleports (teleport_id, destination_id, price) FROM stdin;
1	1	24000
2	6	13000
3	7	22000
4	8	10000
\.


--
-- Data for Name: dion_castle_town_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dion_castle_town_teleports (teleport_id, destination_id, price) FROM stdin;
1	9	6800
2	10	33000
3	11	52000
4	12	71000
5	13	57000
6	14	12000
\.


--
-- Data for Name: dwarven_village_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.dwarven_village_teleports (teleport_id, destination_id, price) FROM stdin;
\.


--
-- Data for Name: elven_village_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.elven_village_teleports (teleport_id, destination_id, price) FROM stdin;
1	1	20000
2	3	16000
3	4	13000
4	6	17000
5	7	32000
6	8	12000
7	11	26000
\.


--
-- Data for Name: giran_castle_town_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.giran_castle_town_teleports (teleport_id, destination_id, price) FROM stdin;
1	5	6800
2	8	29000
3	10	9400
4	11	13000
5	12	63000
6	13	59000
7	14	7600
\.


--
-- Data for Name: gludin_village_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.gludin_village_teleports (teleport_id, destination_id, price) FROM stdin;
1	1	9400
2	3	16000
3	4	26000
4	6	10000
5	8	7300
\.


--
-- Data for Name: gludio_castle_town_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.gludio_castle_town_teleports (teleport_id, destination_id, price) FROM stdin;
1	2	7300
2	3	9200
3	4	10000
4	5	34000
5	6	32000
6	7	32000
7	9	29000
8	10	35000
9	11	56000
10	12	71000
11	13	53000
12	14	47000
\.


--
-- Data for Name: goddard_castle_town_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.goddard_castle_town_teleports (teleport_id, destination_id, price) FROM stdin;
1	5	71000
2	8	71000
3	9	63000
4	10	37000
5	11	8100
6	13	10000
7	14	83000
\.


--
-- Data for Name: heine_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.heine_teleports (teleport_id, destination_id, price) FROM stdin;
1	5	12000
2	8	47000
3	9	7600
4	10	50000
5	11	59000
6	12	83000
7	13	82000
\.


--
-- Data for Name: hunter_village_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hunter_village_teleports (teleport_id, destination_id, price) FROM stdin;
1	10	4100
2	11	5900
\.


--
-- Data for Name: orc_village_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orc_village_teleports (teleport_id, destination_id, price) FROM stdin;
1	1	35000
2	3	18000
3	4	13000
4	7	17000
5	8	23000
\.


--
-- Data for Name: rune_castle_town_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rune_castle_town_teleports (teleport_id, destination_id, price) FROM stdin;
1	5	57000
2	8	53000
3	9	59000
4	10	10000
5	11	37000
6	12	10000
7	14	82000
\.


--
-- Data for Name: talking_island_village_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.talking_island_village_teleports (teleport_id, destination_id, price) FROM stdin;
1	2	18000
2	3	23000
3	4	24000
4	7	23000
5	6	35000
\.


--
-- Data for Name: town; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.town (town_id, town_name) FROM stdin;
1	Talking Island Village
2	Gludin Village
3	Elven Village
4	Dark Elven Village
5	Dion Castle Town
6	Orc Village
7	Dwarven Village
8	Gludio Castle Town
9	Giran Castle Town
10	Town of Oren
11	Aden Castle Town
12	Goddard Castle Town
13	Rune Castle Town
14	Heine
15	Hunter Village
\.


--
-- Data for Name: town_of_oren_teleports; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.town_of_oren_teleports (teleport_id, destination_id, price) FROM stdin;
1	5	33000
2	8	35000
3	9	9400
4	11	6900
5	12	37000
6	13	10000
7	14	50000
\.


--
-- Name: aden_castle_town_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.aden_castle_town_teleports_teleport_id_seq', 8, true);


--
-- Name: dark_elven_village_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.dark_elven_village_teleports_teleport_id_seq', 4, true);


--
-- Name: dion_castle_town_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.dion_castle_town_teleports_teleport_id_seq', 6, true);


--
-- Name: dwarven_village_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.dwarven_village_teleports_teleport_id_seq', 1, false);


--
-- Name: elven_village_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.elven_village_teleports_teleport_id_seq', 7, true);


--
-- Name: giran_castle_town_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.giran_castle_town_teleports_teleport_id_seq', 7, true);


--
-- Name: gludin_village_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gludin_village_teleports_teleport_id_seq', 5, true);


--
-- Name: gludio_castle_town_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gludio_castle_town_teleports_teleport_id_seq', 12, true);


--
-- Name: goddard_castle_town_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.goddard_castle_town_teleports_teleport_id_seq', 7, true);


--
-- Name: heine_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.heine_teleports_teleport_id_seq', 7, true);


--
-- Name: hunter_village_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hunter_village_teleports_teleport_id_seq', 2, true);


--
-- Name: orc_village_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orc_village_teleports_teleport_id_seq', 5, true);


--
-- Name: rune_castle_town_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rune_castle_town_teleports_teleport_id_seq', 7, true);


--
-- Name: talking_island_village_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.talking_island_village_teleports_teleport_id_seq', 5, true);


--
-- Name: town_of_oren_teleports_teleport_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.town_of_oren_teleports_teleport_id_seq', 7, true);


--
-- Name: town_town_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.town_town_id_seq', 15, true);


--
-- Name: aden_castle_town_teleports aden_castle_town_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aden_castle_town_teleports
    ADD CONSTRAINT aden_castle_town_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: dark_elven_village_teleports dark_elven_village_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dark_elven_village_teleports
    ADD CONSTRAINT dark_elven_village_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: dion_castle_town_teleports dion_castle_town_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dion_castle_town_teleports
    ADD CONSTRAINT dion_castle_town_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: dwarven_village_teleports dwarven_village_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dwarven_village_teleports
    ADD CONSTRAINT dwarven_village_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: elven_village_teleports elven_village_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.elven_village_teleports
    ADD CONSTRAINT elven_village_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: giran_castle_town_teleports giran_castle_town_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.giran_castle_town_teleports
    ADD CONSTRAINT giran_castle_town_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: gludin_village_teleports gludin_village_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gludin_village_teleports
    ADD CONSTRAINT gludin_village_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: gludio_castle_town_teleports gludio_castle_town_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gludio_castle_town_teleports
    ADD CONSTRAINT gludio_castle_town_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: goddard_castle_town_teleports goddard_castle_town_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.goddard_castle_town_teleports
    ADD CONSTRAINT goddard_castle_town_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: heine_teleports heine_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.heine_teleports
    ADD CONSTRAINT heine_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: hunter_village_teleports hunter_village_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hunter_village_teleports
    ADD CONSTRAINT hunter_village_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: orc_village_teleports orc_village_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orc_village_teleports
    ADD CONSTRAINT orc_village_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: rune_castle_town_teleports rune_castle_town_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rune_castle_town_teleports
    ADD CONSTRAINT rune_castle_town_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: talking_island_village_teleports talking_island_village_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.talking_island_village_teleports
    ADD CONSTRAINT talking_island_village_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: town_of_oren_teleports town_of_oren_teleports_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.town_of_oren_teleports
    ADD CONSTRAINT town_of_oren_teleports_pkey PRIMARY KEY (teleport_id);


--
-- Name: town town_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.town
    ADD CONSTRAINT town_pkey PRIMARY KEY (town_id);


--
-- Name: aden_castle_town_teleports aden_castle_town_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.aden_castle_town_teleports
    ADD CONSTRAINT aden_castle_town_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: dark_elven_village_teleports dark_elven_village_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dark_elven_village_teleports
    ADD CONSTRAINT dark_elven_village_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: dion_castle_town_teleports dion_castle_town_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dion_castle_town_teleports
    ADD CONSTRAINT dion_castle_town_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: dwarven_village_teleports dwarven_village_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.dwarven_village_teleports
    ADD CONSTRAINT dwarven_village_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: elven_village_teleports elven_village_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.elven_village_teleports
    ADD CONSTRAINT elven_village_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: giran_castle_town_teleports giran_castle_town_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.giran_castle_town_teleports
    ADD CONSTRAINT giran_castle_town_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: gludin_village_teleports gludin_village_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gludin_village_teleports
    ADD CONSTRAINT gludin_village_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: gludio_castle_town_teleports gludio_castle_town_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gludio_castle_town_teleports
    ADD CONSTRAINT gludio_castle_town_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: goddard_castle_town_teleports goddard_castle_town_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.goddard_castle_town_teleports
    ADD CONSTRAINT goddard_castle_town_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: heine_teleports heine_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.heine_teleports
    ADD CONSTRAINT heine_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: hunter_village_teleports hunter_village_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hunter_village_teleports
    ADD CONSTRAINT hunter_village_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: orc_village_teleports orc_village_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orc_village_teleports
    ADD CONSTRAINT orc_village_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: rune_castle_town_teleports rune_castle_town_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rune_castle_town_teleports
    ADD CONSTRAINT rune_castle_town_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: talking_island_village_teleports talking_island_village_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.talking_island_village_teleports
    ADD CONSTRAINT talking_island_village_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- Name: town_of_oren_teleports town_of_oren_teleports_destination_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.town_of_oren_teleports
    ADD CONSTRAINT town_of_oren_teleports_destination_id_fkey FOREIGN KEY (destination_id) REFERENCES public.town(town_id);


--
-- PostgreSQL database dump complete
--

