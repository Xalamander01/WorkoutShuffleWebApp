import React from 'react';
import Exercise from './Exercise'
import '../css/Database.css';

export default function Database() {

    const [allExercises, setAllExercises] = React.useState(null)

    React.useEffect(()=>{fetch('/allExercises').then(res=>res.json()).then(data=>setAllExercises(data))},[])

    const allExercisesDiv = allExercises === null ? null :
                allExercises.map(exercise=>
                    <Exercise key={JSON.stringify(exercise.exerciseShortName)} exercise={JSON.stringify(exercise)} />
                )

    console.log("FROM DB")

    return (
        <div key="fullDatabase" className="fullDatabase">
            <h2> ALL EXERCISES ARE LISTED HERE </h2>
            {allExercisesDiv}
        </div>
    )
}