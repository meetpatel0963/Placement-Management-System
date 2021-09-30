CREATE KEYSPACE IF NOT EXISTS pms_job_service WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE pms_job_service;

CREATE TABLE IF NOT EXISTS jobs (id timeuuid PRIMARY KEY, company_id bigint, eligible_streams set<text>, job_description blob, start_date date, end_date date, lpa double, num_registrations int);
CREATE INDEX IF NOT EXISTS ON jobs(company_id);
CREATE INDEX IF NOT EXISTS ON jobs(eligible_streams);
CREATE INDEX IF NOT EXISTS ON jobs(start_date);
CREATE INDEX IF NOT EXISTS ON jobs(end_date);
CREATE INDEX IF NOT EXISTS ON jobs(lpa);
CREATE INDEX IF NOT EXISTS ON jobs(num_registrations);

CREATE TABLE IF NOT EXISTS student_job_registrations (job_id timeuuid PRIMARY KEY, student_id text);
CREATE INDEX IF NOT EXISTS ON student_job_registrations(student_id);