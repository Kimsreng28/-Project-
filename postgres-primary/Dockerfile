FROM postgres:16

RUN apt-get update && apt-get install -y vim netcat-openbsd ssh && rm -rf /var/lib/apt/lists/*


COPY init-db.sh /docker-entrypoint-initdb.d/
RUN chmod +x /docker-entrypoint-initdb.d/init-db.sh

COPY master-replication-setup.sh /master-replication-setup.sh
RUN chmod +x /master-replication-setup.sh

ENTRYPOINT ["/master-replication-setup.sh"]
