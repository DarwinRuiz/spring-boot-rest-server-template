package com.darwinruiz.springbootservertemplate.shared.interfaces;

import java.util.List;

public interface IMaintenance<T> {
    // Creates a new record in the database table.
    T createRecord(T record);

    // Reads and retrieves a specific record from the database table.
    T readRecord(Integer id);

    // Updates an existing record in the database table.
    T updateRecord(T record);

    // Deletes a record from the database table.
    void deleteRecord(Integer id);

    // Retrieves all records from the database table.
    List<T> getAllRecords();

    // Gets the total records stored in the table
    Integer getTotalRecords();
}
