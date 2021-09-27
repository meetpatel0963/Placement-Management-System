package database

import (
	"log"

	"github.com/gocql/gocql"
	"github.com/spf13/viper"
)

type DBConnection struct {
	cluster *gocql.ClusterConfig
	session *gocql.Session
}

var connection DBConnection

func SetupDBConnection() {
	connection.cluster = gocql.NewCluster(viper.GetString("db_host"))
	connection.cluster.Consistency = gocql.Quorum
	connection.cluster.Keyspace = viper.GetString("keyspace")
	connection.session, _ = connection.cluster.CreateSession()
	if connection.session == nil {
		log.Fatal("Couldn't connect to Cassandra DB")
	}
}

func CloseConnection() {
	if connection.session != nil && !connection.session.Closed() {
		connection.session.Close()
	}
}

func ExecuteQuery(query string, values ...interface{}) error {
	if err := connection.session.Query(query).Bind(values...).Exec(); err != nil {
		log.Fatal(err)
		return err
	}
	return nil
}

type Job struct {
	Id                    string   `json:"id"`
	CompanyName           string   `json:"companyName"`
	EligibleStreams       []string `json:"eligibleStreams"`
	JobDescription        []byte   `json:"jobDescription"`
	StartDate             string   `json:"startDate"`
	EndDate               string   `json:"endDate"`
	LPA                   float64  `json:"lpa"`
	NumberOfRegistrations int32    `json:"numberOfRegistrations"`
}

func SaveJob(job Job) error {
	query := `INSERT INTO jobs 
	(id, company_name, eligible_streams, job_description, 
		end_date, lpa, num_registrations, start_date) 
	values (?, ?, ?, ?, ?, ?, ?, ?)`

	err := connection.session.Query(query, gocql.TimeUUID(), job.CompanyName,
		job.EligibleStreams, job.JobDescription,
		job.EndDate, job.LPA, job.NumberOfRegistrations,
		job.StartDate).Exec()

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
		&job.NumberOfRegistrations, &job.StartDate)

	return job, err
}

func GetJobByCompanyName(companyName string) (Job, error) {
	query := `SELECT * from jobs WHERE company_name=?`

	var job Job
	err := connection.session.Query(query, companyName).Consistency(gocql.One).Scan(
		&job.Id, &job.CompanyName,
		&job.EligibleStreams, &job.EndDate,
		&job.JobDescription, &job.LPA,
		&job.NumberOfRegistrations, &job.StartDate)

	return job, err
}

func UpdateJob(job Job) error {
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

func DeleteJob(jobId string) error {
	query := `DELETE FROM jobs WHERE id=?`

	err := ExecuteQuery(query, jobId)

	return err
}

func GetJobByStartDate(startDate string) ([]Job, error) {
	query := `SELECT * from jobs WHERE start_date <= ? ALLOW FILTERING`

	iter := connection.session.Query(query, startDate).Iter()

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

func GetJobByEndDate(endDate string) ([]Job, error) {
	query := `SELECT * from jobs WHERE end_date >= ? ALLOW FILTERING`

	iter := connection.session.Query(query, endDate).Iter()

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

func GetJobByStream(streamName string) ([]Job, error) {
	query := `SELECT * from jobs WHERE eligible_streams CONTAINS ?`

	iter := connection.session.Query(query, streamName).Iter()

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

type StudentJobEntry struct {
	JobID    	string `json:"job_id"`
	StudentID	string `json:"student_id"`
}

func RegisterStudentForJob(entry StudentJobEntry) (error) {
	query := `SELECT * from jobs WHERE id = ? LIMIT 1`
	
	var job Job
	err := connection.session.Query(query, entry.JobID).Consistency(gocql.One).Scan(
		&job.Id, &job.CompanyName,
		&job.EligibleStreams, &job.EndDate,
		&job.JobDescription, &job.LPA,
		&job.NumberOfRegistrations, &job.StartDate)

	if err != nil {
		return err
	}
		
	query = `INSERT INTO student_job_registrations (job_id, student_id) VALUES (?, ?)`
	err = connection.session.Query(query, entry.JobID, entry.StudentID).Exec()
	
	return err	
}

func GetRegisteredStudentsByJobId(jobId string) ([]StudentJobEntry, error) {
	query := `SELECT * from student_job_registrations WHERE job_id = ?`

	var entries []StudentJobEntry
	iter := connection.session.Query(query, jobId).Iter()

	var entry StudentJobEntry
	for iter.Scan(&entry.JobID, &entry.StudentID) {
		entries = append(entries, entry)
	}

	err := iter.Close()

	return entries, err	
}