# Zone School API

Yao and I found out many real estate websites have inaccurate information about the zone schools of specific addresses.
We want to make sure people are informed with correct zone schools of the houses they intend to buy/rent.

## How it works
This service is written using Spring Boot and gets it's data from https://www.schools.nyc.gov

All data are available in public and parsed using JSOUP

## How to run
To run locally
1) Do a maven build and simply run ZoneSchoolApiApplication.java
2) Build the project and run ZoneSchoolAPI***.jar

## Challenges
Our biggest challenge right now is lack of data.  We only know where to get zone school info for NYC schools.
Anywhere else such as Long Island area and other states, we couldn't find any reliable source of zone schools.
Feel free to provide tips, info, or anything else to us.