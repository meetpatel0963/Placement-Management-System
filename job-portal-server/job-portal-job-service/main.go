package main

import "job-portal.com/job_service/database"

func main() {
	database.SetupDBConnection()

	query := `INSERT INTO job_service 
				(company_name, id, eligible_streams, 
				job_description, last_date, lpa, num_registrations, start_date) 
				values ('abc', now(), {'cse'}, 
				textAsBlob('JVBERi0xLjUKJeTw7fgKMTcgMCBvYmoKPDwvRmlsdGVyL0ZsYXRlRGVjb2RlL0xlbmd0aCA1MjM4Pj4Kc3RyZWFtCnja3T3JbiNLcnd/BX9A6dwXQODBgD2Ab2P3zfBBpMS5eA4zF/++Y8msyqXUfi2pGdRgho8UWU1Gxb7n6W8nc9LwP3NKFv6vT9e/wl9/gsdflue/nf7lx+mf/82cXFE56Hj6cTsZF1WO/mSd0jGdfrz+17PW0Wj9FvBx9s/a5Mv5yUZ4pdPlnOHpYs6R3qfLjL2e//vHv5/+9cfpzyetvInDf//jTwdv/n2Dxp6MViXkgtD4pEwJp6iMY1CMCxsogX/ShDeCIA8QaHPNcPUN3uMri9b66rXRr/wlF6ONufKl0cFnN7oHH/DjHf4jqEwxSiffgaWvGVASNHxBxC+4nZ8MftkbvouvGBB+lMgPXfh9eNZvr/hcr67fhq80Qpn32359Icj1NfIz/v26Xe1e4JvhYR3fX3KNPA05rw1O7QECV+gbEA940U60jUGUKzmc/vf0BNz0FFS08fTXU/C6/fE/p//8JSL/'), 
				'2021-09-30', 1, 0, '2021-09-20')`
	
	database.ExecuteQuery(query)
}
