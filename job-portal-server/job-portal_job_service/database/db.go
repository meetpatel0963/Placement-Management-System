package database

import (
	"log"

	"job_service/config"

	"github.com/gocql/gocql"
)

type DBConnection struct {
	cluster *gocql.ClusterConfig
	session *gocql.Session
}

var connection DBConnection

func SetupDBConnection() {
	connection.cluster = gocql.NewCluster(config.DB_HOST)
	connection.cluster.Consistency = gocql.Quorum
	connection.cluster.Keyspace = config.KEYSPACE
	connection.session, _ = connection.cluster.CreateSession()
}

func ExecuteQuery(query string, values ...interface{}) (error) {
	if err := connection.session.Query(query).Bind(values...).Exec(); err!= nil {
		log.Fatal(err)
		return err
	}
	return nil
}

type Job struct {
    Id         				string	 	`json:"id"`	
    CompanyName       		string		`json:"companyName"`
    EligibleStreams			[]string	`json:"eligibleStreams"`
	JobDescription			[]byte		`json:"jobDescription"`
	StartDate				string 		`json:"startDate"`
	EndDate					string 		`json:"endDate"`
	LPA						float64		`json:"lpa"`
	NumberOfRegistrations	int32		`json:"numberOfRegistrations"`
}

func SaveJob(job Job) (error) {
	query := `INSERT INTO jobs 
	(id, company_name, eligible_streams, job_description, 
		end_date, lpa, num_registrations, start_date) 
	values (?, ?, ?, ?, ?, ?, ?, ?)`

	err := connection.session.Query(query, gocql.TimeUUID(), job.CompanyName, 
								job.EligibleStreams, job.JobDescription, 
								job.EndDate, job.LPA, job.NumberOfRegistrations, 
								job.StartDate).Exec();
	
	return err
}

func GetAllJobs() ([]Job, error) {
	query := `SELECT * from jobs`

	iter := connection.session.Query(query).Iter()
	
	var jobs []Job
	var job Job
	for iter.Scan(&job.Id, &job.CompanyName, 
				  &job.EligibleStreams, &job.EndDate, 
				  &job.JobDescription, &job.LPA, 
				  &job.NumberOfRegistrations, &job.StartDate) {
		jobs = append(jobs, job)
	}

	err := iter.Close()
	
	return jobs, err
}

func GetJobById(jobId string) (Job, error) {
	query := `SELECT * from jobs WHERE id=?`
	
	var job Job
	err := connection.session.Query(query, jobId).Consistency(gocql.One).Scan(
								&job.Id, &job.CompanyName, 
								&job.EligibleStreams, &job.EndDate, 
								&job.JobDescription, &job.LPA, 
								&job.NumberOfRegistrations, &job.StartDate);

	return job, err
}

func GetJobByCompanyName(companyName string) (Job, error) {
	query := `SELECT * from jobs WHERE company_name=?`

	var job Job
	err := connection.session.Query(query, companyName).Consistency(gocql.One).Scan(
								&job.Id, &job.CompanyName, 
								&job.EligibleStreams, &job.EndDate, 
								&job.JobDescription, &job.LPA, 
								&job.NumberOfRegistrations, &job.StartDate);
	
	return job, err
}

func UpdateJob(job Job) (error) {
	query := `UPDATE jobs 
			  SET
				company_name=?, eligible_streams=?, job_description=?, 
				end_date=?, lpa=?, num_registrations=?, start_date=?
			  WHERE
			  	id=?`

	err := ExecuteQuery(query, job.CompanyName, job.EligibleStreams, 
						job.JobDescription, job.EndDate, job.LPA, 
						job.NumberOfRegistrations, job.StartDate, job.Id)
		
	return err
}

func DeleteJob(jobId string) (error) {
	query := `DELETE FROM jobs WHERE id=?`

	err := ExecuteQuery(query, jobId)

	return err
}
