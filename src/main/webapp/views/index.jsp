<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
<h1>This is the index page</h1>
<hr>
<b>Get a single workout</b>
<form action = "singleWorkout">
Today I would like to train:<br>
<input type="radio" id="push" name="workoutType" value="push">
<label for="push">Push</label><br>
<input type="radio" id="pull" name="workoutType" value="pull">
<label for="pull">Pull</label><br>
<input type="radio" id="upper" name="workoutType" value="upper">
<label for="upper">Push and Pull</label><br>
<input type="radio" id="legs" name="workoutType" value="legs">
<label for="legs">Legs</label><br>
<input type="radio" id="fullBody" name="workoutType" value="fullBody">
<label for="fullBody">Full Body</label><br>
<input type="submit" value="Submit">
</form>
<hr>
<b>Get a weekly training split</b>
<form action = "weeklyWorkouts">
<label for="workoutsPerWeek">I would like to train </label>
<select name="workoutsPerWeek" id="workoutsPerWeek">
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
</select>
times per week.<br>
I would like to do something extremely different every single time I am in the gym:<br>
<input type="radio" id="5" name="repetitionTolerance" value="5">
<label for="5">Strongly disagree</label>
<input type="radio" id="4" name="repetitionTolerance" value="4">
<label for="4">Disagree</label>
<input type="radio" id="3" name="repetitionTolerance" value="3">
<label for="3">Neutral</label>
<input type="radio" id="2" name="repetitionTolerance" value="2">
<label for="2">Agree</label>
<input type="radio" id="1" name="repetitionTolerance" value="1">
<label for="1">Strongly agree</label><br>
<input type="hidden" id="workoutDay" name="workoutDay" value="1" />
<input type="submit" value="Submit">
</form>
<hr>
</body>
</html>
