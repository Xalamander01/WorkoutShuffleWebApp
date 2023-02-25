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
<hr>
<table><tr>
<c:forEach var="i" begin="1" end="${workoutsPerWeek}">
<td>
<form action="weeklyWorkouts">
    <input type="hidden" id="workoutsPerWeek" name="workoutsPerWeek" value="${workoutsPerWeek}" />
    <input type="hidden" id="repetitionTolerance" name="repetitionTolerance" value="${repetitionTolerance}" />
    <input type="hidden" id="workoutDay" name="workoutDay" value="${i}" />
    <button type="submit"> <c:out value="${workoutTypes[i-1]}"/> Day ${i} </button>
</form>
</td>
</c:forEach>
</tr></table>
<hr>
this doesn't work yet
<form action="refreshWorkout">
    <input type="hidden" id="workoutsPerWeek" name="workoutsPerWeek" value="${workoutsPerWeek}" />
    <input type="hidden" id="repetitionTolerance" name="repetitionTolerance" value="${repetitionTolerance}" />
    <input type="hidden" id="workoutDay" name="workoutDay" value="${i}" />
    <button type="submit"> ReShuffle </button>
</form>
<hr> <h2>All exercises will be listed here</h2> <ul>
The workout for day ${workoutDay} contains the following exercises:
<c:forEach items="${exerciseList}" var="exercise">
<p>
<span class="tab">exerciseShortName: ${exercise.exerciseShortName}<br>
<span class="tab">exerciseLongName: ${exercise.exerciseLongName}<br>
<span class="tab">exerciseDescription: ${exercise.exerciseDescription}<br>
</c:forEach>
</ul>
</body>
</html>