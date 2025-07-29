/**
 * gymlog (the 8 hours of videos to watch assignment)
 *
 * @author Savannah Kestral | lynx
 * @since 7/28/25
 *
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

package com.cst338.gymlog.database.typeConverters;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTypeConverter {
    @TypeConverter
    public long convertDateToLong(LocalDateTime date) {
        ZonedDateTime zdt = ZonedDateTime.of(date, ZoneId.systemDefault());
        return zdt.toInstant().toEpochMilli();

    }

    @TypeConverter
    public LocalDateTime convertLongToDate(Long epochMilli) {
        Instant instant = Instant.ofEpochMilli(epochMilli);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }


}
