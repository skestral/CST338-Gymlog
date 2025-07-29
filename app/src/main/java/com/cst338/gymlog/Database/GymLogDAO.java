/**
 * gymlog (the 8 hours of videos to watch assignment)
 *
 * @author Savannah Kestral | lynx
 * @since 7/28/25
 */
//
//         `\.      ,/'
//          |\\____//|
//          )/_ `' _\(
//         ,'/-`__'-\`\
//        /.  (_><_)  ,\
//        `  )/`--'\(` '
//           `      '
//       _
//      | |
//      | |_   _ _ __ __  __
//      | | | | | '_ \\ \/ /
//      | | |_| | | | |>  <
//      |_|\__, |_| |_/_/\_\
//          __/ |
//         |___/
//

package com.cst338.gymlog.Database;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.cst338.gymlog.Database.entities.GymLog;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface GymLogDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(GymLog gymLog);

    @Query("Select * from " + GymLogDatabase.gymLogTable)
    ArrayList<GymLog> getAllRecords();

    }
