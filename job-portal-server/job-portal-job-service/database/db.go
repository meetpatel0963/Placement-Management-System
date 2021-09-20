package database

import (
	"log"

	"github.com/gocql/gocql"
)

type DBConnection struct {
	cluster *gocql.ClusterConfig
	session *gocql.Session
}

var connection DBConnection

func SetupDBConnection() {
	connection.cluster = gocql.NewCluster(DB_HOST)
	connection.cluster.Consistency = gocql.Quorum
	connection.cluster.Keyspace = KEYSPACE
	connection.session, _ = connection.cluster.CreateSession()
}

func ExecuteQuery(query string, values ...interface{}) {
	if err := connection.session.Query(query).Bind(values...).Exec(); err!= nil {
		log.Fatal(err)
	}
}