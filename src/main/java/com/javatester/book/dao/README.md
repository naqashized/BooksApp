# Exercise 4: Implementing `BookService`

For this exercise you must implement the `BookService` interface, which defines
methods for getting and deleting books from a relational database. A detailed
description of the structure of the tables in this relational database is given
below (see Database Tables).

## What Is Provided:
1. This README.md file.
2. The BookService interface - DO NOT MODIFY!
3. The BookServiceTest JUnit - DO NOT MODIFY!
4. The BookDB class          - DO NOT MODIFY!

## What You Must Do:
1. Create a class named BookServiceImpl that implements the BookService interface.
2. Make sure there is a no-arg constructor for BookServiceImpl.
3. The tables of the relational database are described in the comments of
   the BookDB class and below (see Database Tables).
   
   1607341341814,0.0442672968,1282509067
1607341339814,0.0473002568,1785397644
1607341331814,0.0899538547,1852154378
1607341271814,0.0586780608,111212767
1607341261814,0.0231608748,1539565646
1607341331814,0.7796950936,1820653751
1607341291814,0.0876221433,1194727708
1607341338814,0.0302456915,1760856792
1607341311814,0.0554600768,2127711810
1607340341814,0.0360791311,1563887095
   
## Dependencies
`PersonImpl`
`BookImpl`
   
## Additional Information

The `BookDB` represents an embedded in-memory relational database. Your
soulution must use this class to initialize the database before executing any
SQL. To use this class, all you need to do is call `BookDB.getInstance()`. This
will start up the database, create the required database tables, populate the
tables with data, and return a singleton `BookDB` instance. The `BookDB` can
then be used directly or indirectly to connect to the database. Here is the
information you will need to connect to the database:

	1. General connection data:

			URL:		"jdbc:derby:memory:BookDB;create=true"
			Username:	"user1"
			Password:	"user1"
		
	2. To get a javax.sql.DataSource, call BookDB.getDataSource();

	3. To get a javax.sql.Connection, call BookDB.getConnection();
	
## Database Tables
There are three database tables you need to access:

	1. Book
	2. Person
	3. Genre
	
Here are the SQL create table statement for these tables:

    create table book (
        title varchar(50),
        isbn bigint,
        author int,
        genre int,
        pages int,
        published date,
        primary key (isbn),
        foreign key (author) references Person(id),
        foreign key (genre) references genre(id)
    )

    create table person (
        id int,
        firstName varchar(25),
        lastName varchar(25),
        born date,
        primary key (id)
    )

    create table genre (
        id int,
        name varchar(25),
        primary key (id)
    )

Finally, here's the logical data model:

                                                  +------------------------+
                                                  | PERSON                 |
    +-------------------------+                   +------------------------+
    | BOOK                    |                   | firstName  varchar(25) |
    +-------------------------+                   | lastName   varchar(25) |
    |                         |                   | born       date        |
    | author    int    (FK) +-------------------> | id         int    (PK) |
    | title     varchar(50)   |                   +------------------------+
    | isbn      bigint (PK)   |                
    | born      date          |          +-------------------+
    | pages     int           |          | GENRE             |
    | published date          |          +-------------------+
    | genre     int    (FK) +----------> | id    int    (PK) |
    |                         |          | name  varchar(25) |
    +-------------------------+          +-------------------+
