package cs.cs430.lab5;

import java.sql.ResultSet;

public class BookSearch {
    /*

CREATE TABLE book (
    ISBN              VARCHAR(15)     NOT NULL,
    title             VARCHAR(50)     NOT NULL,
    pubID             INT             NOT NULL,
    year_published    date            NOT NULL,
    PRIMARY KEY (ISBN),
	FOREIGN KEY (pubID) REFERENCES publisher(pubID)
);
     */

    public void getBookByName(final String bookName) {
        final String getBookByName = "select title, from  book where name like '%" + bookName +"%'";
        final ResultSet resultSet = Lab5Utils.executeSelect(getBookByName);

    }
}
