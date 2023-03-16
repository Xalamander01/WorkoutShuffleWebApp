import React from 'react';

export default function Exercise(props) {

    const key = props.divKey
    const exercise = JSON.parse(props.exercise)

    return (
        <div key={key}>
                {exercise.exerciseShortName} <br/>
                {exercise.exerciseLongName} <br/>
                {exercise.exerciseDescription}
            <hr/>
        </div>
    )
}