package com.example.zzz.exerciser.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.zzz.exerciser.db.domain.Exercise;
import com.example.zzz.exerciser.db.domain.Repetition;
import com.example.zzz.exerciser.db.domain.Training;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.example.zzz.exerciser.db.domain.tables.MyTables.*;


public class MyDatabase extends SQLiteAssetHelper implements IDatabaseHandler {
    private static final String DATABASE_NAME = "exer.db";
    private static final int DATABASE_VERSION = 1;
    Logger logger = LoggerFactory.getLogger(MyDatabase.class);

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void addTraining() {

    }

    @Override
    public void getTraining() {

    }

    @Override
    public List<Training> getAllTrainings() {
        List<Training> trainingsList = new ArrayList<>();
        String selectQuery = selectAllFrom(TrainingsTable.table_name);
        logger.info("getAllTrainings(): query: " + selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Training training = new Training();
                training.id = getInt(cursor, TrainingsTable.id);
                training.name = getString(cursor, TrainingsTable.training_name);
                training.description = getString(cursor, TrainingsTable.description);
                training.status = getInt(cursor, TrainingsStatusTable.status);
                trainingsList.add(training);
            } while (cursor.moveToNext());
        }

        return trainingsList;
    }



    public List<Training> getStartedTrainings() {
        List<Training> trainingsList = new ArrayList<>();
        String selectQuery = selectStartedTrainings();
        logger.info("getAllTrainings(): query: " + selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Training training = new Training();
                training.id = getInt(cursor, TrainingsTable.id);
                training.launchedTrainingId = getInt(cursor, TrainingsStatusTable.id);
                training.name = getString(cursor, TrainingsTable.training_name);
                training.description = getString(cursor, TrainingsTable.description);
                training.status = getInt(cursor, TrainingsStatusTable.status);
                trainingsList.add(training);
            } while (cursor.moveToNext());
        }

        return trainingsList;
    }

    @Override
    public void addExercise() {

    }

    @Override
    public void getExercise() {

    }

    @Override
    public List<Exercise> getAllExercises(Training training) {
        List<Exercise> exerciseList = new ArrayList<>();
        String selectQuery = selectAllFromWhere(ExercisesTable.table_name, ExercisesTable.training_id, String.valueOf(training.id));
        logger.info("getAllExercises(): query: {}", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                logger.info("getAllExercises(): cursor.moveToFirst() >0");
                Exercise exercise = new Exercise();
                exercise.id = getInt(cursor, ExercisesTable.id);
                exercise.training_id = getInt(cursor, ExercisesTable.training_id);
                exercise.exerciseName = getString(cursor, ExercisesTable.exercise_name);
                exercise.description = getString(cursor, ExercisesTable.description);
                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }

        return exerciseList;
    }

    @Override
    public List<Exercise> getExercisesFromStartedTraining(Training training) {
        List<Exercise> exerciseList = new ArrayList<>();
        String selectQuery = selectStartedExercises(training.id, training.launchedTrainingId);
        logger.info("getExercisesFromStartedTraining(): query: {}", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                logger.info("getExercisesFromStartedTraining(): cursor.moveToFirst() >0");
                Exercise exercise = new Exercise();
                exercise.id = getInt(cursor, ExercisesTable.id);
                exercise.training_id = getInt(cursor, ExercisesTable.training_id);
                exercise.lauchedTrainingId = getInt(cursor, ExercisesStatusTable.lauched_training_id);
                exercise.exerciseName = getString(cursor, ExercisesTable.exercise_name);
                exercise.description = getString(cursor, ExercisesTable.description);
                exercise.status = getInt(cursor, ExercisesStatusTable.status);
                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }

        return exerciseList;

    }

    public List<Repetition> getAllRepetitionsFromStartedExercise(Exercise exercise) {
        List<Repetition> repetitionList = new ArrayList<>();
        String selectQuery = selectStartedRepetitions(exercise.id, exercise.lauchedTrainingId);
        logger.info("getAllRepetitionsFromStartedExercise(): selectQuery: {}", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                logger.info("getAllRepetitionsFromStartedExercise(): cursor.moveToFirst() >0");
                Repetition repetition = new Repetition();
                repetition.id = getInt(cursor, RepetitionsTable.id);
                repetition.name = getString(cursor, RepetitionsTable.name);
                repetition.weight = getString(cursor, RepetitionsTable.weight);
                repetition.count = getString(cursor, RepetitionsTable.count);
                repetition.description = getString(cursor, RepetitionsTable.description);
                repetition.status = getInt(cursor, RepetitionsStatusTable.status);
                repetitionList.add(repetition);
            } while (cursor.moveToNext());
        }
        return repetitionList;
    }

    @Override
    public void addRepetition() {

    }

    @Override
    public void getRepetition() {

    }

    @Override
    public void getAllRepetitions() {

    }

    @Override
    public void addHistoryItem() {

    }

    private String getString(Cursor cursor, Enum column) {
        String columnName = column.toString();
        String result = cursor.getString(cursor.getColumnIndex(columnName));
        return result;
    }

    private int getInt(Cursor cursor, Enum column) {
        String columnName = column.toString();
        int result = cursor.getInt(cursor.getColumnIndex(columnName));
        return result;
    }


}
