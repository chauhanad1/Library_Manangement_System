package com.example.library_management_system.Service;

import com.example.library_management_system.Entity.Library_Transactions;

public interface LibraryTransactionService {
    void logTransaction(Library_Transactions transaction);
    Library_Transactions getLogTransaction(int user_id, int copy_id);
}
