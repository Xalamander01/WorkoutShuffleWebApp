import React from 'react';
import '../css/Exercise.css'

export default function Exercise(props) {

    const exercise = JSON.parse(props.exercise)

    return (
        <div className="exercise">
                <div className="exerciseShortName">{exercise.exerciseShortName}</div>
                <div className="exerciseLongName">{exercise.exerciseLongName}</div>
                <div className="exerciseDescription">{exercise.exerciseDescription}</div>
            <hr/>
        </div>
    )
}