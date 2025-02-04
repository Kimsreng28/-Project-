FROM postgres:16

RUN apt-get update && apt-get install -y vim netcat-openbsd ssh && rm -rf /var/lib/apt/lists/*


COPY init-replica-server.sh /init-replica-server.sh
RUN chmod +x /init-replica-server.sh

ENTRYPOINT ["/init-replica-server.sh"]
