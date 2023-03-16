import React from 'react';
import Exercise from './Exercise';

export default function ListWorkout(props) {

    const [workout, setWorkout] = React.useState(null)
    const workoutType = props.workoutType

    React.useEffect(()=>{
                    let fetchUrl = "/singleWorkout/"+workoutType
                    fetch(fetchUrl).then(res=>res.json()).then(data=>setWorkout(data))
                },[workoutType])

    console.log("FROM LIST WO")

    const exerciseList = workout == null ? null : workout.map(exercise=>
            <Exercise divKey={JSON.stringify(exercise.exerciseShortName)} exercise={JSON.stringify(exercise)} />
        )

    function handleClick() {
        props.setWorkoutType(null)
    }

    return (
        <div key="ExerciseList">
            {exerciseList}
            <button onClick={handleClick}>Another one</button>
        </div>
    )
}