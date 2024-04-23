Questions:
---------
	1) Find total claimed_charge of the exported documents.
  	Query : SELECT Sum(D.claimed_charge) FROM  D WHERE D.status = "EXPORTED";


	2) Find insured_name, insured_address and claimed_charge for the documents that have status "TO_REPRICE" and customer id 1 and 2.
	Query : SELECT D.insured_name, D.insured_address, D.claimed_charge FROM DOCUMENT D
	JOIN BATCH B ON D.batch_id = B.id
	WHERE D.status = "TO_REPRICE" AND B.customer_id IN (1, 2);