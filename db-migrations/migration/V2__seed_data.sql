-- === TOWN ===
INSERT INTO public.town (town_id, town_name) VALUES
(1,'Talking Island Village'),
(2,'Gludin Village'),
(3,'Elven Village'),
(4,'Dark Elven Village'),
(5,'Dion Castle Town'),
(6,'Orc Village'),
(7,'Dwarven Village'),
(8,'Gludio Castle Town'),
(9,'Giran Castle Town'),
(10,'Town of Oren'),
(11,'Aden Castle Town'),
(12,'Goddard Castle Town'),
(13,'Rune Castle Town'),
(14,'Heine'),
(15,'Hunter Village')
ON CONFLICT (town_id) DO NOTHING;

-- === ADEN CASTLE TOWN TELEPORTS ===
INSERT INTO public.aden_castle_town_teleports (teleport_id, destination_id, price) VALUES
(1,5,52000),(2,8,56000),(3,9,13000),(4,10,6900),
(5,12,8100),(6,13,37000),(7,14,59000),(8,15,5900)
ON CONFLICT (teleport_id) DO NOTHING;

-- === DARK ELVEN VILLAGE TELEPORTS ===
INSERT INTO public.dark_elven_village_teleports (teleport_id, destination_id, price) VALUES
(1,1,24000),(2,6,13000),(3,7,22000),(4,8,10000)
ON CONFLICT (teleport_id) DO NOTHING;

-- === DION CASTLE TOWN TELEPORTS ===
INSERT INTO public.dion_castle_town_teleports (teleport_id, destination_id, price) VALUES
(1,9,6800),(2,10,33000),(3,11,52000),(4,12,71000),
(5,13,57000),(6,14,12000)
ON CONFLICT (teleport_id) DO NOTHING;

-- === DWARVEN VILLAGE TELEPORTS ===

-- === ELVEN VILLAGE TELEPORTS ===
INSERT INTO public.elven_village_teleports (teleport_id, destination_id, price) VALUES
(1,1,20000),(2,3,16000),(3,4,13000),(4,6,17000),
(5,7,32000),(6,8,12000),(7,11,26000)
ON CONFLICT (teleport_id) DO NOTHING;

-- === GIRAN CASTLE TOWN TELEPORTS ===
INSERT INTO public.giran_castle_town_teleports (teleport_id, destination_id, price) VALUES
(1,5,6800),(2,8,29000),(3,10,9400),(4,11,13000),
(5,12,63000),(6,13,59000),(7,14,7600)
ON CONFLICT (teleport_id) DO NOTHING;

-- === GLUDIN VILLAGE TELEPORTS ===
INSERT INTO public.gludin_village_teleports (teleport_id, destination_id, price) VALUES
(1,1,9400),(2,3,16000),(3,4,26000),(4,6,10000),(5,8,7300)
ON CONFLICT (teleport_id) DO NOTHING;

-- === GLUDIO CASTLE TOWN TELEPORTS ===
INSERT INTO public.gludio_castle_town_teleports (teleport_id, destination_id, price) VALUES
(1,2,7300),(2,3,9200),(3,4,10000),(4,5,34000),
(5,6,32000),(6,7,32000),(7,9,29000),(8,10,35000),
(9,11,56000),(10,12,71000),(11,13,53000),(12,14,47000)
ON CONFLICT (teleport_id) DO NOTHING;

-- === GODDARD CASTLE TOWN TELEPORTS ===
INSERT INTO public.goddard_castle_town_teleports (teleport_id, destination_id, price) VALUES
(1,5,71000),(2,8,71000),(3,9,63000),(4,10,37000),
(5,11,8100),(6,13,10000),(7,14,83000)
ON CONFLICT (teleport_id) DO NOTHING;

-- === HEINE TELEPORTS ===
INSERT INTO public.heine_teleports (teleport_id, destination_id, price) VALUES
(1,5,12000),(2,8,47000),(3,9,7600),(4,10,50000),
(5,11,59000),(6,12,83000),(7,13,82000)
ON CONFLICT (teleport_id) DO NOTHING;

-- === HUNTER VILLAGE TELEPORTS ===
INSERT INTO public.hunter_village_teleports (teleport_id, destination_id, price) VALUES
(1,10,4100),(2,11,5900)
ON CONFLICT (teleport_id) DO NOTHING;

-- === ORC VILLAGE TELEPORTS ===
INSERT INTO public.orc_village_teleports (teleport_id, destination_id, price) VALUES
(1,1,35000),(2,3,18000),(3,4,13000),(4,7,17000),(5,8,23000)
ON CONFLICT (teleport_id) DO NOTHING;

-- === RUNE CASTLE TOWN TELEPORTS ===
INSERT INTO public.rune_castle_town_teleports (teleport_id, destination_id, price) VALUES
(1,5,57000),(2,8,53000),(3,9,59000),
(4,10,10000),(5,11,37000),(6,12,10000),(7,14,82000)
ON CONFLICT (teleport_id) DO NOTHING;

-- === TALKING ISLAND VILLAGE TELEPORTS ===
INSERT INTO public.talking_island_village_teleports (teleport_id, destination_id, price) VALUES
(1,2,18000),(2,3,23000),(3,4,24000),(4,7,23000),(5,6,35000)
ON CONFLICT (teleport_id) DO NOTHING;

-- === TOWN OF OREN TELEPORTS ===
INSERT INTO public.town_of_oren_teleports (teleport_id, destination_id, price) VALUES
(1,5,33000),(2,8,35000),(3,9,9400),(4,11,6900),
(5,12,37000),(6,13,10000),(7,14,50000)
ON CONFLICT (teleport_id) DO NOTHING;

-- === SEQUENCE RESET ===
DO $$
DECLARE r record;
BEGIN
  FOR r IN
    SELECT
      c.oid::regclass AS table_regclass,
      a.attname       AS colname,
      pg_get_serial_sequence(n.nspname||'.'||c.relname, a.attname) AS seqname
    FROM pg_attribute a
    JOIN pg_class c      ON a.attrelid = c.oid
    JOIN pg_namespace n  ON n.oid = c.relnamespace
    WHERE a.attnum > 0
      AND NOT a.attisdropped
      AND pg_get_serial_sequence(n.nspname||'.'||c.relname, a.attname) IS NOT NULL
      AND n.nspname = 'public'
  LOOP
    EXECUTE format(
      'SELECT setval(%L, COALESCE((SELECT MAX(%I) FROM %s), 0) + 1, false)',
      r.seqname, r.colname, r.table_regclass
    );
  END LOOP;
END$$;
