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
A shoulder score of ${workoutEntity.workoutShoulderGoal} needs to be reached with ${workoutEntity.shoulderExerciseCount} exercises.<br>
An arm score of ${workoutEntity.workoutArmGoal} needs to be reached with ${workoutEntity.armExerciseCount} exercises.<br>
</ul>
<hr> <h3>All exercises will be listed here</h3> <hr>
<ul>
<c:forEach items="${exercises}" var="exercise">
<li> exerciseShortName: ${exercise.exerciseShortName} exerciseLongName: ${exercise.exerciseLongName} exerciseDescription: ${exercise.exerciseDescription} </li>
</c:forEach>
</ul>
</body>
</html>