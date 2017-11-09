package com.example.ruben.sqlliteinsertruben;

import android.provider.BaseColumns;

/**
 * Created by Ruben on 9-11-2017.
 */

public class Contract {
    private  Contract() {}

    //Columnen van de database
    public static final class ContractEntry implements BaseColumns {

        public static final String TABLE_NAME = "myTable";
        public static final String COLUMN_UID="_id";
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_PASSWORD= "Password";
    }
}
