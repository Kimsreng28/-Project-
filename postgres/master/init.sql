CREATE ROLE replicator WITH REPLICATION PASSWORD 'kim12345' LOGIN;
ALTER SYSTEM SET wal_level = 'replica';
ALTER SYSTEM SET max_wal_senders = 10;
ALTER SYSTEM SET hot_standby = 'on';
SELECT pg_reload_conf();