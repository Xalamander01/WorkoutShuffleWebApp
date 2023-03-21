import React from 'react';
import Exercise from './Exercise';

export default function ListWorkout(props) {

    const workout = props.workout

    const exerciseList = workout == null ? null : workout.map(exercise=>
            <Exercise key={JSON.stringify(exercise.exerciseShortName)} exercise={JSON.stringify(exercise)} />
        )

    return (
        <div>
            {exerciseList}
        </div>
    )
}