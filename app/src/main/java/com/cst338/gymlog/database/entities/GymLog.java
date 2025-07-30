/**
 * gymlog (the 8 hours of videos to watch assignment)
 *
 * @author Savannah Kestral | lynx
 * @since 7/28/25
 * POJO class for a gym log entry.
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

package com.cst338.gymlog.database.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.cst338.gymlog.database.GymLogDatabase;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(tableName = GymLogDatabase.gymLogTable)
public class GymLog {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String exercise;
    private double weight;
    private int reps;
    private LocalDateTime date;

    public GymLog(String exercise, double weight, int reps) {
        this.exercise = exercise;
        this.weight = weight;
        this.reps = reps;
        date = LocalDateTime.now();
    }

    @NonNull
    @Override
    public String toString() {
        return exercise + '\n' +
                "Weight: " + weight + '\n' +
                "Reps: " + reps + '\n' +
                "Date: " + date.toString() + '\n' +
                "=-=-=-=-=-=-=-=-=-=-=-=-=-=";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GymLog gymLog = (GymLog) o;
        return id == gymLog.id && Double.compare(weight, gymLog.weight) == 0 && reps == gymLog.reps && Objects.equals(exercise, gymLog.exercise) && Objects.equals(date, gymLog.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exercise, weight, reps, date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
