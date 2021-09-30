CREATE TABLE IF NOT EXISTS pms_job_service.jobs (
	id timeuuid PRIMARY KEY,
	company_id bigint,
	end_date date,
	job_description blob,
	lpa double,
	num_registrations int,
	start_date date,
	eligible_streams set<text>)
	WITH ID = fd89e5a0-2200-11ec-a124-996a04fa7cd9
	AND bloom_filter_fp_chance = 0.01
	AND dclocal_read_repair_chance = 0.1
	AND crc_check_chance = 1.0
	AND default_time_to_live = 0
	AND gc_grace_seconds = 864000
	AND min_index_interval = 128
	AND max_index_interval = 2048
	AND memtable_flush_period_in_ms = 0
	AND read_repair_chance = 0.0
	AND speculative_retry = '99PERCENTILE'
	AND comment = ''
	AND caching = { 'keys': 'ALL', 'rows_per_partition': 'NONE' }
	AND compaction = { 'max_threshold': '32', 'min_threshold': '4', 'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
	AND compression = { 'chunk_length_in_kb': '64', 'class': 'org.apache.cassandra.io.compress.LZ4Compressor' }
	AND cdc = false
	AND extensions = {  };
CREATE INDEX IF NOT EXISTS jobs_company_id_idx ON pms_job_service.jobs (company_id);
CREATE INDEX IF NOT EXISTS jobs_eligible_streams_idx ON pms_job_service.jobs (values(eligible_streams));
CREATE INDEX IF NOT EXISTS jobs_end_date_idx ON pms_job_service.jobs (end_date);
CREATE INDEX IF NOT EXISTS jobs_lpa_idx ON pms_job_service.jobs (lpa);
CREATE INDEX IF NOT EXISTS jobs_num_registrations_idx ON pms_job_service.jobs (num_registrations);
CREATE INDEX IF NOT EXISTS jobs_start_date_idx ON pms_job_service.jobs (start_date);
