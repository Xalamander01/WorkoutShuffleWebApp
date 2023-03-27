import React from 'react';
import '../css/Exercise.css'

export default function Exercise(props) {

    const exercise = JSON.parse(props.exercise)
    const index = props.index+1

    //<span className="exerciseDescription">{exercise.exerciseDescription}</span>
    //<span className="exerciseShortName">{exercise.exerciseShortName}</span>

    return (
        <div className="exercise">
            <button>{index}</button>
            <div className="exerciseLongName">{exercise.exerciseShortName.toUpperCase()}</div>
        </div>
    )
}