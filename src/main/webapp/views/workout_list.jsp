<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST WORKOUT</title>
</head>
<body>
<h1>This is the workout listing page</h1>

<hr> <h2>All scores will be listed here</h2> <ul>
A legs score of ${workoutEntity.workoutLegsGoal} needs to be reached with ${workoutEntity.legsExerciseCount} exercises.<br>
A back score of ${workoutEntity.workoutBackGoal} needs to be reached with ${workoutEntity.backExerciseCount} exercises.<br>
A chest score of ${workoutEntity.workoutChestGoal} needs to be reached with ${workoutEntity.chestExerciseCount} exercises.<br>
A shoulder score of ${workoutEntity.workoutShoulderPushGoal} needs to be reached with ${workoutEntity.shoulderPushExerciseCount} exercises.<br>
A shoulder score of ${workoutEntity.workoutShoulderPullGoal} needs to be reached with ${workoutEntity.shoulderPullExerciseCount} exercises.<br>
An arm score of ${workoutEntity.workoutArmPushGoal} needs to be reached with ${workoutEntity.armPushExerciseCount} exercises.<br>
An arm score of ${workoutEntity.workoutArmPullGoal} needs to be reached with ${workoutEntity.armPullExerciseCount} exercises.<br>
</ul>

<hr> <h3>All exercises will be listed here</h3> <ul>
The workout contains ${listSize} exercises:
<c:forEach items="${exerciseList}" var="exercise">
<p>
<span class="tab">exerciseShortName: ${exercise.exerciseShortName}<br>
<span class="tab">exerciseLongName: ${exercise.exerciseLongName}<br>
<span class="tab">exerciseDescription: ${exercise.exerciseDescription}<br>
</c:forEach>
</ul>
</body>
</html>