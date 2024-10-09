package com.example.library_management_system.ServiceImpl;

import com.example.library_management_system.Entity.Library_Transactions;
import com.example.library_management_system.Repository.LibraryTransaction;
import com.example.library_management_system.Service.LibraryTransactionService;
import org.springframework.beans.factory.annotation.Autowired;

public class LibraryTransactionServiceImpl implements LibraryTransactionService {

    @Autowired
    private LibraryTransaction library_transactions;
    @Override
    public void logTransaction(Library_Transactions transaction) {

    }

    @Override
    public Library_Transactions getLogTransaction(int user_id, int copy_id) {
        return library_transactions.getLibraryTransactions(user_id,copy_id);
    }
}
