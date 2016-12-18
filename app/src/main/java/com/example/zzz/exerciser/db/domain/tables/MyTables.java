package com.example.zzz.exerciser.db.domain.tables;

/**
 * Created by zzz on 11/27/16.
 */

public class MyTables {
    public static String selectAllFrom(Enum from) {
        String selectQuery = "SELECT * FROM %s";
        return String.format(selectQuery, from.toString());
    }

    public static String selectAllFromWhere(Enum from, Enum where, String is) {
        String selectQuery = "SELECT * FROM %s where %s = '%s'";
        return String.format(selectQuery, from.toString(), where.toString(), is);
    }

    public static String selectStartedTrainings() {
        String selectQuery = "select t._id, t.name, t.description, ts.status, ts._id as launched_training_id " +
                "from trainings t inner join trainings_status ts on t._id=ts.training_id " +
                "where ts.status != 0;";
        return selectQuery;
    }

    public static String selectStartedExercises(int trainingId, int launchedTraining) {
        String selectQuery = "select * " +
                "from exercises e left join exercises_status es on e._id=es.exercise_id " +
                "where e.training_id = '%s' and (es.lauched_training_id = '%s' or es.lauched_training_id is null)";
        return String.format(selectQuery, trainingId, launchedTraining);
    }

    public static String selectStartedRepetitions(int exerciseId, int launchedTrainingId) {
        String selectQuery = "select * " +
                "from repetitions r left join repetitions_status rs on r._id=rs.repetition_id " +
                "where r.exercise_id = '%s' and (rs.lauched_training_id = '%s' or rs.lauched_training_id is null)";
        return String.format(selectQuery, exerciseId, launchedTrainingId);
    }

    public enum TrainingsTable {
        table_name("trainings"),
        id("_id"),
        training_name("name"),
        description("description");

        String curValue;

        TrainingsTable(String value) {
            curValue = value;
        }

        public String toString() {
            return curValue;
        }
    }

    public enum ExercisesTable {
        table_name("exercises"),
        id("_id"),
        training_id("training_id"),
        exercise_name("name"),
        description("description");

        String curValue;

        ExercisesTable(String value) {
            curValue = value;
        }

        public String toString() {
            return curValue;
        }
    }

    public enum RepetitionsTable {
        table_name("repetitions"),
        id("_id"),
        exercise_id("exercise_id"),
        name("name"),
        description("description"),
        count("count"),
        weight("weight");

        String curValue;

        RepetitionsTable(String value) {
            curValue = value;
        }

        public String toString() {
            return curValue;
        }
    }

    //todo update id of the table
    public enum TrainingsStatusTable {
        id("launched_training_id"),
        training_id("training_id"),
        table_name("trainings_status"),
        status("status"),
        last_date("last_date");
        String curValue;

        TrainingsStatusTable(String value) {
            curValue = value;
        }

        public String toString() {
            return curValue;
        }
    }

    public enum ExercisesStatusTable {
        table_name("exercises_status"),
        status("status"),
        lauched_training_id("lauched_training_id"),
        exercise_id("exercise_id");
        String curValue;

        ExercisesStatusTable(String value) {
            curValue = value;
        }

        public String toString() {
            return curValue;
        }
    }

    public enum RepetitionsStatusTable {
        table_name("repetitions_status"),
        status("status"),
        lauched_training_id("lauched_training_id"),
        repetition_id("repetition_id");
        String curValue;

        RepetitionsStatusTable(String value) {
            curValue = value;
        }

        public String toString() {
            return curValue;
        }
    }
}
