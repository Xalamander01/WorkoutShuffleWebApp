import React from 'react';
import ListWorkout from './ListWorkout';

export default function ListManyWorkouts(props) {

    const workouts = props.workouts

    const workoutsListElement = workouts === null ?
        null :
        Object.keys(workouts).map((workoutType)=>
            <div key={workoutType}>
                <h1>{workoutType}</h1>
                <ListWorkout workout={workouts[workoutType]} />
            </div>)

    return (
        <div>
            {workoutsListElement}
        </div>
    )
}