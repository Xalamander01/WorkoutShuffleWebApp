<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
<h1>This is the index JSP file</h1>
<hr>
<h2>Here is a list of all the users</h2>
<hr>
<ul>
<c:forEach items="${users}" var="user">
<li> user id: ${user.userId} username: ${user.username} Password: ${user.password} </li>
</c:forEach>
</ul>
<hr>
<ul>
<c:forEach items="${exercises}" var="exercise">
<li> exerciseShortName: ${exercise.exerciseShortName} exerciseLongName: ${exercise.exerciseLongName} exerciseDescription: ${exercise.exerciseDescription} </li>
</c:forEach>
</ul>
<hr>
<ul>
<c:forEach items="${workoutTypes}" var="workout">
<li> workoutType: ${workout.workoutType} workoutArmGoal: ${workout.workoutArmGoal} workoutChestGoal: ${workout.workoutChestGoal} workoutBackGoal: ${workout.workoutBackGoal} workoutLegsGoal: ${workout.workoutLegsGoal} workoutShoulderGoal: ${workout.workoutShoulderGoal} </li>
</c:forEach>
</ul>
<hr>
<ul>
<c:forEach items="${workoutSplits}" var="workoutSplit">
<li> workoutSplitId: ${workoutSplit.splitId} workoutSplit: ${workoutSplit.workoutSplit} workoutsPerWeek: ${workoutSplit.workoutsPerWeek} typesOfWorkouts: ${workoutSplit.typesOfWorkouts} </li>
</c:forEach>
</ul>
</body>
</html>
