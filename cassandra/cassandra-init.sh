#!/bin/bash

# while ! cqlsh -e 'describe cluster' > /dev/null 2>&1; do sleep 6; done

# for f in $(find . -type f -name "*.cql" -print | sort); do
#         cqlsh -f "$f"
# done

if [[ ! -z "$CASSANDRA_KEYSPACE" ]]; then
	until cqlsh -f /cassandra-init-db.cql; do
		echo "cqlsh: Cassandra is unavailable - retry later"
		sleep 2
	done &
fi

exec /docker-entrypoint.sh "$@"