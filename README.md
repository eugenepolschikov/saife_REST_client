# saife_REST_client
repo will be storing implementation for REST client; it's main responsibility - to call APIs available from SAIFE dashboard



=================   URLs   =================

1) Dasboard
https://dashboard.saifeinc.com/#/dashboard


2) APIs available
http://saifeinc.com/developers/libraries/management/?shell#create-and-sign-a-new-certificate


3) SAIFE lib provided from client's side: 
https://drive.google.com/a/exadel.com/folderview?id=0BxPUmV8hvTJ8fmJUbEVtbEpjZUdYRWZjT2hpZ2NES2NZTUZNUUZrRVF4a2thSndOb3k3Z1E&usp=gmail#list

4) videos that probably can be useful
http://saifeinc.com/videos/

5) GIT lab 
http://saife-git.exadel.by/

6) my private git lab project 
http://saife-git.exadel.by/Polschikov/saife-draft-import-from-github

=================   end of URLs   =================


APIs for implementation ASAP: 
1) CERTIFICATES
- post new one (P0) 
- edit  existing (p2) 
- delete existing (p2) 
2) ENDPOINTS (i.e devices) 
- post new one (P0) 
- delete (p2) 
3) GROUPS
- new group 
(a) 1st type: OMNI group. POST omni group (P0) 
                          PUT (EDIT) omni group (p2)
                          DELETE omni group (p2)
(b) leader followers group. POST leader followers group (P0)
                            PUT   --//-- (P2) 
			    DELETE  --//-- (P2)	   




DATA: What can be temporary hardcoded: 
- api key hadrdcoded- 
- users, creds


=================   examples of working HTTP requests:   =================

I) via API key 
header:
Authorization:   Basic NlFISkgwOUVEODJLUEgwRUVXOUhTWjVESjdNR1JQRkFDQkVDRUtFMVNOOVFLRUE0RjJBMDo=

GET /api/v2/certificate
response:  https://yadi.sk/i/fR6WfWGNiVuJo  , OK

II) standard auth
Pre-requisite: add cookie manager in scope of standard auth flow
a) interactive login: 
POST /api/v2/interactive/login
params: email=ypolshchykau@exadel.com&password=Trigger_09031944
response: https://yadi.sk/i/xU6LhM9diVuNV

b) GET /api/v2/certificate 
response: https://yadi.sk/i/owgmJk25iVuTC

c) interactive logout: 
GET /api/v2/interactive/logout 
response: https://yadi.sk/i/uIN9lVxtiVuVe


=================   How to use SAIFE REST client API  =================

import com.saife.dashboard.client.SaifeClientFactory;

...

String apiKey = "yourApiKey";
String certId = "tourCertificateId";

SaifeClientFactory factory = SaifeClientFactory.getInstance(apiKey);

CertificateClient certClient = factory.getCertificateClient();
try {
	certClient.resetPassword(certId);
} catch (ClientException ce) {
	// client exception can be caused on client side only,
	// for example if connection is broken
} catch (SaifeException se) {
	// SAIFE exception is happened on SAIFE dashboard server,
	// this exception contains SAIFE error inside, by type of the error
	// you can determine what actually happened, for example, if certificate
	// cannot be found by the given certId, SAIFE error will be NOT_FOUND.
}
