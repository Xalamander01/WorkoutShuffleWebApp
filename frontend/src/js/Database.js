import React from 'react';
import Exercise from './Exercise'
import '../css/Database.css';

export default function Database() {

    const [allExercises, setAllExercises] = React.useState(null)
    React.useEffect(fetch('/allExercises').then(res=>res.json()).then(data=>{
                                                            setAllExercises(JSON.stringify(data))
                                                            //console.log("FROM DB " + JSON.stringify(data))
                                                        }),[])

    console.log("FROM DB " + allExercises)

    return (
        <div key="fullDatabase" className="fullDatabase">
            { allExercises != null ?
                allExercises.map(exercise=>
                 <Exercise divKey={JSON.stringify(exercise.exerciseShortName)} exercise={JSON.stringify(exercise)} />
            ) : null }
        </div>
    )
}