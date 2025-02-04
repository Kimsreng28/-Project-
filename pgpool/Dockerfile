FROM ubuntu:22.04

RUN apt-get update && apt-get install -y pgpool2 vim postgresql-client netcat

COPY wait-for-db.sh /wait-for-db.sh
RUN chmod +x /wait-for-db.sh

ENTRYPOINT ["/wait-for-db.sh"]
CMD ["pgpool", "-n"]
